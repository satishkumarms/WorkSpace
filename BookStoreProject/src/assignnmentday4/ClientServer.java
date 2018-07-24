package assignnmentday4;

public class ClientServer {
	
	public static void main(String[] args)
	{
		FunctionClass fun = new FunctionClass();
		
		MyThread1 thread1 = new MyThread1(fun);
		thread1.setName("-one");
		thread1.start();
		//System.out.println("Thread 1 started");
		
		
		MyThread2 thread2 = new MyThread2(fun);
		thread2.setName("-two");
		thread2.start();
		//System.out.println("Thread 2 started");
	}

}
