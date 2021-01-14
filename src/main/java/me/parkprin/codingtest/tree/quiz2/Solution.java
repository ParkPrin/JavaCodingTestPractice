package me.parkprin.codingtest.tree.quiz2;


class Solution {
    /**
     # 높이를 구하는 문제
     주어진 이진 트리 높이를 구하여라

     * 시간복잡도 O(n)
     * 공간복잡도 최대 O(1)
     */
    public static void main(String[] args) {
        Node node  = new Node(9)
                .setLeft(new Node(2).setLeft(new Node(1)).setRight(new Node(5)))
                .setRight(new Node(3).setLeft(new Node(4)).setRight(new Node(9)));
        System.out.println(new Solution().solution(node));
    }


    public int solution(Node node){
        if (node == null) {
            return 0;
        }
        int leftDepth = solution(node.getLeft());
        int rightDepth = solution(node.getRight());

        if (leftDepth > rightDepth){
            return leftDepth+1;
        } else {
            return rightDepth+1;
        }
    }


}
