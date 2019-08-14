package com.algorithms.sort;

import com.algorithms.sort.shell.ShellSort;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

/**
 * @author Carlos
 * @description 排序算法的模板，所有排序类都继承此类
 * @Date 2019/8/12
 */

public class Example {

    /**
     * 所有被排序的数组须实现Comparable接口
     * @param a 被排序的类
     */
    public static void sort(Comparable[] a) {

    }

    /**
     * 判断 v 是否小于 w 如果是返回true,否则返回false;
     * v , w 均为实现Comparable接口的对象
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组Comparable[] a中i, j位置的数据
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 判断数组a是否有序
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {

        if (a.length == 0) {
            throw new RuntimeException("无数据.");
        } else if (a.length == 1) {
            return true;
        } else {

            int N = a.length;

            for (int i = 1; i < N; i++) {
                if (less(a[i], a[i - 1])) {
                    return false;
                }
            }

            return true;
        }

    }

    /**
     * 将数组打印出来，两个元素之间以空格隔开
     * @param a
     */
    public static void show(Comparable[] a ) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 使用algs4.jar包中的StdDraw标准画图实现可视化
     * @param a
     */
    public static void draw(Comparable[] a, Color color) {

        //1.设置x轴长度
        StdDraw.setXscale(-1, a.length + 1);

        //2.找出最大的元素并设为y轴高度
        Comparable max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (less(max, a[i])) {
                max = a[i];
            }
        }
        StdDraw.setYscale(-2, (Integer)max + 1);

        //3.设置图形颜色
        StdDraw.setPenColor(color);

        //4.把每个元素的大小转换成矩形的高度并展示出来
        for (int i = 0 ; i < a.length; i++) {
            int y = (Integer)a[i];
            StdDraw.filledRectangle(i + 0.5, y / 2.0, 0.3, y / 2.0);
        }

    }

    /**
     * 把被交换的两个元素改为红色，如果与自己交换，则变为粉色
     * @param a
     * @param v
     * @param w
     */
    public static void draw(Comparable[] a, int v, int w) {
        StdDraw.setXscale(-1, a.length + 1);

        Comparable max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (less(max, a[i])) {
                max = a[i];
            }
        }
        StdDraw.setYscale(-2, (Integer)max + 1);

        for (int i = 0 ; i < a.length; i++) {
            int y = (Integer)a[i];

            if (i == v || i == w) {
                if (v == w){
                    StdDraw.setPenColor(StdDraw.PINK);
                } else {
                    StdDraw.setPenColor(StdDraw.RED);
                }
            } else {
                StdDraw.setPenColor(StdDraw.GRAY);
            }

            StdDraw.filledRectangle(i + 0.5, y / 2.0, 0.3, y / 2.0);
        }
    }

    /**
     * 获取一个Integer[] ，该数组是由0~100的数字通过打乱顺序获得的，改函数提供了一个测试数据
     * @param N 数组的大小
     * @return  Integer[]数组
     */
    public static Integer[] getTestData(int N) {
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
        //StdRandom.shuffle()函数实现打乱顺序.
        StdRandom.shuffle(a);
        return a;
    }

    public static void main(String[] args) {

        //1.获取实验数据
        Integer[] a = getTestData(100);

        //2.排序算法
        //2.1选择排序
//        SelectionSort.sort(a);
        //2.2插入排序
//        InsertionSort.sort(a);
        //2.3希尔排序
        ShellSort.drawSort(a);

        //3.验证是否已经有序
        System.out.println(isSorted(a));

        //4.可视化
        draw(a, StdDraw.GRAY);


    }

}
