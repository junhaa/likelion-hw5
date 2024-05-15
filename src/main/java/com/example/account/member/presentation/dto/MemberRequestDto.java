package com.example.account.member.presentation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class MemberRequestDto {

	@Getter
	@Setter
	public static class SignupRequestDto {
		@NotBlank(message = "이메일을 입력해주세요.")
		@Email(message = "이메일 형식을 맞춰주세요.")
		private String email;

		@NotBlank(message = "전화번호를 입력해주세요 ")
		@Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "전화번호 형식을 맞춰주세요.")
		private String phone;

		@NotBlank(message = "아이디를 입력해주세요.")
		@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "아이디는 영문자와 숫자만 포함할 수 있습니다.")
		private String userId;

		@NotBlank(message = "비밀번호를 입력해주세요.")
		@Size(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
		@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*()_+={};:,<.>]).{8,}$", message = "비밀번호는 영어, 숫자, 특수문자를 포함해야 합니다.")
		private String password;
	}

	@Getter
	@Setter
	public static class LoginRequestDto {

		@NotBlank(message = "아이디를 입력해주세요.")
		private String userId;

		@NotBlank(message = "비밀번호를 입력해주세요.")
		private String password;
	}

}
