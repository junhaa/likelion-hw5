package com.example.account.member.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.account.member.entity.Member;
import com.example.account.member.exception.MemberNotExistException;
import com.example.account.member.presentation.dto.MemberRequestDto;
import com.example.account.member.repository.MemberRepository;
import com.example.account.util.enums.ErrorStatus;
import com.example.account.util.exception.GeneralException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{
	private final MemberRepository memberRepository;

	@Override
	public void login(MemberRequestDto.LoginRequestDto request){
		Member member = memberRepository.findByUserId(request.getUserId())
			.orElseThrow(() -> new MemberNotExistException());

		if(!member.getPassword().equals(request.getPassword())){
			throw new GeneralException(ErrorStatus._PASSWORD_INVALID);
		}
	}

}
