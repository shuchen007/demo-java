package com.micai.demo.java8;

@FunctionalInterface
public interface IConvert<T,F> {
	T convert(F from);
}
