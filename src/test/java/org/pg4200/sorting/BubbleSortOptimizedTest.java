package org.pg4200.sorting;

import org.pg4200.losninger.ex3.BubbleSortOptimized;

/**
 * Created by arcuri82 on 21-Aug-17.
 */
public class BubbleSortOptimizedTest extends SortTestTemplate{

    @Override
    protected MySort getInstance() {
        return new BubbleSortOptimized();
    }
}