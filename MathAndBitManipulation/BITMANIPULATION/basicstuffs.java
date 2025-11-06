package BITMANIPULATION;


    public class basicstuffs {
    public static void main(String[] args) {
        int a = 5; // 0101
        int b = 3; // 0011

        System.out.println("a & b = " + (a & b));  // AND → 0001 = 1
        System.out.println("a | b = " + (a | b));  // OR  → 0111 = 7
        System.out.println("a ^ b = " + (a ^ b));  // XOR → 0110 = 6
        System.out.println("~a = " + (~a));        // NOT → flips bits = -6
        System.out.println("a << 1 = " + (a << 1)); // Left shift (×2) → 10
        System.out.println("a >> 1 = " + (a >> 1)); // Right shift (÷2) → 2
    }
}


