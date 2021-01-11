package me.parkprin.codingtest.linkedlist;

public class LinkedNode {

    int number;
    LinkedNode next;

    public int getNumber() {
        return number;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public LinkedNode(int number) {
        this.number = number;
    }
}
