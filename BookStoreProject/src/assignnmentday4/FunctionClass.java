package assignnmentday4;

import java.util.ArrayList;
import java.util.List;

public class FunctionClass {
	
	private List<Integer> list;
	private int number;
	private static Boolean flag = false;
	public FunctionClass()
	{
		list = new ArrayList<>();
		 list.add(3);
		 list.add(5);
		 list.add(9);
		 list.add(2);
		 list.add(2);
		 
	}
	
	public synchronized void  factorialNumber(int num) throws InterruptedException
	{
		if(flag==false)
		{
			wait();
		}
		else
		{
		int res = 1, i;
	    for (i=2; i<=num; i++)
	        res *= i;
	    System.out.println(res);
	    flag = false;
	    
	    notify();
	    wait();
	    
		}
	  
	}
	public synchronized void readNumber() throws InterruptedException
	{
	
		for(Integer num : list)
		{
			number = num;
			System.out.println("Fetched number is "+num);
			flag = true;
			notify();
			Thread.sleep(1000);
			
			wait();
			
		}
			
		//	this.factorialNumber(num);
		
	}
	public int getNumber()
	{
		return number;
	}

}
