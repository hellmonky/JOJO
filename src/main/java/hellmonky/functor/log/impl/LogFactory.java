package hellmonky.functor.log.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ServiceLoader;

import aliyun.common.log.Log;
import org.apache.commons.logging.LogConfigurationException;

/**
 * Created by yuanlai.xwt on 2017/7/6.
 */
public class LogFactory {
    private static final LogFactory singleton = new LogFactory();

    private final Constructor<? extends Log> discoveredLogConstructor;

    private LogFactory() {
        ServiceLoader<Log> logLoader = ServiceLoader.load(Log.class);
        Constructor<? extends Log> m=null;
        for (Log log: logLoader) {
            Class<? extends Log> c=log.getClass();
            try {
                m=c.getConstructor(String.class);
                break;
            }
            catch (NoSuchMethodException | SecurityException e) {
                throw new Error(e);
            }
        }
        discoveredLogConstructor=m;
    }

    public Log getInstance(String name) throws LogConfigurationException {
        if (discoveredLogConstructor == null) {
            return Log4jLog.getInstance(name);
        }
        try {
            return discoveredLogConstructor.newInstance(name);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException |
            InvocationTargetException e) {
            throw new LogConfigurationException(e);
        }
    }
    public Log getInstance(Class<?> clazz) throws LogConfigurationException {
        return getInstance( clazz.getName());
    }

    public static LogFactory getFactory() throws LogConfigurationException {
        return singleton;
    }
    public static Log getLog(Class<?> clazz)
        throws LogConfigurationException {
        return getFactory().getInstance(clazz);
    }
    public static Log getLog(String name)
        throws LogConfigurationException {
        return getFactory().getInstance(name);
    }
}
