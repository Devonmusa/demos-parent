package com.algorithm.demo.search;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/4 23:31
 * @since 1.0.0
 */
public class BinaerySearch {


    /**
     * 1.验空
     * 2.定义左右边界数下标（）
     * 3.求中位数下标
     * 4.比较大小移动左右边界下标
     * 5.循环步骤3，4
     * 6.返回结果下标
     *
     * @param array
     * @param key
     * @return
     */
    public static int rank(int[] array, int key) {
        if (array == null) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (key < array[mid]) {
                right = mid-1;
            } else if (key > array[mid]) {
                left = mid+1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}