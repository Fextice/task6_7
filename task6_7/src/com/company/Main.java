package com.company;
import java.util.Locale;
import java.util.Scanner;

class task6_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.ROOT);
        System.out.println("Введите x: ");
        double x = sc.nextDouble();
        if (x <= -1 || x >= 1) {
            System.err.println("Вы ввели неверное значение x.");
            System.exit(0);
        }
        System.out.println("Введите n: ");
        int n = sc.nextInt();
        System.out.println("Введите e: ");
        double e = sc.nextDouble();

        print(e, n, count(n, x, e));
    }

    public static class Solution {
        public double sumN; //1 ый член последовательности
        public double sumE;
        public int nE;
        public int nE10;
        public double sumE10;
        public double exactValue;
    }

    public static void print(double e, int n, Solution sol) {
        System.out.printf("Значение функции через метод Math: %.12f%n", sol.exactValue);
        System.out.printf("Сумма %d элементов функции: %.12f%n", n, sol.sumN);
        System.out.printf("Сумма %d элементов, по модулю больших e = %.12f: %.15f%n", sol.nE, e, sol.sumE);
        System.out.printf("Сумма %d элементов, по модулю больших e/10 = %.12f: %.15f%n", sol.nE10, e / 10, sol.sumE10);
    }

    public static Solution count(int n, double x, double e) {
        Solution sol = new Solution();
        sol.exactValue = 1 / Math.sqrt(1 + x);

        double quantity = 1;

        for (int i = 0; i <= n || Math.abs(quantity) < e / 10; i++) {
            if (i < n) {  // Находит сумму n слагаемых заданного типа.
                sol.sumN += quantity;
            }
            if (Math.abs(quantity) > e) { // Находит сумму тех слагаемых, которые по абсолютной величине больше "e"
                sol.sumE += quantity;
                sol.nE++;
            }
            if (Math.abs(quantity) > e / 10) { // Находит сумму тех слагаемых, которые по абсолютной величине больше "e/10"
                sol.sumE10 += quantity;
                sol.nE10++;
            }

            int num = 2 * i + 1;
            int den = 2 * i + 2;

            quantity = -quantity * x * num / den ;
        }


        return sol;

    }
}