package me.parkprin.codingtest.queue.quiz3;


class Solution {
    /**
     *
     최대 n개 만큼의 가장 최근에 접근한 데이터를 캐싱하는 LRU (least recently used) 캐시를 구현하라.
     바이너리 트리의 계층별 합계 중에 최대 값을 구하라.

     9  -> 9
     2 3  -> 5
     1 5 4 9 -> 19
     ==========> 10

     */
    public static void main(String[] args) {
        Node node  = new Node(100)
                .setLeft(new Node(2).setLeft(new Node(1)).setRight(new Node(5)))
                .setRight(new Node(3).setLeft(new Node(4)).setRight(new Node(9)));
        BFSLogic bfsLogic = new BFSLogic(node);
        System.out.println(bfsLogic.maxSum());
    }





}
