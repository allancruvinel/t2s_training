package com.t2s.enums;

public enum Handling {
	BOARDING(0),DISCHARGE(1),GATE_IN(2),GATE_OUT(3),STACK(4),WEIGHING(5),SCANNER(6);
	
	int valueHandling;
	Handling(int value){
		this.valueHandling = value;
	}
}
