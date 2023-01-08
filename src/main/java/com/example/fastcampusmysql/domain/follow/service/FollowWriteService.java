package com.example.fastcampusmysql.domain.follow.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.example.fastcampusmysql.domain.follow.entity.Follow;
import com.example.fastcampusmysql.domain.follow.repository.FollowRepository;
import com.example.fastcampusmysql.domain.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FollowWriteService {
    final private FollowRepository followRepository;

    @Transactional
    public void create(MemberDto fromMember, MemberDto toMember) {
        Assert.isTrue(!fromMember.id().equals(toMember.id()), "From, To 회원이 동일합니다.");

        var follow = Follow.builder()
                .fromMemberId(fromMember.id())
                .toMemberId(toMember.id())
                .build();

        followRepository.save(follow);
    }
}
