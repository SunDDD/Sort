package com.algorithms.sort.quick;

import com.algorithms.sort.Example;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Carlos
 * @description 快速排序
 * @Date 2019/8/19
 */

public class QuickSort extends Example {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int p = partition(a, lo, hi);
        sort(a, lo, p - 1);
        sort(a, p + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                if (i >= hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j <= lo) {
                    break;
                }
            }
            if (j <= i) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

}
