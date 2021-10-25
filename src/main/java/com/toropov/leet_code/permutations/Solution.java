/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


Constraints:

1 <= nums.length <= 4
-10 <= nums[i] <= 10
All the integers of nums are unique.*/

package com.toropov.leet_code.permutations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[]args){
        int [] nums = new int[]{1,2,3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> tmpList2;
        Integer[] arr = Arrays.stream(nums).boxed().toArray( Integer[]::new );
        List<Integer> tmpList = new LinkedList<Integer>(Arrays.asList(arr));
        list.add(tmpList);
        int count = 1;
        int count1 = 1;
        int count2 = 0;
        int index = arr.length - 1;
        if(list.size() == nums.length){
            return list;
        }
        if(arr.length%2==0){
            while(count != factorial(arr.length)){
                if(count!=1 || arr.length==2){
                    if(count2 == arr.length - 1){
                        int tmp = arr[0];
                        arr[0] = arr[arr.length-1];
                        arr[arr.length-1] = tmp;
                        tmpList2 = new LinkedList<Integer>(Arrays.asList(arr));
                        list.add(tmpList2);
                        count++;
                    } else {
                        int tmp = arr[1];
                        arr[1] = arr[0];
                        arr[0] = tmp;
                        tmpList2 = new LinkedList<Integer>(Arrays.asList(arr));
                        list.add(tmpList2);
                        count++;
                    }
                }
                index = arr.length - 1;
                while(count1 != factorial(arr.length-1)){
                    if(index == 1)
                        index = arr.length - 1;
                    int tmp = arr[index];
                    arr[index] = arr[index-1];
                    arr[index-1] = tmp;
                    tmpList2 = new LinkedList<Integer>(Arrays.asList(arr));
                    list.add(tmpList2);
                    index--;
                    count1++;
                    count++;
                }
                count1 = 1;
                count2++;
            }
        }else {
            while(count != factorial(arr.length)){
                if(index == 0)
                    index = arr.length - 1;
                int tmp = arr[index];
                arr[index] = arr[index-1];
                arr[index-1] = tmp;
                tmpList2 = new LinkedList<Integer>(Arrays.asList(arr));
                list.add(tmpList2);
                index--;
                count++;
            }
        }

        return list;
    }




    public static int factorial(int number) {
        int result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }
}
