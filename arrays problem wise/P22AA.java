public class P22AA {//anotehr apporach for not having extra space (moores voting algorithm)
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 1};
        int count = 0;
        int candidate = -1;

        // Step 1: Find candidate
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                candidate = arr[i];
            }

            if (arr[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Confirm if candidate is majority
        int freq = 0;
        for (int num : arr) {
            if (num == candidate) {
                freq++;
            }
        }

        if (freq > arr.length / 2) {
            System.out.println("The majority element is " + candidate + ", appeared " + freq + " times");
        } else {
            System.out.println("No majority element");
        }
    }
}
