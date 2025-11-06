package BITMANIPULATION;

public class SwappingUsingXor {
    public static void main(String[] args) {
        int a=7;
        int b=4;
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("a="+a+",b="+b);

    }
}
