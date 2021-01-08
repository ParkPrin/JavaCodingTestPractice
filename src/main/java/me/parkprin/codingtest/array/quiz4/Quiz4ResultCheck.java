package me.parkprin.codingtest.array.quiz4;

public class Quiz4ResultCheck {
    public static void main(String[] args) {
        int [] result = new Solution().solution(new int[]{2, 3, 6, 8, 9}, 16);
        for (int eachResult : result) System.out.println(eachResult);
    }
}
