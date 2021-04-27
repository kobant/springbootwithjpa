package com.example.springbootwithjpa.exception;


import com.example.springbootwithjpa.enums.ErrCode;

public class ErrCodeException extends JMException {

	public ErrCodeException(ErrCode code) {
		super(code.getCode(),code.getMsgZ());
	}

}
