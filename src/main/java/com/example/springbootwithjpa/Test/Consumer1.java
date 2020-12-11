package com.example.springbootwithjpa.Test;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/10 19:41
 */
public class Consumer1 {
	private static final String QUEUE_NAME = "basic_queue";

	@Test
	public void test() throws IOException, TimeoutException {
		//消息消费者与mq服务建立连接
		Connection connection = TestMq.get();
		//建立通道
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		DefaultConsumer consumer = new DefaultConsumer(channel) {
			// 获取消息，并且处理，这个方法类似事件监听，如果有消息的时候，会被自动调用

			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
									   byte[] body) throws IOException {
				// body 即消息体
				String msg = new String(body);
				System.out.println("消费者1接收到消息：" + msg);
			}
		};
		channel.basicConsume(QUEUE_NAME, true, consumer);
	}


	/**
	 * 一个生产发送消息到队列，允许有多个消费者接收消息，但是一条消息只会被一个消费者获取。
	 *
	 * 消费者一
	 *
	 * @throws IOException
	 * @throws TimeoutException
	 */
	@Test
	public void test2() throws IOException, TimeoutException {
		Connection connection = TestMq.get();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		DefaultConsumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				String msg = new String(body);
				System.out.println("消费者1接收到消息：" + msg);
				try {
					Thread.sleep(50);//模拟消费耗时
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		channel.basicConsume(QUEUE_NAME, true, consumer);
	}


	/**
	 * 测试消费者2
	 * @throws IOException
	 * @throws TimeoutException
	 */
	@Test
	public void test3() throws IOException, TimeoutException {
		Connection connection = TestMq.get();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		DefaultConsumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,byte[] body) throws IOException {
				String msg = new String(body);
				System.out.println("消费者2接收到消息：" + msg);
				try {
					Thread.sleep(50);//模拟消费耗时
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				channel.basicAck(envelope.getDeliveryTag(), false);
			}
		};
		channel.basicConsume(QUEUE_NAME, true, consumer);
	}
}
