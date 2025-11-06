# BITMANIPULATION — Bit Manipulation Problems

This folder contains short Java solutions demonstrating common bitwise techniques. Each file focuses on a single concept or problem and shows a compact approach.

Files and tiny approaches (with complexities)
- `ADDBinary.java` — Add two binary strings. Approach: simulate bit addition with carry from LSB to MSB.
	- TC: O(max(m, n)) where m,n are string lengths
	- SC: O(max(m, n)) for result string
- `basicstuffs.java` — Small bitwise examples and helpers. Approach: demonstrations of shifts, masks, and bit ops.
	- TC: O(1) per example (varies by snippet)
	- SC: O(1) per example
- `CountBits.java` — Count number of set bits (per integer or up to n). Approach: use x & (x-1) loop or DP for ranges.
	- TC: per-integer O(k) where k = number of set bits (worst O(log W) where W = word size); for range 0..n using DP: O(n)
	- SC: per-integer O(1); for DP range O(n)
- `EvenOddcheck.java` — Check even/odd using bit 0. Approach: n & 1 to test parity.
	- TC: O(1)
	- SC: O(1)
- `MissingNumber.java` — Find missing number in array 0..n. Approach: XOR all indices and array values to cancel pairs.
	- TC: O(n)
	- SC: O(1)
- `NumberOf1Bits.java` — Hamming weight of an integer. Approach: repeatedly clear lowest set bit: x &= (x-1).
	- TC: O(k) where k = number of set bits (worst O(log W))
	- SC: O(1)
- `PowerOf2.java` — Check if a number is a power of two. Approach: x > 0 && (x & (x-1)) == 0.
	- TC: O(1)
	- SC: O(1)
- `ReverseBits.java` — Reverse bits in a 32-bit integer. Approach: swap bits using masks or iterative shifting.
	- TC: O(1) (32 steps) — or O(log W) where W is bit-width
	- SC: O(1)
- `SingleNumber.java` — Find number appearing once when others appear twice. Approach: XOR all elements to cancel pairs.
	- TC: O(n)
	- SC: O(1)
- `SwappingUsingXor.java` — Swap two integers without temp. Approach: a ^= b; b ^= a; a ^= b.
	- TC: O(1)
	- SC: O(1)

Notes
- These solutions favor clarity and minimal extra memory.
- Many use bit tricks like masking, shifting, and x&(x-1) for efficiency.

Want me to:
- add unit tests for these files,
- or add short README examples showing input -> output for each file.
