package exeptions;
//Case 2: Declare Exception
//        In case we declare the exception and the exception occurs, it will be thrown at runtime because throws does not handle the exception
import java.io.*;
class M2{
    void method()throws IOException{
        throw new IOException("device error");
    }
}
class Testthrows4{
    public static void main(String args[])throws IOException{//declare exception
        M2 m=new M2();
        m.method();

        System.out.println("normal flow...");
    }
}