import java.util.*;
import java.io.*;
import java.math.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.System.out;
import static java.lang.System.setProperty;


public class Main {
    public static int binarySearch(int[] arr, int target) {
        int s = 0, e = arr.length - 1;
        while(s <= e) {
            int mid = (s + e) >> 1;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        out.println("Enter Size of the array: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        out.println("Enter array elements!");
        for(int i = 0; i < n; i++) {
            out.print("Enter Arr["+i+"] value: ");
            arr[i] = in.nextInt();
        }

        out.print("Enter target elements: ");
        int target = in.nextInt();

        Arrays.sort(arr);
        out.println("Sorting....");
        for(int i = 0; i < n; i++) {
            out.println("Arr["+i+"] value: "+arr[i]);
        }

        int index = binarySearch(arr, target);
        if(index == -1) {
            out.println("Not Found");
        } else {
            out.println("Found at index: " + index);
        }
        return ;
    }
}
