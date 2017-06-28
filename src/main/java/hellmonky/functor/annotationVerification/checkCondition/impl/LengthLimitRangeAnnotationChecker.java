package hellmonky.functor.annotationVerification.checkCondition.impl;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import hellmonky.functor.annotationVerification.checkCondition.FieldAnnotationChecker;
import hellmonky.functor.annotationVerification.defineAnnotation.LengthLimitRange;

/**
 * Created by yuanlai.xwt on 2017/6/27.
 */
public class LengthLimitRangeAnnotationChecker implements FieldAnnotationChecker {
    @Override
    public boolean check(Object value, Field field) {
        if (null == value) {
            System.out.println("The value is null or empty!");
            return true;
        }

        LengthLimitRange lengthRange = field
            .getAnnotation(LengthLimitRange.class);

        int maxValue = lengthRange.maxValue();

        int minValue = lengthRange.minValue();

        if (value instanceof String) {
            String strValue = (String) value;
            if (strValue.length() > maxValue || strValue.length() < minValue) {
                System.out
                    .println("The input value is out of the value limit range!");
                return false;
            }
        } else if (value instanceof Collection<?>) {
            Collection<?> collValue = (Collection<?>) value;
            if (collValue.size() > maxValue || collValue.size() < minValue) {
                System.out
                    .println("The input value is out of the value limit range!");
                return false;
            }
        } else if (value instanceof Map<?, ?>) {
            Map<?, ?> mapValue = (Map<?, ?>) value;
            if (mapValue.values().size() > maxValue
                || mapValue.values().size() < minValue) {
                System.out
                    .println("The input value is out of the value limit range!");
                return false;
            }
        }
        return true;
    }
}
