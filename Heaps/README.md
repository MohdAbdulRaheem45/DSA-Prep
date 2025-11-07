## Heaps — quick reference and how this repo uses them

This README explains what a heap is, common types and operations, their time/space costs, how to implement them in Java, how to recognize problems that call for a heap, and short notes on how each file in this repository uses heaps.

---

## What is a heap?

- A heap is a specialized tree-based data structure that satisfies the heap property: every parent node is ordered with respect to its children. In a max-heap the parent >= children; in a min-heap the parent <= children.
- Heaps are typically implemented as a binary heap stored in an array (implicit complete binary tree).

Why use a heap:
- Efficiently get the largest or smallest element repeatedly (peek/extract).
- Supports dynamic insertion and removal while keeping order.

## Types of heaps

- Min-heap — smallest element at the root (useful for "k smallest", merging, minimum-cost problems).
- Max-heap — largest element at the root (useful for "k largest", top-k frequent if using counts).
- Variants: d-ary heaps, Fibonacci heaps, pairing heaps (used in algorithmic research). For most coding problems, Java's binary heap (PriorityQueue) is enough.

## Common heap operations (binary heap)

Contract (inputs / outputs / error modes):
- Input: collection of comparable items and optionally a comparator.
- Output: peek/top, extracted item, heap after insert/delete.
- Errors: operations on empty heap should be handled (exceptions or checks).

Operations and typical complexity (n = number of elements):

- peek() / top(): O(1) — return root without removing.
- insert(item): O(log n) — place item at the end and sift-up (bubble-up) to restore heap.
- extract (removeRoot / poll): O(log n) — remove root, move last node to root and sift-down (heapify) to restore heap.
- heapify-down (sift-down): O(log n) — used when root changed.
- build-heap (from array): O(n) — Floyd's algorithm (sift-down from last parent downwards).
- decrease-key / increase-key: O(log n) — adjust a key and sift-up or sift-down accordingly (often simulated by removing and reinserting when no direct handle).
- merge heaps: depends on heap type (for binary heap, merging two binary heaps is O(n + m) if rebuilding; for specialized heaps this can be faster).

Space complexity for heap structure: O(n) to store n elements.

