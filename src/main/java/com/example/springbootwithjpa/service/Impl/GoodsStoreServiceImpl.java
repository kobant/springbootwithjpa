/*
package com.example.springbootwithjpa.service.Impl;

import com.example.springbootwithjpa.Lock.RedisLock;
import com.example.springbootwithjpa.dao.GoodsStoreRespository;
import com.example.springbootwithjpa.entity.GoodsStore;
import com.example.springbootwithjpa.service.GoodsStoreFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

*/
/**
 *
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/15 15:43
 *//*

@Service
public class GoodsStoreServiceImpl implements GoodsStoreFacade {

	@Autowired
	private GoodsStoreRespository goodsStoreRespository;

	@Autowired
	private RedisLock redisLock;

	*/
/**
	 * 超5秒报错
	 *//*

	private static final int TIMEOUT = 5*1000;

	@Override
	public String updateGoodsStore(String code,int count) {
		//上锁
		long time = System.currentTimeMillis() + TIMEOUT;
		if(!redisLock.lock(code, String.valueOf(time))){
			return "排队人数太多，请稍后再试.";
		}
		System.out.println("获得锁的时间戳："+String.valueOf(time));
		try {
			GoodsStore goodsStore = getGoodsStore(code);
			if(goodsStore != null){
				if(goodsStore.getStore() <= 0){
					return "对不起，卖完了，库存为："+goodsStore.getStore();
				}
				if(goodsStore.getStore() < count){
					return "对不起，库存不足，库存为："+goodsStore.getStore()+" 您的购买数量为："+count;
				}
				System.out.println("剩余库存："+goodsStore.getStore());
				System.out.println("扣除库存："+count);
				goodsStoreRespository.updateStore(code, count);
				try{
					//为了更好的测试多线程同时进行库存扣减，在进行数据更新之后先等1秒，让多个线程同时竞争资源
					Thread.sleep(1000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}
				return "恭喜您，购买成功！";
			}else{
				return "获取库存失败。";
			}
		} finally {
			//释放锁
			redisLock.release(code, String.valueOf(time));
			System.out.println("释放锁的时间戳："+String.valueOf(time));
		}
	}

	*/
/**
	 * 获取库存对象
	 * @param code
	 * @return
	 *//*

	@Override
	public GoodsStore getGoodsStore(String code) {
		Optional<GoodsStore> optional = goodsStoreRespository.findById(code);
		return optional.get();
	}
}
*/
