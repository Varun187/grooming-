package com.example.day3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class HashMapOp {
    public static void main(String[] args) {
        HashMap<Integer,String> h=new HashMap<Integer,String>();
        h.put(22,"Yami");
        h.put(21,"Tara");
        h.put(20,"Sarah");
        h.put(19,"Monica");
        System.out.println(h);
        System.out.println("After sorting");
        TreeMap<Integer,String> tm=new  TreeMap<Integer,String>(h);  
        Iterator i=tm.keySet().iterator();               
            while(i.hasNext())    
            {    
                int key=(int)i.next();  
                System.out.println("Key: "+key+" Value: "+h.get(key));  
            }    
        }
    }