Edge cases / notes:
- Empty heap: peek/poll behaviors differ across languages (Java's `PriorityQueue.poll()` returns null; `remove()` throws). Check which you use.
- Stable ordering: binary heap is not stable for equal keys.

## Java notes (PriorityQueue)

- Min-heap (default): new PriorityQueue<>()
- Max-heap: new PriorityQueue<>(Collections.reverseOrder()) or provide Comparator.reverseOrder()
- Build from collection: new PriorityQueue<>(collection) — this uses O(n) build-heap.

Example snippets (conceptual):
- Min-heap: PriorityQueue<Integer> min = new PriorityQueue<>();
- Max-heap: PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

---

## How to recognize problems that should use a heap

Look for these clues in problem statements:
- Phrases: "top k", "kth largest/smallest", "top K frequent", "merge k sorted", "running median", "minimum cost to connect/merge ropes/files", "process the next highest priority", "priority queue", "schedule by priority", "sliding window k max/min".
- When you need the min or max repeatedly while performing dynamic inserts/removals.
- When you can maintain a bounded-size structure of the best candidates (e.g., keep only k elements) efficiently.

Quick decision guide:
- Need smallest repeatedly → use min-heap.
- Need largest repeatedly → use max-heap.
- Need median → use two heaps (max-heap for lower half, min-heap for upper half).
- Need to merge many sorted lists → use a min-heap keyed by current element value.

---

## Files in this repository — approach, why heap, complexity

Each file below is a typical heap-based problem. For each: short description, why a heap is appropriate, and time/space complexity.

- `HeapSort.java`
  - Problem: implement heapsort.
  - Approach: build a max-heap from the array (O(n)), then repeatedly extract max and place it at the end (n extracts × O(log n) each). In-place variants use array-based heap operations.
  - Why heap: heapsort directly uses the heap property to sort in-place with O(n log n) worst-case time.
  - Time complexity: O(n log n) overall (build O(n) + n·O(log n)).
  - Space complexity: O(1) additional (in-place) or O(n) if using auxiliary structure.

- `KTHLARGESTELEMENT.java`
  - Problem: find the kth largest element in an array or stream.
  - Approach: maintain a min-heap of size k; iterate the array inserting and if size > k remove the smallest. After processing, the root is the kth largest.
  - Why heap: keeping k best candidates requires O(log k) per element; efficient when k << n or when streaming.
  - Time complexity: O(n log k).
  - Space complexity: O(k).

- `TopKFrequentElements.java`
  - Problem: return the k most frequent elements from an array.
  - Approach: count frequencies with a hash map, then use a min-heap of size k keyed by frequency (or use bucket sort). Maintain k most frequent in heap; root is the smallest frequency among top k.
  - Why heap: efficient when k is small relative to number of unique elements; streaming-friendly.
  - Time complexity: O(n log k) (n to build counts, then push unique elements into heap of size at most k).
  - Space complexity: O(u + k) where u = number of unique elements (for the map) and O(k) for heap.

- `MergeKsortedList.java`
  - Problem: merge k sorted lists into one sorted list/array.
  - Approach: push the first element from each list into a min-heap keyed by value (store value + originating list index + pointer). Repeatedly pop smallest and push next element from same list.
  - Why heap: it always gives the global smallest next value across the k lists in O(log k) per output element.
  - Time complexity: O(n log k) where n = total number of elements across lists.
  - Space complexity: O(k) for heap (plus output size O(n)).

- `ConnectsRopestoMInCost.java` (typical "connect ropes" or "minimum cost to connect sticks")
  - Problem: given lengths of ropes/sticks, connect them pairwise; cost to connect two ropes = sum of their lengths; find min total cost.
  - Approach: use a min-heap containing all rope lengths; repeatedly extract two smallest, sum them, add cost, push the combined rope back until one rope remains.
  - Why heap: greedy — always combine two smallest minimizes incremental cost; heap gives the two smallest in O(log n) each iteration.
  - Time complexity: O(n log n) (n inserts + (n-1) extract/push pairs).
  - Space complexity: O(n).

Notes: For each of the above, Java's `PriorityQueue` is the natural implementation.

---

## Example design patterns / utils (practical tips)

- Keep only k elements: use min-heap of size k to track k largest. Insert new element and if size>k then poll().
- For Kth largest streaming data: same min-heap approach works online.
- When counting frequency: build a map first then heap over map entries.
- Merging lists/streams: heap node should store (value, sourceId, index/pointer) so you can push the next element from the same source.
- Median maintenance: two heaps — max-heap for the lower half and min-heap for the upper half. Balance sizes so difference ≤ 1.

## How to prove correctness (short)

- Most heap greedy algorithms rely on an exchange argument: choosing the min (or max) locally (via heap) can be shown to be part of an optimal solution (e.g., Huffman-like and connect-ropes problems).

## Quick checklist to choose heap vs other methods

Use a heap when:
- You need repeated access to minimum/maximum while the set changes.
- You need to maintain top-k in streaming input.
- You need to merge many sorted sources efficiently.

Consider alternatives:
- Sorting: if you need full order once and no streaming, sort (O(n log n)) may be simpler.
- Hash + bucket (for frequency with small range) may be O(n).
- Selection algorithms (QuickSelect) give average O(n) for kth element but not streaming.

---

## Where to go next

- If you want, I can:
  - add short README sections with code snippets for each Java file showing the exact PriorityQueue usage used in that file, or
  - run quick static checks to ensure each file compiles, or
  - add example inputs and expected outputs for each program.

---

Files referenced in this README:

- `HeapSort.java` — heapsort implementation
- `KTHLARGESTELEMENT.java` — kth largest
- `TopKFrequentElements.java` — top-k frequent
- `MergeKsortedList.java` — merge k sorted lists
- `ConnectsRopestoMInCost.java` — connect ropes / minimum cost

If you want the README expanded (examples, code snippets, or per-file run instructions), tell me which parts to expand.
