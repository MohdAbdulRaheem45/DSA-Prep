# 🧠 DSA Pattern Notes

Your personal DSA bible covering 200+ essential problems and their core logic patterns.

---

## 📦 1. Arrays

**Core Patterns**
- **Prefix Sum / Sliding Window** – When subarray sum, count, or average is involved.  
  → Maintain `current_sum`, shrink/grow window as needed.  
- **Two Pointer** – For sorted arrays or pair/triplet sum problems.  
  → Move left/right pointer based on condition.  
- **Kadane’s Algorithm** – For maximum subarray sum.  
  → `current_sum = max(num, num + current_sum)`  
- **Sorting + Hashing** – Duplicates, majority element, frequency-based logic.  
- **Matrix Traversal / Rotation** – Work layer by layer.

**Common Problems**
- Kadane’s Algorithm, Longest Sum K, Pair Sum, Move Zeroes, Sort 012, Trapping Rain Water, 3Sum, Container With Most Water.

---

## 🧵 2. Strings

**Core Patterns**
- **Two Pointers** – Reverse, check palindrome, valid anagram (sort or count freq).  
- **Sliding Window** – Longest substring without repeat, min window substring.  
- **HashMap Counting** – For frequency and window-based problems.  
- **Dynamic Programming** – LCS, Palindromic Substring, Edit Distance.

**Common Problems**
- Valid Anagram, Longest Substring No Repeat, Minimum Window, Palindromic Substring, Group Anagrams.

---

## 🔍 3. Searching & Sorting

**Core Patterns**
- **Binary Search (BS)** – When array is sorted or answer lies in a monotonic range.  
  → `while (low <= high) { mid = (low+high)/2; ... }`  
- **Binary Search on Answer** – Search for min/max feasible value (Aggressive Cows, Allocate Pages).  
- **Greedy + Sorting** – Merge Intervals, Minimum Platforms, Activity Selection.

**Common Problems**
- Rotated Array Search, Peak Element, Aggressive Cows, Allocate Pages, Kth Element Two Sorted Arrays.

---

## 🔗 4. Linked List

**Core Patterns**
- **Two Pointers (Slow–Fast)** – Detect cycle, find middle.  
- **Reverse (Iterative/Recursive)** – Core of many problems.  
- **Merge Technique** – Merge sorted lists.  
- **Pointer Rearrangement** – Add Numbers, Rotate, Palindrome.

**Common Problems**
- Reverse LL, Cycle Detection, Merge 2 Sorted LL, Add Numbers, Palindrome Check.

---

## 🧱 5. Stack & Queue

**Core Patterns**
- **Monotonic Stack** – NGE/NSE, Stock Span, Histogram Rectangle.  
- **Stack Simulation** – Valid Parentheses, Min Stack, Evaluate Expression.  
- **Deque / Sliding Window** – For maximum/minimum in window efficiently (O(n)).

**Common Problems**
- Stock Span, NGE, Sliding Window Max, Largest Rectangle in Histogram.

---

## 🌳 6. Trees & BST

**Core Patterns**
- **Recursion & DFS** – Every tree problem → root-left-right pattern.  
- **Property-Based Logic** – Height, diameter, sum, balanced tree checks.  
- **BST** – Validate, Search, Insert, Delete using order property.  
- **Construction** – Build tree from Preorder/Inorder/Postorder.  
- **LCA (Lowest Common Ancestor)** – Split condition → one node left, one node right.

**Common Problems**
- Height, Diameter, Validate BST, Build Tree from Traversals, LCA.

---

## 🕸️ 7. Graphs

**Core Patterns**
- **Traversal** – BFS/DFS base for all.  
- **Cycle Detection** – BFS (with parent) or DFS (visited & recursion stack).  
- **Shortest Path** – Dijkstra (weighted), BFS (unweighted).  
- **Topological Sort** – DAG ordering (DFS stack / Kahn’s Algorithm).  
- **MST** – Kruskal (DSU) / Prim (PQ).

