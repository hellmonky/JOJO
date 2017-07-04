package hellmonky.functor.tmAbstractCall;

/**
 * Created by yuanlai.xwt on 2017/7/4.
 */
public class CallerTest {
    public static void main(String[] args){
        try {
            StandardServer standardServer = new StandardServer();
            standardServer.init();

            LifecycleMBeanBase lserver = new StandardServer();
            lserver.init();

            Lifecycle lcserver = new StandardServer();
            lcserver.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
