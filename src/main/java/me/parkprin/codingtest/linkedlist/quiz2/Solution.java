package me.parkprin.codingtest.linkedlist.quiz2;

import me.parkprin.codingtest.linkedlist.LinkedList;
import me.parkprin.codingtest.linkedlist.LinkedNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
linkedlist의 뒤에서 K번째 수를 찾는 방법
 */
public class Solution {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new LinkedNode(4));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(6));
        list.add(new LinkedNode(7));
        list.add(new LinkedNode(3));
        System.out.println(new Solution().solution(list, 1));
    }

    public int solution(LinkedList list, int k){

        int answer = 0;
        /*
        솔루션 1. HashMap을 이용하여 푸는 경우
        LinkedList를 for문으로 돌리면서 Map에 들어간 순서를
        key값으로 LinkedItem 숫자를 value로 넣는다.
        뒤에서 번째 값으로 나오는 k값을 numberlist에 맞게 계산하여
        map에서 조회한다.

        시간복잡도: O(n)
        공간복잡도: O(n)
         */
        LinkedNode head = list.getHead();
        LinkedNode current = head;
        Map<Integer, Integer> numberList = new HashMap<>();
        int count = 1;
        while(current != null){
            LinkedNode next = current.getNext();
            numberList.put(count++, current.getNumber());
            current = next;
        }

        return numberList.get(numberList.size()+1-k);
        /*
        솔루션 2. 두 번의 반복을 통해서 LinkedList를 푸는 방법
        LinkedList의 사이즈를 먼저 얻은 후
        뒤에서 k번째가 되었을 때 해당 LinkedItem의 number를 get하는 방식

        시간복잡도: O(n)
        공간복잡도: O(1)
        LinkedNode head = list.getHead();
        LinkedNode current = head;
        int count = 0;
        while(current.getNext() != null){
            LinkedNode next = current.getNext();
            current = next;
            count ++;
        }
        int reCount = 0;
        current = head;
        while(current.getNext() != null){
            LinkedNode next = current.getNext();
            current = next;
            if (count - reCount == k) return current.getNumber();
            reCount++;
        }
        */

        /*
        솔루션 3. StringBuilder를 통해서 푸는 경우, 솔루션 2와 2번 반복이 동일함
        for문을 통하여 반복할 때마다, LinkedItem에 있는 number를 StringBuilder 객체에
        append 한다. 구분점을 주기 위해서 ","를 추가하고 마지막에는 제외한다.
        for문이 마치고 나서 ","를 기준으로 split를 하면, String 배열이 생성이 된다.
        이 후의 과정은 솔루션 2와 동일하다

        시간복잡도: O(n)
        공간복잡도: O(n)

        LinkedNode head = list.getHead();
        LinkedNode current = head;
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        while(current != null){
            if (current.getNext() == null)  stringBuilder.append(current.getNumber());
            else stringBuilder.append(current.getNumber() + ",");
            LinkedNode next = current.getNext();
            current = next;
            count++;
        }
        String[] stringArray = stringBuilder.toString().split(",");
        answer =Integer.parseInt(stringArray[count-k]);*/


        /*
        솔루션 4. 포인터를 2개를 두고 푸는 방법
        right 포인터는 처음부터 끝까지 진행하고
        left 포인터는 k만큼의 간격이 될때까지 진행하지 않고 있다가
        k의 간격만큼 되면 진행하는 경우

        시간복잡도: O(1)
        공간복잡도: O(1)

        LinkedNode left = list.getHead(), right = list.getHead();
        int count = 0;
        while(right.getNext() != null) {
            if (count == k-1) {
                left = left.getNext();
                right = right.getNext();
            } else if (count ++ < k) {
                right = right.getNext();
            }
        }
        return left.getNumber();

         */
    }
}
