package aliyun.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by yuanlai.xwt on 2017/5/27.
 */

@Path("Welcome")
public class Welcome {

    private String welcomeStr;

    public Welcome(){
        this.welcomeStr = "welcome to apsara stack proxy";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listPhysicalHost() {
        return this.welcomeStr;
    }
}