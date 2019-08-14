package com.algorithms.sort.shell;

import com.algorithms.sort.Example;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * @author Carlos
 * @description 希尔排序
 * @Date 2019/8/14
 */

public class ShellSort extends Example {

    public static void sort(Comparable[] a) {

        int h = 1;
        int N = a.length;

        while (h < N / 3) {
            //h的取值为1, 4, 13, 40, 121, 364,1093...
            h = h * 3 + 1;
        }

        while (h >= 1) {

            for (int i = h; i < N; i++) {
                //将a[i]插入到a[i - h], a[i - 2 * h], a[i - 3 * h]...之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    //内层循环当h等于1时，与插入排序相同
                    exch(a, j, j - h);
                }
            }

            //每完成一次h-排序就把h变为h/3
            h = h / 3;
        }

    }

    public static void drawSort(Comparable[] a) {
        int h = 1;
        int N =a.length;
        draw(a, StdDraw.GRAY);
        StdDraw.pause(2000);
        StdDraw.clear();
        while (h < N / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
/*                    drawShell(a, j, h);
                    StdDraw.pause(500);
                    StdDraw.clear();*/
                }
            }
            Color color;
            if (h == 121) {
                 color = StdDraw.RED;
            } else if (h == 40) {
                color = StdDraw.BLUE;
            } else if (h == 13) {
                color = StdDraw.PINK;
            } else if (h == 4) {
                color = StdDraw.GREEN;
            } else {
                color = StdDraw.BLACK;
            }
            draw(a, color);
            StdDraw.pause(500);
            StdDraw.clear();
            h = h / 3;
        }
        draw(a, StdDraw.BLACK);

    }


    public static void main(String[] args) {

        Integer[] a = getTestData(150);
        drawSort(a);

    }

}
