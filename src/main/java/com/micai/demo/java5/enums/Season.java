package com.micai.demo.java5.enums;

public enum Season {

	SPRING, // 春
    SUMMER, // 夏
    AUTUMN, // 秋
    WINTER; // 冬
	
	int code;
	
	private Season() {}
	private Season(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}

/** 
 * 反编译class文件：
  public final class com.micai.demo.java5.enums.Season extends java.lang.Enum<com.micai.demo.java5.enums.Season> {
  public static final com.micai.demo.java5.enums.Season SPRING;
  public static final com.micai.demo.java5.enums.Season SUMMER;
  public static final com.micai.demo.java5.enums.Season AUTUMN;
  public static final com.micai.demo.java5.enums.Season WINTER;
  public static com.micai.demo.java5.enums.Season[] values();
  public static com.micai.demo.java5.enums.Season valueOf(java.lang.String);
  static {};
}

用于 switch 语句
实现单例模式
*/
