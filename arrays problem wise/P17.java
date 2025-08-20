import java.util.HashMap;

public class P17 {//counting frequency of elements
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 2, 3, 2, 2};
        HashMap<Integer, Integer> freq = new HashMap<>();
freq.get(10);
        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }

        for (int key : freq.keySet()) {
            System.out.println("Element " + key + " appears " + freq.get(key) + " times.");
        }
    }
}

