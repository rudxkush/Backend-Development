import java.util.*;

public class Main {
    private static void mergeArr1And2(int[] arr1, int[] arr2) {
      int n = arr1.length ;
      int m =  arr2.length;
      int p = n + m;
      int[] res = new int[p];
      
      int i = 0, j = 0, k = 0;
      while(i < n && j < m) {
        if(arr1[i] <= arr2[j]) {
          res[k++] = arr1[i++];
        } else {
          res[k++] = arr2[j++];
        }
      }
      
      while(i < n) {
        res[k++] = arr1[i++];
      }
      
      while(j < m) {
        res[k++] = arr2[j++];
      }
      
      for(int r = 0; r < p; r++) {
        System.out.print(res[r]+" ");
      }
    }
    
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      System.out.println("Enter size1: ");
      int n = input.nextInt();
      int[] arr1 = new int[n];
      System.out.println("Enter elements for arr1: ");
      for(int i = 0; i < n; i++) {
        arr1[i] = input.nextInt();
      }
      
      System.out.println("Enter size2: ");
      int m = input.nextInt();
      int[] arr2 = new int[m];
      System.out.println("Enter elements for arr2: ");
      for(int i = 0; i < m; i++) {
        arr2[i] = input.nextInt();
      }
      
      System.out.println("Sorted Array: ");
      mergeArr1And2(arr1, arr2);
      return ;
  }
}
