package com.codecool.quicksort;


import java.util.List;

public class QuickSort {

    /**
     * Sorts the given List in place
     * @param toSort the List to sort. Throws an error if its null
     */

    public void sort(List<Integer> toSort) {
        if (toSort == null)
            throw new IllegalArgumentException("list not defined");

        if (toSort.size() == 0)
            return;

        sort(toSort, 0, toSort.size() - 1);
    }

    private void sort(List<Integer> toSort, int start, int end) {
        if (start == end)
            return;

        int middleIndex = (start + end) / 2;
        System.out.println(toSort);
        System.out.println("============================");
        System.out.println("start: " + start + " end: " + end + " middle index: " + middleIndex);

        int pivotValue = toSort.get(middleIndex);

        int left = start;
        int right = end;
        int partitionPoint;

        while (true) {
            while (toSort.get(left) < pivotValue)
                left++;
            while (toSort.get(right) > pivotValue)
                right--;

            if (left <= right) {
                swapToElements(toSort, left, right);
                left++;
                right--;
            } else {
                partitionPoint = left;
                break;
            }
        }

        sort(toSort, start, partitionPoint - 1);
        sort(toSort, partitionPoint, end);
        System.out.println("============================");
        System.out.println(toSort);
    }

    private void swapToElements(List<Integer> list, int leftIndex, int rightIndex) {
        Integer leftElem = list.get(leftIndex);
        Integer rightElem = list.get(rightIndex);
        list.set(leftIndex, rightElem);
        list.set(rightIndex, leftElem);
    }

//    private void moveElementToEnd(List<Integer> toSort, int index) {
//        Integer value = toSort.get(index);
//        toSort.remove(index);
//        toSort.add(value);
//    }

}
