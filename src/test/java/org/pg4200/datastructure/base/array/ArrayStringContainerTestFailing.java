package org.pg4200.datastructure.base.array;

import org.pg4200.datastructure.base.StringContainerWithIndex;
import org.pg4200.datastructure.base.StringContainerWithIndexTestTemplate;

/**
 * Created by arcuri82 on 14-Aug-17.
 */
public class ArrayStringContainerTestFailing extends StringContainerWithIndexTestTemplate {

    @Override
    protected StringContainerWithIndex getNewInstance() {
        return new ArrayStringContainer(4);
    }

    /*
        When this test suite is run, at least one test fail.
        Why?
        Because we have one test in which we try to add 5 elements, but here we chose that the backing array
        has size 4.

        So, couldn't we just choose a starting size of 1_000_000_000 to solve this problem???
        Of course we could, but then this trivial example would take 1GB of RAM for each single
        container class...
     */
}
