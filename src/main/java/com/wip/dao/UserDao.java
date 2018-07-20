/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/20 9:46
 **/
package com.wip.dao;

import com.wip.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    /**
     * 通过用户名和密码查找用户
     * @param username
     * @param password
     * @return
     */
    User getUser(@Param("username") String username,@Param("password") String password);
}
