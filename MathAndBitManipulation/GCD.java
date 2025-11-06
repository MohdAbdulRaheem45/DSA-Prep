class MathUtils {
    
    // Function to find GCD using Euclidean algorithm
    public static int gcd(int a, int b) {
        // Base case: when b becomes 0, a is the GCD
        while (b != 0) {
            int temp = b;
            b = a % b; // remainder becomes the new b
            a = temp;  // old b becomes the new a
        }
        return a; // GCD found
    }

    // Function to find LCM using the relation: LCM(a, b) * GCD(a, b) = a * b
    public static int lcm(int a, int b) {
        // To avoid overflow, divide before multiply
        return (a / gcd(a, b)) * b;
    }

    // Example usage
    public static void main(String[] args) {
        int a = 12, b = 18;

        System.out.println("GCD of " + a + " and " + b + " = " + gcd(a, b));
        System.out.println("LCM of " + a + " and " + b + " = " + lcm(a, b));
    }
}
