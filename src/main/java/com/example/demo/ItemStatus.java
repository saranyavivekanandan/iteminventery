package com.example.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ItemStatus {
	AVAILABLE,SOLD;
	
//		AVAILABLE("AVAILABLE"),SOLD("SOLD");
//	
//	private String text;
//	 
//	ItemStatus(String text){
//		this.text=text;
//	}
//	
//	@JsonCreator
//	public static ItemStatus convert(String s) {
//		
//		for(ItemStatus is:ItemStatus.values()) {
//			if(is.text.equals(s)) {
//				return is;
//			}
//		}
//		throw new IllegalArgumentException();
//	}
//	
//	@JsonValue
//	public String getText() {
//		return text;
//	}
}
