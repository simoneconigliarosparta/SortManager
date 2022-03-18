package com.sparta.sc.model.sorters;

public class MergeSorter implements Sorter {

    @Override
    public int[] sortArray(int[] array) {

        if (array.length == 1) {
            return array;
        }

        int[] arrayOne = new int[array.length / 2];
        int[] arrayTwo = new int[array.length - array.length / 2];
        int index = 0;

        for (int i = 0; i < arrayOne.length; i++) {
            arrayOne[i] = array[index];
            index++;

        }
        for (int i = 0; i < arrayTwo.length; i++) {
            arrayTwo[i] = array[index];
            index++;
        }

        sortArray(arrayOne);
        sortArray(arrayTwo);

        return sortMerge(array, arrayOne, arrayTwo);
    }

    public int[] sortMerge(int[] mainArray, int[] arrayOne, int[] arrayTwo) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arrayOne.length && j < arrayTwo.length) {
            if (arrayOne[i] < arrayTwo[j]) {
                mainArray[k] = arrayOne[i];
                i++;
            } else {
                mainArray[k] = arrayTwo[j];
                j++;
            }
            k++;
        }

        while (i < arrayOne.length) {
            mainArray[k] = arrayOne[i];
            i++;
            k++;
        }

        while (j < arrayTwo.length) {
            mainArray[k] = arrayTwo[j];
            j++;
            k++;
        }

        return mainArray;
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName();
    }

}
