package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsDemo {
	
public static void main(String[] args)
{
	
	List<ListClass> mylist = new ArrayList<ListClass>();
	
	mylist.add(new ListClass("satish",1234));
	mylist.add(new ListClass("amit",2345));
	mylist.add(new ListClass("mayur",7576));
	mylist.add(new ListClass("shesha",1256));
	/*mylist.add(new ListClass("satish",1234));
	mylist.add(new ListClass("satish",1234));*/
	
	Collections.sort(mylist, new Comparator<ListClass>()
			{

				@Override
				public int compare(ListClass arg0, ListClass arg1) {
					// TODO Auto-generated method stub
					/*Integer r1 = arg0.getUserid();
					Integer r2 = arg1.getUserid();
					
					return r1.compareTo(r2);*/
					return arg0.getUsername().compareTo(arg1.getUsername());
				}
		
			});
	for(ListClass list : mylist)
	{
		//System.out.println(list.getUserid());
		System.out.println(list.getUsername());
	}
}
	
	
	

}
