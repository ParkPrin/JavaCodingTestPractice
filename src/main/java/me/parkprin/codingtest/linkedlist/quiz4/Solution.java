package me.parkprin.codingtest.linkedlist.quiz4;

import me.parkprin.codingtest.linkedlist.LinkedList;
import me.parkprin.codingtest.linkedlist.LinkedNode;

public class Solution {
    /**
     * # 정렬된 연결 리스트에서 중복 노드 제거하기
     * 정렬된 연결 리스트에서 중복된 노드를 제거하는 함수를 구현하라.
     *
     * 예) 1 -> 1 -> 2 -> 3 -> 3 => 1 -> 2-> 3
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

        /*
        솔루션 1. 순회 방식

        시간복잡도: O(n)
        공간복잡도: O(1)
         */


        /*LinkedNode current = linkedList.getHead(), firstNode = linkedList.getHead();
        LinkedNode next = null;
        while (current.getNext() != null){
            next = current.getNext();
            if (current.getNumber() == next.getNumber()){
                if (current.getNext().getNext() != null) current.setNext(current.getNext().getNext());
                else current.setNext(null);
            } else {
                current = next;
            }
        }*/


        /*
        솔루션 2. 재귀방식
        재귀메소드에서 중복인 값을 가지고 있는 Item에서 재귀하여 다른값을 반환하고,
        가리키고 있는 아이템을 바꾼다.

        시간복잡도: O(n)
        공간복잡도: O(1)

         */

        LinkedNode current = linkedList.getHead();
        LinkedNode next = null;
        while (current.getNext() != null){
            next = removeDuplicateRecursive(current);
            if (next != null){
                current.setNext(next);
                if (next.getNext() == null){
                    current.setNext(null);
                }
                current = next;
            } else {
                current.setNext(null);
            }
        }
    }

    private LinkedNode removeDuplicateRecursive(LinkedNode node){
        if (node.getNext() == null) return null;

        if (node.getNumber() == node.getNext().getNumber()) return removeDuplicateRecursive(node.getNext());
        else return node.getNext();
    }
}
