package com.example.fastcampusmysql.application.usecase;

import org.springframework.stereotype.Service;

import com.example.fastcampusmysql.domain.follow.service.FollowWriteService;
import com.example.fastcampusmysql.domain.member.sevice.MemberReadService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateFollowMemberUsecase {
    final private MemberReadService memberReadService;
    final private FollowWriteService followWriteService;

    public void execute(Long fromMemberId, Long toMemberId) {
        var fromMember = memberReadService.getMember(fromMemberId);
        var toMember = memberReadService.getMember(toMemberId);

        followWriteService.create(fromMember, toMember);
    }
}
