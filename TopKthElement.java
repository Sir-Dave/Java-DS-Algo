package com.sirdave.data_structures;

import java.util.*;

public class TopKthElement {

    //Method 1: Using Min Heaps PriorityQueues
    static Integer topKthElement(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<>();

        for (int i: nums){
            priorityQueue.add(i);

            if(priorityQueue.size()>k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.peek();
    }

    //Method 2: Using QuickSelect Algorithm
    static int kthLargest(int[] arr, int k) {
        int n = arr.length;
        k = n - k;
        int left = 0;
        int right = n - 1;

        Random rand = new Random(0);

        while (left <= right) {
            int chosenPivotIndex = rand.nextInt(right - left + 1) + left;

            int finalIndexOfChosenPivot = partition(arr, left, right, chosenPivotIndex);

            if (finalIndexOfChosenPivot == k) {
                return arr[finalIndexOfChosenPivot];
            } else if (finalIndexOfChosenPivot > k) {
                right = finalIndexOfChosenPivot - 1;
            } else {
                left = finalIndexOfChosenPivot + 1;
            }
        }

        return -1;
    }

    static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        int lesserItemsTailIndex = left;

        swap(arr, pivotIndex, right); //move the pivot index out of the way

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, lesserItemsTailIndex);
                lesserItemsTailIndex++;
            }
        }

        swap(arr, right, lesserItemsTailIndex);

        return lesserItemsTailIndex;
    }


    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int res = kthLargest(nums, 2);
        System.out.println(res);
    }
}
