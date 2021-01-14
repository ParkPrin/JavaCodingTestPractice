package me.parkprin.codingtest.queue.quiz2;

import java.util.*;

class LRUCache {
    /**
     *


     */

    private int cacheSize;
    private Deque<Integer> deque;

    public LRUCache(int cacheSize){
        this.cacheSize = cacheSize;
        this.deque = new LinkedList<Integer>();
    }

    public void query(int number){
        if (deque.contains(number)) deque.remove(number);
        else if (deque.size() == cacheSize) deque.removeLast();

        deque.addFirst(number);
    }

    public void print(){
        System.out.println(deque);
    }



}
