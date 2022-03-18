package com.sparta.sc.model.factory;

import com.sparta.sc.exceptions.SorterException;
import com.sparta.sc.model.sorters.*;

public class SortFactory {

    public static Sorter getSorter(int num) throws SorterException {
        switch (num) {
            case 1:
                return new BubbleSorter();
            case 2:
                return new MergeSorter();
            case 3:
                return new BinarySorter();
            case 4:
                return new QuickSorter();
            case 5:
                return new InsertionSorter();
            case 6:
                return new SelectionSorter();
            default:
                throw new SorterException();

        }
    }
}
