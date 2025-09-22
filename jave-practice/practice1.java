import java.util.*;

public class Main {
  
    private static void sumAndAverage(Scanner input) {
      int n = input.nextInt();
      int[] arr = new int[n];
      int sum = 0;
      for(int i = 0; i < n; i++) {
        arr[i] = input.nextInt();
        sum += arr[i];
      }
      int avg = sum/arr.length;
      System.out.println("Sum of all elements in the array: "+sum);
      System.out.println("Average of all elements in the array: "+avg);
    }
    
    private static int countOccurences(Scanner input) {
      int n = input.nextInt();
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) {
        arr[i] = input.nextInt();
      }
      int freqNum = 0;
      System.out.println("Enter the number: ");
      int number = input.nextInt();
      for(int i = 0; i < n; i++) {
        if(arr[i] == number) {
          freqNum++;
        }
      }
      return freqNum;
    }
    
    private static void findMinMax(Scanner input) {
      int n = input.nextInt();
      int[] arr = new int[n];
      int mini = Integer.MAX_VALUE;   
      int maxi = Integer.MIN_VALUE; 
      for(int i = 0; i < n; i++) {
        arr[i] = input.nextInt();
        if(maxi < arr[i]) {
          maxi = arr[i];
        } 
        if(mini > arr[i]) {
          mini = arr[i];
        }
      }
      System.out.println("Minimum in the array: "+mini+" and Maximum: "+maxi);
    }
    
    private static Boolean checkSortedOrNot(Scanner input) {
      int n = input.nextInt();
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) {
        arr[i] = input.nextInt();
        if(i > 0 && arr[i] < arr[i - 1]) {
          return false;
        }
      }
      return true;
    }
    
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      sumAndAverage(input);
      System.out.println("Number of occurences: "+countOccurences(input));
      findMinMax(input);
      if(checkSortedOrNot(input)) {
        System.out.println("Yes it is sorted");
      } else {
        System.out.println("nope not sorted!");
      }
      return ;
  }
}
