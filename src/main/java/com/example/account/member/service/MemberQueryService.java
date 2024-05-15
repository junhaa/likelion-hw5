package com.example.account.member.service;

import com.example.account.member.presentation.dto.MemberRequestDto;

public interface MemberQueryService {
	void login(MemberRequestDto.LoginRequestDto request);
}

