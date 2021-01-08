package me.parkprin.codingtest.array.quiz2;

import java.util.HashSet;
import java.util.Set;

/**
 * 숫자로 구성된 배열이 주어졌을 때 그 배열에 중복된 숫자가 있는지 확인하는 함수를 작성하라. 중복된 숫자가 있다면 true 없다면 false
 */
public class Solution {
    public char[] solution(char[] chars){
        /*
        솔루션 1. for문을 돌리고 출력되는 값을 끝에서 부터 출력하도록 하는 방법
        시간복잡도 O(n)
        공간복잡도 O(n)
        char[] charList = new char[chars.length];
        for (int i = 0; i < chars.length; i++ ){
            charList[i] = chars[chars.length-1-i];
        }

        return charList;
         */

        /*
        솔루션 2. 주어진 문자열의 가운데 문자는 건들이지 않고, 임시 변수를 이용하여 양쪽 끝에서부터 자리교환 하는 방법
        시간복잡도 O(n)
        공간복잡도 O(1)
        for (int i = 0; i < chars.length/2; i++ ){
            char temp = chars[i];
            chars[i] = chars[chars.length-1-i];
            chars[chars.length-1-i] = temp;
        }
        return chars;
         */



        /*
        솔루션 3. StringBuilder를 이용한 방법
        StringBuilder의 reverse()의 시간 복잡도는 O(n)이다
        시간복잡도 O(n)
        공간복잡도 O(n)
         */

        return new StringBuilder(String.valueOf(chars)).reverse().toString().toCharArray();
    }
}
