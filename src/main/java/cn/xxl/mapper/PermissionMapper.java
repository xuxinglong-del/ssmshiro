package cn.xxl.mapper;

import cn.xxl.domain.Permission;

import java.util.List;

/**
 * @author xuxinglong
 * @date 2020/4/21 17:09
 * @Description
 */
public interface PermissionMapper {
    /**
     * 根据用户id查询权限
     * @param userid
     * @return
     */
    List<Permission> queryPermssionByUserId(Integer userid);


}
