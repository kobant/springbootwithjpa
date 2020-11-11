package com.example.springbootwithjpa.Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/11/11 9:36
 */
public class TestForch {

	@Test
	public void test() {
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		items.forEach((j,k) -> System.out.println("聪聪: "+j+ "嘿嘿 :" +k));

		items.forEach((j,k)->{
			System.out.println("测试新特性判断");
			if ("D".equals(k)){
				System.out.println("聪聪 ：E" );
			}
		});

		items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));

		items.forEach((k, v) -> {
			System.out.println("Item : " + k + " Count : " + v);
			if ("E".equals(k)) {
				System.out.println("Hello E");
			}
		});
	}

	@Test
	public void test02(){
		List<String> items = new ArrayList<>();
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("D");
		items.add("E");

		//lambda
		//Output : A,B,C,D,E
		items.forEach(item->System.out.println(item));

		//Output : C
		items.forEach(item->{
			if("C".equals(item)){
				System.out.println(item);
			}
		});

		items.forEach(item ->{
			if ("c".equalsIgnoreCase(item)){
				System.out.println("还真的是你："+item);
			}
		});

		//method reference
		//Output : A,B,C,D,E
		items.forEach(System.out::println);

		//Stream and filter
		//Output : B
		items.stream()
				.filter(s->s.contains("B"))
				.forEach(System.out::println);
	}
}
