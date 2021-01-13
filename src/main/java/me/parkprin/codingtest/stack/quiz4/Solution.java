package me.parkprin.codingtest.stack.quiz4;

import java.util.*;

class Solution {
    /**
     *
     # 인픽스를 포스트픽스로 바꾸는 문제

     포스트픽스로 주어진 식을 계산하는 코드를 작성하라. 수식은 사칙연산 (+, -, *, /)만 사용한다고 가정한다.

     예) (1-(2+3))*5 => 123+-5*
     예) (1-(2+3))*(1-(2+3)) => 123+-123+-*
     */
    public static void main(String[] args) {
        System.out.println(new Solution().solution("(1-(2+3))*(1-(2+3))"));
    }

    /*
    솔루션1. StringBuilder와 Stack을 동시에 사용하는 방법

    시간복잡도: O(n)
    공간복잡도: O(n)
     */

    public String solution(String infix) {
        Stack<String> stack = new Stack<String>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : infix.toCharArray()){
            switch (c){
                case '(' :
                    stack.push("(");
                    break;
                case '+' :
                    calculationLowLevel(stack, stringBuilder, "+");
                    break;
                case '-' :
                    calculationLowLevel(stack, stringBuilder, "-");
                    break;
                case '*' :
                    calculationHighLevel(stack, stringBuilder, "*");
                    break;
                case '/' :
                    calculationHighLevel(stack, stringBuilder, "/");
                    break;
                case ')' :
                    String temp = stack.pop();
                    while (temp != "("){
                        stringBuilder.append(temp);
                        temp = stack.pop();
                    }
                    break;
                default:
                    stringBuilder.append(c);
                    break;
            }
        }
        while(!stack.empty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    private void calculationHighLevel(Stack<String> stack, StringBuilder stringBuilder,String sign){
        if (stack.empty()){
            stack.push(sign);
        } else {
            if (stack.peek() == "+" || stack.peek() == "-"){
                stringBuilder.append(sign);
            } else {
                stack.push(sign);
            }
        }
    }

    private void calculationLowLevel(Stack<String> stack, StringBuilder stringBuilder,String sign){
        if (stack.empty()){
            stack.push(sign);
        } else {
            if (stack.peek() == "*" || stack.peek() == "/"){
                stringBuilder.append(stack.pop());
                stack.push(sign);
            } else if (stack.peek() == "(") {
                stack.push(sign);
            }
        }
    }



}
