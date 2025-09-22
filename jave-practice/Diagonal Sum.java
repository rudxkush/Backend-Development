import java.util.*;

public class Main {
    private static int diagonalArraySum(int[][] mat, int n) {
      int sum = 0;
      for(int i = 0; i < n; i++) {
        sum += mat[i][i];         
        sum += mat[i][n - i - 1];
      }
      
      if(n%2 == 0) {
        return sum;
      }
      else {
        int centerIndex = n/2;
        sum -= mat[centerIndex][centerIndex];
        return sum;
      }
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
      
      int res = diagonalArraySum(mat, n);
      System.out.println(res);
      return ;
  }
}
