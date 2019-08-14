package com.algorithms.sort.insert;

import com.algorithms.sort.Example;
import edu.princeton.cs.algs4.StdDraw;

/**
 * @author Carlos
 * @description 插入排序
 * @Date 2019/8/14
 */

public class InsertionSort extends Example {
    
    public static void sort(Comparable[] a) {
        
        int N = a.length;
        for (int i = 1; i < N; i++) {
            
            for (int j = i; j >=1 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
            
        }
        
    }

    public static void drawInsertion(Comparable[] a, int v, int n) {
        StdDraw.setXscale(-1, a.length + 1);

        Comparable max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (less(max, a[i])) {
                max = a[i];
            }
        }
        StdDraw.setYscale(-2, (Integer)max + 1);



        for (int i = 0; i < a.length; i++) {
            int y = (Integer)a[i];

            if (i == v) {
                StdDraw.setPenColor(StdDraw.RED);
            } else if(i > n) {
                StdDraw.setPenColor(StdDraw.GRAY);
            } else {
                StdDraw.setPenColor(StdDraw.BLACK);
            }

            StdDraw.filledRectangle(i + 0.5, y / 2.0, 0.3, y / 2.0);
        }
    }

    public static void drawSort(Comparable[] a) {
        int N = a.length;

        draw(a, StdDraw.GRAY);
        StdDraw.pause(2000);

        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                drawInsertion(a, j, i);
                StdDraw.pause(400);
                StdDraw.clear();
                exch(a, j, j - 1);
            }
        }
        draw(a, StdDraw.BLACK);

    }

    public static void main(String[] args) {
        Integer[] a = getTestData(20);
        drawSort(a);

    }
}
