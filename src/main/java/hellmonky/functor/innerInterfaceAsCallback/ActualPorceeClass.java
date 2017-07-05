package hellmonky.functor.innerInterfaceAsCallback;

/**
 * Created by yuanlai.xwt on 2017/7/5.
 */
public class ActualPorceeClass {

    public ActualPorceeClass(){

    }

    public BasicBean createDisk(BasicBean insertBean) {
        String url = "in_ActualPorceeClass";
        return ProcessingClass.transformResponse(url,insertBean,
            new ProcessingClass.CallBack<String, BasicBean>() {
                @Override
                public void execute(String aResp, BasicBean iResp) {
                    iResp.setPassword(aResp);
                }
            });
    }

    public static void main(String[] args){
        ActualPorceeClass test = new ActualPorceeClass();
        BasicBean bean = new BasicBean();
        bean.setUsername("ack");
        bean.setPassword("1");
        System.out.println("before call");
        System.out.println(bean.getUsername());
        System.out.println(bean.getPassword());
        test.createDisk(bean);
        System.out.println("after call");
        System.out.println(bean.getUsername());
        System.out.println(bean.getPassword());
    }
}
