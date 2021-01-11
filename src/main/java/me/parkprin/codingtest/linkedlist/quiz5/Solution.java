package me.parkprin.codingtest.linkedlist.quiz5;

import me.parkprin.codingtest.linkedlist.LinkedList;
import me.parkprin.codingtest.linkedlist.LinkedNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * # 정렬되지 않은 연결 리스트에서 중복 노드 제거하기
     * 정렬된 연결 리스트에서 중복된 노드를 제거하는 함수를 구현하라.
     *
     * 예) 2 -> 1 -> 9 -> 1 -> 6 -> 4 -> 4 => 1 -> 2 -> 4 -> 6 -> 9
     *
     */

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(9));
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(6));
        list.add(new LinkedNode(4));
        list.add(new LinkedNode(4));
        Solution solution = new Solution();
        solution.solution(list);
        LinkedNode linkedNode = list.getHead();
        while (linkedNode != null){
            System.out.println(linkedNode.getNumber());
            linkedNode = linkedNode.getNext();
        }


    }

    public void solution(LinkedList linkedList) {

        /*
        솔루션 1. Map을 이용한 방법

        1) Map에 LinkedItem을 넣는다.
        2) Map keylist를 Integer Array로 가지고 온다.
        3) Integer Array를 정렬한다.
        4) 정렬된 Array KeyList를 for문을 돌려서 LinkedItem을 가지고 온다.
        5) 처음 가지고온 LinkedItem을 linkedList의 Head로 설정한다.
        5) LinkedItem을 관계를 초기화한다.
        6) LinkedItem 관계를 설정한다.

        시간복잡도: O(nlogn)
        공간복잡도: O(n)
         */
        LinkedNode linkedNode = linkedList.getHead();
        Map<Integer, LinkedNode> linkedNodeMap = new HashMap<Integer, LinkedNode>();
        while (linkedNode != null){
            if (!linkedNodeMap.containsKey(linkedNode.getNumber()))
                linkedNodeMap.put(linkedNode.getNumber(), linkedNode);

            linkedNode = linkedNode.getNext();
        }
        Integer[] linkedNodeKeyList = linkedNodeMap.keySet().toArray(new Integer[linkedNodeMap.size()]);
        Arrays.sort(linkedNodeKeyList);
        int count = 0;
        LinkedNode prev = null;
        for (int linkedNodeKey : linkedNodeKeyList){

            LinkedNode getLinkedNode = linkedNodeMap.get(linkedNodeKey);
            if (count == 0 ) linkedList.setHead(getLinkedNode);

            // 불러온 LinkedNode의 관계를 다 끊어버린다.
            getLinkedNode.setNext(null);

            // 이전에 불러온 LinkedNode의 Next를 현재 불러온 LinkedNode에 관계를 지어준다.
            if (prev != null) prev.setNext(getLinkedNode);

            // 현재 불러온 LinkedNode를 이전 LinkedNode에 넣는다.
            prev = getLinkedNode;
            count++;

            if (linkedNodeKeyList.length == count){
                getLinkedNode.setNext(null);
                linkedList.setTail(getLinkedNode);
            }
        }
    }


}
