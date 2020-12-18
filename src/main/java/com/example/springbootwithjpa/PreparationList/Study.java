package com.example.springbootwithjpa.PreparationList;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/11 14:52
 */
public class Study {
	public void study(PreparationList preparationList){
		if (preparationList.isWashFace()){
			System.out.println("洗脸");
		}
		if (preparationList.isWashHair()){
			System.out.println("洗头");
		}
		if (preparationList.isHaveBreakfast()){
			System.out.println("吃早餐！");
		}
		System.out.println("我可以走了！");
	}
}
