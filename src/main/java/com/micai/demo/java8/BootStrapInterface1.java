package com.micai.demo.java8;

public interface BootStrapInterface1 {
	
	/** 加, defined in {@link BootStrapInterface1} */
	default Integer add (int x, int y) {
		return x+y;
	}
	
	/** 除, defined in {@link BootStrapInterface1} */
	static double div (int x, int y) {
		return Math.floorDiv(x, y);
	}
}
