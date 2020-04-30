package cn.xxl.service.impl;

import cn.xxl.domain.Role;
import cn.xxl.mapper.RoleMapper;
import cn.xxl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuxinglong
 * @date 2020/4/21 16:58
 * @Description
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<String> queryRoleByUserId(Integer userid) {
        List<Role> roleList = roleMapper.queryRolesByUserId(userid);

        List<String> roles = new ArrayList<>();
        //遍历
        for (Role role : roleList) {
            //获取角色名
            roles.add(role.getRolename());
        }
        return roles;
    }
}
