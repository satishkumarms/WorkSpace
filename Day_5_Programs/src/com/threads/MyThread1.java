package com.threads;

public class MyThread1 extends Thread{

	private Account acc;
	
	public MyThread1(Account acc)
	{
		this.acc = acc;
	}
	public void run()
	{
		try {
			acc.randomNumbers();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
