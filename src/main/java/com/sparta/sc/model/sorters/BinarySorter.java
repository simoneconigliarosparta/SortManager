package com.sparta.sc.model.sorters;

import com.sparta.sc.model.sorters.binarytree.BinaryTree;
import com.sparta.sc.model.sorters.binarytree.BinaryTreeImpl;

public class BinarySorter implements Sorter {

    @Override
    public int[] sortArray(int[] array) {
        BinaryTree binaryTree = new BinaryTreeImpl(array[0]);
        binaryTree.addElements(array);
        return binaryTree.getSortedTreeAsc();
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName();
    }
}
