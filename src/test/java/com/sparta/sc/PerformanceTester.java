package com.sparta.sc;

import com.sparta.sc.model.sorters.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class PerformanceTester {

    private static int[] arrayToSort;
    
    @BeforeAll
    static void populateArray() {
        arrayToSort = new int[100];
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            arrayToSort[i] = random.nextInt(1000) +1;
        }
    }

    @Test
    @DisplayName("Test BubbleSorter")
    void testBubbleSorter() {
        Sorter sorter = new BubbleSorter();
        System.out.println(sorter);
        int[] unsortedArray = arrayToSort.clone();

        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();

        printResult(sortedArray, end - start);
    }

    @Test
    @DisplayName("Test MergeSorter")
    void testMergeSorter() {
        Sorter sorter = new MergeSorter();
        System.out.println(sorter);
        int[] unsortedArray = arrayToSort.clone();

        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();

        printResult(sortedArray, end - start);
    }

    @Test
    @DisplayName("Test BinarySorter")
    void testBinarySorter() {
        Sorter sorter = new BinarySorter();
        System.out.println(sorter);
        int[] unsortedArray = arrayToSort.clone();

        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();

        printResult(sortedArray, end - start);
    }

    @Test
    @DisplayName("Test QuickSorter")
    void testQuickSorter() {
        Sorter sorter = new QuickSorter();
        System.out.println(sorter);
        int[] unsortedArray = arrayToSort.clone();

        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();

        printResult(sortedArray, end - start);
    }

    @Test
    @DisplayName("Test InsertionSorter")
    void testInsertionSorter() {
        Sorter sorter = new InsertionSorter();
        System.out.println(sorter);
        int[] unsortedArray = arrayToSort.clone();

        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();

        printResult(sortedArray, end - start);
    }

    @Test
    @DisplayName("Test SelectionSorter")
    void testSelectionSorter() {
        Sorter sorter = new SelectionSorter();
        System.out.println(sorter);
        int[] unsortedArray = arrayToSort.clone();

        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();

        printResult(sortedArray, end - start);
    }

    private void printResult(int[] sortedArray, long time) {
        System.out.println(Arrays.toString(arrayToSort));
        System.out.println(Arrays.toString(sortedArray));
        System.out.println("Time taken " + time + " nanoseconds");
    }

}
