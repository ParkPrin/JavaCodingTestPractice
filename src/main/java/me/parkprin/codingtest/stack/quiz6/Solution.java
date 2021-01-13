package me.parkprin.codingtest.stack.quiz6;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    /**
     *
     # 배열에서 큰 수 찾기

     주어진 배열의 오른쪽에 처음으로 등장하는 현재 숫자보다
     큰 수를 담고 있는 배열을 만드는 코드를 작성하라.
     오른쪽에 현재 수보다 큰수가 없는 경우에는 -1.

     예) [1, 1, 2, 3]    =>   [2, 2, 3, -1]
     예) [10, 4, 2, 30]    =>   [30, 30, 30, -1]
     예) [82, 7, 15]    =>   [-1, 15, -1]

     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new int[]{1, 1, 2, 3})));
        System.out.println(Arrays.toString(new Solution().solution(new int[]{10, 4, 2, 30})));
        System.out.println(Arrays.toString(new Solution().solution(new int[]{82, 7, 15})));
    }

    /*
    솔루션1. 인덱스와 stack을 이용한 풀이법

    시간복잡도: O(n)
    공간복잡도: O(n)
     */

    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] answers = new int[numbers.length];
        for (int i = numbers.length-1; i >= 0; i--){

            if (i != numbers.length-1){
                while (!stack.empty()){
                    if (stack.peek() > numbers[i]){
                        answers[i] = stack.peek();
                        break;
                    } else {
                       stack.pop();
                       if (stack.empty()){
                           answers[i] = -1;
                       }
                    }
                }
            } else {
                answers[i] = -1;

            }
            stack.push(numbers[i]);

        }
        return answers;
    }



}
