package com.sparta.sc.model.sorters;

public class BubbleSorter implements Sorter {

    @Override
    public int[] sortArray(int[] array) {
        
        int tempNumber;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {

                if (array[i] > array[j]) {
                    tempNumber = array[j];
                    array[j] = array[i];
                    array[i] = tempNumber;
                }
            }
        }
        return array;
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName();
    }
}
