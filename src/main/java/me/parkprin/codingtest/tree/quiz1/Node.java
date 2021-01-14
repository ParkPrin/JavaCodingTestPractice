package me.parkprin.codingtest.tree.quiz1;

public class Node {
    private int value = 0;
    private Node left = null;
    private Node right = null;

    public Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node setLeft(Node left) {
        this.left = left;
        return this;
    }

    public Node setRight(Node right) {
        this.right = right;
        return this;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
