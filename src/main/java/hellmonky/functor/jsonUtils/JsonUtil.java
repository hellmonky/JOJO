package hellmonky.functor.jsonUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Created by wb-sk288659 on 2017/6/1.
 */
public interface JsonUtil {
    /**
     * To json string.
     *
     * @param object    the object
     * @param buildNull the build null 是否转换空值
     * @param iteration the iteration 是否迭代(双向迭代)
     * @return the string
     * @throws Exception the exception
     */
    String toJson(Object object, boolean buildNull, boolean iteration);

    /**
     * To json string.
     *
     * @param object    the object
     * @param buildNull 是否构造null值
     * @param inner     迭代内部非基本数据类
     * @param upward    迭代父类的属性
     * @return string string
     */
    String toJson(Object object, boolean buildNull, boolean inner, boolean upward);

    /**
     * Map 2 json string.
     *
     * @param object    the object
     * @param buildNull the build null 是否转换空值
     * @param iteration the iteration 是否迭代
     * @return the string
     * @throws Exception the exception
     */
    String map2Json(Map<Object, Object> object, boolean buildNull, boolean iteration) throws InstantiationException, IllegalAccessException, InvocationTargetException;

    /**
     * Map 2 json string.
     *
     * @param map       the map
     * @param buildNull 是否构造null值
     * @param inner     迭代内部非基本数据类
     * @param upward    迭代父类的属性
     * @return the string
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     */
    String map2Json(Map<Object, Object> map, boolean buildNull, boolean inner, boolean upward)
            throws InstantiationException, IllegalAccessException, InvocationTargetException;

    /**
     * List 2 json string.
     *
     * @param object    the object
     * @param buildNull the build null 是否转换空值
     * @param iteration the iteration 是否迭代
     * @return the string
     * @throws Exception the exception
     */
    String list2Json(List object, boolean buildNull, boolean iteration) throws InstantiationException, IllegalAccessException, InvocationTargetException;

    /**
     * List 2 json string.
     *
     * @param list      the list
     * @param buildNull the build null
     * @param inner     the inner
     * @param upward    the upward
     * @return the string
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     */
    String list2Json(List list, boolean buildNull, boolean inner, boolean upward)
            throws InstantiationException, IllegalAccessException, InvocationTargetException;

    /**
     *
     * @param clazz
     * @param jsonStr
     * @param <T>
     * @return
     */
    <T> T formatJson(Class<T> clazz, String jsonStr);

    /**
     * Json 2 map map.
     *
     * @param jsonStr the json str
     * @return the map
     * @throws Exception the exception
     */
    <T,O> Map<T,O> json2Map(Map<T, O> map, String jsonStr);

    /**
     * Json 2 list list.
     *
     * @param <T>     the type parameter
     * @param t       the t
     * @param jsonStr the json str
     * @return the list
     * @throws Exception the exception
     */
    <T> List<T> json2List(List<T> t, String jsonStr);
}
