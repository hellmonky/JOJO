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
 * 元素长度范围注解
 * @author maomq
 * @since 2013-08-29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface LengthLimitRange {

    static final int MIN_VALUE = 0;

    static final int MAX_VALUE = 255;

    public int minValue() default MIN_VALUE;

    public int maxValue() default MAX_VALUE;
}

