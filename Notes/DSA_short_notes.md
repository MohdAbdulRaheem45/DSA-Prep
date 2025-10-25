**📘 Introduction to DSA (Notes)**

**🔹 What is DSA?**

-   **Data Structures** → Ways of organizing and storing data
    efficiently.

    -   Examples: Arrays, Linked List, Stack, Queue, HashMap, Trees,
        Graphs.

-   **Algorithms** → Step‑by‑step methods to solve problems using data
    structures.

    -   Examples: Sorting, Searching, Dynamic Programming, Greedy.

Together, **DSA = Data Structures + Algorithms** → backbone of problem
solving and placements.

**🔹 Why is DSA Important?**

-   Improves **problem solving & logic**.

-   Most companies test **DSA in coding rounds** (service + product
    based).

-   Helps you crack **aptitude style problems in technical way**.

-   Builds strong foundation for **AI/ML, Web Dev, System Design**
    later.

**🔹 Core Topics of DSA (Placement Focus)**

1.  **Arrays & Strings** → Basics, sliding window, hashing, prefix sum.

2.  **Hashing (HashMap/HashSet)** → frequency, duplicate, subarray
    problems.

3.  **Two Pointers / Sliding Window** → subarrays, pairs, optimization.

4.  **Recursion & Backtracking** → DFS, generating subsets,
    permutations.

5.  **Linked List** → reversing, cycle detection, merge lists.

6.  **Stacks & Queues** → next greater element, LRU cache, sliding
    window max.

7.  **Binary Search** → on arrays, search in rotated arrays, sqrt(x).

8.  **Sorting & Greedy** → interval scheduling, activity selection.

9.  **Binary Trees / BST** → traversals, lowest common ancestor.

10. **Heaps & Priority Queue** → top k elements, heap sort.

11. **Graphs** → BFS, DFS, shortest path (Dijkstra, BFS).

12. **Dynamic Programming (DP)** → knapsack, longest subsequence, etc.

**🔹 How to Approach DSA Problems**

1.  **Identify the pattern** → (two pointers? sliding window? hashmap?).

2.  **Think brute force** → then optimize.

3.  **Write logic in English first** → then code.

4.  **Dry run with small examples**.

5.  **Analyze time & space complexity**.

**🔹 Time Complexity (Big‑O Basics)**

-   **O(1)** → Constant (direct access).

-   **O(log n)** → Divide & conquer (binary search).

-   **O(n)** → Single loop through array.

-   **O(n log n)** → Sorting, divide & conquer merges.

-   **O(n²)** → Nested loops (brute force).

-   **O(2\^n), O(n!)** → Recursion, backtracking.

