package com.example.fastcampusmysql.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.member.sevice.MemberReadService;
import com.example.fastcampusmysql.domain.member.sevice.MemberWriteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "회원정보")
@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {
    final private MemberWriteService memberWriteService;
    final private MemberReadService memberReadService;

    @Operation(summary = "회원정보 등록")
    @PostMapping("")
    public MemberDto register(@RequestBody RegisterMemberCommand command) {
        var member = memberWriteService.register(command);
        return memberReadService.toDto(member);
    }

    @Operation(summary = "회원정보 조회")
    @GetMapping("/{id}")
    public MemberDto getMember(@PathVariable Long id) {
        return memberReadService.getMember(id);
    }
}
