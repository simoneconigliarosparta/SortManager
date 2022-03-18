package com.sparta.sc.model.sorters.binarytree;

import com.sparta.sc.exceptions.ChildNotFoundException;

public class BinaryTreeImpl implements BinaryTree {

    private final Node rootNode;

    private int counter = 0;

    private int numberNodes = 1;

    private int[] sortedArray;

    public BinaryTreeImpl(final int element) {
        rootNode = new Node(element);
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return getNumberNodes();
    }

    @Override
    public void addElement(int element) {
        addNodeToTree(rootNode, element);
    }

    @Override
    public void addElements(int[] elements) {
        // i = 1 because elements[0] is the rootElement
        for (int i = 1; i < elements.length; i++) {
            addNodeToTree(rootNode, elements[i]);
        }
    }

    @Override
    public boolean findElement(int value) {
        Node node = findNode(value);
        return node != null;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);

        if(node.isLeftChildEmpty()){
            throw new ChildNotFoundException();
        }
        return node.getLeftChild().getValue();
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        if(node.isRightChildEmpty()){
            throw new ChildNotFoundException();
        }
        return node.getRightChild().getValue();
    }

    @Override
    public int[] getSortedTreeAsc() {
        sortedArray = new int[numberNodes];
        counter = 0;
        return getNodesInAscOrder(rootNode);
    }

    @Override
    public int[] getSortedTreeDesc() {
        sortedArray = new int[numberNodes];
        counter = 0;
        return getNodesInDecOrder(rootNode);
    }

    private void addNodeToTree(Node node, int element) {
        if (element <= node.getValue()) {
            if (node.isLeftChildEmpty()) {
                node.setLeftChild(new Node(element));
                numberNodes++;
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if (element > node.getValue()) {
            if (node.isRightChildEmpty()) {
                node.setRightChild(new Node(element));
                numberNodes++;
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    private Node findNode(int element) {
        Node node = rootNode;
        while (node != null) {
            if (element == node.getValue()) {
                return node;
            }
            if (element < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return null;
    }

    private int getNumberNodes() {
        return numberNodes;
    }

    private int[] getNodesInAscOrder(Node node) {
        if (node == null) {
            counter++;
            return null;
        }
        getNodesInAscOrder(node.getLeftChild());
        sortedArray[counter - 1] = node.getValue();
        getNodesInAscOrder(node.getRightChild());
        return sortedArray;
    }

    private int[] getNodesInDecOrder(Node node) {
        if (node == null) {
            counter++;
            return null;
        }
        getNodesInDecOrder(node.getRightChild());
        sortedArray[counter - 1] = node.getValue();
        getNodesInDecOrder(node.getLeftChild());
        return sortedArray;
    }

    public static class Node {

        private final int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public int getValue() {
            return value;
        }

        public boolean isLeftChildEmpty() {
            return leftChild == null;
        }

        public boolean isRightChildEmpty() {
            return rightChild == null;
        }
    }
}
