public class Basic {
    public static void main(String[] args) {
        // String Declaration
        String str = "Hello, World!";

        // Immutability
        String str2 = str.replace("World", "Java");
        System.out.println("Original: " + str); // "Hello, World!"
        System.out.println("Modified: " + str2); // "Hello, Java!"

        // Length of String
        System.out.println("Length: " + str.length());

        // Character at index
        System.out.println("Char at 1: " + str.charAt(1));

        // Substring
        System.out.println("Substring (0,5): " + str.substring(0, 5));

        // String Comparison
        String str3 = "hello, world!";
        System.out.println("Equals: " + str.equals(str3)); // false
        System.out.println("Equals Ignore Case: " + str.equalsIgnoreCase(str3)); // true

        // Lexicographical Comparison
        System.out.println("CompareTo: " + str.compareTo(str3));

        // Convert to char array
        char[] chars = str.toCharArray();
        System.out.println("First char: " + chars[0]);

        // Split string
        String[] parts = str.split(", ");
        System.out.println("Split: " + parts[0] + " and " + parts[1]);

        // StringBuilder for mutable strings
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" Java");
        System.out.println("StringBuilder: " + sb.toString());

        // Conversion
        int num = Integer.parseInt("123");
        String numStr = String.valueOf(456);
        System.out.println("Parsed int: " + num + ", String value: " + numStr);
    }
}
