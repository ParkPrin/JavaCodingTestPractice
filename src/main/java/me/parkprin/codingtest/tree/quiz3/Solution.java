package me.parkprin.codingtest.tree.quiz3;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /**
     # 전위 탐색을 이진 트리로 순회하는 방법
     전위 탐색을 이진 트리로 순회하는 방법하는 방법과 재귀를 사용하는 방법으로 각각 구현하라.
     => Root -> left -> right

     # 중위 탐색을 이진 트리로 순회하는 방법
     중위 탐색을 이진 트리로 순회하는 방법하는 방법과 재귀를 사용하는 방법으로 각각 구현하라.
     =>  left -> Root -> right

     # 하위 탐색을 이진 트리로 순회하는 방법
     하위 탐색을 이진 트리로 순회하는 방법하는 방법과 재귀를 사용하는 방법으로 각각 구현하라.
     =>  left -> right -> Root

     # BFS(Breadth First Search) - 넓이우선탐색로 이진 트리 순회
     BFS로 이진 트리 순회하는 코드를 작성하라.
     => 상위 레벨부터 하위 레벨 까지 순회하는 방식

     9
     2 3
     1 5 4 9
     */
    public static void main(String[] args) {
        Node node  = new Node(9)
                .setLeft(new Node(2).setLeft(new Node(1)).setRight(new Node(5)))
                .setRight(new Node(3).setLeft(new Node(4)).setRight(new Node(9)));
        new Solution().preOrderSolution(node);
        System.out.println();
        new Solution().inOrderSolution(node);
        System.out.println();
        new Solution().postOrderSolution(node);
        System.out.println();
        new Solution().bfsSolution(node);
    }

    /*
    전위 탐색 순회
     */
    public void preOrderSolution(Node node){
        if (node != null){
            System.out.println(node.getValue());
            preOrderSolution(node.getLeft());
            preOrderSolution(node.getRight());
        }
    }

    /*
    중위 탐색 순회
     */
    public void inOrderSolution(Node node){
        if (node != null){
            inOrderSolution(node.getLeft());
            System.out.println(node.getValue());
            inOrderSolution(node.getRight());
        }
    }

    /*
    하위 탐색 순회
     */
    public void postOrderSolution(Node node){
        if (node != null){
            postOrderSolution(node.getLeft());
            postOrderSolution(node.getRight());
            System.out.println(node.getValue());
        }
    }

    /*
    넓이 우선 탐색법: BFS
     */

    public void bfsSolution(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        if (node != null) {
            queue.offer(node);
            while (!queue.isEmpty()) {
                int count = queue.size();
                while (count > 0) {
                    count--;
                    Node getNode = queue.poll();
                    System.out.println(getNode.getValue());
                    if (getNode.getLeft() != null) queue.offer(getNode.getLeft());
                    if (getNode.getLeft() != null) queue.offer(getNode.getRight());
                }
            }

        }
    }


}
