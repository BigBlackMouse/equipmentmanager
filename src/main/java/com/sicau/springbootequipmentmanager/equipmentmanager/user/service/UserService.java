package com.sicau.springbootequipmentmanager.equipmentmanager.user.service;

import com.sicau.springbootequipmentmanager.equipmentmanager.dto.UserInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.UserPerms;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-02
 */
public interface UserService extends IService<User> {
    User getUserInfo(UserInfo userInfo);
    List<UserPerms> getUserPerms(Integer userId);
}
