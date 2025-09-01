import java.util.Arrays;

public class MinimumPlatforms {

    // Function to calculate minimum platforms needed
    public static int findMinPlatforms(int[] arrivals, int[] departures) {
        // Step 1: Sort both arrival and departure arrays
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int n = arrivals.length;
        int platformsNeeded = 0; // current platforms needed at this moment
        int maxPlatforms = 0;    // maximum platforms required at any point
        int i = 0, j = 0;        // pointers for arrivals and departures

        // Step 2: Iterate through all events
        while (i < n && j < n) {
            if (arrivals[i] <= departures[j]) {
                // New train arrives before previous one departs → need a platform
                platformsNeeded++;
                maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
                i++; // move to next arrival
            } else {
                // A train departs → free a platform
                platformsNeeded--;
                j++; // move to next departure
            }
        }

        return maxPlatforms;
    }

    public static void main(String[] args) {
        int[] arrivals   = {900, 940, 950, 1100, 1500, 1800};
        int[] departures = {910, 1120, 1130, 1200, 1900, 2000};

        int result = findMinPlatforms(arrivals, departures);
        System.out.println("Minimum platforms required = " + result);
    }
}
