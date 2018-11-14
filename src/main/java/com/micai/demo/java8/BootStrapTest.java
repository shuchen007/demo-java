package com.micai.demo.java8;

import java.util.function.Predicate;

public class BootStrapTest implements BootStrapInterface2,BootStrapInterface1 {

	@Override
	public Integer add(int x, int y) {
		return BootStrapInterface2.super.add(x, y);
	}
	
	public static String valueOf(Integer num) {
		return num+"";
	}
	
	public static <T> boolean test(T t,Predicate<T> condition) {
		return condition.test(t);
	}
}
