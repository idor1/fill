package com.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        System.out.println(" (2) : " + solution(A));//2

        Arrays.stream(B).forEach(i -> System.out.print(" " + i));
        System.out.println(" (8) : " + solution(B));//8

        Arrays.stream(C).forEach(i -> System.out.print(" " + i));
        System.out.println(" (1) : " + solution(C));//1

        Arrays.stream(D).forEach(i -> System.out.print(" " + i));
        System.out.println(" (1) : " + solution(D));//1

        Arrays.stream(E).forEach(i -> System.out.print(" " + i));
        System.out.println(" (6) : " + solution(E));//6

        Arrays.stream(F).forEach(i -> System.out.print(" " + i));
        System.out.println(" (8) : " + solution(F));//3 + 4 + 1 = 8

        Arrays.stream(G).forEach(i -> System.out.print(" " + i));
        System.out.println(" (10) : " + solution(G));//3 + 4 + 3 = 10

        Arrays.stream(H).forEach(i -> System.out.print(" " + i));
        System.out.println(" (11) : " + solution(H));//11

        Arrays.stream(J).forEach(i -> System.out.print(" " + i));
        System.out.println(" (0) : " + solution(J));//0

        Arrays.stream(K).forEach(i -> System.out.print(" " + i));
        System.out.println(" (3) : " + solution(K));//3
    }


    public static int solution(int[] a) {
        List<Segment> segments = parseToSegments(a);
        return fillSergment(segments.get(0));
    }

    private static List<Segment> parseToSegments(int[] a) {
        Segment segment = new Segment();
        segment.setA(a);

        List<Segment> segments = new LinkedList<>();
        segments.add(segment);

        return segments;
    }

    private static int fillSergment(Segment segment) {
        int smallerBorder = findSmallerBorder(segment.getA());

        int volume = 0;
        for (int i : segment.getA()) {
            if (i < smallerBorder) {
                volume += smallerBorder - i;
            }
        }
        return volume;
    }

    private static int findSmallerBorder(int[] a) {
        return a[0] > a[a.length - 1] ? a[a.length - 1] : a[0];
    }

}
