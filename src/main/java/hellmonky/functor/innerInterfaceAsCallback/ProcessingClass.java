package hellmonky.functor.innerInterfaceAsCallback;

/**
 * Created by yuanlai.xwt on 2017/7/5.
 * 处理类
 */
public class ProcessingClass {

    public ProcessingClass(){

    }

    public interface CallBack<String,I>{
        public void execute(String aResp,I iResp);
    }

    public static <I> I transformResponse(String url,I bean,
                                          CallBack<String,I> callBack){
        I result = bean;
        callBack.execute(url,result);
        return result;
    }
}
