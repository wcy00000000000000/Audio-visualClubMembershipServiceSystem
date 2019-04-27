package com.wcy.audio_visual_club_membership_service_system.service.impl;

import com.wcy.audio_visual_club_membership_service_system.mapper.OrderProductMapper;
import com.wcy.audio_visual_club_membership_service_system.pojo.OrderProduct;
import com.wcy.audio_visual_club_membership_service_system.pojo.OrderProductExample;
import com.wcy.audio_visual_club_membership_service_system.pojo.OrderProductKey;
import com.wcy.audio_visual_club_membership_service_system.service.OrderProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("orderProductService")
public class OrderProductServiceImpl implements OrderProductService {
    @Resource
    private OrderProductMapper orderProductMapper;

    @Override
    public long countByExample(OrderProductExample example) {
        return orderProductMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderProductExample example) {
        return orderProductMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(OrderProductKey key) {
        return orderProductMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int insert(OrderProduct record) {
        return orderProductMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderProduct record) {
        return orderProductMapper.insertSelective(record);
    }

    @Override
    public List<OrderProduct> selectByExample(OrderProductExample example) {
        return orderProductMapper.selectByExample(example);
    }

    @Override
    public OrderProduct selectByPrimaryKey(OrderProductKey key) {
        return orderProductMapper.selectByPrimaryKey(key);
    }

    @Override
    public int updateByExampleSelective(OrderProduct record, OrderProductExample example) {
        return orderProductMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(OrderProduct record, OrderProductExample example) {
        return orderProductMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderProduct record) {
        return orderProductMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderProduct record) {
        return orderProductMapper.updateByPrimaryKey(record);
    }
}
