package cn.xxl.service;

import java.util.List;

/**
 * @author xuxinglong
 * @date 2020/4/21 16:57
 * @Description
 */
public interface RoleService {
    /**
     * 根据用户id查询角色
     * @param userid
     * @return
     */
    public List<String> queryRoleByUserId(Integer userid);
}
