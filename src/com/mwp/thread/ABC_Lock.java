package com.mwp.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ABC_Lock {
	
	private static ReentrantLock lock = new ReentrantLock();//共享变量锁
	
	private static String status = "A";//共享变量标志是否打印
	
	private static class ThreadA implements Runnable{

		private String name;
		int count;
		
		private ThreadA(String name,int count){
			this.name = name;
			this.count = count;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(count > 0 ){
				try{
					lock.lock();
					if("A".equals(status)){
						System.out.print(name);
						count--;
						status="B";
					}
				}finally{
					lock.unlock();
				}
			}
		}
		
	}
	private static class ThreadB implements Runnable{

		private String name;
		int count;
		
		private ThreadB(String name,int count){
			this.name = name;
			this.count = count;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(count > 0 ){
				try{
					lock.lock();
					if("B".equals(status)){
						System.out.print(name);
						count--;
						status="C";
					}
				}finally{
					lock.unlock();
				}
			}
		}
		
	}
	private static class ThreadC implements Runnable{

		private String name;
		int count;
		
		private ThreadC(String name,int count){
			this.name = name;
			this.count = count;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(count > 0 ){
				try{
					lock.lock();
					if("C".equals(status)){
						System.out.print(name);
						count--;
						status="A";
					}
				}finally{
					lock.unlock();
				}
			}
		}
		
	}
	
	public static void main(String[] args){
		new Thread(new ThreadA("A",10)).start();
		new Thread(new ThreadB("B",10)).start();
		new Thread(new ThreadC("C",10)).start();
	}
}
