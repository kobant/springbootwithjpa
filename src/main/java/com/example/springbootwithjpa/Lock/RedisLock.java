package com.example.springbootwithjpa.Lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 *实现Redis分布式锁
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/15 11:33
 */
@Component
public class RedisLock {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 加锁
	 * @param lockKey 加锁的Key
	 * @param timeStamp 时间戳：当前时间+超时时间
	 * @return
	 */
	public boolean lock(String lockKey,String timeStamp){
		if (stringRedisTemplate.opsForValue().setIfAbsent(lockKey,timeStamp));
		//对应setNx命令，可以设置，也就是key不存在，获的锁成功
		return true;
	}

}
