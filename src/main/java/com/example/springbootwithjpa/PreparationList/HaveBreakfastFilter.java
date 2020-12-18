package com.example.springbootwithjpa.PreparationList;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/11 15:18
 */
public class HaveBreakfastFilter extends AbstractPrepareFilter {
	public HaveBreakfastFilter(AbstractPrepareFilter nextPrepareFilter) {
		super(nextPrepareFilter);
	}

	@Override
	public void prepare(PreparationList preparationList) {
		if (preparationList.isHaveBreakfast()){
			System.out.println("吃早餐");
		}
	}
}
