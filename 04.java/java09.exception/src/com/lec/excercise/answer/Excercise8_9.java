package com.lec.excercise.answer;

import javax.management.RuntimeErrorException;

public class Excercise8_9 {

	public static void main(String[] args) {
		
		throw new UnsupportedFunctionException("지원하지 않는 기능입니다", 100);
		
		
	}

}

class UnsupportedFunctionException extends RuntimeException {
	private int ERR_CODE = 100; // 에러코드 저장
	
	UnsupportedFunctionException(String msg, int errCode) {
		super(msg);
		ERR_CODE = errCode;
	}
	UnsupportedFunctionException(String msg) {
		this(msg, 100);
	}
	
	
	public int getErrorCode() {
		return ERR_CODE;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "[" + getErrorCode() + "]" + super.getMessage();
	}
	
}