package AssignmentDay2;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList implements MyList {
	
	List<Integer> arraylist = new ArrayList<>();
	public void add(int element)
	{
		
		arraylist.add(element);
		//System.out.println(arraylist);
	}
	public int get(int index)
	{
		System.out.println(arraylist.size());
		if(index>(arraylist.size()-1) || index < -1)
			return -1;
		else
			return arraylist.get(index);
	}


}
