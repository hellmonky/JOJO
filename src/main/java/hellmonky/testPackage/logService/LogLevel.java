package hellmonky.testPackage.logService;

/**
 * Created by yuanlai.xwt on 2017/6/23.
 * 日志级别分类
 */
public enum  LogLevel {
    /**
     * info：消息模式
     */
    INFO(1, "info"),
    /**
     * warn：警告模式
     */
    WARN(2, "warn"),
    /**
     * error：错误模式
     */
    ERROR(3, "error"),
    /**
     * exception：异常模式
     */
    EXCEPTION(4, "exception");

    private final Integer index;
    private final String description;

    LogLevel(Integer index, String description){
        this.index = index;
        this.description = description;
    }
}
