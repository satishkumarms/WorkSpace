package com.threads;

import java.util.Random;

public class Account {
	
	private int sum;
	private Boolean flag=false;

	public synchronized void  randomNumbers() throws InterruptedException
	{
		
		Random ran = new Random();
		for(int i=1;i<=5;i++)
		{
			int num = ran.nextInt(5);
			System.out.println("NUMBER GENERATED IS:"+num);
			sum+=num;
			Thread.sleep(1000);
		}
		flag=true;
		notify();
	}
	public synchronized void printSum()
	{

		if(flag==false)
		{
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Request for printing the sum");
		try {
			Thread.sleep(500);
		}
		
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("SUM"+sum);
	}
}
