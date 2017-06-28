package hellmonky.simpleLoger;

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
    }
}
