# Recursion and Backtracking Problems

## What is Recursion?
Recursion is a programming concept where a function calls itself to solve a smaller instance of the same problem. It consists of:
- **Base Case**: The condition where recursion stops
- **Recursive Case**: Where the function calls itself with a smaller input
- **Stack Space**: Each recursive call takes space in the call stack

### Key Points about Recursion:
1. Every recursive solution can be converted to iteration
2. Recursion can make code more readable for complex problems
3. Memory usage is higher due to call stack
4. Time complexity often involves the number of recursive calls

## What is Backtracking?
Backtracking is an algorithmic technique that considers searching every possible combination in order to solve a computational problem. It's like trying different paths, and when you hit a dead end, you "backtrack" to try a different path.

### When to Use Backtracking:
- Finding all possible solutions
- Optimization problems
- Decision problems (finding a path to a goal)
- Constraint satisfaction problems

## Problems & Solutions

### 1. Combination Sum
- **Problem**: Find all unique combinations of candidates where chosen numbers sum to target
- **Approach**: 
  - Use recursion to try each number
  - Keep track of current sum and combination
  - Allow reuse of same number
- **Time Complexity**: O(2^target)
- **Space Complexity**: O(target)

### 2. Combination Sum II
- **Problem**: Find all unique combinations where numbers sum to target (no reuse)
- **Approach**:
  - Sort array first
  - Skip duplicates at same level
  - Use index to avoid reusing elements
- **Time Complexity**: O(2^n)
- **Space Complexity**: O(n)

### 3. Generate Parentheses
- **Problem**: Generate all valid combinations of n pairs of parentheses
- **Approach**:
  - Track count of open and close brackets
  - Only add open if open < n
  - Only add close if close < open
- **Time Complexity**: O(4^n / √n)
- **Space Complexity**: O(n)

### 4. N-Queens
- **Problem**: Place N queens on NxN board so no two queens threaten each other
- **Approach**:
  - Try placing queen in each column
  - Check row, diagonal constraints
  - Backtrack if not valid
- **Time Complexity**: O(N!)
- **Space Complexity**: O(N^2)

### 5. Permutations
- **Problem**: Generate all possible permutations of an array
- **Approach**:
  - Fix one position at a time
  - Swap elements to generate different permutations
  - Backtrack by swapping back
- **Time Complexity**: O(N!)
- **Space Complexity**: O(N)

### 6. Rat in a Maze
- **Problem**: Find path from source to destination in a maze
- **Approach**:
  - Try all possible directions (up, right, down, left)
  - Mark visited cells
  - Backtrack if no path found
- **Time Complexity**: O(4^(N*M))
- **Space Complexity**: O(N*M)

### 7. Subsets
- **Problem**: Generate all possible subsets of an array
- **Approach**:
  - For each element, decide to include or not
  - Use recursion tree approach
- **Time Complexity**: O(2^N)
- **Space Complexity**: O(N)

### 8. Sudoku Solver
- **Problem**: Solve a 9x9 Sudoku puzzle
- **Approach**:
  - Try numbers 1-9 for each empty cell
  - Check row, column, and 3x3 box constraints
  - Backtrack if no valid number found
- **Time Complexity**: O(9^(N*N))
- **Space Complexity**: O(N*N)

## Common Patterns
1. **Decision Space**: Identify what choices you can make at each step
2. **Constraints**: Define what makes a solution valid
3. **Goal**: Know when you've found a solution
4. **State Management**: Track current state and restore on backtrack

## Tips for Solving Recursion/Backtracking Problems
1. Always identify base cases first
2. Draw recursion tree to understand the flow
3. Consider using helper functions for clarity
4. Be careful with mutable state (arrays, lists)
5. Think about pruning invalid paths early