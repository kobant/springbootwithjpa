package com.example.springbootwithjpa.configuration;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/17 10:30
 */
@Component
public class AsyncTask {
	@Async
	public Future<Boolean> task1() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(1000);
		long end = System.currentTimeMillis();
		System.out.println("task1 耗时："+(end-start));
		return new AsyncResult<>(true);
	}

	public Future<Boolean> task2() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(3000);
		long end = System.currentTimeMillis();
		System.out.println("task2 耗时："+(end-start));
		return new AsyncResult<>(true);
	}
}
