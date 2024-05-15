package com.example.account.member.exception;

import com.example.account.util.enums.ErrorStatus;
import com.example.account.util.exception.GeneralException;

public class MemberNotExistException extends GeneralException {
	public MemberNotExistException() {
		super(ErrorStatus._MEMBER_NOT_EXIST);
	}
}
