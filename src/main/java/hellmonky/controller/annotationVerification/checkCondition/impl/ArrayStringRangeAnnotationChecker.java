package hellmonky.controller.annotationVerification.checkCondition.impl;

import java.lang.reflect.Field;

import hellmonky.controller.annotationVerification.checkCondition.FieldAnnotationChecker;
import hellmonky.controller.annotationVerification.defineAnnotation.ArrayStringRange;

/**
 * Created by yuanlai.xwt on 2017/6/27.
 */
public class ArrayStringRangeAnnotationChecker implements FieldAnnotationChecker {

    @Override
    public boolean check(Object value, Field field) {
        if (null == value) {
            System.out.println("The value is null or empty!");
            return true;
        }

        ArrayStringRange arrayRange = field
            .getAnnotation(ArrayStringRange.class);

        String[] strArray = arrayRange.valueArray();

        if (value instanceof String && strArray.length > 0) {
            for (String strTemp : strArray) {
                if (strTemp.equalsIgnoreCase(value.toString())) {
                    return true;
                }
            }
            System.out.println("The input value is out of the value range!");
            return false;
        }

        return true;
    }

}
