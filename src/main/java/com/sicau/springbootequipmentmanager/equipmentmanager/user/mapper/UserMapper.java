package com.sicau.springbootequipmentmanager.equipmentmanager.user.mapper;

import com.sicau.springbootequipmentmanager.equipmentmanager.dto.UserPerms;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-02
 */
public interface UserMapper extends BaseMapper<User> {
    List<UserPerms> selectUserPerms(Integer userId);
}
