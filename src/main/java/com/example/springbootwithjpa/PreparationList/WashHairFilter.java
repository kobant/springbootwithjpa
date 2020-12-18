package com.example.springbootwithjpa.PreparationList;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/11 15:17
 */
public class WashHairFilter extends AbstractPrepareFilter {
	public WashHairFilter(AbstractPrepareFilter nextPrepareFilter) {
		super(nextPrepareFilter);
	}

	@Override
	public void prepare(PreparationList preparationList) {
		if (preparationList.isWashHair()){
			System.out.println("洗头");
		}
	}
}
