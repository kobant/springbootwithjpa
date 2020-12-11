package com.example.springbootwithjpa.Test;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/10 19:29
 */
public class TestMq {

	public static Connection get() throws IOException, TimeoutException {
		//定义连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		//设置服务地址
		factory.setHost("127.0.0.1");
		//端口
		factory.setPort(5672);
		//设置账号信息，用户名、密码、vhost
		factory.setUsername("guest");
		factory.setPassword("guest");
		// 通过工程获取连接
		Connection connection = factory.newConnection();
		return connection;
	}

	@Test
	public void test1() throws IOException, TimeoutException {
		System.out.println(get());
	}



}
