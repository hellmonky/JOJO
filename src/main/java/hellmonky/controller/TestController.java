package hellmonky.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import hellmonky.functor.annotationVerification.AnnotationCheckerUtil;
import hellmonky.functor.annotationVerification.test.TestAnnotationBean;

/**
 * Created by yuanlai.xwt on 2017/6/27.
 */
@Path("testAnnotationController")
public class TestController {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String caller(TestAnnotationBean testAnnotationBean) {
        System.out.println("call in action");
        Boolean result = AnnotationCheckerUtil.checkField(testAnnotationBean);
        if(result){
            return "GET request get bean success";
        } else {
            return "GET request get bean failed";
        }
    }
}
