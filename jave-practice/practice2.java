import java.util.*;

public class Main {
    private static int[] deleteElement(int[] arr, int numberToBeDeleted) {
      int frequency = 0;
      int n = arr.length;
      for(int i = 0; i < n; i++) {
        if(numberToBeDeleted == arr[i]) {
          frequency++;
        }
      }
      int m = n - frequency;
      int[] updatedArr = new int[m];
      int j = 0;
      for(int i = 0; i < n; i++) {
        if(arr[i] == numberToBeDeleted) continue;
        updatedArr[j] = arr[i];
        j++;
      }
      return updatedArr;
    }
    private static void displayArry(int[] arr) {
      int p = arr.length;
      for(int i = 0; i < p; i++) {
        System.out.println("element at i:"+i+": "+arr[i]);
      }
    }
    
    private static void reverseArray(int[] arr) {
      int i = 0, j = arr.length - 1;
      while(i < j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }
    
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int n = input.nextInt();
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) {
        arr[i] = input.nextInt();
      }
      System.out.println("Original Array: ");
      displayArry(arr);
      System.out.println("Enter the number to be deleted: ");
      int numberToBeDeleted = input.nextInt();
      System.out.println("Number Entered: "+numberToBeDeleted);
      int[] result = deleteElement(arr, numberToBeDeleted);
      System.out.println("Updated Array: ");
      displayArry(result);
      
      int m = input.nextInt();
      int[] nums = new int[m];
      for(int i = 0; i < m; i++) {
        nums[i] = input.nextInt();
      }
      System.out.println("Original Array: ");
      displayArry(nums);
      reverseArray(nums);
      System.out.println("Updated Array: ");
      displayArry(nums);
      
      return ;
  }
}
