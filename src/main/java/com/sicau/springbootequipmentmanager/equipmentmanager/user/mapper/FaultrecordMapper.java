package com.sicau.springbootequipmentmanager.equipmentmanager.user.mapper;

import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Faultrecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-02
 */
public interface FaultrecordMapper extends BaseMapper<Faultrecord> {


    Integer adminLogicDeleteByFauId(@Param("fauId") Integer fauId);

    Integer userLogicDeleteByFauId(Integer fauId);
}
