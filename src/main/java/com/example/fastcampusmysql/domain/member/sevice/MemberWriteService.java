package com.example.fastcampusmysql.domain.member.sevice;

import com.example.fastcampusmysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberWriteService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member register(RegisterMemberCommand command) {
        var member = Member.builder()
                .email(command.email())
                .nickname(command.nickname())
                .birthday(command.birthday())
                .build();
        var savedMember = memberRepository.save(member);

        return savedMember;
    }

    public void changeNickname(Long memberId, String nickname) {
        var member = memberRepository.findById(memberId).orElseThrow();
        member.changeNickname(nickname);
        memberRepository.save(member);
        // TODO: 변경내역 히스토리를 기록한다.
    }
}