package cn.xxl.domain;

import java.io.Serializable;

/**
 * @author xuxinglong
 * @date 2020/4/21 17:02
 * @Description
 */
public class Permission implements Serializable {
    private Integer perid;
    private String pername;
    private String percode;

    public Permission() {
    }

    public Permission(Integer perid, String pername, String percode) {
        this.perid = perid;
        this.pername = pername;
        this.percode = percode;
    }

    public Integer getPerid() {
        return perid;
    }

    public void setPerid(Integer perid) {
        this.perid = perid;
    }

    public String getPername() {
        return pername;
    }

    public void setPername(String pername) {
        this.pername = pername;
    }

    public String getPercode() {
        return percode;
    }

    public void setPercode(String percode) {
        this.percode = percode;
    }
}
