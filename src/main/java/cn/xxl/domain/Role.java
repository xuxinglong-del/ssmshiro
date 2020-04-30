package cn.xxl.domain;

import java.io.Serializable;

/**
 * @author xuxinglong
 * @date 2020/4/21 16:49
 * @Description
 */
public class Role implements Serializable {
    private Integer roleid;
    private String rolename;

    public Role() {
    }

    public Role(Integer roleid, String rolename) {
        this.roleid = roleid;
        this.rolename = rolename;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
