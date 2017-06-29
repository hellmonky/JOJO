package hellmonky.controller;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;

import hellmonky.functor.simpleLoger.LogUtil;
import sun.rmi.runtime.Log;

/**
 * Created by yuanlai.xwt on 2017/6/29.
 */

public class Startup extends Application {

    /*
    @Context
    private Configuration configuration;
    */

    @Override
    public Set<Class<?>> getClasses() {
        /* 检查当前环境
        Collection<String> names = configuration.getPropertyNames();
        for(String name : names){
            System.out.println(name);
        }
        //*/

        LogUtil.getInstance().error("startup process.......");
        //System.out.println("startup process.......");

        // 添加特性
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        // register resources and features
        classes.add(LogUtil.class);
        return classes;
    }
}
