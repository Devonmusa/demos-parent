package org.devon.java8.completable.future;


import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author dewen.ye
 * @date 2019/3/19 08:46
 */
public class LoadTask implements Supplier<List<Product>> {

	private Path path;

	public LoadTask(Path path) {
		this.path = path;
	}

	@Override
	public List<Product> get() {

		System.out.println("Supplier:start,Thread:" + Thread.currentThread().getName());
        /*List<Product> productList = null;
        try {
            //todo
            productList = Files.walk(path, FileVisitOption.FOLLOW_LINKS)
                    .parallel().filter(f -> f.toString().endsWith(".txt")).map(path -> {
                        return new ProductLoader().apply(path);
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {

        }finally {
            path.
        }*/
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Supplier:end,Thread:" + Thread.currentThread().getName());

		return null;
	}
}
