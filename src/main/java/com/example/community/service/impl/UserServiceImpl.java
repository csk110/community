package com.example.community.service.impl;

import com.example.community.mapper.UserMapper;
import com.example.community.model.User;
import com.example.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenSK
 * @date 2019-07-25 - 17:42
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int addUserInfo(String accountId) {
        User user1 = userMapper.getUserByAccountId(accountId);
        if(user1!=null){
            return 0;
        }
        return userMapper.addUser(accountId);
    }
}
