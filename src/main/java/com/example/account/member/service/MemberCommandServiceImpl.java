package com.example.account.member.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.account.member.converter.MemberConverter;
import com.example.account.member.entity.Member;
import com.example.account.member.presentation.dto.MemberRequestDto;
import com.example.account.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberCommandServiceImpl implements MemberCommandService{

	private final MemberRepository memberRepository;

	@Override
	public Member join(MemberRequestDto.SignupRequestDto request) {
		return memberRepository.save(MemberConverter.toMember(request));
	}
}
