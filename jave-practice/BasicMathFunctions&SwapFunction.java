import java.util.*;
import java.io.*;
import java.math.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.System.out;

public class Main {
    static class typeIn{
        int a, b;
        typeIn(int a, int b) {
            this.a = a;
            this.b = b;
        }
        int getA() {
            return a;
        }
        int getB() {
            return b;
        }
    };
    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        out.println("a: "+a+", b: "+b);
    }
    static void swapObj(typeIn obj) {
        int temp = obj.a;
        obj.a = obj.b;
        obj.b = temp;
    }
    static int LCM(int num1, int num2) {
        int i = 1;
        while (true) {
            int factor = num1 * i;
            if(factor % num2 == 0) {
                return factor;
            }
            i++;
        }
    }

    static int GCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }


    public static void main(String[] args) {
        // Swap
        typeIn obj = new typeIn(5, 6);
        Scanner in = new Scanner(System.in);
        int a = 5, b = 6;
        out.println("a: "+a+", b: "+b);
        // pass by value
        // swap(a, b);
        // pass by value(obj is passed)
        swapObj(obj);
        out.println("a: "+obj.getA()+", b: "+obj.getB());

        // Odd or Even
        out.println("Enter a number: ");
        int x = in.nextInt();
        out.println("Entered number is: ");
        int ans = x & 1;
        if(ans == 1) {
            out.println("Odd");
        } else {
            out.println("Even");
        }

        // LCM
        out.println("Enter two number: ");
        int num1 = in.nextInt();
        int num2 = in.nextInt();

        out.println(LCM(num1, num2));

        // GCD
        out.println(GCD(num1, num2));
    }
}
