package com.mwp.consum;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mwp.dao.mapper.PriceMapper;
import com.mwp.dao.mapper.PriceVersionMapper;
import com.mwp.dao.model.Price;
import com.mwp.dao.model.PriceVersion;
import com.mwp.thread.MyThreadPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class singleConsumerTest {

	private static Logger _log = LoggerFactory.getLogger(singleConsumerTest.class);
	@Autowired
	PriceMapper priceMapper;
	
	@Autowired
	PriceVersionMapper priceVersionMapper;
	
	@Autowired
	MyThreadPool myThreadPool;
	
	
	/**
	 * 单一线程处理
	 */
	
	public void test(){
		for(int i=0;i<100;i++){
			Price price = priceMapper.selectByPrimaryKey(1);
			int ron = 10;
			price.setFront(price.getFront().subtract(new BigDecimal(ron)));
			price.setEnd(price.getEnd().add(new BigDecimal(ron)));
			price.setTotal(price.getFront().add(price.getEnd()));
			//id=1的记录把front-10，end+10,total=front+end
			priceMapper.updateByPrimaryKey(price);
			//写入新流水
			price.setId(null);
			priceMapper.insertSelective(price);
		}
	}
	
	/**
	 * 多线程更新数据
	 */
	@Test
	public void testThread(){
		try{
			//final CountDownLatch countDownLatch = new CountDownLatch(10);
			for(int i=0;i<1;i++){
				Thread t = new Thread (new Runnable() {
					public void run() {
						_log.info("1111线程开始执行-----"+Thread.currentThread().getName());
						try{
							Price price = priceMapper.selectByPrimaryKey(1);
							_log.info("asdasdas=====");
							int ron = 10;
							price.setFront(price.getFront().subtract(new BigDecimal(ron)));
							price.setEnd(price.getEnd().add(new BigDecimal(ron)));
							price.setTotal(price.getFront().add(price.getEnd()));
							//id=1的记录把front-10，end+10,total=front+end
							priceMapper.updateByPrimaryKey(price);
							//写入新流水
							price.setId(null);
							priceMapper.insertSelective(price);
							_log.info("2222线程执行结束-----"+Thread.currentThread().getName());
							//countDownLatch.countDown();
						}catch(Exception e){
							e.printStackTrace();
						}
						
					}
				});
				t.setDaemon(false);
				myThreadPool.execute(t);
				
			}
			//countDownLatch.await();
			_log.info(Thread.currentThread().getState()+"---主线程执行结束---"+Thread.currentThread().getName()+"----"+Thread.currentThread().isAlive());
			//Thread.sleep(5000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 多线程增加乐观锁更新
	 */
	public void testThreadVersion(){
		//主线程的try-catch
		try{
			final CountDownLatch countDownLatch = new CountDownLatch(3);
			_log.info("before==="+countDownLatch.getCount());
			for(int i=0;i<3;i++){
				Thread t = new Thread (new Runnable() {
					public void run() {
						//子线程的异常捕获
						try{
							_log.info("线程开始执行-----"+Thread.currentThread().getName());
							PriceVersion priceVersion = priceVersionMapper.selectByPrimaryKey(1);
							
							int ron = new Random().nextInt(20);
		                    _log.info("本次消费="+ron);
		                    priceVersion.setFront(new BigDecimal(ron));
		                    int count = priceVersionMapper.updateByVersion(priceVersion);
							if(count==0){
								_log.info("线程"+Thread.currentThread().getName()+"更新失败");
							}else{
								_log.info("线程"+Thread.currentThread().getName()+"更新成功");
								//写入新流水
								priceVersion.setId(null);
								priceVersionMapper.insertSelective(priceVersion);
							}
							countDownLatch.countDown();
							_log.info("线程执行结束-----"+Thread.currentThread().getName());
						}catch(Exception e){
							//e.printStackTrace();
							_log.info(Thread.currentThread().getName()+"异常被捕获");
							countDownLatch.countDown();
						}
						
					}
				});
				myThreadPool.submit(t);
				
			}
			while(countDownLatch.getCount()>0){
				countDownLatch.await();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
