package org.devon.clazz.load;

import java.lang.reflect.Proxy;

/**
 * @author dewen.ye
 * @date 2019/1/3 00:36
 */
public class ProxyClassLoader extends ClassLoader {


    public ProxyClassLoader() {
        super(ClassLoader.getSystemClassLoader());
    }

    public ProxyClassLoader(ClassLoader parent) {
        super(parent);
    }
}
