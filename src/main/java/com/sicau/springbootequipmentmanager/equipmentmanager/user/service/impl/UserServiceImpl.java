package com.sicau.springbootequipmentmanager.equipmentmanager.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.UserInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.UserPerms;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.User;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.mapper.UserMapper;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserInfo(UserInfo userInfo) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name",userInfo.getUserName());
        wrapper.eq("user_password",userInfo.getUserPassword());
        return this.getOne(wrapper);
    }

    @Override
    public List<UserPerms> getUserPerms(Integer userId) {
        return userMapper.selectUserPerms(userId);
    }
}
