import java.util.*;

public class TopologicalSortUsingBfs {

    // Function to return a topological order of courses
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        // Step 2: Compute in-degree of each course
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0]; // course to take
            int prereq = pre[1]; // prerequisite
            graph.get(prereq).add(course); // edge: prereq -> course
            inDegree[course]++;            // course has one more prerequisite
        }

        // Step 3: Initialize queue with courses having in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        // Step 4: BFS to determine topological order
        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();      // take course ready to be taken
            topoOrder.add(node);          // add to topo order

            // Decrease in-degree of dependent courses
            for (int nbr : graph.get(node)) {
                inDegree[nbr]--;          // one prerequisite done
                if (inDegree[nbr] == 0) { // all prerequisites done
                    queue.add(nbr);       // course ready to take
                }
            }
        }

        // Step 5: Check if all courses were included
        if (topoOrder.size() != numCourses) return new int[0]; // cycle exists

        // Step 6: Convert List<Integer> to int[]
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) result[i] = topoOrder.get(i);

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

        int[] order = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order));
        // Output could be: [0,1,2,3] or [0,2,1,3]
    }
}
