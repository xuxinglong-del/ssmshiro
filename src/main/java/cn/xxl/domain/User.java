package cn.xxl.domain;

import java.io.Serializable;

/**
 * @author xuxinglong
 * @date 2020/4/21 16:31
 * @Description
 */
public class User implements Serializable {
    private Integer userid;
    private String username;
    private String userpwd;
    private String sex;
    private String address;

    public User() {
    }

    public User(Integer userid, String username, String userpwd, String sex, String address) {
        this.userid = userid;
        this.username = username;
        this.userpwd = userpwd;
        this.sex = sex;
        this.address = address;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
