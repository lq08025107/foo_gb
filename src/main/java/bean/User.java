package bean;

public class User {
    private String userId;
    private String nickName;
    private int power;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", power=" + power +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
