package com.wcy.audio_visual_club_membership_service_system.service.impl;

import com.wcy.audio_visual_club_membership_service_system.mapper.MemberMapper;
import com.wcy.audio_visual_club_membership_service_system.pojo.Member;
import com.wcy.audio_visual_club_membership_service_system.pojo.MemberExample;
import com.wcy.audio_visual_club_membership_service_system.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("memberService")
public class MembersServiceImpl implements MemberService {
    @Resource
    private MemberMapper memberMapper;

    @Override
    public long countByExample(MemberExample example) {
        return memberMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MemberExample example) {
        return memberMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return memberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Member record) {
        return memberMapper.insert(record);
    }

    @Override
    public int insertSelective(Member record) {
        return memberMapper.insertSelective(record);
    }

    @Override
    public List<Member> selectByExample(MemberExample example) {
        return memberMapper.selectByExample(example);
    }

    @Override
    public Member selectByPrimaryKey(Integer id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Member record, MemberExample example) {
        return memberMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Member record, MemberExample example) {
        return memberMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Member record) {
        return memberMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Member record) {
        return memberMapper.updateByPrimaryKey(record);
    }

    @Override
    public Member selectByAccount(String account) {
        return memberMapper.selectByAccount(account);
    }
}
