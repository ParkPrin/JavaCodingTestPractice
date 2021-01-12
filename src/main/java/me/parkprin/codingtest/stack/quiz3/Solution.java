package me.parkprin.codingtest.stack.quiz3;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    /**
     * # 괄호 짝 맞추기
     *
     # 포스트픽스 계산하기

     포스트픽스로 주어진 식을 계산하는 코드를 작성하라. 수식은 사칙연산 (+, -, *, /)만 사용한다고 가정한다.

     - 예) 12+         => 3
     - 예) 123+-5*  => -20
     */
    public static void main(String[] args) {
        System.out.println(new Solution().solution("123+-5*"));
    }

    public String solution(String equationText) {
        Stack<Integer> stack = new Stack<Integer>();
        for (char c : equationText.trim().toCharArray()){
            switch (c) {
                case '+' :
                    stack.push(stack.pop() + stack.pop());
                    break;
                case '-' :
                    stack.push((- stack.pop()) + stack.pop());
                    break;
                case '*' :
                    stack.push(stack.pop() * stack.pop());
                    break;
                case '/' :
                    int leftNum = stack.pop();
                    int rightNum = stack.pop();
                    stack.push(rightNum / leftNum);
                    break;
                default:
                    stack.push(Integer.parseInt(String.valueOf(c)));
                    break;
            }
        }
        return String.valueOf(stack.pop());
    }



}
