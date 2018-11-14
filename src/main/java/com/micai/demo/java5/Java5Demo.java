package com.micai.demo.java5;
import static java.lang.System.*;

import org.springframework.stereotype.Component;

@Component
public class Java5Demo {
	
	/**
	 * java5 演示可变参数
	 * @param params 可变参数,可以看做是一个数组
	 */
	public static void sum(int...params) {
		int sum = 0;
		for (int i : params) {
			sum += i;
		}
		out.println("java5->可变参数演示: sum="+sum);
	}
	
	
	/**
	  * 演示非可变参数
	 * @param params
	 */
	public static void sumOldWay(int[] params) {
		int sum = 0;
		for (int i:params) {
			sum += i;
		}
		out.println("java5->非可变参数演示: sum="+sum);
	}
	
}
