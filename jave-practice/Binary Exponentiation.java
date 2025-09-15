import java.util.*;
import java.io.*;
import java.math.*;

import static java.lang.Math.*;
import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    // Binary Exponentiation - O(logn)where n=power(exponent)
    public static long fastPower(int x, int power) {
        long res = 1;
        while(power > 0) {
            if((power & 1) == 1) {
                res *= x;
            }
            x = x*x;
            power >>= 1;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        out.print("Enter number: ");
        int x = input.nextInt();
        out.print("Enter power: ");
        int power = input.nextInt();
        out.println("number^power: " + fastPower(x, 3));
        return ;
    }
}
