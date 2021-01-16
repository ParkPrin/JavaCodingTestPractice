package me.parkprin.codingtest.programmers.ce.quiz2;


import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     # 주석 넣는 곳
     [[1, 4], [3, 4], [3, 10]]	[1, 10]
     [[1, 1], [2, 2], [1, 2]]	[2, 1]

     시간복잡도: O(n)
     공간복잡도: O(1)

     */
    public static void main(String[] args) {
        int[][] v = {{1, 1}, {2, 2}, {1, 2}};

        int[] result = new Solution().solution(v);
        System.out.println("x= " + result[0] + " y= " +result[1]);
    }

    public int[] solution(int[][] v) {
        int[] answer = new int[2];
        Set<Integer> xSet = new HashSet<Integer>();
        Set<Integer> ySet = new HashSet<Integer>();

        for (int[] xAndY : v){
            int x = xAndY[0];
            int y = xAndY[1];

            if (xSet.contains(x)) xSet.remove(x);
            else xSet.add(x);

            if (ySet.contains(y)) ySet.remove(y);
            else ySet.add(y);
        }
        answer[0] =xSet.iterator().next();
        answer[1] =ySet.iterator().next();
        return answer;
    }
}
