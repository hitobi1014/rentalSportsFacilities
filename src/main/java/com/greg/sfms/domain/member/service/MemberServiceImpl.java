package com.greg.sfms.domain.member.service;

import com.greg.sfms.domain.member.domain.Member;
import com.greg.sfms.domain.member.dto.MemberInfo;
import com.greg.sfms.domain.member.repository.MemberRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepositoryImpl memberRepository;

    public MemberServiceImpl(MemberRepositoryImpl memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public boolean join(MemberInfo memberJoin) {
        // 비밀번호 암호화/복호화
        memberRepository.save(memberJoin.toEntity());
        return true;
    }

    @Override
    public MemberInfo getMember(MemberInfo memberInfo) {
        Member member = memberRepository.findByLoginInfo(memberInfo.toEntity());
        MemberInfo memInfo = new MemberInfo().toDto(member);
        return memInfo;
    }

    @Override
    public List<MemberInfo> getMembers() {
        List<Member> getMembers = memberRepository.findAll();
        List<MemberInfo> result = new ArrayList<>();
        getMembers.forEach(item -> result.add(new MemberInfo().toDto(item)));
        return result;
    }
}
