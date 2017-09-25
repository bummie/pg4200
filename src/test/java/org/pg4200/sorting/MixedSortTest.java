package org.pg4200.sorting;

import org.pg4200.losninger.ex4.MixedSort;

/**
 * Created by arcuri82 on 21-Aug-17.
 */
public class MixedSortTest extends SortTestTemplate{

    @Override
    protected MySort getInstance() {
        return new MixedSort();
    }
}