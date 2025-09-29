import java.util.*;
public class Main {
    public static void main(String[] args) {
    // StringBuffer: Thread-safe (synchronized), so suitable for multithreaded use.
    //               Slower than StringBuilder due to synchronization overhead.
    // StringBuilder: Not thread-safe, but faster in single-threaded scenarios.
    // Both are better than using plain String concatenation in loops, 
    // since they avoid creating many intermediate String objects.
    StringBuilder sentence = new StringBuilder("This is a sentence.");
    sentence.append(" Added word.");
    System.out.println(sentence);
    String upperText = sentence.toString().toUpperCase();
    System.out.println(upperText);
  }  
}
