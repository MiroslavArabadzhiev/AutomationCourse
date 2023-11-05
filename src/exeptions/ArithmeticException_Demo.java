package exeptions;

class ArithmeticException_Demo
{
    public static void main(String args[])
    {
        try {
            int a = 30, b = 2;
            int c = a/b; // cannot divide by zero
            System.out.println ("Result = " + c);
        }
        catch(ArithmeticException e) {
            System.out.println ("Can't divide a number by 0");
        }
        finally {
            System.out.println("I am in final block");
        }
    }
}