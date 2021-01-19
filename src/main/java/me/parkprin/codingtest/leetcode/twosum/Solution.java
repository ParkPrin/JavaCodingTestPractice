package me.parkprin.codingtest.leetcode.twosum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    /**
     *
     *
     * Given an array of integers nums and an integer target,
     * return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution,
     * and you may not use the same element twice.
     *
     * You can return the answer in any order.
     *
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
        int[] answers = new Solution().twoSum(new int[]{3,3}, 6);
        for (int answer : answers){
            System.out.println(answer);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        /*

        솔루션 1. for문 안에 for문
        시간복잡도: O(n^2)
        공간복잡도: O(1)

        int[] answer = new int[2];
        for (int i = 0; i < nums.length-1; i++){
            for (int j =i+1; j < nums.length; j++){
                if (target-nums[i] == nums[j]){
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        return answer;
         */


        /*
        솔루션 2. Map + for문
        시간복잡도: O(n)
        공간복잡도: O(n)
         */
        int[] answer = new int[2];
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map1.containsKey(target - nums[i])){
                int getIndex = map1.get(target-nums[i]);
                answer[0] = getIndex;
                answer[1] = i;
            } else if (!map1.containsKey(nums[i])){
                map1.put(nums[i], i);
            } else if (map1.containsKey(nums[i])) {
                int getIndex =map1.get(nums[i]);
                answer[0] = getIndex;
                answer[1] = i;
            }
        }
        return answer;
    }
}
