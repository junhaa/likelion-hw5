package com.example.account.member.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.account.member.entity.Member;
import com.example.account.member.presentation.dto.MemberRequestDto;
import com.example.account.member.service.MemberCommandService;
import com.example.account.member.service.MemberQueryService;
import com.example.account.util.response.CustomApiResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberRestController {

	private final MemberCommandService memberCommandService;
	private final MemberQueryService memberQueryService;

	@PostMapping("/sign-up")
	public ResponseEntity<CustomApiResponse<?>> signup(@Valid @RequestBody MemberRequestDto.SignupRequestDto request){
		Member join = memberCommandService.join(request);
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(CustomApiResponse.createSuccess(HttpStatus.CREATED.value(), null, "회원가입에 성공하였습니다."));
	}


}
