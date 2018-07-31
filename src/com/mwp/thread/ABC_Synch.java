package com.mwp.thread;

public class ABC_Synch {

	public static class ThreadPrinter implements Runnable{

		private String name;//线程名称
		private Object pre;//前置锁对象
		private Object self;//本身对象
		private int count;//打印次数
		private ThreadPrinter(String name,Object pre,Object self,int count){
			this.name = name;
			this.pre = pre;
			this.self = self;
			this.count = count;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(count > 0){
				synchronized (pre) {//先获取前置锁
					synchronized(self){//再获取本身的锁
						System.out.print(name);
						count-- ;
						self.notifyAll();//告诉其他线程可以竞争获取self前置锁,当前self还未立即释放
					}
					try {//马上释放当前自身锁
						if(count == 0){
							pre.notifyAll();
						}else{
							pre.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException{
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		
		ThreadPrinter t1 = new ThreadPrinter("A",c,a,10);
		ThreadPrinter t2 = new ThreadPrinter("B",a,b,10);
		ThreadPrinter t3 = new ThreadPrinter("C",b,c,10);
		
		new Thread(t1).start();
		Thread.sleep(10);
		new Thread(t2).start();
		Thread.sleep(10);
		new Thread(t3).start();
		Thread.sleep(10);
	}
}
