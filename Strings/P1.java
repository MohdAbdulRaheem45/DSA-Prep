public class P1 {//reverse a string
    

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        int left = 0, right = s.length - 1;

        // Swap until both pointers meet
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }

        // Print reversed string
        System.out.print("Reversed: ");
        for (char c : s) {
            System.out.print(c);
        }
    }
}
