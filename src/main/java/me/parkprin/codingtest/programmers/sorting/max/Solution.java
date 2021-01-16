package me.parkprin.codingtest.programmers.sorting.max;

import java.util.*;
import java.util.stream.Stream;

class Solution {
    /**
     0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

     예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

     0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

     제한 사항
     numbers의 길이는 1 이상 100,000 이하입니다.
     numbers의 원소는 0 이상 1,000 이하입니다.
     정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

     솔루션
     정렬에 대한 방식 핵심인 문제
     정렬을 할 때 앞 수와 뒤 수의 문자열의 합이 더 큰것을 기준으로 반환해야 한다.

     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {9, 90, 99, 0, 1000, 999, 8, 900, 87, 1000, 201, 0};
        System.out.println(solution.solution(array));

    }

    public String solution(int[] numbers) {

        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(result, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));


        if (result[0].equals("0")) {
            return "0";
        }

        String answer = "";
        // 정렬된 문자 하나로 합치기
        for (String a : result) {
            answer += a;
        }
        return answer;
    }
}
