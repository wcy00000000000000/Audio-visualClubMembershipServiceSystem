package com.wcy.audio_visual_club_membership_service_system.service;

import com.wcy.audio_visual_club_membership_service_system.pojo.Staff;
import com.wcy.audio_visual_club_membership_service_system.pojo.StaffExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffService {
    long countByExample(StaffExample example);

    int deleteByExample(StaffExample example);

    int deleteByPrimaryKey(String account);

    int insert(Staff record);

    int insertSelective(Staff record);

    List<Staff> selectByExample(StaffExample example);

    Staff selectByPrimaryKey(String account);

    int updateByExampleSelective(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByExample(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}