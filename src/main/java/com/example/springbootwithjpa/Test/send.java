package com.example.springbootwithjpa.Test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/10 19:39
 */
public class send{
	private static final String QUEUE_NAME = "basic_queue";
	@Test
	public void test() throws IOException, TimeoutException {
		//消息发送端与mq服务创建连接
		Connection connection = TestMq.get();
		//建立通道
		Channel channel = connection.createChannel();
		//声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "hello world";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println("生产者已发送：" + message);
		channel.close();
		connection.close();
	}

	    //private static final String QUEUE_NAME = "work_queue";
	   @Test
		public  void test1() throws Exception {
			Connection connection = TestMq.get();
			Channel channel = connection.createChannel();
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			// 循环发布任务
			for (int i = 1; i <= 20; i++) {
				// 消息内容
				String message = "task .. " + i;
				channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
				System.out.println("生产者发送消息：" + message);
				Thread.sleep(500);
			}
			channel.close();
			connection.close();

	}
}