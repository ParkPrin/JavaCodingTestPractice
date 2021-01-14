package me.parkprin.codingtest.queue.quiz4;

import java.util.ArrayDeque;
import java.util.Queue;




public class Stack <E> {
    Queue<E> queue = new ArrayDeque();
    Queue<E> queue2 = new ArrayDeque();

    /*public E pop(){
        if (!queue.isEmpty()){
            while(!(queue.size()-1 == 0)){
                queue2.offer(queue.poll());
            }
            E stackPop = queue.poll();
            while (!queue2.isEmpty()){
                queue.offer(queue2.poll());
            }
            return stackPop;
        } else {
            return null;
        }
    }

    public void push(E element){
        queue.offer(element);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }*/

    public E pop(){
       if (queue.isEmpty() && queue2.isEmpty()) {
           return null;
       } else if (queue.isEmpty() && !queue2.isEmpty()){
           return queue2.poll();
       } else if (!queue.isEmpty() && queue2.isEmpty()) {
           return queue.poll();
       } else return null;
    }

    public void push(E element){
        if (queue.isEmpty() && queue2.isEmpty()) {
            queue.offer(element);
        } else if (!queue.isEmpty() && queue2.isEmpty()){
            queue2.offer(element);
            while (!queue.isEmpty()){
                queue2.offer(queue.poll());
            }

        } else if (queue.isEmpty() && !queue2.isEmpty()) {
            queue.offer(element);
            while (!queue2.isEmpty()){
                queue.offer(queue2.poll());
            }
        }
    }

    public E peek(){
        if (queue.isEmpty() && queue2.isEmpty()) {
            return null;
        } else if (queue.isEmpty() && !queue2.isEmpty()){
            return queue2.peek();
        } else if (!queue.isEmpty() && queue2.isEmpty()) {
            return queue.peek();
        } else return null;
    }

    public boolean isEmpty(){
        return queue.isEmpty() && queue2.isEmpty();
    }

    public int size(){
        return Math.max(queue.size(), queue.size());
    }
}
