package hellmonky.functor.simpleLoger;

import com.alibaba.druid.support.json.JSONUtils;

/**
 * Created by yuanlai.xwt on 2017/6/30.
 */
public class LogInfo {
    private Class<?> currentLogClass;
    private String content;

    public LogInfo(){

    }

    public Class<?> getCurrentLogClass() {
        return currentLogClass;
    }

    public void setCurrentLogClass(Class<?> currentLogClass) {
        this.currentLogClass = currentLogClass;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString(){
        String reuslt = "{\""+
            this.getCurrentLogClass().toString()+"\":\""+
            this.getContent()+"\"}";
        return reuslt;
    }
}
