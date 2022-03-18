package com.sparta.sc.view;

import com.sparta.sc.logger.SortManagerLogger;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;

public class ViewManager {

    private final static Scanner scanner = new Scanner(System.in);
    private static final String[] listSorters = new String[]{"BubbleSorter", "MergeSorter", "BinarySorter", "QuickSorter", "InsertionSorter", "SelectionSorter"};

    public static int chooseFromListSorters() {
        SortManagerLogger.getLogger().log(Level.INFO, Arrays.toString(listSorters));
        System.out.println("Please enter a number between from 1 and 6 to choose one of the Sorters");
        for (int i = 0; i < listSorters.length; i++) {
            System.out.println(i + 1 + " - " + listSorters[i]);
        }
        return scanner.nextInt();
    }

    public static int askForRootElement(){
        System.out.println("Please insert your root element (number between -1000 and 1000)");
        return scanner.nextInt();
    }

    public static int askForLengthArray(){
        System.out.println("Please choose the length of array you wish to create (max length is 1000)");
        return scanner.nextInt();
    }

    public static void showUnsortedArray(int choice, int[] unsortedArray){
        System.out.println("You have chosen a " + listSorters[choice - 1]);
        System.out.println("Your unsorted array:\n" + Arrays.toString(unsortedArray));
    }

    public static void showResults(long time, int[] sortedArray){
        System.out.println("Your sorted array:\n" + Arrays.toString(sortedArray));
        System.out.println("Time taken " + time + " nanoseconds");
    }

}
