package com.greg.sfms.domain.member.repository;

import com.greg.sfms.domain.member.domain.Member;

import java.util.List;

public interface MemberRepository {
    //등록, 조회, 리스트조회, 수정, 삭제
    void save(Member member);

    Member findOne(Long id);

    List<Member> findAll();

    Member findByLoginInfo(Member member);
}
