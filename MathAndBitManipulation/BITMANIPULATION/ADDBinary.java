package BITMANIPULATION;

class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;    // pointer for string a (starting from last bit)
        int j = b.length() - 1;    // pointer for string b
        int carry = 0;             // to store carry (0 or 1)
        StringBuilder sb = new StringBuilder(); // for building result string

        // loop until both strings and carry are done
        while (i >= 0 || j >= 0 || carry != 0) {
            // get bits from both strings; if exhausted, take 0
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;

            // sum current bits and carry
            int sum = bitA + bitB + carry;

            // result bit (0 or 1)
            sb.append(sum % 2);

            // update carry (0 or 1)
            carry = sum / 2;

            // move to next bits
            i--;
            j--;
        }

        // reverse since we added from right to left
        return sb.reverse().toString();
    }

    // ✅ For VS Code testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.addBinary("11", "1"));      // Output: 100
        System.out.println(sol.addBinary("1010", "1011")); // Output: 10101
        System.out.println(sol.addBinary("0", "0"));       // Output: 0
    }
}

