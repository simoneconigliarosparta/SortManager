package com.sparta.sc;

import com.sparta.sc.exceptions.SorterException;
import com.sparta.sc.model.factory.SortFactory;
import com.sparta.sc.model.sorters.Sorter;
import org.junit.jupiter.api.*;

import java.util.Random;

public class SortTester {

    @Test
    @DisplayName("Test array is sorted")
    void testArrayIsSorted() throws SorterException {
        int[] unsortedArray = {20, 34, 56, 72, 24, 15, 45, 95, 47, 68};

        for (int numSort = 1; numSort <= 6; numSort++) {
            Sorter sorter = SortFactory.getSorter(numSort);
            System.out.println("Testing the " + sorter);

            int[] sortedArray = sorter.sortArray(unsortedArray);

            for (int i = 1; i < sortedArray.length; i++) {
                Assertions.assertTrue(sortedArray[i - 1] <= sortedArray[i]);
            }
            System.out.println("-- Test on " + sorter + " passed");
        }
    }

    @Test
    @DisplayName("Test array with single value")
    void testArrayWithSingleValue() throws SorterException {
        int[] unsortedArray = {5};

        for (int numSort = 1; numSort <= 6; numSort++) {
            Sorter sorter = SortFactory.getSorter(numSort);
            System.out.println("Testing the " + sorter);

            int[] sortedArray = sorter.sortArray(unsortedArray);

            Assertions.assertEquals(unsortedArray.length, sortedArray.length);
            Assertions.assertEquals(unsortedArray[unsortedArray.length - 1], sortedArray[sortedArray.length - 1]);
            System.out.println("-- Test on " + sorter + " passed");
        }
    }

    @Test
    @DisplayName("Test array with duplicate values")
    void testArrayWithDuplicateValues() throws SorterException {
        int[] unsortedArray = {20, 34, 20, 72, 24, 34, 45, 95, 47, 72};

        for (int numSort = 1; numSort <= 6; numSort++) {
            Sorter sorter = SortFactory.getSorter(numSort);
            System.out.println("Testing the " + sorter);

            int[] sortedArray = sorter.sortArray(unsortedArray);

            for (int j = 1; j < sortedArray.length; j++) {
                Assertions.assertTrue(sortedArray[j - 1] <= sortedArray[j]);
            }
            System.out.println("-- Test on " + sorter + " passed");
        }
    }

    @Test
    @DisplayName("Test array with max length allowed")
    void testArrayWithMaxLengthAllowed() throws SorterException {
        Random random = new Random();
        int[] unsortedArray = new int[1000];

        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = random.nextInt(1000) + 1;
        }

        for (int numSort = 1; numSort <= 6; numSort++) {
            Sorter sorter = SortFactory.getSorter(numSort);
            System.out.println("Testing the " + sorter);

            int[] sortedArray = sorter.sortArray(unsortedArray);

            for (int i = 1; i < sortedArray.length; i++) {
                Assertions.assertTrue(sortedArray[i - 1] <= sortedArray[i]);
            }
            System.out.println("-- Test on " + sorter + " passed");
        }
    }
}
