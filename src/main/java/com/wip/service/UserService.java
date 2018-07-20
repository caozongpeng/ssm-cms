/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/20 9:49
 **/
package com.wip.service;

import com.wip.dao.UserDao;
import com.wip.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public boolean login(String username, String password) {
        User user = userDao.getUser(username,password);
        if (user == null) {
            return false;
        }else {
            return true;
        }
    }

}
