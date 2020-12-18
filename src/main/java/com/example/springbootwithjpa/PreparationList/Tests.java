package com.example.springbootwithjpa.PreparationList;

import org.junit.Test;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/11 15:19
 */
public class Tests {

	@Test
	public void testResponsibility() {
		PreparationList preparationList = new PreparationList();
		preparationList.setWashFace(true);
		preparationList.setWashHair(true);
		preparationList.setHaveBreakfast(true);

		Studys study = new Studys();

		AbstractPrepareFilter haveBreakfastFilter = new HaveBreakfastFilter(null);
		AbstractPrepareFilter washFaceFilter = new WashFaceFilter(haveBreakfastFilter);
		AbstractPrepareFilter washHairFilter = new WashHairFilter(washFaceFilter);


		washHairFilter.doFilter(preparationList, study);
	}

}
