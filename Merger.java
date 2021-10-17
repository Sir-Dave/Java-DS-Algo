package com.sirdave.data_structures;

import java.util.Arrays;

public class Merger {
    public static int[] mergeTwoArrays(int[] myArray, int[] aliceArray){
        int[] mergedArray = new int[myArray.length + aliceArray.length];

        int currentIndex = 0;
        int myIndex = 0;
        int aliceIndex = 0;

        while (currentIndex < mergedArray.length){

            boolean isAliceExhausted = aliceIndex >= aliceArray.length;
            boolean isMineExhausted = myIndex >= myArray.length;

            if (!isMineExhausted && (isAliceExhausted ||
                    myArray[myIndex] < aliceArray[aliceIndex])){
                mergedArray[currentIndex] = myArray[myIndex];
                myIndex++;
            }

            else {
                mergedArray[currentIndex] = aliceArray[aliceIndex];
                aliceIndex++;
            }
            currentIndex++;
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
        int[] aliceArray = new int[]{1, 5, 8, 12, 14, 19};
        int[] mergedArray = mergeTwoArrays(myArray, aliceArray);
        System.out.println(Arrays.toString(mergedArray));
    }
}
