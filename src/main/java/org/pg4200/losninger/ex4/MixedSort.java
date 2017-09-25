package org.pg4200.losninger.ex4;

import org.pg4200.sorting.MySort;
public class MixedSort implements MySort
{

    private int bubbleLimit = 5;

    @Override
    public <T extends Comparable<T>> void sort(T[] array)
    {
        if (array == null) {
            return;
        }

        T[] buffer = (T[]) new Comparable[array.length];

        mergesort(0, array.length - 1, array, buffer);
    }

    private <T extends Comparable<T>> void mergesort(int low, int high, T[] array, T[] buffer) {


        if (low >= high) {
            /*
                This means we are in a subarea of array with 1 or less elements.
                As such subarray is sorted by definition (ie less than 2 elements),
                we do not need to do anything
             */
            return;
        }else if((high - low) < bubbleLimit)
        {
            bubblesort(low, high, array);
        }else
        {
            int middle = low + (high - low) / 2;

            mergesort(low, middle, array, buffer);

            mergesort(middle + 1, high, array, buffer);

            merge(low, middle, high, array, buffer);

        }
    }

    private <T extends Comparable<T>> void merge(int low, int middle, int high, T[] array, T[] buffer) {

        for (int i = low; i <= high; i++) {
            buffer[i] = array[i];
        }

        //index over the left half, before middle
        int i = low;

        //index over the right half, after middle
        int j = middle + 1;

        for (int k = low; k <= high; k++) {
            if (i > middle) {
                //done with left half, just copy over the right
                array[k] = buffer[j++];
            } else if (j > high) {
                //done with right half, just copy over the left
                array[k] = buffer[i++];
            } else if (buffer[j].compareTo(buffer[i]) < 0) {
                array[k] = buffer[j++];
            } else {
                array[k] = buffer[i++];
            }
        }
    }

    private <T extends Comparable<T>> void bubblesort(int low, int high, T[] array)
    {
        if (array == null)
        {
            return;
        }

        //make sure we enter into first loop of the "while"
        boolean swapped = true;
        int lastSorted = high;

        while (swapped)
        {

            /*
                if there is not going to be any swapping, then the
                array is sorted, and we do not need to recheck
             */
            swapped = false;
            for (int i = low; i < high; i++)
            {
                if(i >= lastSorted)
                    break;
                int j = i+1;

                /*
                    if current element is greater than next,
                    then swap them.
                    Like a bubble, the highest value will fly up.
                 */

                if (array[i].compareTo(array[j]) > 0)
                {
                    T tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;

                    swapped = true;
                }
            }
            lastSorted--;
        }
    }
}
