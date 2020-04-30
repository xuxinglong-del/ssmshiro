package cn.xxl.service;

import java.util.List;

/**
 * @author xuxinglong
 * @date 2020/4/21 17:07
 * @Description
 */
public interface PermissionService {
    /**
     * 根据用户id查询权限
     * @param userid
     * @return
     */
    public List<String> queryPermissionByUserId(Integer userid);
}
