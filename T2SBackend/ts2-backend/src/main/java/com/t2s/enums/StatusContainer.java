package com.t2s.enums;

public enum StatusContainer {
	EMPTY(0),FULL(1);
	
	int valueStatus;
	StatusContainer(int value){
		this.valueStatus = value;
	}
}
