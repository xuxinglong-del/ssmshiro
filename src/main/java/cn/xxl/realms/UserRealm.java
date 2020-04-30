package cn.xxl.realms;

import cn.xxl.domain.ActiveUser;
import cn.xxl.domain.User;
import cn.xxl.service.PermissionService;
import cn.xxl.service.RoleService;
import cn.xxl.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author xuxinglong
 * @date 2020/4/21 16:30
 * @Description 自定的用户认证类
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从token中获取身份信息
        String username = authenticationToken.getPrincipal().toString();
        //根据用户名到数据库中取出用户信息 如果查询不到 返回null
        User user = userService.queryUserByUserName(username);
        if (user != null) {
            ActiveUser activeUser = new ActiveUser();
            //查询角色
            activeUser.setRoles(this.roleService.queryRoleByUserId(user.getUserid()));
            //查询权限
            activeUser.setPermissions(this.permissionService.queryPermissionByUserId(user.getUserid()));
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername() + user.getAddress());
            //返回认证信息
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(activeUser, user.getUserpwd(), credentialsSalt, getName());
            return authenticationInfo;
        }
        return null;


    }

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取身份信息
        ActiveUser activeUser = (ActiveUser) principalCollection.getPrimaryPrincipal();
        //获取用户登录所拥有的角色
        List<String> roles = activeUser.getRoles();
        //获取用户所拥有的权限
        List<String> permissions = activeUser.getPermissions();
        //鉴权信息
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (null != roles && roles.size() > 0) {
            //将角色和权限放入鉴权信息中
            authorizationInfo.addRoles(roles);
        }
        if (null != permissions && permissions.size() > 0) {
            authorizationInfo.addStringPermissions(permissions);
        }
        return authorizationInfo;
    }
}
