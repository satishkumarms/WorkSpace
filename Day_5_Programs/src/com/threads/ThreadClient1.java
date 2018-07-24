package com.threads;

public class ThreadClient1 {
	public static void main(String[] args) throws InterruptedException
	{
		Account acc = new Account();
		
		
		MyThread1 thread1 = new MyThread1(acc);
		thread1.setName("one");
		thread1.start();
		

		MyThread2 thread2 = new MyThread2(acc);
		thread2.setName("two");
		thread2.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
	
		
	}

}
