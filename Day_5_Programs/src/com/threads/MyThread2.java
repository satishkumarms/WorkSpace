package com.threads;

public class MyThread2 extends Thread{
	private Account acc;
	public MyThread2(Account acc)
	{
		this.acc = acc;
	}
    public void run()
    {
    	acc.printSum();
    }
}
