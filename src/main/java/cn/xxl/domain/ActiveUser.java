package cn.xxl.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author xuxinglong
 * @date 2020/4/21 17:15
 * @Description  用户容器类
 */
@Repository
public class ActiveUser implements Serializable {
    private User user;
    private List<String> roles;
    private List<String> permissions;

    public ActiveUser() {
    }

    public ActiveUser(User user, List<String> roles, List<String> permissions) {
        this.user = user;
        this.roles = roles;
        this.permissions = permissions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
