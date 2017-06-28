package hellmonky.controller.annotationVerification;

/**
 * Created by yuanlai.xwt on 2017/6/27.
 * 测试入口
 */
public class TestEntery {
    /*
    public static void main(String[] args) {
        TestAnnotationBean testAnnotationBean =new TestAnnotationBean();

        testAnnotationBean.setUserId("AAA");
        testAnnotationBean.setUserName("12345678901");
        testAnnotationBean.setHabby("walking");
        testAnnotationBean.setDescription("ggsgsgsggs");

        JsonUtil jsonUtil = new ReflectionJsonUtil();
        String result = jsonUtil.toJson(testAnnotationBean,false,false,false);
        System.out.println(result);

        // 手动调用Bean检测，但是在实际程序中，往往会和选型的框架结合处理，例如Jersey
        if(!AnnotationCheckerUtil.checkField(testAnnotationBean)) {
            System.out.println("Something is wrong!");
        }
    }
    //*/
}
