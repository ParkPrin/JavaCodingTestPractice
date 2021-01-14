package me.parkprin.codingtest.queue.quiz2;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class LRUCache3 {

    private int cacheSize;
    private Set<Integer> set;


    public LRUCache3(int cacheSize){
        this.cacheSize = cacheSize;
        this.set = new LinkedHashSet<Integer>();
    }

    public void query(int number){
        if (set.contains(number)){
            set.remove(number);
        } else {
            if (cacheSize == set.size()){
                int firstKey = set.iterator().next();
                set.remove(firstKey);
            }
        }
        set.add(number);
    }



    public void print(){
        System.out.println(set);
    }





}
