package cn.nnu.jyjs.etpweb.bean;

public class User {

    private Integer userId;

    private String userName;

    private String userEmail;

    private String userPassword;

    private Integer userStatus;

    private String userAuthority;

    private String userHeadUrl;

    public User(){
    }

    public User(String userName){
        this.userName = userName;
    }

    public User(String userName,String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(String userName,String userPassword,String userEmail){
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUsereEmail() {
        return userEmail;
    }

    public void setUsereEmail(String usereEmail) {
        this.userEmail = usereEmail == null ? null : usereEmail.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(String userAuthority) {
        this.userAuthority = userAuthority == null ? null : userAuthority.trim();
    }

    public String getUserHeadUrl() {
        return userHeadUrl;
    }

    public void setUserHeadUrl(String userHeadUrl) {
        this.userHeadUrl = userHeadUrl == null ? null : userHeadUrl.trim();
    }
}