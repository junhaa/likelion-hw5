package com.example.account.member.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@PostMapping("/login")
	public CustomApiResponse<?> login(@Valid @RequestBody MemberRequestDto.LoginRequestDto request){
		memberQueryService.login(request);
		return CustomApiResponse.createSuccess(HttpStatus.OK.value(), null, "로그인에 성공하였습니다.");
	}

	@DeleteMapping("/{userId}/withdraw")
	public CustomApiResponse<?> withdraw(@PathVariable(name = "userId") String userId){
		memberCommandService.withdraw(userId);
		return CustomApiResponse.createSuccess(HttpStatus.OK.value(), null, "회원이 정상적으로 탈퇴되었습니다.");
	}

}
