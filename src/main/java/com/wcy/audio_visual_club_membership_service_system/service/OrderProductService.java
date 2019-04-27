package com.wcy.audio_visual_club_membership_service_system.service;

import com.wcy.audio_visual_club_membership_service_system.pojo.OrderProduct;
import com.wcy.audio_visual_club_membership_service_system.pojo.OrderProductExample;
import com.wcy.audio_visual_club_membership_service_system.pojo.OrderProductKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderProductService {
    long countByExample(OrderProductExample example);

    int deleteByExample(OrderProductExample example);

    int deleteByPrimaryKey(OrderProductKey key);

    int insert(OrderProduct record);

    int insertSelective(OrderProduct record);

    List<OrderProduct> selectByExample(OrderProductExample example);

    OrderProduct selectByPrimaryKey(OrderProductKey key);

    int updateByExampleSelective(@Param("record") OrderProduct record, @Param("example") OrderProductExample example);

    int updateByExample(@Param("record") OrderProduct record, @Param("example") OrderProductExample example);

    int updateByPrimaryKeySelective(OrderProduct record);

    int updateByPrimaryKey(OrderProduct record);
}