**Common Problems**
- BFS/DFS, Cycle Detection, Dijkstra, Kruskal, Topo Sort, Number of Islands, Rotten Oranges, Word Ladder.

---

## 💰 8. Dynamic Programming

**Core Patterns**
- **Recursion → Memoization → Tabulation → Space Optimization.**  
- **1D DP:** Climbing Stairs, House Robber, Max Subarray.  
- **2D DP:** Knapsack, Subset Sum, Target Sum, Coin Change.  
- **String DP:** LCS, Edit Distance.  
- **Grid DP:** Unique Paths, Min Path Sum.  
- **Sequence DP:** LIS, Partition Equal Subset Sum.

**Common Idea**
1. Define state (index, sum, etc.)
2. Define recurrence (choices → min/max)
3. Apply memoization/tabulation

---

## 🎯 9. Backtracking

**Core Patterns**
- **Decision Tree:** Choose → Explore → Unchoose.  
- Use when finding all combinations or valid arrangements.  
- **Pruning:** Stop recursion early if invalid (like N-Queens).  

**Common Problems**
- Subset, Permutation, Combination Sum, Sudoku Solver, N-Queens, Rat in Maze.

---

## ⚙️ 10. Heaps & Tries

**Heap Patterns**
- Kth Largest/Smallest → Min/Max Heap.  
- Top K frequent → Min Heap with comparator.  
- Merge K Lists → Priority Queue based merging.

**Trie Patterns**
- Prefix-based search.  
- Each node stores child references (26 for lowercase).  
- Insert/Search/Delete in O(L) per word.

**Common Problems**
- Kth Largest Element, Top K Frequent, Merge K Lists, Implement Trie, Longest Word in Dictionary.

---

# 🧮 Time & Space Complexity (TC / SC)

## 🔹 Step 1: Identify Loops or Recursion
- Each loop → `O(n)`
- Nested loops → multiply (`O(n²)`)
- Recursion → `O(branches^depth)`

## 🔹 Step 2: Identify Extra Operations

| Operation | Time Complexity |
|------------|----------------|
| Sorting | O(n log n) |
| Binary Search | O(log n) |
| Heap insert/pop | O(log n) |
| HashMap insert/search | O(1) avg |
| DFS/BFS | O(V + E) |

## 🔹 Step 3: Dominant Term
Keep only the highest order term.  
`O(n + n log n)` → `O(n log n)`

## 🔹 Step 4: Space Complexity
Count:
- Arrays / Hashmaps → O(n)
- Recursion stack → O(depth)
- Constants → O(1)

## 🔹 Common Patterns

| Problem Type | Time | Space |
|---------------|------|-------|
| Two Pointer / Sliding Window | O(n) | O(1) |
| Prefix Sum / Hashmap | O(n) | O(n) |
| Sorting | O(n log n) | O(1) |
| DFS / BFS | O(V + E) | O(V) |
| DP (1D) | O(n) | O(n) or O(1) optimized |
| DP (2D) | O(n × m) | O(n × m) |

---

# 🧩 Quick Revision Formula

When you see a problem, ask yourself:

1. **Which pattern fits?** (Window, Recursion, DP, etc.)
2. **What’s changing each step?** (Index, Sum, Count)
3. **Can I reuse previous results?** (Memoization)
4. **Is the input sorted or monotonic?** (Binary Search)
5. **What’s the range of input?** (Helps estimate TC/SC)

---

# 🧾 Final Tip
You don’t need to memorize every problem.  
Just master these *patterns* — every new question will fall under one of them.

> 🧠 Pattern Recognition > Memorization

---

**Author:** [Mohd Abdul Raheem](https://github.com/MohdAbdulRaheem45)  
**Repo:** [DSA-Prep](https://github.com/MohdAbdulRaheem45/DSA-Prep)
