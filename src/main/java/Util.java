import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class Util {
    public static final Logger LOGGER = Logger.getLogger(Util.class);
    public static Properties getProperty(){
        Properties prop = null;
        try {
            prop = new Properties();
            prop.load(Util.class.getResourceAsStream("/conf.properties"));

        } catch (IOException e) {
            LOGGER.error("check the configuration file");
        }
        return prop;
    }

    public static final String url= getProperty().getProperty("JDBC");
    public static final String name=getProperty().getProperty("NAME");
    public static final String user=getProperty().getProperty("USER");
    public static final String password=getProperty().getProperty("PASSWORD");
    public static final String db = getProperty().getProperty("DB");
    public static final String My_User_Id = getProperty().getProperty("MY_USER_ID");
    public static final String Authorization = getProperty().getProperty("MY_AUTH");




    //可偷用户列表前缀
    public static final String Steal_User_List_Pre = "https://walletgateway.gxb.io/miner/steal/user/list/v2?";
    //指定用户前缀
    public static final String Steal_From_User_Pre= "https://walletgateway.gxb.io/miner/steal/";

    public static final String Mine_Pre = "https://walletgateway.gxb.io/miner/";

    public static final String Mine_Post = "/mine/list/v2";

    public static final String Change = "change=";
    public static final String Has_Location = "hasLocation=";
    public static final String AND = "&";

    public static final String V2 = "/v2";

    public static final String SingInURL = "https://walletgateway.gxb.io/customer/daily/signin/v2";

    public static final String Fortune_List = "/mine/list";
    public static final String Mine = "/mine/";



    public static final String ApplicationJson = "application/json";
    public static final String Host = "walletgateway.gxb.io";
    public static final String Content_Type = "application/json;charset=utf-8";
    public static final String Origin = "https://blockcity.gxb.io";
    public static final String Accept_Encoding ="br, gzip, deflate";
    public static final String Content_Length = "0";
    public static final String Connection = "keep-alive";
    public static final String Accept = "application/json, text/plain, */*";
    public static final String User_Agent = "Mozilla/5.0 (iPhone; CPU iPhone OS 11_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15F79 (5578685952)";
    public static final String Accept_Language = "zh-CN";

    public static final String Referer = "https://blockcity.gxb.io/";

    public static final String WhilelistUrl = "https://walletgateway.gxb.io/miner/steal/record/list?pageSize=30";
    public static final String PageNo = "&pageNo=";

    public static final String UploadLocationUrl = "https://walletgateway.gxb.io/customer/location/upload";

    static class MyDevice{
        public static final String Version = "1.3.8";
        public static final String DeviceId = "CAE8D444-6875-4974-B6B5-ED700669A727";
        public static final String OsVersion = "11.4";
        public static final String Model = "iPhone8%2C1";
        public static final String Os = "ios";
        public static final String ApplicationChannel = "";
        public static final int DeviceWidth = 375;
        public static final int DeviceHeight = 667;
        public static final int DevicePixelRatio = 2;

    }
//?serverTimeZone=UTC"




    public static void main(String[] args){
        System.out.println(new Date().getTime());
    }
}
