package hellmonky.controller;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import hellmonky.functor.simpleLoger.LogUtil;

/**
 * Created by yuanlai.xwt on 2017/6/29.
 */

public class Startup extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        LogUtil.getInstance().error("startup process.......");
        //System.out.println("startup process.......");

        /**
         * 添加启动时需要的特性
         */
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        // register resources and features
        classes.add(LogUtil.class);
        return classes;
    }
}
