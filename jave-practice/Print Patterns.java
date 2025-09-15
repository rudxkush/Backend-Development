import java.util.*;
import java.io.*;
import java.math.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.System.out;


public class Main {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < i + 1; j++) {
                out.print('*');
            }
            out.println();
        }
        out.println();
        for(int i = 0; i < 5; i++) {
            for(int j = 5 - i; j > 0; j--) {
                out.print('*');
            }
            out.println();
        }
        out.println();
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                out.print("*");
            }
            out.println();
        }

        return ;
    }
}
