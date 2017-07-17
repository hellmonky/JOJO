package hellmonky.functor.log;

import hellmonky.functor.log.impl.LogFactory;

/**
 * Created by yuanlai.xwt on 2017/7/6.
 */
public class LogTest {

    public static void main(String[] args) {
        LogTest test = new LogTest();
        Log log = LogFactory.getLog(LogTest.class);
        log.info("info");
        log.debug("debug");
        log.error("error");

        /*
        LogUtil  logUtil = LogUtil.getInstance();
        logUtil.info("info");
        logUtil.debug("debug");
        logUtil.error("error");
        */
    }
}
