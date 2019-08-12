package com.algorithms.sort.selection;

import com.algorithms.sort.example.Example;

/**
 * @author Carlos
 * @description 选择排序
 * @Date 2019/8/12
 */

public class SelectionSort extends Example {

    public static void sort(Comparable[] a) {
        /*将a[]按升序排列*/
        int N = a.length; //数组长度
        for (int i = 0; i < N; i++) {
            /*将a[i]和a[i + 1] ~ a[N - 1]中最小的元素交换 */
            int min = i;  //最小元素索引
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, min ,i);
        }
    }

}
