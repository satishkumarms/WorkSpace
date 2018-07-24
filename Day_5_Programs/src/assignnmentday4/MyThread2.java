package assignnmentday4;

public class MyThread2 extends Thread{
	
	private FunctionClass fun;
	
	public MyThread2(FunctionClass fun)
	{
		this.fun = fun;
	}

	public void run()
	{
	
		for(int i=0;i<5;i++)
		{
			int number = fun.getNumber();
			try {
				fun.factorialNumber(number);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
