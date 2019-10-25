package com.cbl.spring.cloud.service;

import com.cbl.spring.cloud.dao.UserInfoMapper;
import com.cbl.spring.cloud.entity.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserById(String userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

}
