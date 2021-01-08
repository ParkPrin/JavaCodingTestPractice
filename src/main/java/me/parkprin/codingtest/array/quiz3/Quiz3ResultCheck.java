package me.parkprin.codingtest.array.quiz3;

public class Quiz3ResultCheck {
    public static void main(String[] args) {
        int [] result = new Solution().solution(new int[]{1, 2, 6, 8}, 9);
        for (int eachResult : result) System.out.println(eachResult);
    }
}
