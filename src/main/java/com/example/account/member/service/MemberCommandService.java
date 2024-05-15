package com.example.account.member.service;

import com.example.account.member.entity.Member;
import com.example.account.member.presentation.dto.MemberRequestDto;

public interface MemberCommandService {
	Member join(MemberRequestDto.SignupRequestDto request);
	void withdraw(String userId);
}
