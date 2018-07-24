package assignnmentday4;

public class MyThread1 extends Thread {
	
	private FunctionClass fun;
	
	public MyThread1(FunctionClass fun)
	{
		this.fun = fun;
	}
	
	public void run()
	{
		try {
			fun.readNumber();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
