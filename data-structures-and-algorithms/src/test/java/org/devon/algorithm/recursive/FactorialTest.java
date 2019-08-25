/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.algorithm.recursive;

import org.devon.algorithms.recursive.Factorial;
import org.junit.Test;

/**
 * @author dewen.ye
 * @date 2019/2/17 11:13
 */
public class FactorialTest {
    Factorial factorial = new Factorial();
    @Test
    public void factorial() {
        int num= factorial.factorial(5);
        System.out.println("num:"+num);
    }

    @Test
    public void factorialAge() {
        factorial.factorialAge(5);
    }

}