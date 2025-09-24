import java.util.*;

public class Main {
    private static Boolean validPalindrome(String str, int i, int j) {
      if(i >= j){
        return true;
      }
      
      if(str.charAt(i) != str.charAt(j)) {
        return false;
      } else {
        return validPalindrome(str, i+1, j-1);
      }
    }
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String str = input.nextLine();
      int n = str.length();
      if(validPalindrome(str, 0, n-1)) {
        System.out.println("Valid palindrome!");
      } else {
        System.out.println("Not a palindrome");
      }
  }
}
