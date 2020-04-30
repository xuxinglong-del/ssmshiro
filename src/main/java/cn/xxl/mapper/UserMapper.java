package cn.xxl.mapper;

import cn.xxl.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author xuxinglong
 * @date 2020/4/21 16:33
 * @Description
 */
public interface UserMapper {

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    User queryUserByUserName(@Param("username")String username);
}
