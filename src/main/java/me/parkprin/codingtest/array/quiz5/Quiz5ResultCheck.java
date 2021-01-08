package me.parkprin.codingtest.array.quiz5;

public class Quiz5ResultCheck {
    public static void main(String[] args) {

        int[] numbers = new int[50];
        for (int i = 0; i < 50; i++){
            numbers[i] = (int) (Math.random() * 100 + 1);
        }
        int [] result = new Solution().solution(numbers);
        for (int eachNum : result){
            System.out.println(eachNum);
        }
    }
}
