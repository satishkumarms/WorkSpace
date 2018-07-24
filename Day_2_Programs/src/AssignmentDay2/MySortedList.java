package AssignmentDay2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MySortedList implements MyList {
	
		List<Integer> arraylist = new ArrayList<>();
		public void add(int element)
		{
			
			arraylist.add(element);
			//System.out.println(arraylist);
		}
		@Override
		public int get(int index) {
			// TODO Auto-generated method stub
			return 0;
		}
		public void sort()
		{
			Collections.sort(arraylist, new Comparator<Integer>()
					{

						@Override
						public int compare(Integer arg0, Integer arg1) {
							// TODO Auto-generated method stub
							return arg0.compareTo(arg1);
						}
			
					});
			System.out.println(arraylist);
		}
	}


