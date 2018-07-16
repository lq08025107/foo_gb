import com.google.gson.Gson;
import okhttp3.*;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GxbHttp {
    private final static Logger LOGGER = Logger.getLogger(GxbHttp.class);
    private static OkHttpClient okHttpClient ;
    private RequestBody body;
    private  static Request.Builder builder;
    private static Gson gson;

    static {
        okHttpClient = new OkHttpClient.Builder().connectTimeout(20, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS).build();
        builder = new Request.Builder().addHeader("Host", Util.Host).
                addHeader("Origin", Util.Origin).
                addHeader("Accept-Encoding", Util.Accept_Encoding).
                addHeader("Connection", Util.Connection).
                addHeader("Accept", Util.Accept).
                addHeader("User-Agent",Util.User_Agent).
                addHeader("Authorization", Util.Authorization).
                addHeader("Referer", Util.Referer).
                addHeader("Accept-Language", Util.Accept_Language);
        gson = new Gson();
    }
    public static String GET(String url){
        String result = null;
        Request request = builder.url(url).get().build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            result = response.body().string();
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return result;
    }

    public static String POST(String url, RequestBody body){
        String result = null;
        Request request = builder.url(url).post(body).build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            result = response.body().string();
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(GxbHttp.GET("https://walletgateway.gxb.io/config/coins"));

    }
}
