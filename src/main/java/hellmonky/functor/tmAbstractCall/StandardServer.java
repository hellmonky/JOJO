package hellmonky.functor.tmAbstractCall;

/**
 * Created by yuanlai.xwt on 2017/7/4.
 */
public final class StandardServer extends LifecycleMBeanBase{
    @Override
    protected void initInternal() throws Exception {
        super.initInternal();
        System.out.println("in StandardServer initInternal");
    }
}
