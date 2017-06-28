package hellmonky.controller.annotationVerification.checkCondition;

/**
 * Created by yuanlai.xwt on 2017/6/27.
 */
import java.lang.reflect.Field;

/**
 * 注解检测实现接口类
 */
public interface FieldAnnotationChecker {

    /**
     * 返回check结果
     *
     * @param value
     * @param field
     * @return boolean
     */
    public boolean check(Object value, Field field);
}
