package hellmonky.annotationVerification.checkCondition.impl;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import hellmonky.annotationVerification.checkCondition.FieldAnnotationChecker;

/**
 * Created by yuanlai.xwt on 2017/6/27.
 */
public class RequiredAnnotationChecker implements FieldAnnotationChecker {

    @Override
    public boolean check(Object value, Field field) {
        if (null == value) {
            System.out.println("The required value is null!");
            return false;
        }

        if (value instanceof String) {
            String strValue = (String)value;
            if (strValue.isEmpty()) {
                System.out.println("The required value is null!");
                return false;
            }
        } else if (value instanceof Collection<?>) {
            Collection<?> collValue = (Collection<?>)value;
            if (collValue.isEmpty()) {
                System.out.println("The required value is null!");
                return false;
            }
        } else if (value instanceof Map<?, ?>) {
            Map<?, ?> mapValue = (Map<?, ?>)value;
            if (mapValue.isEmpty()) {
                System.out.println("The required value is null!");
                return false;
            }
        }
        return true;
    }
}
