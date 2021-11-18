package com.sirdave.data_structures;

import java.util.Arrays;

public class CountingSort {

    static int[] countingSort(int[] array){
        int[] count = new int[10]; // specify the max length based on your input

        int k = 0;

        for (int i: array) count[i]++;
        for (int j = 0; j < count.length; j++){
            while (count[j] > 0){
                array[k] = j;
                count[j]--;
                k++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {4,3,1,1,2, 9};
        int[] res = countingSort(array);
        System.out.println(Arrays.toString(res));
    }
}
