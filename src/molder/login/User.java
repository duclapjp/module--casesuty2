package molder.login;

public class User {
    private String nickName;
    private String pass;

    public User() {
    }

    public User(String nickName, String pass) {
        this.nickName = nickName;
        this.pass = pass;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
