package me.parkprin.codingtest.stack.quiz2;

import java.util.*;

class Solution {
    /**
     * # 괄호 짝 맞추기
     *
     * 주어진 수식의 괄호짝이 맞는지 확인하는 코드를 작성하라.
     *
     * 예) [{1 + 2 * (2 + 2)} - (1 - 3)]   => true
     * 예) [{1 + 2 * (2 + 2)} - [1 - 3)]   => false
     *
     *
     * 괄호의 특성을 이해해야 하는 문제
     * 시간복잡도: O(n) => for문 안에서 contains를 사용하므로 O(n^2)이다
     * 공간복잡도: O(n)
     *
     * 문제의 응용: Stack을 사용해도 되는지 여부? 직접구현해서 해당 문제를 풀이 또는 라이브러리를 사용하여 풀이
     *
     * 괄호 수식과 여는 괄호의 위치가 주어졌을 때 그에 대응하는 닫힌 괄호의 위치를 찾는 코드를 작성하라.
     * 괄호 몇개를 뒤집어야 정상적인 수식을 만들 수 있는지 계산하는 코드를 작성하라
     * 주어진 수식에 불필요한 괄호가 있지 않은지 확인하는 코드를 작성하라
     */
    public static void main(String[] args) {
        System.out.println(new Solution().solution("[{1 + 2 * (2 + 2)} - (1 - 3}]"));
    }

    public boolean solution(String equationText) {
        Stack<Character> stack = new Stack<Character>();
        List<Character> openingBrackets = Arrays.asList('[', '{', '('),
                closeingBrackets = Arrays.asList(']', '}', ')');
        for (char c : equationText.toCharArray()){
            if (openingBrackets.contains(c)){
                stack.push(c);
            } else if (closeingBrackets.contains(c)) {
                Character openingBracket = stack.pop();
                if (openingBrackets.indexOf(openingBracket) != closeingBrackets.indexOf(c)) return false;
            }
        }
        return true;
    }



}
