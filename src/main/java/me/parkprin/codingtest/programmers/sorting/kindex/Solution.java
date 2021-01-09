package me.parkprin.codingtest.programmers.sorting.kindex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    /**
     * 문제설명:
     * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
     *
     * 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
     *
     * array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
     * 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
     * 2에서 나온 배열의 3번째 숫자는 5입니다.
     * 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한사항
     * array의 길이는 1 이상 100 이하입니다.
     * array의 각 원소는 1 이상 100 이하입니다.
     * commands의 길이는 1 이상 50 이하입니다.
     * commands의 각 원소는 길이가 3입니다.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] results = solution.solution(array, commands);
        for (int result : results){
            System.out.println(result);
        }
    }

    public int[] solution(int[] array, int[][] commands) {
        // 답의 갯수는 commands 1차배열의 수와 일치함
        // 시간복잡도 O(n^2logn)
        // 공간복잡도 O(n)
        /*
            최상위 for문이 O(n)에 해당한다.

            내부의 for문은 최상위 for문과 곱으로 계산하기 때문에 O(n^2)이 된다.
            내부의 Collections.sort()는 O(nlogn)으로 계산이 된다.
            그러나 외부의 for문과 곱의 계산이 되기 때문에 O(n^2logn)으로 계산된다
            두 로직이 병렬로 이루어지기 때문에 합으로 계산이 되어
            O(n^2logn + n^2)로 게산이 되지만 가장 큰 수만 남기기 때문에
            시간복잡도는 O(n^2logn)이 된다.

            공간복잡도는 List 하나만 생성하기 때문에 O(n)이 된다.

         */
        int[] answer = new int[commands.length];

        List<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < commands.length; i++){
            arrayList.clear();
            int[] command = commands[i];
            for (int j = command[0]-1; j < command[1]; j++){
                 arrayList.add(array[j]);
            }
            Collections.sort(arrayList);
            answer[i] = arrayList.get(command[2]-1);
        }
        return answer;
    }
}
