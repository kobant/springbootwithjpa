package com.example.springbootwithjpa.PreparationList;

import javax.servlet.FilterChain;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/11 15:41
 */

public interface StudyPrepareFilter {
	public void doFilter(PreparationList preparationList, FilterChain filterChain);
}
