package hellmonky.logService.impl;

import hellmonky.logService.LogContent;
import hellmonky.logService.Logger;

/**
 * Created by yuanlai.xwt on 2017/6/23.
 */
public class Log4jService {

    private String log4j_property;
    private Logger logger;

    public Log4jService(){
        this.log4j_property = "";
        this.logger = null;
    }

    public Log4jService(String property){
        this.log4j_property = property;
    }


    public void write2Log(LogContent content, String contents) {

    }
}
