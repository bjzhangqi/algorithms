package com.myproc.algorithms;

import javax.swing.*;
import java.awt.*;

public class BruteForce {
    public static void selectionSort(int[] array) {
        if (array != null) {
            if (array.length > 1) {
                for (int i = 0; i < array.length - 1; i++) {
                    int min = i;
                    for (int j = i + 1; j < array.length; j++) {
                        if (array[j] < array[min]) {
                            min = j;
                        }
                    }
                    int tmp = array[i];
                    array[i] = array[min];
                    array[min] = tmp;
                }
            }
        }
    }

    public static void bubbleSort(int[] array) {
        if (array != null) {
            if (array.length > 1) {
                for (int i = 0; i < array.length - 1; i++) {
                    for (int j = 0; j < array.length - 1 - i; j++) {
                        if (array[j] > array[j + 1]) {
                            int tmp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = tmp;
                        }
                    }
                }
            }
        }
    }

    /**
     * @param strArray1
     * @param strArray2
     * @return if strArray1 is not match strArray2, return -1
     */
    public static int stringMatch(char[] strArray1, char[] strArray2) {
        if (strArray1 != null && strArray2 != null) {
            if (strArray1.length > strArray2.length && strArray1.length > 1) {
                for (int i = 0; i <= strArray1.length - strArray2.length; i++) {
                    int j = 0;
                    while (j < strArray2.length && strArray1[i + j] == strArray2[j]) {
                        j = j + 1;
                    }
                    if (j == strArray2.length) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isConvex(Polygon polygon) {
        if (polygon.npoints == 3) {
            return true;
        }
        if (polygon.npoints > 3) {
            int pointCount = 0;
            for (int i = 0; i < polygon.npoints; i++) {
                for (int j = i + 1; j < polygon.npoints; j++) {
                    int sideA = 0;
                    int sideB = 0;
                    // ax + by = c
                    // a = y2 - y1, b = x1 - x2, c = x1y2 - y1x2
                    int a = polygon.ypoints[j] - polygon.ypoints[i];
                    int b = polygon.xpoints[i] - polygon.xpoints[j];
                    int c = polygon.xpoints[i] * polygon.ypoints[j] - polygon.ypoints[i] * polygon.xpoints[j];
                    for (int k = 0; k < polygon.npoints; k++) {
                        if (k == i || k == j) {
                            continue;
                        } else {
                            int c1 = a * polygon.xpoints[k] + b * polygon.ypoints[k];
                            if (c1 > c) {
                                sideA++;
                            } else {
                                sideB++;
                            }
                        }
                    }
                    if (sideA == polygon.npoints - 2 || sideB == polygon.npoints - 2) {
                        pointCount++;
                    }
                }
            }
            if (pointCount == polygon.npoints) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        frame.getContentPane().add(new MyPanel());
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(200,200);
//        frame.setVisible(true);
        int xpoints[] = {25, 145, 145, 80, 25};
        int ypoints[] = {25, 25, 145, 160, 145};
        int npoints = 5;
        Polygon polygon = new Polygon(xpoints, ypoints, npoints);
        System.out.println(BruteForce.isConvex(polygon));
    }

}

// ax + by = c
// a = y2 - y1, b = x1 - x2, c = x1y2 - y1x2
class Line {
    private int a;
    private int b;
    private int c;

    public Line(Point p1, Point p2) {
        this.a = p2.y - p1.y;
        this.b = p1.x = p2.x;
        this.c = p1.x * p2.y - p1.y * p2.x;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.a = y2 - y1;
        this.b = x1 - x2;
        this.c = x1 * y2 - y2 * x2;
    }
}

class MyPanel extends JPanel {
    public void paint(Graphics g) {
        int xpoints[] = {25, 145, 145, 80, 25};
        int ypoints[] = {25, 25, 145, 160, 145};
        int npoints = 5;

        g.drawPolygon(xpoints, ypoints, npoints);
    }
}
