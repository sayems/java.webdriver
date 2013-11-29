package com.sayem.webdriver.basic.part4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class SetJava {

    public static void main(String[] args) {

        List<String> l = new ArrayList<String>();
        l.add("India"); //0
        l.add("Russia");//1
        l.add("France");//2
        l.add("France");//3
        System.out.println("Size of the list is "+ l.size());
        System.out.println(l.get(2));
        // no dupicate elements
        //no order
        // no index
        System.out.println("***************");
        Set<String> s = new HashSet<String>();
        s.add("India");
        s.add("Russia");
        s.add("France");
        s.add("France");
        System.out.println("Size of the set is "+ s.size());
        //System.out.println(s.get);

        Iterator<String> iter = s.iterator();
        //System.out.println(iter.hasNext());
        //System.out.println(iter.next()); // 2
        while(iter.hasNext()){
            System.out.println(iter.next());

        }
    }
}

