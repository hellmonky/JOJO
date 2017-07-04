package hellmonky.functor.tmAbstractCall;

/**
 * Created by yuanlai.xwt on 2017/7/4.
 */
public abstract class LifecycleBase implements Lifecycle {

    @Override
    public void init() throws Exception {
        System.out.println("LifecycleBase init start");
        initInternal();
        System.out.println("LifecycleBase init end");
    }


    protected abstract void initInternal() throws Exception;
}
