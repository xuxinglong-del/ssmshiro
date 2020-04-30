package cn.xxl.mapper;

import cn.xxl.domain.Role;

import java.util.List;

/**
 * @author xuxinglong
 * @date 2020/4/21 16:49
 * @Description
 */
public interface RoleMapper {
    /**
     * 根据用户id查询角色
     * @param userid
     * @return
     */
    List<Role> queryRolesByUserId(Integer userid);
}
