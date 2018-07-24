
public class Utilities {
	

		
		/*public static Boolean isprime(int prime)
		{
			int flag=0;
			for(int i=2;i<prime;i++)
			{
				 if(prime%i==0)
				 {
					 flag=1;
					 break;
				 }
			}
			if(flag==1)
			{
				 return false;
			}
			else
			{
				return true;
			}
		}*/                                //  PROG ------ 1
	
	 public int findMax(int numb[])
	 {
		 int ran = numb[0];
		 for(int i=0;i<numb.length;i++)
		 {
			  if(ran<numb[i])
			  {
				  ran = numb[i];
			  }
		 }
		 return ran;
	 }
	
	 public int findMin(int numb[])
	 {
		 int ran = numb[0];
		 for(int i=0;i<numb.length;i++)
		 {
			  if(ran>numb[i])
			  {
				  ran = numb[i];
			  }
		 }
		 return ran;
	 }
	 		
	
}
