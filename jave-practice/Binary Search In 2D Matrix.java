import java.util.*;

public class Main {
    private static int[] binarySearch(int[][] mat, int n, int target) {
      int i = 0, j = n*n - 1;
      while(i <= j) {
        int mid = (i + j) >> 1;
        int row = mid / n;
        int col = mid % n;
        if(mat[row][col] == target) {
          return new int[]{row, col};
        } else if(mat[row][col] > target) {
          j = mid - 1;
        } else {
          i = mid + 1;
        }
      }
      return new int[]{-1, - 1};
    }
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      System.out.println("Enter size: ");
      int n = input.nextInt();
      int[][] mat = new int[n][n];
      
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
          mat[i][j] = input.nextInt();
        }
      }
      
      int target = input.nextInt();
      
      int[] res = binarySearch(mat, n, target);
      if(res[0] == -1) {
        System.out.println("Not Found");
      } else {
        System.out.println("Found at i: " + res[0] + ", j: " + res[1]);
      }
      return ;
  }
}
