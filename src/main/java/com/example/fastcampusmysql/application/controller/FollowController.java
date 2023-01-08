package com.example.fastcampusmysql.application.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fastcampusmysql.application.usecase.CreateFollowMemberUsecase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/follow")
public class FollowController {
    final private CreateFollowMemberUsecase createFollowMemberUsecase;

    @PostMapping("/{fromId}/{toId}")
    public void create(@PathVariable Long fromId, @PathVariable Long toId) {
        createFollowMemberUsecase.execute(fromId, toId);
    }
}
