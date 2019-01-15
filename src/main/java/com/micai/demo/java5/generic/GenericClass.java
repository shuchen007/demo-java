package com.micai.demo.java5.generic;

/**
 * 定义单泛型
 * @author Administrator
 * @param <T>
 */
public class GenericClass<T> {
	private T t;
	private String a;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}
	
/**
 * 定义两个泛型
 * @author Administrator
 * @param <T>
 * @param <S>
 */
class GenericClass1<T, S> {
	private T t;
	private S s;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public S getS() {
		return s;
	}
	public void setS(S s) {
		this.s = s;
	}
	
}

/**
 * 定义泛型继承对象
 * @author Administrator
 * @param <T>
 */
class GenericClass2<T extends Object> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}
