/*
package com.example.springbootwithjpa.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

*/
/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/10 18:43
 *//*

@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class MsgReceiver {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RabbitHandler
	public void process(String content) {
		logger.info("接收处理队列A当中的消息： " + content);
	}

}
*/
