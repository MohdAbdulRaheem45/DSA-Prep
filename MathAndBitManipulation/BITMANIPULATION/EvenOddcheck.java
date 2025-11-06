package BITMANIPULATION;


public class EvenOddcheck {
    public static void main(String[] args) {
       
      
        int n=7;

        if ((n & 1) == 1)
            System.out.println(n + " is Odd");
        else
            System.out.println(n + " is Even");

        
    }
}

