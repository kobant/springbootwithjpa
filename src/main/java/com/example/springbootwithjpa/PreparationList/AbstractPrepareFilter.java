package com.example.springbootwithjpa.PreparationList;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/11 14:55
 */
public abstract class AbstractPrepareFilter {

	private AbstractPrepareFilter nextPrepareFilter;

	public AbstractPrepareFilter (AbstractPrepareFilter nextPrepareFilter){
		this.nextPrepareFilter = nextPrepareFilter;
	}

	public void doFilter(PreparationList preparationList,Studys study){
		prepare(preparationList);

		if (nextPrepareFilter==null){
			study.study();
		}else {
			nextPrepareFilter.doFilter(preparationList,study);
		}
	}

	public abstract void  prepare(PreparationList preparationList);
}
