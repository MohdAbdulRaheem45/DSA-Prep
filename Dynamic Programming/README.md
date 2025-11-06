# Dynamic Programming - Problem Catalog

This folder collects classic dynamic programming (DP) problems, grouped by pattern. For each file in this folder there is a short approach, time complexity (T.C.), and space complexity (S.C.). Use this as your study checklist and quick reference when practicing or interviewing.

---

## How to run
Compile and run Java files from this folder (Windows PowerShell):

```powershell
javac *.java
java <ClassName>
```

(If a file is in a subfolder like `Greedy/`, compile with `javac Greedy\*.java` or include paths.)

---

## Files in this folder

### `AClimbingStairs.java`
- Approach: 1D DP on steps. dp[i] = dp[i-1] + dp[i-2] (number of ways).
- T.C.: O(n)
- S.C.: O(n) (can be reduced to O(1) using two vars)
- Notes: Demonstrates memoization vs tabulation and rolling variables.

### `FibonacciNumber.java`
- Approach: Basic DP (memoization and iterative). f[n] = f[n-1] + f[n-2]
- T.C.: O(n)
- S.C.: O(n) or O(1) with rolling vars
- Notes: Good warm-up for DP concepts.

### `TribonacciAllMethods.java`
- Approach: Sequence DP (3-term recurrence). Implement iterative and recursive+memo.
- T.C.: O(n)
- S.C.: O(n) or O(1)

### `HouseRobber1.java` and `HouseRobber2.java`
- Approach: 1D DP for maximum sum without adjacent picks. HouseRobber2 handles circular houses.
- T.C.: O(n)
- S.C.: O(n) or O(1) with rolling variables
- Notes: Shows how problem constraints change recurrence (circular -> split into two linear problems).

### `MaxSubarray.java` (Kadane)
- Approach: Greedy/DP (Kadane). Track local max ending here and global max.
- T.C.: O(n)
- S.C.: O(1)

### `MaximumProductSubarray.java`
- Approach: Keep both max and min ending at current index because negatives flip sign.
- T.C.: O(n)
- S.C.: O(1)
- Notes: Edge cases with zeros and negative numbers.

### `CoinChange.java` (min coins)
- Approach: 1D DP where dp[x] = min coins to make amount x using coin choices.
- T.C.: O(n * amount) (n = number of coins)
- S.C.: O(amount)

### `CoinChangeII.java` (ways to make change)
- Approach: 1D DP counting combinations (iterate coins outer, amounts inner to avoid duplicates).
- T.C.: O(n * amount)
- S.C.: O(amount)

### `KnapsackAllInOne.java`
- Approach: 0/1 knapsack dynamic programming (2D DP table or optimized 1D reverse iteration).
- T.C.: O(n * W)
- S.C.: O(n * W) or O(W) with 1D optimization
- Notes: Important template for subset-sum and partition problems.

### `SubsetSumEqualsK.java`
- Approach: 1D/2D knapsack-style DP to determine if subset with sum K exists.
- T.C.: O(n * K)
- S.C.: O(n * K) or O(K)

### `PartitionEqualSubsetSum.java`
- Approach: Reduce to subset sum with target = totalSum/2.
- T.C.: O(n * sum)
- S.C.: O(sum)

### `TargetSum.java`
- Approach: Convert to subset sum by mapping +/- signs to partitions (sumPos - sumNeg = target).
- T.C.: O(n * sum)
- S.C.: O(sum)

### `UniquePaths.java` and `UniquePaths2.java` (obstacles)
- Approach: Grid DP. dp[i][j] = dp[i-1][j] + dp[i][j-1], handle obstacles where needed.
- T.C.: O(m * n)
- S.C.: O(m * n) or O(n) row-optimized

### `MinPathSum.java`
- Approach: Sum-minimizing grid DP with same recurrence as UniquePaths but using min.
- T.C.: O(m * n)
- S.C.: O(m * n) or O(n)

### `MInCostClimbingStairs.java`
- Approach: Similar to climbing stairs but costs attached to steps. dp[i] = cost[i] + min(dp[i-1], dp[i-2]).
- T.C.: O(n)
- S.C.: O(n) or O(1)

### `DecodeWays.java`
- Approach: 1D DP over string positions, check single-digit and two-digit validity for decoding.
- T.C.: O(n)
- S.C.: O(n) or O(1)
- Notes: Watch for leading zeros and invalid two-digit combos.

### `EditDistance.java`
- Approach: 2D DP (classic Levenshtein). dp[i][j] = min(insert, delete, replace).
- T.C.: O(m * n)
- S.C.: O(m * n) (can be reduced to O(min(m,n)) with careful rolling arrays)
- Notes: Useful for string transformation problems.

### `LongestCommonSubsequence.java` and `LongestCommonSubString.java`
- Approach: 2D DP. LCS uses dp[i][j]=dp[i-1][j-1]+1 when chars match; LCSubstring uses contiguous matching and resets on mismatch.
- T.C.: O(m * n)
- S.C.: O(m * n) or O(n) optimized
- Notes: Include reconstruction for LCS to get the actual sequence.

### `InterleavingStrings.java`
- Approach: 2D DP to check whether s3 can be formed by interleaving s1 and s2. dp[i][j] indicates using first i of s1 and j of s2.
- T.C.: O(m * n)
- S.C.: O(m * n) or O(n)

### `DecodeWays.java`
- (Duplicate entry above) See decode rules and handling of '0'.

### `LIS.java` (Longest Increasing Subsequence)
- Approach: Provide both O(n^2) DP and O(n log n) patience/sequence method. For reconstruction keep predecessor indices.
- T.C.: O(n^2) for DP, O(n log n) for patience method
- S.C.: O(n)
- Notes: Important to master both to explain trade-offs in interviews.

### `EditDistance.java` (already listed)

### `MaximumProductSubarray.java` (already listed)

### `Greedy/JumpGameI.java` and `Greedy/JumpGameII.java`
- Approach: Greedy/interval covering. Good pair to compare greedy vs DP thinking.
- T.C.: O(n)
- S.C.: O(1)

---

## Suggested additions (to cover more interview patterns)
- Interval DP: Matrix Chain Multiplication, Burst Balloons, Palindrome Partitioning (min cuts)
- Tree DP: DP on rooted trees (subtree states, rerooting techniques)
- Bitmask DP: TSP / assignment problems for small n (1<<n states)
- Word Break & Word Break II (string + DP with reconstruction)
- A few reconstruction-focused examples (returning the sequence/path)

---

## Study tips
- For each problem practice: define state → write recurrence → implement memo → implement tabulation → optimize space.
- Time yourself solving medium DP problems in 15–20 minutes and review correctness + edge cases.
- Keep a one-page cheat sheet with common templates: 1D index, 2D strings, knapsack, grid, bitmask.

---

If you want, I can:
- Add unit/main test harnesses for several files so you can run them quickly.
- Add the missing problem templates (LIS patience method, matrix chain, tree DP examples).

