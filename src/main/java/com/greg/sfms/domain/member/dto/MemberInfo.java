package com.greg.sfms.domain.member.dto;

import com.greg.sfms.domain.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class MemberInfo {
    private String nickName;
    private String email;
    private String emailDomain;
    private String passWord;
    private String mobile;
    private String name;

    @Builder
    private MemberInfo(String nickName, String email, String emailDomain, String passWord, String mobile, String name) {
        this.nickName = nickName;
        this.email = email;
        this.emailDomain = emailDomain;
        this.passWord = passWord;
        this.mobile = mobile;
        this.name = name;
    }

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .emailDomain(emailDomain)
                .passWord(passWord)
                .name(name)
                .mobile(mobile)
                .nickName(nickName)
                .build();
    }

    public MemberInfo toDto(Member member) {
        nickName = member.getNickName();
        email = member.getEmail();
        emailDomain = member.getEmailDomain();
        passWord = member.getPassWord();
        mobile = member.getMobile();
        name = member.getName();
        return this;
    }
}
