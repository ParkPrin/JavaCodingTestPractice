package me.parkprin.codingtest.selftest.quiz1;

import java.util.*;

class Solution {
    /**
     * 문제: String 이중배열에 있는 날짜를 최근에 생성된 데이터부터 정렬 후 배열 이름을 반환하세요.
     *
     * ```
     * 예를 들어 array가 [["2017-12-10", "데이터a"],["2020-11-24", "데이터b"],["2011-09-04", "데이터c"]]라면
     *
     * ["데이터b","데이터a","데이터c"]로 반환하여라
     * ```
     *
     *
     * 제한사항
     * - array의 길이는 1 이상이다
     * - 날짜와 이름은 반드시 들어가 있다.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] arrays = {{"2017-12-10", "데이터a"}, {"2020-11-24", "데이터b"}, {"2011-09-04", "데이터c"}};
        String[] results = solution.solution(arrays);
        for (String result : results){
            System.out.println(result);
        }
    }

    public String[] solution(String[][] arrays) {
        /*
        시간복잡도: O(nlogn)
        => O(n) + O(nlogn) + O(n) 이므로 제일 항이 큰 O(nlogn)으로 표시함

        공간복잡도: O(n)
        Map: O(n)
        List: O(n)
        Array: O(2n)
        => O(4n)이지만 항이 같으므로 O(n)으로 표시함

        솔루션: 맵객체와 리스트 객체를 만든 후 String 이차배열을 돌면서
        Map 입력시 키값에는 날짜를 value값에는 String 배열을 넣는다
        List에는 날짜 String 값을 입력하고
        Collections.sort 이용하여 가장 먼저 입력된 날짜 순으로 정렬한다.
        for문에서 List.get을 이용할 경우 시간복잡도가 O(n^2)으로 증가할 수 있기 때문에
        List를 Array로 바꾸어준다.
        그리고 for 문을 돌면서 날짜 Array에서 날짜를 가지고 올때, 가장 먼저 등록된 순으로
        입력되었기 때문에 역순으로 가지고 오면 가장 최근 날짜로 가지고 올 수 있다.
        역순데이터를 Map객체 키값으로 접근하여 String 배열에서 이름 데이터를 가지고 온다.
        이름 데이터를 answer 배열에 순서대로 담아서 반환한다.
         */

        String[] answer = new String[arrays.length];
        Map<String, String[]> objMap = new HashMap<String, String[]>();
        List<String> dataList = new ArrayList<String>();
        // 시간복잡도 O(n)
        for (String[] array : arrays){
            objMap.put(array[0], array);
            dataList.add(array[0]);
        }
        // 시간복잡도 O(nlogn)
        Collections.sort(dataList);
        // 시간복잡도 O(n)
        String[] dataArray = dataList.toArray(new String[dataList.size()]);
        // 시간복잡도 O(n)
        for (int i =0; i < dataArray.length; i++){
            answer[i] = objMap.get(dataArray[dataArray.length-1-i])[1];
        }
        return answer;
    }
}
