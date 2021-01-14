package me.parkprin.codingtest.queue.quiz3;

import java.util.LinkedList;
import java.util.Queue;

public class BFSLogic {
    Node root = null;

    public BFSLogic(Node node){
        root = node;
    }

    public void ldr1(Node root){
        if (root != null) {
            ldr1(root.getLeft());
            System.out.println(root.getValue());
            ldr1(root.getRight());
        }
    }

    public int maxSum(){
        Queue<Node> queue = new LinkedList<Node>();
        int result = 0;
        int sum =0;
        if (root == null) return 0;
        else {
            result = root.getValue();
            queue.offer(root);
            while (!queue.isEmpty()){
                int count = queue.size();
                sum = 0;
                while (count > 0){
                    count--;
                    Node getNode = queue.poll();
                    sum += getNode.getValue();
                    if (getNode.getLeft() != null) queue.offer(getNode.getLeft());
                    if (getNode.getLeft() != null) queue.offer(getNode.getRight());
                }
                result = Math.max(result, sum);
            }

        }

        return result;
    }

}
