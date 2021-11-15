package com.sirdave.data_structures;

import java.util.ArrayList;

public class CountingSort {
    static ArrayList<Integer> countingSort(int[] array){
        int[] count = new int[array.length];
        ArrayList<Integer> res = new ArrayList<>();

        for (int i: array) count[i]++;
        for (int j = 0; j < count.length; j++){
            while (count[j] > 0){
                res.add(j);
                count[j]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {4,3,1,1,2};
        ArrayList<Integer> res = countingSort(array);
        System.out.println(res);
    }
}
