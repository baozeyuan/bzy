package com.fh.shop.admin.biz.member;

import com.fh.core.util.DateUtil;
import com.fh.shop.admin.mapper.member.IMemberMapper;
import com.fh.shop.admin.po.member.Member;
import com.fh.shop.admin.vo.MemberVO;
import com.fh.shop.backend.backend.backend.po.backend.common.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements IMemberService{
    @Autowired
    private IMemberMapper memberMapper;
    /**
     * 查看会员信息
     * @param member
     * @param draw
     * @param start
     * @param length
     * @return
     */
    @Override
    public DataTableResult findMemberList(Member member, Integer draw, int start, int length) {
            //开始位置的下标
            member.setStartPos(start);
            //每页的条数
            member.setPageSize(length);
            //获取总条数
            Long totalCount= memberMapper.findMemberCount(member);

            List<Member> memberList=memberMapper.findMemberList(member);
            //包装用户VO
            List<MemberVO> memberVoList = wrapperMemberVO(memberList);

        DataTableResult data = DataTableResult.dataTableResultData(memberVoList, draw, totalCount, totalCount);

        System.out.println(data);
        return data;
    }

    /**
     * 修改回显
     * @param id
     * @return
     */
    @Override
    public Member findMember(Integer id) {
        Member member = memberMapper.findMember(id);
        member.setBirthdayStr(DateUtil.date2Str(member.getBirthday(),DateUtil.Y_M_D));
        return member;
    }

    /**
     * 修改
     * @param member
     */
    @Override
    public void updateMember(Member member) {
        memberMapper.updateMember(member);
    }

    //包装用户VO
    private List<MemberVO> wrapperMemberVO(List<Member> userList) {
        List<MemberVO> memberVoList=new ArrayList<>();
        for (Member memberInfo : userList) {
            MemberVO memberVO = getUserVo(memberInfo);
            memberVoList.add(memberVO);

        }
        return memberVoList;
    }
    //VO转po
    private MemberVO getUserVo(Member memberInfo) {
        MemberVO memberVO=new MemberVO();
        memberVO.setId(memberInfo.getId());
        memberVO.setUserName(memberInfo.getUserName());
        memberVO.setBirthday(memberInfo.getBirthday());
        memberVO.setEmail(memberInfo.getEmail());
        memberVO.setPhone(memberInfo.getPhone());
        memberVO.setRegTime(memberInfo.getRegTime());
        memberVO.setPassword(memberInfo.getPassword());
        memberVO.setAreaName(memberInfo.getAreaName());
        return memberVO;
    }
}
