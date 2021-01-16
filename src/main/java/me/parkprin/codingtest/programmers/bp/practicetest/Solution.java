package me.parkprin.codingtest.programmers.bp.practicetest;


import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

     1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
     2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
     3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

     1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

     제한 조건
     시험은 최대 10,000 문제로 구성되어있습니다.
     문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
     가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
     입출력 예
     answers	return
     [1,2,3,4,5]	[1]
     [1,3,2,4,2]	[1,2,3]
     */
    public static void main(String[] args) {
        int[] answers = new int[]{1,3,2,4,2};
        for(int each : new Solution().solution(answers)){
            System.out.println(each);
        }
    }

    public int[] solution(int[] answers) {

        int mathForgiverCount1 = 0;
        int mathForgiverCount2 = 0;
        int mathForgiverCount3 = 0;
        List<Integer> mathForgiver1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> mathForgiver2 = Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5);
        List<Integer> mathForgiver3 = Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5);

        for (int i = 0; i < answers.length; i++){
            int mathForgiverIndex1 =  i % mathForgiver1.size();
            int mathForgiverIndex2 =  i % mathForgiver2.size();
            int mathForgiverIndex3 =  i % mathForgiver3.size();
            if (answers[i] == mathForgiver1.get(mathForgiverIndex1)) mathForgiverCount1++;
            if (answers[i] == mathForgiver2.get(mathForgiverIndex2)) mathForgiverCount2++;
            if (answers[i] == mathForgiver3.get(mathForgiverIndex3)) mathForgiverCount3++;
        }
        if (mathForgiverCount1 == mathForgiverCount2 &&  mathForgiverCount1== mathForgiverCount3 && mathForgiverCount1 ==0) return new int[]{};
        if (mathForgiverCount1 == mathForgiverCount2 &&  mathForgiverCount1== mathForgiverCount3) return new int[]{1, 2, 3};
        else if (mathForgiverCount1 == mathForgiverCount2 && mathForgiverCount1 >mathForgiverCount3) return new int[]{1, 2};
        else if (mathForgiverCount2 == mathForgiverCount3 && mathForgiverCount2 >mathForgiverCount1) return new int[]{2, 3};
        else if (mathForgiverCount3 == mathForgiverCount1 && mathForgiverCount3 >mathForgiverCount2) return new int[]{1, 3};
        else if (mathForgiverCount1 > mathForgiverCount2 && mathForgiverCount1 >mathForgiverCount3) return new int[]{1};
        else if (mathForgiverCount2 > mathForgiverCount1 && mathForgiverCount2 >mathForgiverCount3) return new int[]{2};
        else if (mathForgiverCount3 > mathForgiverCount1 && mathForgiverCount3 >mathForgiverCount1) return new int[]{3};

        return new int[]{};
    }
}
