package hellmonky.functor.annotationVerification.defineAnnotation;

/**
 * Created by yuanlai.xwt on 2017/6/27.
 */
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 字符串范围注解
 * @author maomq
 * @since 2013-08-29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface ArrayStringRange {
    public String[] valueArray();
}
