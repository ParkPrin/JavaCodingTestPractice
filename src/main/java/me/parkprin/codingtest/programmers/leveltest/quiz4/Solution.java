package me.parkprin.codingtest.programmers.leveltest.quiz4;


import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
     *
     * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * numbers는 길이 1 이상 7 이하인 문자열입니다.
     * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
     * 013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
     *
     * numbers	return
     * 17	3
     * 011	2
     */
    public static void main(String[] args) {
        System.out.println(new Solution().solution("013"));
    }

    public int solution(String numbers) {
        int answer = 0;
        char[] numbersArray = numbers.toCharArray();
        Set<Integer> numbersGroup = new HashSet<Integer>();
        for (int j = 0; j <numbers.length(); j++){
            for (int i =0; i <numbersArray.length-1; i++){
                char temp = numbersArray[i];
                numbersArray[i] = numbersArray[i+1];
                numbersArray[i+1] = temp;
                if (numbers.length() <= 1) {
                    int numbersToInt = Integer.parseInt(new String(numbersArray));
                    if (numbersToInt % 2 != 0) numbersGroup.add(numbersToInt);
                } else {
                    for (int z = 1; z <= numbersArray.length; z++){
                        int numbersToInt = Integer.parseInt(new String(numbersArray).substring(0, z));
                        if (numbersToInt % 2 != 0) numbersGroup.add(numbersToInt);
                    }
                }

            }
        }
        for (int eachNumber : numbersGroup){
            boolean isExist = true;
            if (eachNumber == 1) continue;
            for (int i = eachNumber; i > 1; i--){
                if (eachNumber != i && (eachNumber % i ==0)){
                    isExist = false;
                }
            }
            if (isExist){
                answer++;
                System.out.println(eachNumber);
            }
        }
        return answer;
    }


}
