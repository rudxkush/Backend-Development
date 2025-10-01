// To handle runtime errors:
// try: contains code that might generate an exception
// catch: handles the exception thrown in the try block
// finally: always gets executed, whether an exception occurs or not
// We can have multiple try-catch blocks, but only one finally block per try.
public class handlingException
{

    public static void main(String[] args)
    {
         int x, y;
         x = 50;
         y = 0;
         //  Either declare catch or finally or both with try
         try {
             int z = x/y;  //   In-definite value
         } catch(ArithmeticException ex) {
             System.out.println("Exception is: "+ex);  //   ex: ex is an object
         } finally {
             System.out.println("finally block");
         }
    
         /****************
            code block
          ****************/
         
         System.out.println("Random Statement");
    }
}
