package me.parkprin.codingtest.stack.quiz1;

import java.util.*;

class Solution {
    /**
     * # 스택 뒤집기
     *
     * 문제 재귀를 사용해서 스택을 뒤집는 코드를 작성하라
     *
     * 오직 스택만을 이용하여 사용하는 풀어낼 것
     *
     * 시간복잡도 O(n^2)
     * 공간복잡도 O(n)
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        new Solution().solution(stack);
        while (!stack.empty()){
            System.out.println(stack.pop());
        }

    }

    public void solution(Stack<Integer> stack) {
       reverseStack(stack);
    }

    public void reverseStack(Stack<Integer> stack){
        int temp = 0;
        if (!stack.empty()){
            temp = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, temp);
        }
    }

    public void insertAtBottom(Stack<Integer> stack, int input){
        if (stack.empty()){
            stack.push(input);
        } else {
            int element = stack.pop();
            insertAtBottom(stack, input);
            stack.push(element);
        }
    }
}
