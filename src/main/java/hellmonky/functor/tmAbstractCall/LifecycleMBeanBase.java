package hellmonky.functor.tmAbstractCall;

/**
 * Created by yuanlai.xwt on 2017/7/4.
 */
public abstract class LifecycleMBeanBase extends LifecycleBase{
    @Override
    protected void initInternal() throws Exception {
        System.out.println("in LifecycleMBeanBase initInternal");
    }
}
