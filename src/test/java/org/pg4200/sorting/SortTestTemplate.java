package org.pg4200.sorting;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by arcuri82 on 21-Aug-17.
 */
public abstract class SortTestTemplate {

    protected abstract MySort getInstance();

    protected MySort sorter;

    @Before
    public void init(){
        sorter = getInstance();
    }

    @Test
    public void testNull(){
        //should not throw an exception
        sorter.sort(null);
    }

    @Test
    public void testOne(){

        String[] array = {"a"};

        sorter.sort(array);

        assertEquals("a", array[0]);
    }

    @Test
    public void testAlreadySorted(){

        String[] array = {"a", "b", "c", "d"};

        sorter.sort(array);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);
    }


    @Test
    public void testInverted(){

        String[] array = {"d", "c", "b", "a"};

        sorter.sort(array);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);
    }


    @Test
    public void testBase(){

        String[] array = {"d", "a", "c", "b"};

        sorter.sort(array);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);
    }


    @Test
    public void testRandom(){

        Random random = new Random();

        for(int i=0; i<1000; i++){

            Integer[] array = new Integer[10];
            for(int j=0; j<array.length; j++){
                array[j] = random.nextInt(20);
            }

            sorter.sort(array);

            /*
                Regardless of the input array (which could be random)
                there are still properties that we can check, and that
                are independent of the input, like [j] <= [j+1].
             */
            for(int j=0; j<array.length-1; j++){
                assertTrue(Arrays.toString(array), array[j] <= array[j+1]);
            }

            /*
                Is the above check enough to determine if an array is
                sorted???

                What if an implementation of "sorter.sort" just sets all
                the values in the array to 0 ???
             */
        }

    }
}
