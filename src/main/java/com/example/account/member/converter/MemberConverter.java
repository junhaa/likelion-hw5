package com.example.account.member.converter;

import com.example.account.member.entity.Member;
import com.example.account.member.presentation.dto.MemberRequestDto;

public class MemberConverter {
	public static Member toMember(MemberRequestDto.SignupRequestDto request){
		return Member.builder()
			.email(request.getEmail())
			.password(request.getPassword())
			.userId(request.getUserId())
			.phone(request.getPhone())
			.build();
	}
}
