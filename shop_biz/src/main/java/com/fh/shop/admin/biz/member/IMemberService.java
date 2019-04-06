package com.fh.shop.admin.biz.member;

import com.fh.shop.admin.po.member.Member;
import com.fh.shop.backend.backend.backend.po.backend.common.DataTableResult;

public interface IMemberService {
    //查看会员信息
    DataTableResult findMemberList(Member member, Integer draw, int start, int length);
    //修改回显
    Member findMember(Integer id);
    //修改
    void updateMember(Member member);
}
