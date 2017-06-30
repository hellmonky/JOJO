package hellmonky.functor.simpleLoger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by yuanlai.xwt on 2017/6/28.
 */
public class TestLogService {

    public static void main(String[] args) {

        LogUtil logger = LogUtil.getInstance();
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
        //
        TestLogService testLogService = new TestLogService();
        logger.metaInfo(testLogService.getClass(),"test metadata log");

        // stackTrace log
        try{
            String proPath = LogUtil.class.getClassLoader().
                getResource("log4.properties").getPath();
            File initialFile = new File(proPath);
            InputStream inputStream = new FileInputStream(initialFile);
        } catch (FileNotFoundException e){
            logger.error( "file is not exist!", e );
        } catch (NullPointerException e) {
            logger.error( "null point error!", e );
        }
    }
}
