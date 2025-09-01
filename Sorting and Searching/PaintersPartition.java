

public class PaintersPartition {

    // Function to check if it is possible to paint all boards
    // with 'm' painters such that no painter paints more than 'mid' units
    public static boolean isPossible(int arr[], int mid, int m){
        int painter = 1; // Start with 1 painter
        int time = 0;    // Time/units assigned to current painter

        for(int i = 0; i < arr.length; i++){
            // If adding current board to current painter doesn't exceed 'mid'
            if(time + arr[i] <= mid){
                time += arr[i]; // Assign board to current painter
            } else {
                painter++;     // Need a new painter
                time = arr[i]; // Assign current board to new painter
            }
        }

        // Return true if painters used are within limit
        return painter <= m;
    }

    public static void main(String[] args) {
        int arr[] = {10, 10, 10, 10}; // Length of boards
        int m = 2;                     // Number of painters

        int left = 0;   // Minimum possible time (max board length)
        int sum = 0;    // Total sum of all board lengths
        int ans = -1;   // Store final answer

        // Calculate total sum and max board length
        for(int num : arr){
            sum += num;
            left = Math.max(left, num); // Minimum time can't be less than largest board
        }

        // Binary search to find minimum time required
        while(left <= sum){
            int mid = left + (sum - left)/2; // Mid value as potential answer

            if(isPossible(arr, mid, m)){
                ans = mid;     // Update answer
                sum = mid - 1; // Try to find smaller possible time
            } else {
                left = mid + 1; // Need more time, move left up
            }
        }

        System.out.println(ans); // Print minimum time required
    }
}
