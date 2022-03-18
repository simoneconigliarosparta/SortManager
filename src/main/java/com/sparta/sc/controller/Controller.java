package com.sparta.sc.controller;

import com.sparta.sc.exceptions.SorterException;
import com.sparta.sc.logger.SortManagerLogger;
import com.sparta.sc.model.factory.SortFactory;
import com.sparta.sc.model.sorters.Sorter;
import com.sparta.sc.utilities.ArrayGenerator;
import com.sparta.sc.view.ViewManager;

import java.util.Arrays;
import java.util.logging.Level;

public class Controller extends SorterException {

    private static final int BINARY_SORTER = 3;

    private static boolean isLengthValid = false;
    private static boolean isRootElementVail = false;

    private static int[] sortedArray;

    public static void start() {
        SortManagerLogger.setupLogger();
        SortManagerLogger.getLogger().log(Level.INFO, "Starting SortManager...");

        int choice;
        int rootElement = 0;
        int lengthArray = 0;
        int[] unsortedArray;

        SortManagerLogger.getLogger().log(Level.INFO, "Show list of sorters:");
        choice = ViewManager.chooseFromListSorters();

        try {
            Sorter sorter = SortFactory.getSorter(choice);
            SortManagerLogger.getLogger().log(Level.INFO, "Sorter selected: " + sorter);

            if (choice == BINARY_SORTER) {
                while(!isRootElementVail){
                    SortManagerLogger.getLogger().log(Level.INFO, "Ask for root element");
                    rootElement = ViewManager.askForRootElement();
                    checkIsValidRootElement(rootElement);
                    SortManagerLogger.getLogger().log(Level.INFO, "Root element: " + rootElement);
                }
            }

            while(!isLengthValid){
                SortManagerLogger.getLogger().log(Level.INFO, "Ask for length of array");
                lengthArray = ViewManager.askForLengthArray();
                checkLengthArray(lengthArray);
                SortManagerLogger.getLogger().log(Level.INFO, "Length array: " + lengthArray);
            }

            if (choice == BINARY_SORTER) {

                unsortedArray = ArrayGenerator.getRandomArray(rootElement, lengthArray);
            } else {
                unsortedArray = ArrayGenerator.getRandomArray(lengthArray);
            }

            ViewManager.showUnsortedArray(choice, unsortedArray);

            long totalTime = getTimeSorting(sorter, unsortedArray);
            SortManagerLogger.getLogger().log(Level.INFO, "Sorted Array: " + Arrays.toString(sortedArray));
            ViewManager.showResults(totalTime, sortedArray);


        } catch (SorterException e) {
            SortManagerLogger.getLogger().log(Level.WARNING, e.getMessage());
        }
    }

    private static void checkIsValidRootElement(int rootElement) {
        if(rootElement >= -1000 && rootElement <= 1000){
            isRootElementVail = true;
        } else {
            SortManagerLogger.getLogger().log(Level.WARNING, "Invalid root element");
        }
    }

    private static void checkLengthArray(int lengthArray) {
        if(lengthArray >0 && lengthArray <= 1000){
            isLengthValid = true;
        } else {
            SortManagerLogger.getLogger().log(Level.WARNING, "Invalid length array");
        }
    }

    private static long getTimeSorting(Sorter sorter, int[] unsortedArray){
        long start = System.nanoTime();
        sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        return end - start;
    }
}
