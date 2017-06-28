package hellmonky.annotationVerification.test;

import hellmonky.annotationVerification.defineAnnotation.ArrayStringRange;
import hellmonky.annotationVerification.defineAnnotation.LengthLimitRange;
import hellmonky.annotationVerification.defineAnnotation.Required;

/**
 * Created by yuanlai.xwt on 2017/6/27.
 * 测试bean，用于使用当前自定义的检查注解
 */
public class TestAnnotationBean {
    //必填项检测
    @Required
    private String userId;
    //必填，长度限制
    @Required
    @LengthLimitRange(minValue = 1, maxValue = 10)
    private String userName;
    //必填，取值范围限制
    @Required
    @ArrayStringRange(valueArray = {"football", "basketball", "swimming"})
    private String habby;

    @SuppressWarnings(value = { "" })
    private String description;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHabby() {
        return habby;
    }

    public void setHabby(String habby) {
        this.habby = habby;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
