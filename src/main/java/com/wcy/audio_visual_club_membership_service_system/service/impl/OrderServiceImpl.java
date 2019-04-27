package com.wcy.audio_visual_club_membership_service_system.service.impl;

import com.wcy.audio_visual_club_membership_service_system.mapper.OrderInfoMapper;
import com.wcy.audio_visual_club_membership_service_system.mapper.OrderInfoMapper;
import com.wcy.audio_visual_club_membership_service_system.pojo.OrderInfo;
import com.wcy.audio_visual_club_membership_service_system.pojo.OrderInfoExample;
import com.wcy.audio_visual_club_membership_service_system.pojo.OrderInfo;
import com.wcy.audio_visual_club_membership_service_system.service.OrderService;
import com.wcy.audio_visual_club_membership_service_system.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("OrderInfoService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderInfoMapper OrderInfoMapper;

    @Override
    public long countByExample(OrderInfoExample example) {
        return OrderInfoMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderInfoExample example) {
        return OrderInfoMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return OrderInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderInfo record) {
        return OrderInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderInfo record) {
        return OrderInfoMapper.insertSelective(record);
    }

    @Override
    public List<OrderInfo> selectByExample(OrderInfoExample example) {
        return OrderInfoMapper.selectByExample(example);
    }

    @Override
    public OrderInfo selectByPrimaryKey(Integer id) {
        return OrderInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(OrderInfo record, OrderInfoExample example) {
        return OrderInfoMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(OrderInfo record, OrderInfoExample example) {
        return OrderInfoMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderInfo record) {
        return OrderInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderInfo record) {
        return OrderInfoMapper.updateByPrimaryKey(record);
    }
}
