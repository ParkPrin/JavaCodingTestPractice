package me.parkprin.codingtest.linkedlist.quiz7;

import me.parkprin.codingtest.linkedlist.LinkedList;
import me.parkprin.codingtest.linkedlist.LinkedNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * # 원형 연결 리스트
     * 주어진 연결 리스트가 원형 연결 리스트인지 단일 연결 리스트인지 확인하는 함수를 구현하라.
     * 예) 1->2->3->2 => true
     * 예) 1->2->3->1 => true
     * 예) 1->2->3->null => false
     *
     */

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(new LinkedNode(1));
        LinkedNode twoLinkedNode = new LinkedNode(2);
        list.add(twoLinkedNode);
        list.add(new LinkedNode(3));
        LinkedNode lastLinkedNode = list.getTail();
        lastLinkedNode.setNext(twoLinkedNode);
        /*list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));*/
        Solution solution = new Solution();
        System.out.println(solution.solution(list));

    }

    public boolean solution(LinkedList linkedList) {

        /*
        솔루션 1: Map과 HashCode를 이용한 방법,
                원형 연결 리스트가 될시 특정 연결노드의 HashCode가 한번 이상 중복이 일어난다.
                중복이 있으면 true, 없으면 false이다.

                시간복잡도: O(n)
                공간복잡도: O(n)
         */

        /*LinkedNode linkedNode = linkedList.getHead();
        Map<Integer, LinkedNode> linkedNodeMap = new HashMap<Integer, LinkedNode>();
        boolean answer = false;
        while(linkedNode != null){
            if (!linkedNodeMap.containsKey(linkedNode.hashCode())){
                linkedNodeMap.put(linkedNode.hashCode(), linkedNode);
            } else {
                answer = true;
                break;
            }
            linkedNode = linkedNode.getNext();
        }
        return answer;*/

        /*
        2개의 포인터를 이용하는 방법
        문제를 푸는 원리는 두개의 포인터가 원형 경기장을 돌다가 만나게 되면 answer값을 true로 반환한다

        시간복잡도: O(n)
        공간복잡도: O(1)
         */

        LinkedNode fastLinkedNode = linkedList.getHead(), slowLinkedNode = linkedList.getHead() ;
        boolean answer = false;
        while(slowLinkedNode != null){

            if (fastLinkedNode != null) {
                if (fastLinkedNode.getNext() != null) fastLinkedNode = fastLinkedNode.getNext().getNext();
                else fastLinkedNode = null;
            }

            slowLinkedNode = slowLinkedNode.getNext();

            if (fastLinkedNode != null){
                if (fastLinkedNode.hashCode() == slowLinkedNode.hashCode()) {
                    answer = true;
                    break;
                }
            }

        }
        return answer;
    }


}
