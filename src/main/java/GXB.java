import bean.*;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GXB {
    private final static Logger LOGGER = Logger.getLogger(GXB.class);
    private boolean change = true;
    private boolean hasLocation = true;
    private Gson gson;
    private DB db;

    public StealUserList getUserList(boolean change, boolean hasLocation){


        String Url = Util.Steal_User_List_Pre + Util.Change + this.change + Util.AND + Util.Has_Location + this.hasLocation;
        String StealListString = GxbHttp.GET(Url);
        gson = new Gson();
        return gson.fromJson(StealListString, StealUserList.class);
    }
    public void insertDB(StealUserList stealUserList) throws SQLException {
        List<StealUserList.DataBean.ListBean> userList = stealUserList.getData().getList();
        for(int i =0; i < userList.size(); i++){
            StealUserList.DataBean.ListBean userInfo = userList.get(i);
            String userId = userInfo.getUserId();
            String nickName = userInfo.getNickName();
            Object head = userInfo.getHead();
            String distance = userInfo.getDistance();
            int type = userInfo.getType();
            int power = userInfo.getPower();
            boolean canSteal = userInfo.isCanSteal();
            Object countDown = userInfo.getCountDown();
            Object stealCount = userInfo.getStealCount();

            User user = new User();
            user.setUserId(userId);
            user.setNickName(nickName);
            user.setPower(power);
            db = new DB();
            Connection connection = db.getConnection();
            db.insert(connection, user);
            connection.close();
        }
    }
    public void insertWhileList() throws SQLException {
        DB db = new DB();
        Connection connection = db.getConnection();

        List<String> whitelistUserId = new ArrayList<String>();
        int count = 1;
        while(true){
            String recordString = GxbHttp.GET(Util.WhilelistUrl + Util.PageNo + count);
            gson = new Gson();
            Record record = gson.fromJson(recordString, Record.class);
            if(record == null){
                connection.close();
            }
            if(record.getData().size() == 0)
                break;
            List<Record.DataBean> recordlist = record.getData();
            for(int i = 0; i < recordlist.size(); i++){
                String userid = recordlist.get(i).getStealUserId();
                String nickname = recordlist.get(i).getStealNick();
                User user = new User();
                user.setUserId(userid);
                user.setNickName(nickname);
                db.insertWhitelist(connection, user);

            }
            count++;
        }
        connection.close();

    }

    public UserFortuneList getUserFortune(String userId){
        String url = Util.Steal_From_User_Pre + userId + Util.Fortune_List;
        String userFortuneListString = GxbHttp.GET(url);
        gson = new Gson();
        return gson.fromJson(userFortuneListString, UserFortuneList.class);
    }
    public StealResult steal(String userId, String fortuneId){
        String url = Util.Steal_From_User_Pre + userId + Util.Mine + fortuneId;
        RequestBody requestBody = RequestBody.create(null, "");
        String stealResultString = GxbHttp.POST(url, requestBody);
        gson = new Gson();
        StealResult stealResult = gson.fromJson(stealResultString, StealResult.class);
        return  stealResult;
    }
    public void startMine(){
        String url = Util.Mine_Pre + Util.My_User_Id + Util.Mine_Post;
        String myFortuneListString = GxbHttp.GET(url);
        gson = new Gson();
        MyFortuneList myFortuneList = gson.fromJson(myFortuneListString, MyFortuneList.class);
        List<MyFortuneList.DataBean.MinesBean> fortuneList = myFortuneList.getData().getMines();
        for(int i = 0; i < fortuneList.size(); i++){
            MyFortuneList.DataBean.MinesBean fortuneInfo = fortuneList.get(i);
            int id = fortuneInfo.getId();
            int status = fortuneInfo.getStatus();
            long validTime = fortuneInfo.getValidTime();
            String symbol = fortuneInfo.getSymbol();
            double amount = fortuneInfo.getAmount();
            //通过时间来判断是否需要收割，减少服务器访问次数
            if(new Date().getTime() >= validTime && !symbol.equals("BCDN")){
                String mineUrl = Util.Mine_Pre + Util.My_User_Id + Util.Mine + String.valueOf(id) + Util.V2;
                String mineResultString = GxbHttp.GET(mineUrl);
                MineResult mineResult = gson.fromJson(mineResultString, MineResult.class);
                System.out.println("收取自己的 " + symbol + mineResult.getData().getDrawAmount() + "个");
            }

        }
    }
    public void signin(){
        SignIn signIn = new SignIn();
        signIn.setApplicationChannel(Util.MyDevice.ApplicationChannel);
        signIn.setDeviceHeight(Util.MyDevice.DeviceHeight);
        signIn.setDeviceId(Util.MyDevice.DeviceId);
        signIn.setDevicePixelRatio(Util.MyDevice.DevicePixelRatio);
        signIn.setOs(Util.MyDevice.Os);
        signIn.setDeviceWidth(Util.MyDevice.DeviceWidth);
        signIn.setModel(Util.MyDevice.Model);
        signIn.setOsVersion(Util.MyDevice.OsVersion);
        signIn.setVersion(Util.MyDevice.Version);

        gson = new Gson();
        String signInString = gson.toJson(signIn);
        RequestBody requestBody = RequestBody.create(MediaType.parse(Util.ApplicationJson), signInString);
        String signResultString = GxbHttp.POST(Util.SingInURL, requestBody);
        SigninResult signinResult = gson.fromJson(signResultString, SigninResult.class);
        System.out.println(signResultString);
    }

    public void uploadLocation(double latitude, double longtitude){
        Location location = new Location();
        location.setLatitude(latitude);
        location.setLongitude(longtitude);
        gson = new Gson();
        String locationString = gson.toJson(location);
        RequestBody requestBody = RequestBody.create(MediaType.parse(Util.ApplicationJson), locationString);
        String locationResultString = GxbHttp.POST(Util.UploadLocationUrl, requestBody);
        //SigninResult signinResult = gson.fromJson(signResultString, SigninResult.class);
        System.out.println(locationResultString);
    }
    public void startStealWhitelist() throws SQLException {
        DB db = new DB();
        Connection connection = db.getConnection();

        List<String> userIds = db.getwhitelist(connection);

        for(int i =0; i < userIds.size(); i++){
            UserFortuneList userFortuneList = getUserFortune(userIds.get(i));
            List<UserFortuneList.DataBean> fortuneList = userFortuneList.getData();
            for(int j = 0; j < fortuneList.size(); j++){
                UserFortuneList.DataBean fortuneInfo = fortuneList.get(j);
                int mineId = fortuneInfo.getMineId();
                String symbol = fortuneInfo.getSymbol();
                boolean fortuneCanSteal = fortuneInfo.isCanSteal();
                long validDate = fortuneInfo.getValidDate();
                double amount = fortuneInfo.getAmount();
                if(fortuneCanSteal == true){
                    try{
                        StealResult stealResult = steal(userIds.get(i), String.valueOf(mineId));
                        //System.out.println(stealResult.getData().getStealAmount());
                        System.out.println(new Date() + "  偷取用户  " + userIds.get(i) + " 的 " + symbol + " " + stealResult.getData().getStealAmount() + " 个");
                    } catch (Exception e){
                        //System.out.println("财富可偷，但User不可偷");
                        db.deletewhitelist(connection, userIds.get(i));
                }
//                    StealResult stealResult = steal(userIds.get(i), String.valueOf(mineId));
//                    System.out.println(stealResult.getData().getStealAmount());
//                    System.out.println("偷取用户" + userIds.get(i) + "的" + symbol + " " + stealResult.getData().getStealAmount() + "个");
                }
            }
        }
        connection.close();
    }

    public void startSteal(){

        StealUserList stealUserList = getUserList(change, hasLocation);
        List<StealUserList.DataBean.ListBean> userList = stealUserList.getData().getList();
        if(userList.size() == 0){change = false;}
        for(int i =0; i < userList.size(); i++){
            StealUserList.DataBean.ListBean userInfo = userList.get(i);
            String userId = userInfo.getUserId();
            String nickName = userInfo.getNickName();
            Object head = userInfo.getHead();
            String distance = userInfo.getDistance();
            int type = userInfo.getType();
            int power = userInfo.getPower();
            boolean canSteal = userInfo.isCanSteal();
            Object countDown = userInfo.getCountDown();
            Object stealCount = userInfo.getStealCount();
            if(canSteal == true){
                UserFortuneList userFortuneList = getUserFortune(userId);
                List<UserFortuneList.DataBean> fortuneList = userFortuneList.getData();
                for(int j = 0; j < fortuneList.size(); j++){
                    UserFortuneList.DataBean fortuneInfo = fortuneList.get(j);
                    int mineId = fortuneInfo.getMineId();
                    String symbol = fortuneInfo.getSymbol();
                    boolean fortuneCanSteal = fortuneInfo.isCanSteal();
                    long validDate = fortuneInfo.getValidDate();
                    double amount = fortuneInfo.getAmount();
                    if(fortuneCanSteal == true){
                        StealResult stealResult = steal(userId, String.valueOf(mineId));
                        System.out.println("偷取用户" + nickName + "的" + symbol + " " + stealResult.getData().getStealAmount() + "个");
                        //LOGGER.info("偷取用户" + nickName + "的" + symbol + " " + stealResult.getData().getStealAmount() + "个");
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GXB gxb = new GXB();
        //String myMineUrl = Util.Mine_Pre + Util.My_User_Id + Util.Mine_Post;
        //StealUserList stealUserList = gxb.getUserList(false, true);
        //UserFortuneList userFortuneList = gxb.getUserFortune("Pzdjt8CZtHtaecH3JxD007260");
        //StealResult stealResult = gxb.steal("xn9PEDnfIF8xRUHv0CX0353137305", "399162345");
//        while(true){
//            gxb.startSteal();
//            //gxb.startMine();
//            //Thread.sleep(1000);
//        }
        //gxb.startSteal();
        //LOGGER.debug("debug");
        //LOGGER.info("info");
        //LOGGER.error("error");
//        while(true){
//            StealUserList stealUserList = gxb.getUserList(true, true);
//            gxb.insertDB(stealUserList);
//
//        }
//        while(true){
//            gxb.startSteal();
//            System.out.println("一次收完，歇一下，开始下一次");
//            Thread.sleep(5000);
//        }
        while(true){
            try{
                gxb.insertWhileList();
                System.out.println("扫描完成");

                System.out.println("开始采集");
                gxb.startMine();

                gxb.startStealWhitelist();
                System.out.println("偷取一次完成");

                gxb.startSteal();
                System.out.println("偷取最后一个列表完成");

                Thread.sleep(60000);
            } catch(Exception e){
                e.printStackTrace();
                Thread.sleep(1000);
            }

        }

//        gxb.signin();
//        gxb.uploadLocation(120.2000000, 30.27000000);
        //System.out.println();
    }
}
