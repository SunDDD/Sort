package com.algorithms.sort.merge;

import com.algorithms.sort.Example;
import com.algorithms.sort.insert.InsertionSort;
import edu.princeton.cs.algs4.StdDraw;

/**
 * @author Carlos
 * @description 归并排序
 * @Date 2019/8/17
 */

public class MergeSort extends Example {


    public static void sort(Comparable[] a) {

        //1.创建辅助函数并通过参数调用传入到递归函数中
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);

    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

        //2.如果hi<=lo，则数组元素为1，必定有序
        if (hi <= lo) {
            return;
        }

        //3.取子数组中间值为分界线
        int mid = lo + (hi - lo) / 2;

        //4.将两个子数组排序
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);

        //5.使用归并算法将两个有子序数组合并为一个有序数组
        merge(a, aux, lo, mid, hi);

    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        int i = lo;
        int j = mid + 1;
        //0. 两个有序子数组为a[lo]到a[mid]以及a[mid + 1]到a[hi]

        for (int k = lo; k <= hi; k++) {
            //1.拷贝原数组到辅助数组中
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            //2.根据规则进行归并
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    public static void drawSort(Comparable[] a) {

        Comparable[] aux = new Comparable[a.length];
        drawSort(a, aux, 0, a.length - 1);
        draw(a, StdDraw.BLACK);

    }

    private static void drawSort(Comparable[] a, Comparable[] aux, int lo, int hi) {

        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        drawSort(a, aux, lo, mid);
        drawSort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);

        draw(a, lo, hi);
        StdDraw.pause(1000);
        StdDraw.clear();

    }

    public static void draw(Comparable[] a, int lo, int hi) {

        StdDraw.setXscale(-1, a.length + 1);

        Comparable max = a[0];

        for (int k = 1; k < a.length; k++) {
            if (less(max, a[k])) {
                max = a[k];
            }
        }

        StdDraw.setYscale(-2, (Integer)max + 1);
        for (int k = 0; k < a.length; k++) {

            int y = (Integer)a[k];

            if (k >= lo && k <= hi) {
                StdDraw.setPenColor(StdDraw.BLACK);
            } else {
                StdDraw.setPenColor(StdDraw.GRAY);
            }

            StdDraw.filledRectangle(k + 0.5, y / 2.0, 0.3, y / 2.0);
        }

    }

    /**
     * 归并排序的改良
     * @param a
     */
    public static void sortImproved(Comparable[] a) {

        Comparable[] aux = new Comparable[a.length];
        sortImproved(a, aux, 0, a.length - 1);

    }

    /**
     * 归并排序的改良
     * @param a
     * @param aux
     * @param lo
     * @param hi
     */
    private static void sortImproved(Comparable[] a, Comparable[] aux, int lo, int hi) {

        if (hi <= lo + 7) {
            //1.当递归为小数组时，使用插入排序
            InsertionSort.sort(a);
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sortImproved(a, aux, lo, mid);
        sortImproved(a, aux, mid + 1, hi);

        //2.左子数组的最大值小于右子数组的最小值，则数组已经有序，不需进行归并操作。
        if (less(a[mid], a[mid + 1])) {
            return;
        }

        merge(a, aux, lo, mid, hi);

    }

    public static void sortBU(Comparable[] a) {

        int N = a.length;
        Comparable[] aux = new Comparable[N];

        for (int sz = 1; sz < N; sz += sz) {

            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(N - 1, lo + sz + sz - 1));
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = getTestData(20);
        drawSort(a);
    }

}
