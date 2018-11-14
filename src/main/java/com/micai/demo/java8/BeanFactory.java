package com.micai.demo.java8;

import java.util.function.Supplier;


public interface BeanFactory {
	static <T extends Object> T getInstance(Supplier<T> sup) {
		return sup.get();
	}
}
