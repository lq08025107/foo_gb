import bean.StealUserList;
import bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    public Connection con;
    public ResultSet resultSet;
    public PreparedStatement sql;
    public Connection getConnection(){
        try{
            Class.forName(Util.name);
            con = DriverManager.getConnection(Util.url, Util.user, Util.password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    public void insert(Connection connection, User user) throws SQLException {
        sql = connection.prepareStatement("replace into user (user_id, nick_name, power) VALUES("+
                "?"+","+"?"+","+"?"
                +")" );
        sql.setString(1, user.getUserId());
        sql.setString(2, user.getNickName());
        sql.setInt(3, user.getPower());
        sql.executeUpdate();
        sql.close();
    }

    public void insertWhitelist(Connection connection, User user) throws SQLException {
        sql = connection.prepareStatement("replace into " + Util.db + "(user_id, nick_name) VALUES("+
                "?"+","+"?"
                +")" );
        sql.setString(1, user.getUserId());
        sql.setString(2, user.getNickName());
        sql.executeUpdate();
        sql.close();
    }

    public List<String> getwhitelist(Connection connection) {
        //每次都从数据库中取
        List<String> userIds = new ArrayList<String>();
        String sql = "select * from " + Util.db;
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                userIds.add(rs.getString(1));
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userIds;
    }

    public void deletewhitelist(Connection connection, String userId){
        String sql = "delete from " + Util.db + " where user_id='" + userId + "'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) connection.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getNickName(Connection connection, String userID) {
        String nickName = null;
        String sql = "select nick_name from "+ Util.db +" where user_id='" + userID + "'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                nickName = rs.getString(1);
            }

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nickName;
    }
    public static void main(String[] args) throws SQLException {
        DB db = new DB();
        Connection connection = db.getConnection();
        List<String> result = db.getwhitelist(connection);
        db.getNickName(connection, "1f9pqoVcZBVOpai658l004764");
        System.out.println("");
    }
}
