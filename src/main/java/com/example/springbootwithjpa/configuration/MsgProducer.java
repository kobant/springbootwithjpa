package com.example.springbootwithjpa.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/10 17:04
 */
@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback {


	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	//由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
	private RabbitTemplate rabbitTemplate;

	/**
	 * 构造方法注入
	 */

	@Autowired
	public MsgProducer(RabbitTemplate rabbitTemplate){
		this.rabbitTemplate = rabbitTemplate;
		//rabbitTemplate如果为单例的话，那回调就是最后设置的内容
		rabbitTemplate.setConfirmCallback(this);
	}

	public void  sendMsg(String content){
		CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
		//把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
		rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTINGKEY_A, content, correlationId);
	}

	/**
	 * 回调
	 * @param correlationData
	 * @param ack
	 * @param s
	 */
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String s) {
         logger.info("回调id："+correlationData);
         if (ack){
         	logger.info("消息消费成功");
		 }else {
         	logger.info("消息消费失败："+s);
		 }
	}
}
