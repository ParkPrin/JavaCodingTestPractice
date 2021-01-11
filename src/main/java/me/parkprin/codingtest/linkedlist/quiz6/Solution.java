package me.parkprin.codingtest.linkedlist.quiz6;

import me.parkprin.codingtest.linkedlist.LinkedList;
import me.parkprin.codingtest.linkedlist.LinkedNode;

public class Solution {
    /**
     * # 중복되는 모든 노드 제거
     * 정렬된 연결 리스트에서 중복되는 모든 노드 제거하는 코드를 작성하라.
     * 예) 1->2->2->3 => 1->2
     *
     */

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(3));
        Solution solution = new Solution();
        solution.solution(list);
        LinkedNode linkedNode = list.getHead();
        while (linkedNode != null){
            System.out.println(linkedNode.getNumber());
            linkedNode = linkedNode.getNext();
        }


    }

    public void solution(LinkedList linkedList) {

    }


}
