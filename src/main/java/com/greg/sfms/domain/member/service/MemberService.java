package com.greg.sfms.domain.member.service;

import com.greg.sfms.domain.member.dto.MemberInfo;

import java.util.List;

public interface MemberService {
    boolean join(MemberInfo memberJoin);

    MemberInfo getMember(MemberInfo memberInfo);

    List<MemberInfo> getMembers();
}
