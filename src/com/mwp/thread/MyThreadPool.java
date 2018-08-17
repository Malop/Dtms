package com.mwp.thread;
/**
 * @author mwp
 * @describe 建立一个线程池
 * ThreadPoolExecutor是ExecutorService的实现
 */
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class MyThreadPool {

	private static int corePoolSize=20;//核心线程数
	private static int maximumPoolSize=23;//最大线程数
	private static long keepAliveTIme = 6000;//最大空闲时间
	private static TimeUnit unit = TimeUnit.SECONDS;//单位
	private static BlockingQueue<Runnable> workQueueArray = new ArrayBlockingQueue<Runnable>(30);//队列
	//private static BlockingQueue<Runnable> workQueueLinked = new LinkedBlockingDeque<Runnable>(30);
	
	private ThreadPoolExecutor executor ;//线程池
	
	public MyThreadPool(){
		executor = new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTIme,unit,workQueueArray);
	}

	//用submit来取代execute方法，submit可以得到线程执行的返回值
	public void submit(Thread thread){
        executor.submit(thread) ;
    }
	
	public void execute(Thread thread){
        executor.execute(thread) ;
    }
}
