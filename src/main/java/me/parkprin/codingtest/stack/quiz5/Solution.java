package me.parkprin.codingtest.stack.quiz5;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    /**
     *
     # 스펜 찾기

     주어진 배열 prices에 대한 스팬을 구하는 코드를 작성하라.
     스팬: 당일의 주가 보다 낮거나 같았던 연속적인 일 수.

     예) [5, 3, 2, 4, 7, 1]    =>   [1, 1, 1, 3, 5, 1]
     예) [2, 3, 4, 5, 6, 7]    =>   [1, 2, 3, 4, 5, 6]
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new int[]{5, 3, 2, 4, 7, 1})));
        System.out.println(Arrays.toString(new Solution().solution(new int[]{2, 3, 4, 5, 6, 7})));
    }

    /*
    솔루션1. 인덱스와 stack을 이용한 풀이법

    시간복잡도: O(n)
    공간복잡도: O(n)
     */

    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] answers = new int[prices.length];
        for (int i = 0; i < prices.length; i++){
            int count = 1;
            if (i != 0){
                while (prices[stack.peek()] < prices[i]){
                    stack.pop();
                    count++;
                    if (stack.empty()) {
                        count = i+1;
                        break;
                    }
                }
            }
            stack.push(i);
            answers[i] = count;
        }
        return answers;
    }



}
