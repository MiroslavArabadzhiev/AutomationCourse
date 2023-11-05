package exeptions;
//Let's see the example of Java throws clause which describes that checked exceptions can be propagated by throws keyword.
//Rule: If we are calling a method that declares an exception, we must either caught or declare the exception.
import java.io.IOException;
class Testthrows1{
        void m()throws IOException{
        throw new IOException("device error");//checked exception
    }
    void n()throws IOException{
        try{
            m();
        }catch(Exception e){System.out.println("exception handled inside n");}
    }
    void p(){
        try{
            n();
        }catch(Exception e){System.out.println("exception handled inside p");}
    }
    public static void main(String args[]){
        Testthrows1 obj=new Testthrows1();
        obj.p();
        System.out.println("normal flow...");
    }
}
