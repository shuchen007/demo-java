package com.micai.demo;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.micai.demo.java5.Java5Demo;
import com.micai.demo.java5.enums.Season;
import com.micai.demo.java5.generic.GenericClass;
import com.micai.demo.java5.generic.GenericMethod;

import static java.lang.System.*;

import java.io.Console;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Java5Test {
	

	/**可变参数*/
	@Test
	public void testVararg() {
		// 非可变参数形式
		int[] params = new int[] {1,2,3,4,5};
		Java5Demo.sumOldWay(params);
		// 可变参数形式1
		Java5Demo.sum(1,2,3,4,5);
		// 可变参数形式2
		Java5Demo.sum(params);
	}
	
	/**静态引入*/
	@Test
	public void testStaticImport() {
		// 非静态引入
		System.out.println("java5->非静态引入.");
		// 静态引入
		out.println("java5->静态引入.");
	}
	
	/**泛型类*/
	@Test
	public void testGeneric1() {
		// 泛型类
		GenericClass<String> gClass = new GenericClass<>();
		gClass.setT("String类型");
		System.out.println("java5->泛型类:"+gClass.getT());
	}
	
	/**泛型方法*/
	@Test
	public void testGeneric2() {
		GenericMethod gMethod = new GenericMethod();
		String value = gMethod.getValue("1001", "张三");
		System.out.println("java5->泛型方法: "+value);
	}
	
	/**枚举*/
	@Test
	public void testEnum () {
		System.out.println("java5->枚举: "+Season.WINTER);
		// value
		System.out.println("java5->枚举: "+Season.valueOf("WINTER"));
		// valueOf
		Season[] arr = Season.values();
		Arrays.asList(arr).stream().forEach(x -> System.out.print(x+"  "));
		// static {} 的作用.
	}
}
