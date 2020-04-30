package cn.xxl.service;

import cn.xxl.domain.User;

/**
 * @author xuxinglong
 * @date 2020/4/21 16:42
 * @Description
 */
public interface UserService {
   User queryUserByUserName(String username);
}
