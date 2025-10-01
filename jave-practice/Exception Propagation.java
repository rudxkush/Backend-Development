// throw: Used to throw an exception explicitly. used to create custom exception.
// throws: used to declare an exception. for ex: your method might throw an exception.
// propagation from method 2 to method 1 to main method if your exception is in method 2 which 
// is called in method 1 and main method is where your method1 is called.
// so, try and catch should be in main method.
public class exceptionPropagation
{
    static  void validate(int age)
    {
        if(age < 18)
        {
            throw new ArithmeticException("not valid");
        }
        else
        {
            System.out.println("eligible to vote.");
        }
    }
    public static void main(String[] args)
    {
        try
        {
            validate(30);
        }
        catch(Exception ex){}
        System.out.println("rest of the code");
    }
}
