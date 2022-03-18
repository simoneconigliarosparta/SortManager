package com.sparta.sc.utilities;

import com.sparta.sc.logger.SortManagerLogger;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;

public class ArrayGenerator {

    private static final int MIN = -1000;
    private static final int MAX = 1000;

    public static int[] getRandomArray(int length){

        int[] randomArray = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            randomArray[i] = random.nextInt(MAX - MIN) + MIN + 1;
        }
        SortManagerLogger.getLogger().log(Level.INFO, "Random Generated Array: " + Arrays.toString(randomArray));
        return randomArray;
    }

    public static int[] getRandomArray(int rootElement, int length){

        int[] randomArray = new int[length];
        randomArray[0] = rootElement;
        Random random = new Random();

        for (int i = 1; i < length; i++) {
            randomArray[i] = random.nextInt(MAX - MIN) + MIN + 1;
        }
        SortManagerLogger.getLogger().log(Level.INFO, "Generated Array: " + Arrays.toString(randomArray));
        return randomArray;
    }



}
