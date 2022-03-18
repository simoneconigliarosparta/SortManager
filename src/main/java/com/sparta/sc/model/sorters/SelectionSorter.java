package com.sparta.sc.model.sorters;

public class SelectionSorter implements Sorter {

    @Override
    public int[] sortArray(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int tempNumber = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tempNumber;
        }

        return array;
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName();
    }
}
