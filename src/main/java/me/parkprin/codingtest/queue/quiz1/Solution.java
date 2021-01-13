package me.parkprin.codingtest.queue.quiz1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

class Solution {
    /**
     *
     # 큐를 뒤집어라.

     큐가 제공하는 오퍼레이션만 사용해서 큐를 뒤집는 코드를 작성하라.
     제공하는 오퍼레이션은 다음과 같다.

     offer(E e): 큐의 끝에 데이터를 추가한다.
     E poll(): 큐 헤드를 꺼낸다.
     isEmpty(): 큐가 비어있는가.

     예) Q {1, 2, 3}  =>  Q {3, 2, 1}

     */
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(new Solution().solution(queue));
    }

    /*
    솔루션1. 인덱스와 stack을 이용한 풀이법

    시간복잡도: O(n)
    공간복잡도: O(n)
     */

    /*public Queue<Integer> solution(Queue<Integer> queue) {
        System.out.println(queue);
        Stack<Integer> stack = new Stack<Integer>();
        while(!queue.isEmpty()){
            stack.push(queue.poll());
        }
        while(!stack.isEmpty()){
            queue.offer(stack.pop());
        }

        return queue;
    }*/

    /*
    솔루션 2. 재귀를 이용한 방법

    시간복잡도: O(n)
    공간복잡도: O(1)
     */

    public Queue<Integer> solution(Queue<Integer> queue) {
        recursiveMethod(queue);
        return queue;
    }

    private void recursiveMethod(Queue<Integer> queue){
        int element = 0;
        if (!queue.isEmpty()){
            element = queue.poll();
            recursiveMethod(queue);
            queue.offer(element);
        }
    }



}
