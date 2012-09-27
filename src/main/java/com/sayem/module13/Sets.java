package com.sayem.module13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Sets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> l = new ArrayList<String>();
		l.add("A");
		l.add("A");
		l.add("A");
		
		
		// unique
		// no order
		// no index - iterator
		Set<String> s = new HashSet<String>();
		s.add("B");
		s.add("B");
		s.add("B");
		s.add("B1");
		s.add("B2");
		
		System.out.println(l.size());
		System.out.println(s.size());
		
		System.out.println(l.get(2));
		//System.out.println(s.get(0));
		
		System.out.println("******************");
		Iterator<String> it = s.iterator();
		//System.out.println(it.next());
		//System.out.println(it.next());
		//System.out.println(it.next());
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
		
	}

}
