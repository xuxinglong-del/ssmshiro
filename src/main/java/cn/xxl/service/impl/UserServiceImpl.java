package cn.xxl.service.impl;

import cn.xxl.domain.User;
import cn.xxl.mapper.UserMapper;
import cn.xxl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xuxinglong
 * @date 2020/4/21 16:42
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByUserName(String username) {

        return userMapper.queryUserByUserName(username);

    }
}
