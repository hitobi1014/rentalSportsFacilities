package com.greg.sfms.domain.member.repository;

import com.greg.sfms.domain.member.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final EntityManager em;

    //등록, 조회, 리스트조회, 수정, 삭제
    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }


    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    @Override
    public Member findByLoginInfo(Member member) {
        return em.createQuery("select m from Member m where m.email = :email and m.emailDomain = :emailDomain and m.passWord = :password", Member.class)
                .setParameter("email", member.getEmail())
                .setParameter("emailDomain", member.getEmailDomain())
                .setParameter("password", member.getPassWord())
                .getSingleResult();
    }



}
