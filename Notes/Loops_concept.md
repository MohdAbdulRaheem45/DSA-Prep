# 🔁 Loops in Programming

Loops allow us to execute a block of code multiple times until a condition is met.  
Choosing the right loop depends on whether we know the number of iterations in advance.

---

## 1. for loop
✅ When to Use:  
- Number of iterations is known in advance.  
- Best for arrays, strings, counting problems.  

🔹 Syntax
```java
for (initialization; condition; update) {
    // code block
}
🔹 Example: Print first 5 numbers

java
Copy
Edit
for (int i = 1; i <= 5; i++) {
    System.out.print(i + " ");
}
// Output: 1 2 3 4 5
2. while loop
✅ When to Use:

Number of iterations is unknown, depends on condition.

Best for reading input until a stop condition, searching until found.

🔹 Syntax

java
Copy
Edit
while (condition) {
    // code block
}
🔹 Example: Read numbers until user enters 0

java
Copy
Edit
int num = sc.nextInt();
while (num != 0) {
    System.out.println("You entered: " + num);
    num = sc.nextInt();
}
3. do-while loop
✅ When to Use:

Loop must run at least once before condition is checked.

Best for menu-driven programs.

🔹 Syntax

java
Copy
Edit
do {
    // code block
} while (condition);
🔹 Example: Menu example

java
Copy
Edit
int choice;
do {
    System.out.println("1. Play\n0. Exit");
    choice = sc.nextInt();
} while (choice != 0);
4. Nested Loops
✅ When to Use:

When one loop depends on another.

Common for 2D arrays, matrices, patterns.

🔹 Example: Print 3x3 matrix

java
Copy
Edit
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        System.out.print("(" + i + "," + j + ") ");
    }
    System.out.println();
}
Output:

scss
Copy
Edit
(0,0) (0,1) (0,2) 
(1,0) (1,1) (1,2) 
(2,0) (2,1) (2,2)
🔹 Example: while inside for

java
Copy
Edit
for (int i = 1; i <= 3; i++) {
    int j = 1;
    while (j <= i) {
        System.out.print("* ");
        j++;
    }
    System.out.println();
}
Output:

markdown
Copy
Edit
* 
* * 
* * * 
5. Infinite Loops (⚠️ Avoid unless intentional)
Loop runs forever if condition never becomes false.

java
Copy
Edit
while (true) {
    System.out.println("Runs forever!");
}
6. Break & Continue
break → exit loop immediately.

continue → skip current iteration, go to next.

🔹 Example with break

java
Copy
Edit
for (int i = 1; i <= 5; i++) {
    if (i == 3) break;
    System.out.print(i + " ");
}
// Output: 1 2
🔹 Example with continue

java
Copy
Edit
for (int i = 1; i <= 5; i++) {
    if (i == 3) continue;
    System.out.print(i + " ");
}
// Output: 1 2 4 5
🎯 Summary (When to Use Which)
for → Fixed number of repetitions (arrays, counters).

while → Repeat until condition changes (unknown steps).

do-while → Must execute at least once.

Nested loops → 2D structures (matrix, patterns).

break / continue → Control flow inside loops.