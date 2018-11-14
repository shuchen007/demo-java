package com.micai.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.micai.demo.java7.Java7Demo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Java7Test {

	/** 捕获多异常 (新语法) */
	@Test
	public void test1() {
		Integer[] arr = new Integer[] { 4 };
		try {
			int result = arr[0] / 0;
			System.out.println("java7-> 捕获多异常: result:" + result);
		} 
		catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
			System.out.println("java7-> 捕获多异常: " + e.getMessage() + e);
		}
	}
	
	/** 数字下划线*/
	@Test
	public void test2() {
		long num1 = 1888_328_9999L;
		System.out.println("java7-> 数字下划线: "+num1);
	}

	
	/** 增加二进制表示*/
	@Test
	public void test3() {
		int binary = 0B1001_0001;
		System.out.println("java7-> 二进制: "+binary);
		int decimal = 123;
		System.out.println("java7-> 十进制: "+decimal);
		int octal = 0123;
		System.out.println("java7-> 八进制: "+octal);
		int hex = 0X12AB;
		System.out.println("java7-> 十六进制: "+hex);
	}
	
	/** IO流 try with resources（新语法） */
	@Test
	public void test4() {
		File file = new File("C:\\Users\\Administrator\\Desktop\\test.txt");
		try (
				FileInputStream is = new FileInputStream(file);
				BufferedReader  br = new BufferedReader(new InputStreamReader(is))
			)
		{
			System.out.println("java7-> 新语法:"+br.readLine());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** IO流 传统方式*/
	public void test5() {
		File file = new File("C:\\Users\\Administrator\\Desktop\\test.txt");
		FileInputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			is  = new FileInputStream(file);
			isr = new InputStreamReader(is);
			br  = new BufferedReader(isr);
			System.out.println("java7-> IO传统读取: "+br.readLine());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				// 从外向内关闭
				br.close();
				isr.close();
				is.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/** NIO 简单示例*/
	@Test
	public void test6() {
		Java7Demo.testChannel();
	}
}
