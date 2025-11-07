# Trie Data Structure and Problems

## What is a Trie?
A Trie (pronounced "try") is a tree-like data structure used to store and retrieve strings. Each node in a Trie represents a character, and paths from the root to leaf nodes represent complete words or strings. The name "Trie" comes from the word "retrieval".

## When to Use Tries?
Use Tries when you need to:
1. Store and search strings efficiently
2. Find prefixes in strings
3. Auto-complete features
4. Spell checkers
5. IP routing tables
6. Dictionary implementations

## Why Use Tries?
- **Fast Lookups**: O(L) where L is the length of the string
- **Space Efficient**: When storing many strings with common prefixes
- **Prefix-based Operations**: Extremely efficient for prefix-based operations
- **Auto-complete**: Perfect for implementing auto-complete functionality

## Problems in This Repository

### 1. Implement Trie (Prefix Tree)
**Problem**: Implement a basic trie with insert, search, and startsWith operations.

**Approach**:
- Create a TrieNode class with children array and isEnd flag
- Implement insert by creating path of characters
- Implement search by following character path
- Implement startsWith similarly to search

**Time Complexity**: 
- Insert: O(m) where m is the length of word
- Search: O(m)
- StartsWith: O(m)

**Space Complexity**: O(N*M) where N is number of words and M is average length

### 2. Replace Words
**Problem**: Replace words in a sentence with their root word from dictionary.

**Approach**:
- Build a trie from the dictionary words
- For each word in sentence, find shortest prefix in trie
- Replace word with prefix if found

**Time Complexity**: O(N*M + S) where:
- N = number of dictionary words
- M = average length of dictionary words
- S = length of sentence

**Space Complexity**: O(N*M) for trie storage

### 3. Longest Common Prefix
**Problem**: Find longest common prefix among an array of strings.

**Approach**:
- Insert all strings into trie
- Follow path until node has more than one child or isEnd
- Characters collected till that point form longest common prefix

**Time Complexity**: O(N*M) where N is number of strings, M is length of shortest string
**Space Complexity**: O(N*M)

### 4. Word Search II
**Problem**: Find all words from a dictionary in a 2D board of characters.

**Approach**:
- Build trie from dictionary words
- Use DFS with backtracking on board
- Track visited cells to avoid cycles
- Mark words found during traversal

**Time Complexity**: O(M*N*4^L) where:
- M, N are board dimensions
- L is maximum length of word
- 4 represents four possible directions

**Space Complexity**: O(K) where K is total length of all dictionary words

## How to Recognize a Trie Problem?
Look for these indicators:
1. Problem involves multiple strings with common prefixes
2. Need to perform prefix-based operations
3. Dictionary or word-based searching
4. Auto-complete or type-ahead features
5. Questions involving:
   - Word searching
   - Prefix matching
   - String matching with wildcards
   - Finding all strings with common prefix
   - Spell checking
   - IP address routing

## Common Trie Operations
- **Insert**: O(M) time - M is length of string
- **Search**: O(M) time
- **Delete**: O(M) time
- **Prefix Search**: O(P) time - P is length of prefix
- **Space**: O(ALPHABET_SIZE * M * N) where N is number of words

Remember: Tries are especially useful when you have a large set of strings and need to perform frequent prefix-based operations or searches.