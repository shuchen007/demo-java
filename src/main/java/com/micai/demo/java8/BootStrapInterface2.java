package com.micai.demo.java8;

public interface BootStrapInterface2 {
	
	default Integer add (int x, int y) {
		return x+y;
	}
	
	static double div (int x, int y) {
		return Math.floorDiv(x, y);
	}
}
