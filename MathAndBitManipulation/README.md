# MathAndBitManipulation — Math Problems

This folder contains short Java solutions for common math-related algorithm problems. Each file focuses on one small, well-scoped problem and uses a straightforward approach.

Files and quick approaches (with complexities)
- `CountPrime.java` — Count primes up to n. Approach: commonly solved with Sieve of Eratosthenes.
	- TC: O(n log log n) (sieve) — or O(n sqrt n) if naive trial-division per number.
	- SC: O(n) (sieve) or O(1) extra for trial division.
- `FactorialTrailingZeroes.java` — Count trailing zeros in n! by summing n/5 + n/25 + ... to count factors of 5.
	- TC: O(log_5 n) (i.e., O(log n))
	- SC: O(1)
- `GCD.java` — Compute greatest common divisor. Approach: Euclidean algorithm (iterative or recursive modulus).
	- TC: O(log min(a, b))
	- SC: O(1) (iterative) or O(log min(a,b)) stack (recursive)
- `pow_xn.java` — Compute x^n. Approach: fast exponentiation (binary exponentiation) handling negative powers.
	- TC: O(log |n|)
	- SC: O(1) (iterative) or O(log |n|) stack (recursive)
- `ReverseDigit.java` — Reverse digits of an integer. Approach: extract digits with mod/div and rebuild; handle sign and overflow as needed.
	- TC: O(d) where d = number of digits (≈ O(log10 n))
	- SC: O(1)

How to read these files
- Each Java file is standalone with a main/test method you can run directly.
- Look for clear variable names and short helper loops; these are meant for learning and quick reference.

If you want, I can:
- add short unit tests for each file
- unify naming and package declarations
- or create a single runner to try inputs interactively
