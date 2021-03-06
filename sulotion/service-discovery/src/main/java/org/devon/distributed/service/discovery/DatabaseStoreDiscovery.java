package org.devon.distributed.service.discovery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Statement;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dewen.ye
 * @date 2019/1/24 00:32
 */
//TODO
public class DatabaseStoreDiscovery implements ServiceDiscovery, Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseStoreDiscovery.class);
    private ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1, new NameThreadFactory());

    private final String INIT_TABLE_SQL = "create table jdbc_service_discovery(" +
            "cluster_name varchar(256) NOT NULL," +
            "own_addr varchar(256) NOT NULL," +
            "heat_beta Timestamp NOT NULL," +
            "ping_data varchar(3000)" +
            ")";
    private final String INSERT_HEAT_BEAT_SQL = "INSERT INTO jdbc_service_discovery VALUES (?,?,?,?)";
    private final String DELETE_LAST_RECORD_SQL = "DELETE FROM jdbc_service_discovery WHERE cluster_name = ? AND own_addr = ?";
    private final String DELETE_CLUSTER_SQL = "DELETE FROM jdbc_service_discovery WHERE cluster_name = ?";
    private final long DELETE_HEAT_BEAT_MS = 5000;

    private Connection connect;

    private long heatBeta;
    private boolean enable = true;

    public DatabaseStoreDiscovery(Connection connect) {
        this.connect = connect;
    }

    public void init() throws Exception {
        try (Statement statement = connect.createStatement()) {
            statement.execute(INIT_TABLE_SQL);
            Runtime.getRuntime().addShutdownHook(new OfflineClearHeatBeatThread());
        } catch (Exception e) {
            throw new Exception("jdbc_service_discovery table init fail!");
        }
        executor.scheduleAtFixedRate(new DatabaseStoreDiscovery(connect), 5, DELETE_HEAT_BEAT_MS, TimeUnit.MICROSECONDS);
    }

    @Override
    public void run() {
        while (enable) {
            try (Statement statement = connect.createStatement()) {
                statement.execute(DELETE_LAST_RECORD_SQL);
                statement.execute(INSERT_HEAT_BEAT_SQL);
            } catch (Exception e) {
                LOG.warn("heat beat execute fail! Exception:", e);
            }
        }
    }


    static class NameThreadFactory implements ThreadFactory {

        private static final AtomicInteger poolNumber = new AtomicInteger(1);

        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        NameThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            namePrefix = "heat-beat-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r,
                    namePrefix + threadNumber.getAndIncrement());
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

    private class OfflineClearHeatBeatThread extends Thread {
        public OfflineClearHeatBeatThread() {
            setName("OfflineClearHeatBeatThread");
        }

        @Override
        public void run() {
            enable = false;
            try (Statement statement = connect.createStatement()) {
                statement.execute(DELETE_LAST_RECORD_SQL);
            } catch (Exception e) {

            }
        }
    }

}
