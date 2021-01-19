package me.parkprin.codingtest.leetcode.add_two_numbers;

import me.parkprin.codingtest.linkedlist.LinkedNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     *
     *
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     *
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     * 2 ->
     *
     * Example 1:
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     *
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * Example 3:
     *
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     */

    public static void main(String[] args){

        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(9);
        ListNode listNode11 = new ListNode(9);
        ListNode listNode12 = new ListNode(9);
        ListNode listNode13 = new ListNode(9);
        ListNode listNode14 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode11;
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(9);
        ListNode listNode7 = new ListNode(9);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        ListNode result = new Solution().addTwoNumbers(listNode1, listNode4);
        System.out.println(result);
    }

    /*

    솔루션 1. 순환하는 방식
    시간복잡도: O(n)
    공간복잡도: O(n)

    Runtime: 3 ms, faster than 16.05% of Java online submissions for Add Two Numbers.
    Memory Usage: 38.8 MB, less than 99.39% of Java online submissions for Add Two Numbers.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Value = 0;
        int l2Value = 0;
        int rounds = 0;
        ListNode result = null;
        ListNode init = null;
        while (l1 != null || l2 != null){

            if (l1 != null){
                l1Value = l1.val;
                l1 = l1.next;
            } else {
                l1Value = 0;
            }

            if (l2 != null){
                l2Value = l2.val;
                l2 = l2.next;
            } else {
                l2Value = 0;
            }

            if (result == null){
                int inputValue = 0;
                if (l1Value + l2Value >= 10){
                    inputValue = l1Value + l2Value - 10;
                    rounds = 1;
                } else {
                    inputValue = l1Value + l2Value;
                    rounds = 0;
                }
                result = new ListNode(inputValue);
                init = result;
            } else {
                int inputValue = 0;
                int nextRounds = 0;
                if (l1Value + l2Value + rounds >= 10){
                    inputValue = l1Value + l2Value - 10;
                    nextRounds = 1;
                } else {
                    inputValue = l1Value + l2Value;
                    nextRounds = 0;
                }
                result.next = new ListNode(inputValue + rounds);
                rounds = nextRounds;
                result = result.next;
            }

        }
        if (rounds == 1){
            result.next = new ListNode(1);
        }

        return init;
    }*/

    /*
    솔루션 2. 재귀방식
    시간복잡도: O(n)
    공간복잡도: O(n)

    Runtime: 2 ms, faster than 76.87% of Java online submissions for Add Two Numbers.
    Memory Usage: 39.4 MB, less than 59.02% of Java online submissions for Add Two Numbers.

     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = null;
        if (l1.val + l2.val >= 10){
            listNode = new ListNode(l1.val + l2.val - 10);
            if (l1.next != null || l2.next != null) listNode.next = addTwoNumbers(l1.next, l2.next, 1);
            else {
                listNode = new ListNode(l1.val + l2.val - 10);
                listNode.next = new ListNode(1);
            }
        } else {
            listNode = new ListNode(l1.val + l2.val);
            if (l1.next != null || l2.next != null) listNode.next = addTwoNumbers(l1.next, l2.next, 0);
            else {
                listNode = new ListNode(l1.val + l2.val);
            }
        }
        return listNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int rounds) {
        ListNode listNode = null;
        int inputRounds = 0;
        ListNode l1Next = null;
        ListNode l2Next = null;
        if (l1 != null && l2 != null){
            if (l1.val + l2.val + rounds >= 10){
                listNode = new ListNode(l1.val + l2.val + rounds -10);
                inputRounds = 1;
            } else{
                listNode = new ListNode(l1.val + l2.val + rounds);
            }
            l1Next = l1.next;
            l2Next = l2.next;
        } else if (l1 != null && l2 == null){
            if (l1.val + rounds >= 10){
                listNode = new ListNode(l1.val + rounds - 10);
                inputRounds = 1;
            } else{
                listNode = new ListNode(l1.val + rounds);
            }
            l1Next = l1.next;
        } else if (l1 == null && l2 != null){
            if (l2.val + rounds >= 10){
                listNode = new ListNode(l2.val + rounds - 10);
                inputRounds = 1;
            } else{
                listNode = new ListNode(l2.val + rounds);
            }
            l1Next = l2.next;
        }
        if (l1Next == null && l2Next == null){
            if (inputRounds == 1){
              listNode.next = new ListNode(1);
            }
            return listNode;
        } else {
            listNode.next = addTwoNumbers(l1Next, l2Next, inputRounds);
            return listNode;
        }
    }

    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
