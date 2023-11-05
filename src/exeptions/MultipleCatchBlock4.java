package exeptions;

//In this example, we generate NullPointerException, but didn't provide the corresponding exception type.
// In such case, the catch block containing the parent exception class Exception will invoked.
public class MultipleCatchBlock4 {
    public static void main(String[] args) {

        try{
            String s=null;
            System.out.println(s.length());
        }
        catch(ArithmeticException e)
        {
            System.out.println("Arithmetic Exception occurs");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        }
        catch(Exception e)
        {
            System.out.println("Parent Exception occurs");
        }
        System.out.println("rest of the code");
    }
}
