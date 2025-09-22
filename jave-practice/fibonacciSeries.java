import java.util.*;

public class Main {
    public static int rec(int n) {
      if(n == 1) {
        return 0;
      } 
      if(n == 2) {
        return 1;
      }
      return rec(n-1) + rec(n-2);
    }
    
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int n = input.nextInt();
      for(int i = 1; i <= n; i++) {
        System.out.print(rec(i) + " ");
      }
    }
}
