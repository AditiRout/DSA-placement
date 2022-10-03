import java.util.*;
import java.util.Scanner;

class Calculator {
    public static void sum(int a, int b) {
        System.out.println(a + b);
    }

    public static void sub(int a, int b) {
        System.out.println(a - b);
    }

    public static void mul(int a, int b) {
        System.out.println(a * b);
    }

    public static void div(int a, int b) {
        System.out.println(a / b);
    }
}

class maintest {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter value of n:");
        System.out.println(" 1 for addition");
        System.out.println("  2 for subtraction");
        System.out.println("  3 for multiplication");
        System.out.println(" 4 fir division");
        int n = sc.nextInt();
        if (n == 1) {
            int l = sc.nextInt();
            int m = sc.nextInt();
            c.sum(l, m);
        } else if (n == 2) {
            int l = sc.nextInt();
            int m = sc.nextInt();
            c.sub(l, m);

        } else if (n == 3) {
            int l = sc.nextInt();
            int m = sc.nextInt();
            c.mul(l, m);

        } else if (n == 4) {
            int l = sc.nextInt();
            int m = sc.nextInt();
            c.div(l, m);

        } else {
            System.out.println("not valid number!!!!");
        }

    }
}