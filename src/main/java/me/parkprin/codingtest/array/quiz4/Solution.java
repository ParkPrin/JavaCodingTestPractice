package me.parkprin.codingtest.array.quiz4;

import java.util.HashMap;
import java.util.Map;

/**
 * 숫자로 구성된 배열 numbers와 target 숫자 하나가 주어졌을 때 numbers 배열에 들어있는
 * tp 수를 더해 target 숫자를 만들 수 있는 인덱스 세 개를 찾는 함수를 작성하라.
 *
 *
 *
 * 제약사항 1. numbers 배열에 중복되는 숫자 없음
 * 제약사항 2. target 숫자를 만들 수 있는 조합은 하나 뿐
 */
public class Solution {
    public int[] solution(int[] numbers, int target){

        /*
        솔루션 1. Map을 만들고 numbers안에 있는 값을 key로 넣은다음 for문을 돌면서
        target-index에 해당하는 키조회시 존재하는 경우 value값을 각각 추출하는 방법
        시간복잡도 O(n^2)
        공간복잡도 O(n)
         */

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i =0 ; i <numbers.length; i++)
            map.put(numbers[i], i);

        for (int j = 0; j < numbers.length; j++ ){
            for (int z = j+1; z < numbers.length; z++ ){
                int resultKey = target - numbers[j] - numbers[z];
                if (map.containsKey(resultKey))
                return new int[]{j, z, map.get(resultKey)};
            }
        }

        return new int[]{};
    }
}
