package hellmonky.functor.annotationVerification;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hellmonky.functor.annotationVerification.checkCondition.FieldAnnotationChecker;
import hellmonky.functor.annotationVerification.checkCondition.impl.ArrayStringRangeAnnotationChecker;
import hellmonky.functor.annotationVerification.checkCondition.impl.LengthLimitRangeAnnotationChecker;
import hellmonky.functor.annotationVerification.checkCondition.impl.RequiredAnnotationChecker;
import hellmonky.functor.annotationVerification.defineAnnotation.ArrayStringRange;
import hellmonky.functor.annotationVerification.defineAnnotation.LengthLimitRange;
import hellmonky.functor.annotationVerification.defineAnnotation.Required;

/**
 * Created by yuanlai.xwt on 2017/6/27.
 * Bean属性获取，用于在接口参数检查的时候，获取每一个请求参数的属性
 */
public class AnnotationCheckerUtil {
    private static Map<Class<?>, FieldAnnotationChecker> holder = new HashMap<Class<?>, FieldAnnotationChecker>();

    static {
        holder.put(Required.class, new RequiredAnnotationChecker());
        holder.put(LengthLimitRange.class, new LengthLimitRangeAnnotationChecker());
        holder.put(ArrayStringRange.class, new ArrayStringRangeAnnotationChecker());
    }

    /**
     * 获取Bean中所有的属性
     *
     * @param clazz
     * @param fieldList
     */
    private static void getAllField(Class<?> clazz, List<Field> fieldList) {
        if (fieldList == null) {
            fieldList = new ArrayList<Field>();
        }

        Field[] fieldArray = clazz.getDeclaredFields();
        for (Field fieldTemp : fieldArray) {
            fieldList.add(fieldTemp);
        }

        Class<?> superClazz = clazz.getSuperclass();

        if (superClazz != Object.class) {
            getAllField(superClazz, fieldList);
        }
    }

    /**
     * 对传入的JAVABean属性进行检测（使用注解）
     *
     * @param objParam
     * @return
     */
    public static boolean checkField(Object objParam) {
        List<Field> fieldList = new ArrayList<Field>();

        getAllField(objParam.getClass(), fieldList);

        if (fieldList == null || fieldList.isEmpty()) {
            return true;
        }

        for (Field fieldTemp : fieldList) {
            fieldTemp.setAccessible(true);
            Object value = null;
            try {
                value = fieldTemp.get(objParam);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            Annotation[] fieldAnnotations = fieldTemp.getAnnotations();

            for (Annotation annotation : fieldAnnotations) {
                FieldAnnotationChecker checker = holder.get(annotation.annotationType());

                if (null != checker && !checker.check(value, fieldTemp)) {
                    return false;
                }
            }
        }

        return true;
    }
}
