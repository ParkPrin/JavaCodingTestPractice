package me.parkprin.codingtest.tree.quiz4;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /**
     # 중위탐색과 전위탐색 결과를 가지고 이진 트리를 만드는 코드를 작성하라.
     중위탐색(LDR): 4, 2, 5, 1, 3
     전위탐색(DLR): 1, 2, 4, 5, 3

     1
     2 3
     4 5 6 7
     */
    public static void main(String[] args) {
        Node node  = new Node(1)
                .setLeft(new Node(1).setLeft(new Node(1)).setRight(new Node(1)))
                .setRight(new Node(1).setLeft(new Node(1)).setRight(new Node(1)));
        int[] preOrderList = {1, 2, 4, 5, 3, 6, 7};
        int[] inOrderList = {4, 2, 5, 1, 6, 3, 7};
        int[] arrays = {1, 1, 1, 1, 1, 1, 1};
        Node node1 = new Solution().solution(inOrderList);
        //new Solution().preOrderChanage(node, preOrderList);
        new Solution().inOrderChanage(node, inOrderList);
        System.out.println();
        new Solution().preOrderSolution(node1);
        System.out.println();
        new Solution().inOrderSolution(node1);
        System.out.println();
        new Solution().postOrderSolution(node1);
        System.out.println();
        new Solution().bfsSolution(node1);

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
    전위 탐색 값 교체
     */
    int count = 0;
    public void preOrderChanage(Node node, int[] preOrderList){
        if (node != null){
            node.setValue(preOrderList[count]);
            count++;
            preOrderChanage(node.getLeft(), preOrderList);
            preOrderChanage(node.getRight(), preOrderList);
        }
    }

    public Node add(Node node, int value){
        if (node == null){
            node = new Node(value);
        } else if (node.getLeft() == null) {
            node.setLeft(new Node(value));
        } else if (node.getLeft() != null && node.getRight() ==null) {
            node.setRight(new Node(value));
        } else {
            if (!isLowLevelNode(node.getLeft())) add(node.getLeft(), value);
            else add(node.getRight(), value);
        }
        return node;
    }

    public boolean isLowLevelNode(Node node){
        if (node.getLeft() != null && node.getRight() != null) return true;
        else return false;
    }

    public Node solution(int[] inOrderList){
        Solution solution = new Solution();
        Node node = null;
        for (int intvalue : inOrderList){
            node = solution.add(node, intvalue);
        }
        inOrderChanage(node, inOrderList);
        return node;
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
    int count2 = 0;
    public void inOrderChanage(Node node, int[] inOrderList){
        if (node != null){
            inOrderChanage(node.getLeft(), inOrderList);
            node.setValue(inOrderList[count2]);
            count2++;
            inOrderChanage(node.getRight(), inOrderList);
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
