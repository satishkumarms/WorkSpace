package assignmentday4;

import java.util.HashSet;
import java.util.Set;



public class SetDemo {

	public static void main(String[] args)
	{
		Set<String> set = new HashSet<String>();
		set.add("john");
		set.add("sam");
		set.add("sat");
		set.add("shes");
		set.add("shubz");
		//System.out.println(set);
		print(set);


		
	}

	private static void print(Set<String> set) {
		// TODO Auto-generated method stub
		for(String ele: set)
		{
			System.out.println(ele);
		}
	}

}
