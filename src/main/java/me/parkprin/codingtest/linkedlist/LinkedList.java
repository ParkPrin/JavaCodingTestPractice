package me.parkprin.codingtest.linkedlist;

public class LinkedList {

    private LinkedNode head;
    private LinkedNode tail;

    public LinkedNode getHead() {
        return head;
    }

    public LinkedNode getTail() {
        return tail;
    }

    public void setHead(LinkedNode head) {
        this.head = head;
    }

    public void setTail(LinkedNode tail) {
        this.tail = tail;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));

        list.print();
        list.reverse();
        list.print();
    }

    public void print() {
        LinkedNode nodeToPrint = this.head;
        while(nodeToPrint != null) {
            System.out.println(nodeToPrint.number);
            nodeToPrint = nodeToPrint.next;
        }
    }

    public void add(LinkedNode node){
        if (head == null){
            head = node;
            tail = node;
        } else if (tail != null) {
            tail.next = node;
            tail = tail.next;
        }
    }

    private void reverse() {
        /*
        순차적인 방법
        LinkedNode current = this.head;
        LinkedNode prev = null;
        LinkedNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.tail = this.head;
        this.head = prev;
        */

        LinkedNode head = this.head;
        this.head = reverseRecursive(head);
        this.tail = head;
    }

    private LinkedNode reverseRecursive(LinkedNode node){
        if (node == null || node.next == null) return node;

        LinkedNode newHead = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }


}
