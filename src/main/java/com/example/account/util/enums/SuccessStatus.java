package com.example.account.util.enums;

import org.springframework.http.HttpStatus;

public enum SuccessStatus implements BaseCode{
	_OK(HttpStatus.OK, "COMMON200", "성공입니다."),

	_CREATED(HttpStatus.CREATED, "COMMON201", "저장을 성공했습니다.");

	private final HttpStatus httpStatus;
	private final String code;
	private final String message;

	SuccessStatus(HttpStatus httpStatus, String code, String message) {
		this.httpStatus = httpStatus;
		this.code = code;
		this.message = message;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	@Override
	public Integer getStatusValue() {
		return httpStatus.value();
	}
}
