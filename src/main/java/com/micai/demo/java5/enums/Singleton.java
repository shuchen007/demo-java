package com.micai.demo.java5.enums;

public class Singleton {

	private static final Singleton singleton = new Singleton();

	private static Singleton instance;

	private Singleton() {
	}

	// 1.饿汉模式
	public static Singleton getInstanc1() {
		return singleton;
	}

	// 2.懒汉模式
	public static Singleton getInstance2() {
		if (null == instance) {
			synchronized (Singleton.class) {
				instance = new Singleton();
			}
		}
		return instance;
	}

	// 3.双重校验锁
	public static Singleton getInstance3() {
		if (null == instance) {
			synchronized (Singleton.class) {
				if (null == instance) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	// 4.静态内部类  (通过类加载机制来保证线程的安全性,Lazy-Loading,效率高)
	public static Singleton getInstance4() {
		return SingletonInstance.INSTANCE;
	}
	private static class SingletonInstance {
		private static final Singleton INSTANCE = new Singleton();
	}
	
	// 5.枚举实现单例模式 (由于JVM对枚举类型做了特殊的处理,每一个枚举类型和枚举变量在JVM中都是唯一的)
	public static Color getInstance5() {
		return Color.INSTANCE;
	}
}

enum Color {
	INSTANCE
} 







