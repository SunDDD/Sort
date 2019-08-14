package com.algorithms.sort.selection;

import com.algorithms.sort.Example;
import edu.princeton.cs.algs4.StdDraw;

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

    public static void drawSort(Comparable[] a) {
        int N = a.length;
        draw(a, StdDraw.GRAY);
        StdDraw.pause(2000);
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            draw(a, min, i);
            StdDraw.pause(400);
            StdDraw.clear();
            exch(a, min ,i);

        }
        draw(a, StdDraw.GRAY);
    }


    public static void main(String[] args) {

        Integer[] a = Example.getTestData(20);
        SelectionSort.sort(a);

    }

}
