package com.fh.shop.admin.mapper.member;

import com.fh.shop.admin.po.member.Member;
import com.fh.shop.backend.po.member.Member;

import java.util.List;

public interface IMemberMapper {
//获取总条数
    Long findMemberCount(Member member);
// 查看会员信息
    List<Member> findMemberList(Member member);
//修改回显
    Member findMember(Integer id);
//修改
    void updateMember(Member member);
}
