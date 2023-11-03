package com.greg.sfms.domain.member.service;

import com.greg.sfms.domain.member.dto.MemberInfo;
import com.greg.sfms.domain.member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceImplTest {

    @Autowired
    private MemberService service;

    @Autowired
    private MemberRepository repository;
    @DisplayName("회원가입테스트")
    @Test
    @Transactional
    public void 도메인테스트 () throws Exception {

        //given
        MemberInfo joinInfo = MemberInfo.builder()
                .email("hitobi")
                .emailDomain("naver.com")
                .mobile("0105235235")
                .nickName("김또깡")
                .name("김민")
                .passWord("1234")
                .build();
        //when
        service.join(joinInfo);

        MemberInfo getMember = service.getMember(MemberInfo.builder()
                .email("hitobi")
                .emailDomain("naver.com")
                .passWord("1234")
                .build()
        );

        //then
        Assertions.assertThat("김민").isEqualTo(getMember.getName());
    }

    @DisplayName("회원전체조회")
    @Test
    @Transactional
    public void 회원전체조회 () throws Exception {
        //given
        MemberInfo joinInfo = MemberInfo.builder()
                .email("hitobi")
                .emailDomain("naver.com")
                .mobile("0105235235")
                .nickName("김또깡")
                .name("김민")
                .passWord("1234")
                .build();
        service.join(joinInfo);
        List<MemberInfo> members = service.getMembers();
        //when
        members.forEach(item -> System.out.println(item.toString()));
        //then
    }
}