package hellmonky.functor.logService;

/**
 * Created by yuanlai.xwt on 2017/6/23.
 * 日志操作接口
 */
public interface Logger {
    void info(String content);
    void warn(String content);
    void error(String content);
    void exception(String content);
}
