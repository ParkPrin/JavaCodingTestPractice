package me.parkprin.codingtest.programmers.ce.quiz4;


import java.util.*;

class Solution {
    /**
     서로 다른 자연수들로 이루어진 배열 arr와 숫자 n이 입력으로 주어집니다.

     만약 배열 arr에 있는 서로 다른 2개의 자연수를 합하여 숫자 n을 만드는 것이 가능하면 true를, 불가능하면 false를 반환하는 함수를 작성하세요.

     제한사항
     배열의 크기는 1 이상 500,000이하의 자연수입니다.
     배열의 원소는 1 이상 100,000,000이하의 자연수입니다.
     n은 100,000,000 이하인 자연수입니다.

     arr	n	result
     [5, 3, 9, 13]	8	true
     [5, 3, 9, 13]	7	false

     */
    public static void main(String[] args) {
        int[] v = {2, 5, 3, 9, 13};

        boolean result = new Solution().solution(v, 4);
        System.out.println(result);
    }

    public boolean solution(int[] arr, int n) {
        /*
        솔루션 1 List를 이용하는 방법

        공간복잡도: O(n^2)
        시간복잡도: O(n)
        List<Integer> list = new ArrayList<>();
        for (int each : arr){
            if (each <= n) list.add(each);
        }
        for (int i = 0; i < list.size(); i++){
            for (int j = i+1; j <list.size(); j++){
                if (list.get(i) + list.get(j) == n) return true;
            }
        }
        return false;

        */

        /*
        솔루션 2 Map을 이용하는 방법

        공간복잡도: O(n)
        시간복잡도: O(n)

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int each : arr){
            if (each < n) map.put(each, n-each);
        }
        Iterator<Integer> mapKeysIterator = map.keySet().iterator();
        while (mapKeysIterator.hasNext()){
            int key = mapKeysIterator.next();
            if (map.containsKey(map.get(key))) return true;
        }
        */


        /*
        솔루션 3 S을 이용하는 방법
        공간복잡도: O(n)
        시간복잡도: O(n)
         */

        /*
         [5, 3, 9, 13]	8	true
         [5, 3, 9, 13]	7	false
         */

        Set<Integer> set = new HashSet<Integer>();
        for (int each : arr){
            if (each < n) set.add(each);
        }
        Iterator<Integer> setIterator = set.iterator();
        while (setIterator.hasNext()){
            int num = setIterator.next();
            if (set.contains(n-num)) return true;
        }

        return false;
    }
}
