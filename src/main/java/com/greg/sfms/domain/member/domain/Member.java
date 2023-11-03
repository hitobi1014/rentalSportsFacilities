package com.greg.sfms.domain.member.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    이메일 주소, 도메인, 비밀번호, 휴대폰번호(인증), 이름, 별명
    @Column(length = 20, nullable = false)
    private String nickName;
    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String emailDomain;
    @Column(length = 20, nullable = false)
    private String passWord;

    @Column(length = 20, nullable = false)
    private String mobile;
    @Column(length = 20, nullable = false)
    private String name;

    @Builder
    private Member(String nickName, String email, String emailDomain, String passWord, String mobile, String name) {
        this.nickName = nickName;
        this.email = email;
        this.emailDomain = emailDomain;
        this.passWord = passWord;
        this.mobile = mobile;
        this.name = name;
    }
}
