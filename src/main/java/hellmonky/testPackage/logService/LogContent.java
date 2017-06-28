package hellmonky.testPackage.logService;

/**
 * Created by yuanlai.xwt on 2017/6/23.
 * 日志内容分类
 */
public enum  LogContent {
    /**
     * debug：调试模式
     */
    DEBUG(1, "debug"),
    /**
     * dev：开发模式（预发模式）
     */
    DEV(2, "dev"),
    /**
     * release：正式发布模式
     */
    RELEASE(3, "release");

    private final Integer index;
    private final String description;

    LogContent(Integer index, String description){
        this.index = index;
        this.description = description;
    }
}
