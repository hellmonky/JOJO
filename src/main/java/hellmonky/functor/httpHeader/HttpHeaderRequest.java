package hellmonky.functor.httpHeader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by yuanlai.xwt on 2017/6/30.
 */
public class HttpHeaderRequest {

    private String address;
    private URL url;
    private HttpURLConnection con;

    public HttpHeaderRequest(String address) {
        try{
            this.address = address;
            this.url = new URL(address);
            this.con = (HttpURLConnection)this.url.openConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getHeaderProperties(){
        Map<String,List<String>> headers = this.con.getHeaderFields();
        for(Map.Entry<String,List<String>> entry : headers.entrySet()){
            List<String> currentValues = entry.getValue();
            System.out.println("----------- current key -----------");
            System.out.println(entry.getKey());
            System.out.println("----------- current value start -----------");
            for(String value : currentValues){
                System.out.println(value);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        String url = "https://www.baidu.com";
        HttpHeaderRequest test = new HttpHeaderRequest(url);
        test.getHeaderProperties();
    }
}
