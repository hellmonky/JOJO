package hellmonky.testPackage.logService;

/**
 * Created by yuanlai.xwt on 2017/6/23.
 */

public class LogService {
    private LogService(){

    }

    private Logger getLogger(LogLevel level){
        return null;
    }

    public LogService getInstance(){
        return new LogService();
    }
}
