package org.devon.algorithms.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/27 20:22
 * @since 1.0.0
 */
public class SelectionSortTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSort() {

        SelectionSort.sort(new Integer[]{1,3,4,2,9,1,0,4,6,8,7});
    }
}