package com.sparta.sc.model.sorters;

public class InsertionSorter implements Sorter {

    @Override
    public int[] sortArray(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int tempNumber = array[i];
            int j = i - 1;

            while ((j >= 0) && (array[j] > tempNumber)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tempNumber;
        }
        return array;
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName();
    }

}
