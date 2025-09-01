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

## 📂 Folder Structure
