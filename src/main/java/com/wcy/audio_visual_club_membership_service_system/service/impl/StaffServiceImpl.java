package com.wcy.audio_visual_club_membership_service_system.service.impl;

import com.wcy.audio_visual_club_membership_service_system.mapper.StaffMapper;
import com.wcy.audio_visual_club_membership_service_system.pojo.Staff;
import com.wcy.audio_visual_club_membership_service_system.pojo.StaffExample;
import com.wcy.audio_visual_club_membership_service_system.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffMapper staffMapper;

    @Override
    public long countByExample(StaffExample example) {
        return staffMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(StaffExample example) {
        return staffMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String account) {
        return staffMapper.deleteByPrimaryKey(account);
    }

    @Override
    public int insert(Staff record) {
        return staffMapper.insert(record);
    }

    @Override
    public int insertSelective(Staff record) {
        return staffMapper.insertSelective(record);
    }

    @Override
    public List<Staff> selectByExample(StaffExample example) {
        return staffMapper.selectByExample(example);
    }

    @Override
    public Staff selectByPrimaryKey(String account) {
        return staffMapper.selectByPrimaryKey(account);
    }

    @Override
    public int updateByExampleSelective(Staff record, StaffExample example) {
        return staffMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Staff record, StaffExample example) {
        return staffMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Staff record) {
        return staffMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Staff record) {
        return staffMapper.updateByPrimaryKey(record);
    }
}