👉 Always try to go from **O(n² → O(n log n) → O(n)**.

**🔹 Space Complexity**

-   Measures **extra memory used**.

-   Example: Prefix sum uses O(n) extra space; Kadane's uses O(1).

-   Interviewers sometimes ask to **optimize space** (Set Matrix Zeroes
    problem, etc.).

**🔹 Placement Strategy with DSA**

1.  Finish **Arrays + Strings** (base).

2.  Move to **Hashing, Two Pointers, Sliding Window**.

3.  Do **Linked List, Stack, Queue**.

4.  Practice **Binary Search, Trees, DP** basics.

5.  Keep revising patterns.

6.  Solve \~200--250 quality problems before placements.

DSA:Arrays

**1. Sliding Window 🪟**

👉 Used when dealing with **contiguous subarrays** (fixed or variable
size).

-   Grow/shrink window to track sum, max, or count.

-   **Key:** Keep track of windowSum or currSum.

-   Problems:

    -   **P1. Max Sum Subarray of Size K** → Fixed window, update max.

    -   **P5 & P38. Kadane's Algorithm** → Dynamic window, reset sum if
        \< 0.

    -   **P9. Longest Subarray with Sum K (positive nums)** → Two
        pointers expand/shrink.

**2. Prefix Sum / Hashing ➕**

👉 Precompute sums or XORs to answer subarray queries fast.

-   Formula: prefix\[i\] = prefix\[i-1\] + arr\[i\]

-   With HashMap, store seen sums to detect subarray existence/length.

-   Problems:

    -   **P2. Prefix Sum Query** → Quick subarray sum in O(1).

    -   **P9. Count Subarrays with Sum K** → Map for (sum-k).

    -   **P12. Longest Subarray with Sum K** → Track earliest sum index.

    -   **P20. Count Subarrays with Given XOR** → Same with XOR.

**3. Two Pointers 👯**

👉 Move two indices (left, right) to process elements in one pass.

-   Common in sorted arrays, removing/rotating, rearranging.

-   Problems:

    -   **P3. Two Sum (sorted array)** → left+right approach.

    -   **P4. Move Zeroes** → place non‑zeros, then fill rest with
        zeros.

    -   **P6. Check if Sorted** → compare consecutive.

    -   **P7. Remove Duplicates** → slow/fast pointer.

    -   **P8. Rotate Array by K (Reverse method)** → reverse 3 times.

    -   **P13. Rotate by 1** → shift elements.

    -   **P19. Max Product of Two Elements** → track top 2.

    -   **P23. Second Largest** → track top 2.

    -   **P24. Second Smallest** → track bottom 2.

**4. HashMap / HashSet 🗂️**

👉 When you need **frequency, duplicates, or fast existence check**.

-   HashMap → element → count/index.

-   HashSet → check membership in O(1).

-   Problems:

    -   **P16. Arrays Equal** → frequency check.

    -   **P17. Frequency of Elements** → build map.

    -   **P18. Find Duplicates** → map or marking.

    -   **P21. Longest Consecutive Sequence** → use set to expand.

    -   **P22. Majority Element** → HashMap count \> n/2.

**5. Sorting / Greedy 📊**

👉 Simplify by ordering or picking extremes.

-   Problems:

    -   **P14. Missing Number** → sum formula or XOR trick.

    -   **P15. Single Number** → XOR all.

    -   **P25. Rearrange Array by Sign** → alternate
        positives/negatives.

    -   **P26. Move Negatives to One Side** → stable partition.

    -   **P28. Sort 0s,1s,2s (Dutch Flag)** → 3 pointers for each zone.

**6. Leaders / Special Observations 👑**

👉 Problems that rely on scanning with a **running condition**.

-   **P11. Leaders in Array** → Scan from right, track max so far.

**7. Matrix Problems (2D Arrays) 🟦**

👉 Treat as boundaries or use transpose/rotation.

-   Problems:

    -   **P29. Set Matrix Zeroes** → mark first row/col, then update.

    -   **P30. Spiral Traversal** → top, bottom, left, right boundaries.

    -   **P31. Transpose** → swap a\[i\]\[j\] with a\[j\]\[i\].

    -   **P32. Rotate 90°** → transpose + reverse rows/cols.

    -   **P33. Search in Sorted Matrix** → binary search or top‑right
        walk.

    -   **P34. Pascal's Triangle** → DP relation.

**8. Advanced / Mixed ⚡**

👉 Trickier problems combining multiple ideas.

-   **P35. Pascal's Triangle II** → row wise calculation.

-   **P36. Trapping Rain Water** → prefix max + suffix max arrays or 2
    pointers.

-   **P37. Max Consecutive 1s** → scan & reset counter.

Strings:

### 🔹 What are Strings?

-   A **string** = sequence of characters.

-   In coding, treated like an **array of chars** but with extra
    utilities (Java: String, Python: str, C++: string).

-   Used in text processing, parsing, searching, data encoding, and
    interview problems.

👉 Common **operations/patterns**:

-   **Two pointers** → palindromes, reversing.

-   **HashMap / HashSet** → anagrams, frequency.

-   **Stack** → valid parentheses.

-   **Sliding window** → substrings with conditions.

-   **DP** → palindromes, decoding, complex string matching.

-   **Parsing** → convert string ↔ integer, Roman numerals, etc.

## 🔑 Categorization (Placement Priority)

### 🟢 **Must Do (High Frequency)**

-   **P43. Reverse String** → Two pointers swap.

-   **P44. Valid Palindrome** → Clean string, check two pointers.

-   **P45. Valid Anagram** → Count chars (array/map).

-   **P47. Valid Parentheses** → Stack push/pop.

-   **P49. Group Anagrams** → Sort string / frequency map key.

-   **P50. Longest Palindromic Substring** → Expand around center
    (O(n²)).

-   **P54. Longest Common Prefix** → Compare all words char by char.

-   **P59. Longest Substring Without Repeating Characters** → Sliding
    window + set/map.

-   **P67. Minimum Window Substring** → Sliding window + HashMap.

### 🟡 **Medium Must (Seen Often)**

-   **P46. Valid Anagram (HashMap)** → alternate method.

-   **P48. Implement strStr()** → Brute force or sliding window.

-   **P51. String to Integer (atoi)** → parsing + edge cases.

-   **P52. Integer to Roman** → map values, subtract.

-   **P53. Roman to Integer** → reverse mapping logic.

-   **P56. Is Subsequence** → Two pointers.

-   **P57. Length of Last Word** → Reverse scan.

-   **P58. Zigzag Conversion** → simulation.

-   **P60. Add Binary** → simulate binary addition.

-   **P69. Valid Palindrome II** → skip one mismatch check.

-   **P70. Decode Ways** → DP on digits.

### 🔴 **Optional / Low Priority**

-   **P55. Count and Say** → simulation.

-   **P61--P65 (basic easy)** → vowels, words, spaces, reverse words.

-   **P66. Multiply Strings** → manual multiplication.

-   **P68. Repeated Substring Pattern** → string trick or KMP.

-   **P71. Scramble String** → recursion + memoization (hard, rarely
    asked).

## ⚡ Approaches & Patterns

### 1. **Two Pointers**

-   Compare/start from ends.

-   Problems: Reverse String, Valid Palindrome, Valid Palindrome II, Is
    Subsequence.

### 2. **HashMap / HashSet**

-   Count frequency or track characters.

-   Problems: Valid Anagram, Group Anagrams, Longest Substring w/o
    Repeating, Minimum Window Substring.

### 3. **Stack**

-   Balanced expressions, parentheses.

-   Problem: Valid Parentheses.

### 4. **Sliding Window**

-   Maintain window of unique/relevant chars.

-   Problems: Longest Substring w/o Repeating, Minimum Window Substring.

### 5. **Parsing / Conversion**

-   Convert between formats.

-   Problems: atoi, Integer↔Roman, Add Binary.

### 6. **DP (Dynamic Programming)**

-   Store sub-results for overlapping subproblems.

-   Problems: Longest Palindromic Substring, Decode Ways, Scramble
    String.

## 📝 How to Revise String Problems

1.  **Read the statement** → recall pattern (2 pointers? sliding window?
    DP?).

2.  **Explain logic in 3--4 steps** (on paper if needed).

3.  **Dry run small example** to check recall.

4.  **Look at old code only if stuck.**

5.  **Mark tough ones** (🔴) → recheck on last day

# 🔍 Searching & Sorting in DSA  

This section covers the most important *Searching* and *Sorting* algorithms in Data Structures & Algorithms, along with the problems I solved for practice.  

---

## 📘 Introduction  

### 🔎 Searching
Searching is the process of finding an element inside a data structure.  

| Algorithm       | Best Case | Worst Case | Space |
|-----------------|-----------|------------|-------|
| Linear Search   | O(1)      | O(n)       | O(1) |
| Binary Search   | O(1)      | O(log n)   | O(1) |

---

### 🔄 Sorting  
Sorting arranges data in ascending or descending order.  

| Algorithm       | Best Case | Worst Case | Average | Space |
|-----------------|-----------|------------|---------|-------|
| Bubble Sort     | O(n)      | O(n²)      | O(n²)  | O(1) |
| Selection Sort  | O(n²)     | O(n²)      | O(n²)  | O(1) |
| Insertion Sort  | O(n)      | O(n²)      | O(n²)  | O(1) |
| Merge Sort      | O(n log n)| O(n log n) | O(n log n) | O(n) |
| Quick Sort      | O(n log n)| O(n²)      | O(n log n) | O(log n) |
| Counting Sort   | O(n+k)    | O(n+k)     | O(n+k) | O(n+k) |

---

## 📝 Problem List  

Here are the problems I solved in *Searching & Sorting* (with short descriptions):  

### 🔹 Sorting Algorithms
- *BubbleSort.java* → Simple comparison-based sort.  
- *SelectionSort.java* → Selects minimum and places at correct position.  
- *InsertionSort.java* → Inserts elements one by one into the correct position.  
- *MergeSort.java* → Divide & Conquer algorithm, stable sorting.  
- *DutchNationalFlag.java* → Sort colors (0s, 1s, 2s).  
- *MaxProductAndKTHLARGEST.java* → Find max product & Kth largest element.  
- *MaxprodOptimized.java* → Optimized approach for max product subarray.  

---

### 🔹 Searching Problems
- *LinearSearch.java* → Basic linear search.  
- *BinarySearch.java* → Classic binary search in sorted array.  
- *FirstAndLastOccur.java* → Find first & last occurrence of an element.  
- *SearchInRotated.java* → Search element in rotated sorted array.  
- *FindMinRotated.java* → Find minimum in rotated sorted array.  
- *SquareRoot.java* → Square root using binary search.  
- *PeakElement.java* → Find peak element in array.  
- *TwoSum.java* → Classic two-sum problem using binary search/2-pointer.  

---

### 🔹 Advanced Problems (Binary Search on Answer)
- *AggresiveCows.java* → Place cows in stalls with max distance.  
- *AllocatePages.java* → Allocate minimum pages to students.  
- *PaintersPartition.java* → Partition problem using binary search.  
- *MedianTwoSorted.java* → Find median of two sorted arrays.  
- *KthElementTwoSorted.java* → Find kth element from two sorted arrays.  
- *MinimumPlatforms.java* → Find minimum platforms required for trains.  

---

### 🔹 Miscellaneous Problems
- *CountElements.java / CountElementsOpti.java* → Count smaller elements.  
- *RepeatingMissing.java* → Find repeating and missing number in array.  
- *SortCharacByFreq.java* → Sort characters by frequency.  
- *MergeIntervals.java* → Merge overlapping intervals.  
- *InversionCount.java* → Count inversions in array (merge sort logic).  

---
# 📚 Linked List Notes – Placement Guide

## 🧠 Introduction
A **Linked List** is a linear data structure where elements are stored in nodes, and each node points to the next node.  
Unlike arrays, linked lists are **non-contiguous in memory**, allowing **dynamic size changes**.

---

## ⚙️ Node Structure (Java)
```java
class Node {
    int data;   // value
    Node next;  // pointer to next node
    Node(int value) {
        data = value;
        next = null;
    }
}
🧩 Memory Example
rust
Copy code
[10|next] -> [20|next] -> [30|next] -> null
head -> 10
🔧 Basics & Implementation
1. Create a Linked List
Create nodes and link them using next pointers.
Each node points to the next node; last node points to null.

2. Insert at Beginning
Make new node's next = head, then update head = new node.
Time Complexity: O(1)

3. Insert at End
Traverse to last node, then set last.next = newNode.
Time Complexity: O(n)

4. Insert at Position
Traverse to position - 1, then:

java
Copy code
newNode.next = temp.next;
temp.next = newNode;
Time Complexity: O(n)

5. Delete from Beginning
java
Copy code
head = head.next;
Time Complexity: O(1)

6. Delete from End
Traverse to second last node, then:

java
Copy code
secondLast.next = null;
Time Complexity: O(n)

7. Delete from Position
java
Copy code
temp.next = temp.next.next;
Time Complexity: O(n)

8. Search an Element
Traverse and compare each node’s data with key.
Time Complexity: O(n)

9. Print Linked List
Traverse and print node data.
Time Complexity: O(n)

Tips:

Always check for head == null

Visualize pointer updates using diagrams

💥 Important Placement Problems
🔁 Reverse Linked List (Iterative)
Use 3 pointers: prev, curr, next.
Reverse next links while traversing.
Time Complexity: O(n)

🔄 Reverse Linked List (Recursive)
Recursively reverse and fix next during unwind.
Time Complexity: O(n)

⚖️ Find Middle Node
Use slow & fast pointers.
When fast reaches end, slow is at middle.
Time Complexity: O(n)

🌀 Detect Cycle
Use Floyd’s Tortoise & Hare algorithm.
If slow == fast at any point → cycle exists.
Time Complexity: O(n)

✂️ Remove Cycle
After detection, find start of cycle and make the previous node’s next = null.
Time Complexity: O(n)

🔀 Merge Two Sorted Lists
Traverse both lists with two pointers; attach smaller node each time.
Time Complexity: O(n + m)

🔗 Intersection of Two Lists
Use two pointers; when one reaches null, switch to other head.
Meeting point → intersection node.
Time Complexity: O(n + m)

🔄 Palindrome Check
Find middle → reverse second half → compare both halves.
Time Complexity: O(n)

➕ Add Two Numbers
Traverse both lists; sum data + carry, store in new list.
Time Complexity: O(max(n, m))

❌ Remove Nth Node from End
Find (length - n + 1)th node → delete.
Time Complexity: O(n)

🔁 Rotate List by k
k = k % length → adjust pointers or use reverse technique.
Time Complexity: O(n)

🧠 Memory / Pointer Visualization
🧭 Reverse Iterative
Before:
head -> 10 -> 20 -> 30 -> null
After:
head -> 30 -> 20 -> 10 -> null
Pointers Used: prev, curr, next

🧿 Detect Cycle Example
1 -> 2 -> 3 -> 4 -> 2 (cycle back to 2)
Slow and fast meet inside cycle → confirms cycle.

🔂 Merge Two Sorted Lists Example
rust
Copy code
List1: 1 -> 3 -> 5
List2: 2 -> 4 -> 6
Merged: 1 -> 2 -> 3 -> 4 -> 5 -> 6
Use a dummy node and tail pointer.

🔁 Intersection of Two Lists Example
rust
Copy code
ListA: 10 -> 20 -> 30 \
                          -> 40 -> 50
ListB: 15 --------------/
Intersection at node 40.
Two-pointer trick → O(n + m) and no extra space.

🎯 Placement Tips
Draw diagrams for each operation.

Dry-run before coding.

Practice each question twice.

Handle edge cases: null, 1-node, k > length.

Focus on pointer logic — it's key to cracking Linked List rounds.

👨‍💻 Master these and Linked Lists will never trouble you again!
🔥 Happy Coding & All the Best for Placements!

yaml
Copy code

---

Would you like me to make it look more **GitHub-fancy** (like adding emojis for each section header, a collapsible “Problems” list, and table of complexities)?


# 🌳 Trees & Binary Search Trees (BST) – Complete Notes

## 🧠 Introduction

A **Tree** is a hierarchical data structure made up of **nodes**, where one node (the root) connects to others (children) via edges.  
The top node is called the **root**, and nodes with no children are **leaves**.

### 🧩 Basic Terminology

| Term | Meaning |
|------|----------|
| Root | Top-most node of the tree |
| Parent | A node that has child nodes |
| Child | Node connected below a parent |
| Leaf | Node with no children |
| Height | Longest path from root to a leaf |
| Depth | Distance of a node from root |
| Binary Tree | Each node has ≤ 2 children |
| Binary Search Tree (BST) | Binary Tree where: left < root < right |

---

## 🌱 1. Tree Basics

| Problem | Concept | Approach |
|----------|----------|----------|
| Count total nodes | Tree traversal | Recursive count of all nodes |
| Count leaf nodes | Base case: node with no children | DFS + count when node.left==null && node.right==null |
| Height / Depth of tree | Max depth of subtrees | `height = 1 + max(left, right)` |
| Sum of all nodes | Recursively sum all node values | DFS |
| Max / Min value in tree | Compare all node values | DFS |

---

## 🌳 2. Tree Traversals

| Type | Order | Iterative / Recursive |
|------|--------|-----------------------|
| Preorder | Root → Left → Right | Stack / Recursion |
| Inorder | Left → Root → Right | Stack / Recursion |
| Postorder | Left → Right → Root | Stack (two stacks) / Recursion |
| Level Order (BFS) | Level by level | Queue |

**Example Files:**
- `PreorderTraversal.java`
- `InorderTraversal.java`
- `PostorderTraversal.java`
- `LevelOrderTraversal.java`

---

## 🌴 3. Standard Binary Tree Problems

| Problem | LeetCode / GFG | Approach |
|----------|----------------|-----------|
| Identical Trees | LC 100 | Recursively check left & right |
| Subtree of Another Tree | LC 572 | Compare roots recursively |
| Diameter of Binary Tree | LC 543 | `diameter = leftHeight + rightHeight` |
| Transform to Sum Tree | GFG | Replace node with sum of its subtree |
| Count nodes at Kth level | GFG | BFS level tracking |
| Max Depth / Height | LC 104 | Recursive DFS |
| Binary Tree Paths | LC 257 | Backtracking with path list |
| Path Sum Exists | LC 112 | DFS sum check |
| Path Sum II – All Paths | LC 113 | DFS + backtrack list |
| Maximum Width of Binary Tree | LC 662 | Level order + index mapping |

---

## 🌲 4. Binary Search Tree (BST)

**Properties**
- Left subtree < Root < Right subtree  
- Inorder traversal → Sorted order

| Problem | LeetCode / GFG | Approach |
|----------|----------------|-----------|
| Validate BST | LC 98 | Range check for each node |
| Search in BST | GFG | Recursive / Iterative traversal |
| Insert in BST | GFG | Recursive insertion |
| Delete in BST | GFG | Handle 3 cases (0, 1, 2 children) |
| Find Min / Max in BST | GFG | Go extreme left/right |

---

## 🍃 5. Advanced BST Problems

| Problem | LeetCode / GFG | Approach |
|----------|----------------|-----------|
| Kth Smallest in BST | LC 230 | Inorder traversal count |
| Kth Largest in BST | GFG | Reverse inorder count |
| Lowest Common Ancestor in BST | LC 235 | Move left/right based on values |
| Min Distance between BST nodes | LC 783 | Inorder traversal + diff |
| Merge Two BSTs | GFG | Inorder merge of two sorted arrays |

---

## 🌿 6. Tree Construction

| Problem | LeetCode / GFG | Approach |
|----------|----------------|-----------|
| Build Tree from Preorder & Inorder | LC 105 | Recursion + map for inorder index |
| Construct BST from Preorder | GFG | Range-based recursion |
| Convert Sorted Array → Balanced BST | LC 108 | Mid element as root |
| Flatten Binary Tree to Linked List | LC 114 | Recursion + pointer logic |
| Recover BST | LC 99 | Find two swapped nodes using inorder |

---

## 🔥 7. Optional / Harder (Do only if time allows)

| Problem | LeetCode / GFG | Approach |
|----------|----------------|-----------|
| Largest BST in Binary Tree | GFG | Postorder with struct return |
| BST Iterator | LC 173 | Stack + controlled inorder traversal |
| Inorder Predecessor & Successor | GFG | Recursive search |
| Morris Inorder Traversal | Theory | Inorder without stack or recursion |

---

## ✅ Placement Focus Summary

- **Service-based companies:** Basics + standard binary tree + basic BST → (~18 – 20 problems)
- **Product-based companies:** Add advanced BST + construction + optional → (~25 – 28 problems)

---

## 📚 Resources
- [LeetCode – Tree Tag](https://leetcode.com/tag/tree/)
- [GeeksforGeeks – Tree Problems](https://www.geeksforgeeks.org/data-structures/tree/)
- [Visual Algo Tree Animations](https://visualgo.net/en/bst)

---

> 🧩 **Tip:** Always visualize the tree using diagrams.  
> Practice writing recursive and iterative traversals — these are the backbone of all tree problems.


# 🕸️ Graphs – Complete Notes

## 🧠 Introduction

A **Graph** is a collection of **nodes (vertices)** and **edges** that connect pairs of nodes.  
They are used to represent relationships like social networks, maps, dependencies, and networks.

### 📘 Basic Terminology

| Term | Meaning |
|------|----------|
| Vertex / Node | Fundamental unit of a graph |
| Edge | Connection between two vertices |
| Directed Graph | Edges have direction (A → B) |
| Undirected Graph | Edges have no direction (A – B) |
| Weighted Graph | Each edge has a weight or cost |
| Path | Sequence of vertices connected by edges |
| Cycle | Path that starts and ends at same node |
| Connected Graph | Every vertex is reachable from another |
| Component | A disconnected part of a graph |

---

## ⚙️ Graph Representation

| Type | Description | Code Idea |
|------|--------------|-----------|
| Adjacency Matrix | 2D array where `matrix[u][v]=1` if edge exists | Good for dense graphs |
| Adjacency List | Array of lists for each node | Efficient for sparse graphs |
| Edge List | List of all edges with weights (for Kruskal’s) | Used in MST algorithms |

**Example File:**  
`GraphBasics.java`

---

## 🚶 1. Graph Traversal (BFS / DFS)

| Problem | Concept | Approach |
|----------|----------|----------|
| BFS Traversal | Level order traversal of graph | Use Queue; track visited |
| DFS Traversal | Depth-first traversal | Use recursion or Stack |
| Connected Components | Count disconnected parts | Run DFS for every unvisited node |
| Clone Graph | Copy the same structure | BFS/DFS + HashMap<Node,Clone> |

**Example Files:**  
- `BFSTraversalGraph.java`  
- `DFSTraversalGraph.java`  
- `ConnectedComponents.java`  
- `CloneGraph.java`

---

## 🔄 2. Cycle Detection

| Type | Problem | Approach |
|------|----------|----------|
| Undirected Graph | Detect cycle in undirected | BFS/DFS + parent tracking |
| Directed Graph | Detect cycle in directed | DFS + recursion stack OR Kahn’s algo |

**Example Files:**  
- `CycleDetectionInUndirected.java`  
- `DirectedCycleDetectionDFS.java`

---

## 🧮 3. Shortest Path Algorithms

| Algorithm | Graph Type | Concept | Time Complexity |
|------------|-------------|----------|----------------|
| BFS (Unweighted) | Unweighted graph | Level order traversal gives shortest path | O(V + E) |
| Dijkstra’s | Weighted graph (no negative) | PriorityQueue + distance array | O((V+E) log V) |
| Bellman-Ford | Weighted (handles negative weights) | Relax edges (V−1) times | O(V × E) |

**Example Files:**  
- `BFSSimpleShortestPath.java`  
- `DijkstraAlgoPriorityQueue.java`  
- `BellmanFord.java`

---

## 🏗️ 4. Minimum Spanning Tree (MST)

### 🌿 Kruskal’s Algorithm
- Sort all edges by weight  
- Pick smallest edge that doesn’t form a cycle (Union-Find)  
- Continue until all nodes connected  

### 🌲 Prim’s Algorithm
- Start from any node  
- Pick the smallest edge leading to an unvisited node  
- Use MinHeap (PriorityQueue)

**Example Files:**  
- `KruskalsMst.java`  
- `PrimsMST.java`

---

## 🔁 5. Topological Sorting (Directed Acyclic Graphs – DAG)

| Type | Concept | Key Idea |
|------|----------|----------|
| DFS-based | Postorder reverse | Push to stack when recursion ends |
| BFS-based (Kahn’s) | Count in-degree | Add 0 in-degree nodes to queue |

**Example Files:**  
- `TopologicalSortDFS.java`  
- `TopologicalSortUsingBfs.java`

---

## 🌍 6. Grid / Matrix Graph Problems

These can be treated as graphs where each cell is a node and edges connect adjacent cells.

| Problem | LeetCode / GFG | Approach |
|----------|----------------|-----------|
| Number of Islands | LC 200 | DFS/BFS marking visited land |
| Number of Provinces | LC 547 | Count connected components |
| Rotting Oranges | LC 994 | BFS level traversal |
| Word Ladder | LC 127 | BFS shortest transformation path |

**Example Files:**  
- `NumberOfIslands.java`  
- `NumberOfProvinces.java`  
- `RottingOranges.java`  
- `WordLadder.java`

---

## 🧩 7. Advanced / Optional Problems

| Problem | Concept | Approach |
|----------|----------|----------|
| Course Schedule | Topological sort + cycle detection | Kahn’s Algorithm |
| Alien Dictionary | Build graph from word order | Topological sort |
| Detect Bridges / Articulation Points | Tarjan’s algorithm | DFS + discovery/low time |

---

## ✅ Placement Focus Summary

| Company Type | Focus Areas | Problem Count |
|---------------|--------------|----------------|
| Service-based | BFS, DFS, Connected Components, Cycle detection, Grid problems | ~15–18 |
| Mid / Product-based | Add Dijkstra, Topological Sort, MST, Bellman-Ford | ~25–28 |

---

## 📚 Resources
- [LeetCode – Graph Tag](https://leetcode.com/tag/graph/)
- [GFG Graphs](https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/)
- [Visual Algo Graphs](https://visualgo.net/en/graphds)

---

> 💡 **Tip:** Visualize edges and flows while solving.  
> Most graph problems reduce to **BFS / DFS / shortest path / connectivity** — once you see the pattern, they become straightforward.



