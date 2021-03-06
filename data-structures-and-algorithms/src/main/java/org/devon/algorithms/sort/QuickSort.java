package org.devon.algorithms.sort;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018.06.15 01:16
 * @since
 */
public class QuickSort extends AbstractSort implements Sort {


    public static <T> T[] sort(T[] array, int left, int right) {
        if (array == null || left > right) {
            return null;
        }
        int position = partition(array, left, right);
        sort(array, left, position - 1);
        sort(array, position + 1, right);
        return array;
    }


    private static <T> int partition(T[] array, int left, int right) {
        int i = left - 1;
        //以最右边元素为基准点
        T key = array[right];
        //开始以基准点为标准分割序列
        for (int j = left; j < right; j++) {
            if (less(array[j], key)) {
                i++;
                exch(array, i, j);
            }
        }
        //将基准点放置到合适的位置
        exch(array, i + 1, right);
        return i + 1;
    }


    private static int selectPivot(int left,int right){
          return(left+right)/2;
    }

    private static <T> int partition2(T[] array, int left, int right) {
        //最左边元素为基准点
        T key = array[left];

        while (left < right) {
            //从最后找一个合适的值与前面的值交换
            while (left < right && less(key, array[right])) {
                right--;
            }
            exch(array, left, right);
            //从前面找一个合适的值与后面的值交换
            while (left < right && less(array[left], key)) {
                left++;
            }
            exch(array, left, right);
        }
        return left;
    }
}
