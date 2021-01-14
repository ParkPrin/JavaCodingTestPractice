package me.parkprin.codingtest.queue.quiz2;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache2 {

    private int cacheSize;
    private Map<Integer, Node> map;
    Node head;
    Node tail;


    public LRUCache2(int cacheSize){
        this.cacheSize = cacheSize;
        this.map = new HashMap<Integer, Node>();
    }

    public void query(int number){
        if (map.containsKey(number)){
            Node node = map.get(number);
            remove(node);
            addToHead(node);
        } else {
            Node newNode = new Node();
            newNode.value = number;
            if (map.size() == cacheSize){
                map.remove(tail.value);
                remove(tail);
            }
            map.put(number, newNode);
            addToHead(newNode);
        }
    }

    private void addToHead(Node node){
        node.next = head;
        node.prev = null;

        if (head != null) head.prev = node;

        head = node;

        if (tail == null) tail = head;
    }

    private void remove(Node node){

        if (node != head){
            node.prev.next = node.next;
        } else {
            head = node.next;
            head.prev = null;
        }

        if (node != tail){
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
            tail.next = null;
        }
    }

    public void print(){
        Node current = this.head;
        while (current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }

    private class Node<E>{
        E value;
        Node<E> prev;
        Node<E> next;
    }



}
