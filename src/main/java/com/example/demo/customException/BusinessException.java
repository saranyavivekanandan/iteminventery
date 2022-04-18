package com.example.demo.customException;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@Data
@AllArgsConstructor
public class BusinessException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
	
	public BusinessException(){
		
	}
	
	public BusinessException(String errorCode, String errorMessage){
		this.errorCode=errorCode;
		this.errorMessage=errorMessage;
	}

}
