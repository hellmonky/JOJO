package hellmonky.functor.simpleLoger;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yuanlai.xwt on 2017/6/28.
 * 单例模式的日志服务，主要用于目前替换System.out.println()和e.printStackTrace()
 */
public class LogUtil {
    ///*
    static {
        // reset log4j properties
        org.apache.log4j.LogManager.resetConfiguration();
        org.apache.log4j.PropertyConfigurator.configure(LogUtil.class.getClassLoader().getResourceAsStream("log4j.properties"));
    }
    //*/

    private volatile static LogUtil singleton;

    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);
    //private Logger logger;

    private LogUtil (){
        /*
        try{
            //InputStream inputStream = LogUtil.class.getClassLoader().getResourceAsStream("log4j.properties");
            String proPath = LogUtil.class.getClassLoader().
                getResource("log4j.properties").getPath();
            File initialFile = new File(proPath);
            InputStream inputStream = new FileInputStream(initialFile);
            PropertyConfigurator.configure(inputStream);
            logger = LoggerFactory.getLogger(LogUtil.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        */

    }

    public static LogUtil getInstance() {
        if (singleton == null) {
            synchronized (LogUtil.class) {
                if (singleton == null) {
                    singleton = new LogUtil();
                }
            }
        }
        return singleton;
    }

    /*
    public void info(String content){
        logger.info(content);
    }

    public void debug(String content){
        logger.debug(content);
    }

    public void error(String content){
        logger.error(content);
    }

    public void error(String content, Exception e){
        logger.error(content,e);
    }
    */

    // 增加当前日志记录元信息：
    public void info(Class<?> currentClass, String content){
        LogInfo lf = new LogInfo();
        lf.setCurrentLogClass(currentClass);
        lf.setContent(content);
        logger.info(lf.toString());
    }

    public void debug(Class<?> currentClass, String content){
        LogInfo lf = new LogInfo();
        lf.setCurrentLogClass(currentClass);
        lf.setContent(content);
        logger.debug(lf.toString());
    }

    public void error(Class<?> currentClass, String content){
        LogInfo lf = new LogInfo();
        lf.setCurrentLogClass(currentClass);
        lf.setContent(content);
        logger.error(lf.toString());
    }

    public void error(Class<?> currentClass, String content,Exception e){
        LogInfo lf = new LogInfo();
        lf.setCurrentLogClass(currentClass);
        lf.setContent(content);
        logger.error(lf.toString(),e);
    }
}
