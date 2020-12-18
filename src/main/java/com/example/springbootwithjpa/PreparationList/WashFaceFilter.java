package com.example.springbootwithjpa.PreparationList;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/11 15:16
 */
public class WashFaceFilter extends AbstractPrepareFilter {
	public WashFaceFilter(AbstractPrepareFilter nextPrepareFilter) {
		super(nextPrepareFilter);
	}

	@Override
	public void prepare(PreparationList preparationList) {
		if (preparationList.isWashFace()){
			System.out.println("洗脸");
		}
	}
}
