package hellmonky.functor.log.impl;

import aliyun.common.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yuanlai.xwt on 2017/7/6.
 */
public class Log4jLog implements Log {

    static {
        // reset log4j properties
        org.apache.log4j.LogManager.resetConfiguration();
        org.apache.log4j.PropertyConfigurator.configure(
            Log4jLog.class.getClassLoader().
                getResourceAsStream("log4j.properties"));
    }

    static Log getInstance(String name) {
        return new Log4jLog(name);
    }


    public final Logger logger;

    public Log4jLog(String name){
        this.logger = LoggerFactory.getLogger(name);
    }


    @Override
    public final boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override
    public final boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    @Override
    public final boolean isFatalEnabled() {
        return this.logger.isErrorEnabled();
    }

    @Override
    public final boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    @Override
    public final boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    @Override
    public final boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    @Override
    public final void trace(Object message) {
        this.logger.trace(String.valueOf(message));
    }

    @Override
    public final void trace(Object message, Throwable t) {
        this.logger.trace(String.valueOf(message),t);
    }

    @Override
    public final void debug(Object message) {
        this.logger.debug(String.valueOf(message));
    }

    @Override
    public final void debug(Object message, Throwable t) {
        this.logger.debug(String.valueOf(message),t);
    }

    @Override
    public final void info(Object message) {
        this.logger.info(String.valueOf(message));
    }

    @Override
    public final void info(Object message, Throwable t) {
        this.logger.info(String.valueOf(message),t);
    }

    @Override
    public final void warn(Object message) {
        this.logger.warn(String.valueOf(message));
    }

    @Override
    public final void warn(Object message, Throwable t) {
        this.logger.warn(String.valueOf(message),t);
    }

    @Override
    public final void error(Object message) {
        this.logger.error(String.valueOf(message));
    }

    @Override
    public final void error(Object message, Throwable t) {
        this.logger.error(String.valueOf(message),t);
    }

    @Override
    public final void fatal(Object message) {
        this.logger.error(String.valueOf(message));
    }

    @Override
    public final void fatal(Object message, Throwable t) {
        this.logger.error(String.valueOf(message),t);
    }
}
