package cn.xxl.service.impl;

import cn.xxl.domain.Permission;
import cn.xxl.mapper.PermissionMapper;
import cn.xxl.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuxinglong
 * @date 2020/4/21 17:08
 * @Description
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 根据用户id查询权限
     * @param userid
     * @return
     */
    @Override
    public List<String> queryPermissionByUserId(Integer userid) {
        List<Permission> permissionList = permissionMapper.queryPermssionByUserId(userid);
        List<String> permissions = new ArrayList<>();
        for (Permission permission : permissionList) {
            //查询权限
            permissions.add(permission.getPercode());
        }
        return permissions;
    }
}
