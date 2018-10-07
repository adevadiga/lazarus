package com.anoop.stacksqueues;

/*
Approach 1: Fixed Division
We can divide the array in three equal parts and allow the individual stack to grow in that limited space.
Note: We will use the notation "[" to mean inclusive of an end point and "(" to mean exclusive of an end
point.
• For stack 1 , we will use [e, ~ ).
• For stack 2, we will use [ ~, 2~).
• For stack 3, we will use [ 2~, n).
*/
public class FixedMultiStack {
    int numberOfStack = 3;
    int stackCapacity;
    int[] values;
    int[] sizes;

    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStack];
        sizes = new int[numberOfStack];
    }

    public void push(int stackNum, int value) {
        if (isFull(stackNum)) {
            throw new RuntimeException();
        }
        sizes[stackNum]++;// Move the top pointer up
        values[indexofTop(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new RuntimeException();
        }
        int topIndex = indexofTop(stackNum);
        int value = values[topIndex]; // Get top
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    private boolean isFull(int stackNum) {
        int sizeOfStack = sizes[stackNum];
        return sizeOfStack >= stackCapacity;
    }

    private boolean isEmpty(int stackNum) {
        int sizeOfStack = sizes[stackNum];
        return sizeOfStack == 0;
    }

    private int indexofTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

}