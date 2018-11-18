package com.micai.demo.java5.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericMethod {

	public <K, V> V getValue(K k, V v) {
		return v;
	}

	public static <K extends Object> void setK(K k) {

	}

	/** 演示非泛型方法  */
//	public void setT(T t) {
//		
//	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Map<String, String> map = new HashMap<>();
	}
}
