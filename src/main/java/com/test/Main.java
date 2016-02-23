package com.test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] A = {3, 2, 4, 1, 2};

        int[] B = {4, 1, 1, 0, 2, 3};

        int[] C = {3, 2, 4};

        int[] D = {3, 2, 2, 1, 2};

        int[] E = {4, 1, 3, 0, 2, 3};

        int[] F = {3, 1, 4, 0, 4, 1, 2};

        int[] G = {4, 1, 4, 0, 4, 1, 5};

        int[] H = {4, 1, 4, 0, 4, 1, 5, 0, 1};

        int[] J = {4, 3, 2, 2, 1, 1, 0};

        int[] K = {4, 3, 2, 1, 3, 1, 0};

        Arrays.stream(A).forEach(i -> System.out.print(" " + i));
        System.out.println(" (2) : " + count(A));//2

        Arrays.stream(B).forEach(i -> System.out.print(" " + i));
        System.out.println(" (8) : " + count(B));//8

        Arrays.stream(C).forEach(i -> System.out.print(" " + i));
        System.out.println(" (1) : " + count(C));//1

        Arrays.stream(D).forEach(i -> System.out.print(" " + i));
        System.out.println(" (1) : " + count(D));//1

        Arrays.stream(E).forEach(i -> System.out.print(" " + i));
        System.out.println(" (6) : " + count(E));//6

        Arrays.stream(F).forEach(i -> System.out.print(" " + i));
        System.out.println(" (7) : " + count(F));//2 + 4 + 1 = 7

        Arrays.stream(G).forEach(i -> System.out.print(" " + i));
        System.out.println(" (10) : " + count(G));//3 + 4 + 3 = 10

        Arrays.stream(H).forEach(i -> System.out.print(" " + i));
        System.out.println(" (11) : " + count(H));//11

        Arrays.stream(J).forEach(i -> System.out.print(" " + i));
        System.out.println(" (0) : " + count(J));//0

        Arrays.stream(K).forEach(i -> System.out.print(" " + i));
        System.out.println(" (3) : " + count(K));//3
    }


    public static int count(int[] a) {
        int smallerBorder = a[0];
        int volume = 0;
        if (a[0] > a[a.length - 1]) {
            smallerBorder = a[a.length - 1];
            for (int i = a.length - 1; i >= 0; i--) {
                if (a[i] <= smallerBorder) {
                    volume += smallerBorder - a[i];
                } else {
                    volume += count(Arrays.copyOfRange(a, 0, i + 1));
                    break;
                }
            }
        } else {
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= smallerBorder) {
                    volume += smallerBorder - a[i];
                } else {
                    volume += count(Arrays.copyOfRange(a, i, a.length));
                    break;
                }
            }
        }

        return volume;
    }
}
