# algorithms

## Sorting
In Java we use 
* Dual-Pivot Quick Sort for primitives (reordering not important)
* Timsort for objects.

### Quick sort
Quick Sort avg time ~10-20 n log(n) = O(n log(n))
Quick Sort 2-3 times faster than Merge Sort.

### Timsort

Insertion Sort working slow for arrays with size > 256.

Merge Sort working slow for arrays with size < 8.

Timsort evaluates int minrun. Minrun is size of sorted subarrays ([32, 64]).

Any Stream.sort or Collections.sort comes down to Arrays.sort.

### Segment Tree
[Booking concert tickets](https://leetcode.com/problems/booking-concert-tickets-in-groups/)

## LeetCode problems

| Topic               | Problem                                                           | Difficulty | Solution |
|---------------------|-------------------------------------------------------------------|------------|----------|
| Arrays & Hashing     | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate) | Easy       |          |
| Arrays & Hashing     | [Valid Anagram](https://leetcode.com/problems/valid-anagram)      | Easy       |          |
| Arrays & Hashing     | [Two Sum](https://leetcode.com/problems/two-sum)                  | Easy       |          |
| Arrays & Hashing     | [Group Anagrams](https://leetcode.com/problems/group-anagrams)    | Medium     |          |
| Arrays & Hashing     | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements) | Medium     |          |
| Arrays & Hashing     | [Encode and Decode Strings](https://leetcode.com/problems/encode-and-decode-strings) | Medium     |          |
| Arrays & Hashing     | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self) | Medium     |          |
| Arrays & Hashing     | [Valid Sudoku](https://leetcode.com/problems/valid-sudoku)        | Medium     |          |
| Arrays & Hashing     | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence) | Medium     |          |
| Two Pointers        | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome) | Easy       |          |
| Two Pointers        | [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted) | Medium     |          |
| Two Pointers        | [3Sum](https://leetcode.com/problems/3sum)                        | Medium     |          |
| Two Pointers        | [Container With Most Water](https://leetcode.com/problems/container-with-most-water) | Medium     |          |
| Two Pointers        | [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water) | Hard       |          |
| Stack               | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses) | Easy       |          |
| Stack               | [Min Stack](https://leetcode.com/problems/min-stack)               | Medium     |          |
| Stack               | [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation) | Medium     |          |
| Stack               | [Generate Parentheses](https://leetcode.com/problems/generate-parentheses) | Medium     |          |
| Stack               | [Daily Temperatures](https://leetcode.com/problems/daily-temperatures) | Medium     |          |
| Stack               | [Car Fleet](https://leetcode.com/problems/car-fleet)               | Medium     |          |
| Stack               | [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram) | Hard       |          |
| Binary Search       | [Binary Search](https://leetcode.com/problems/binary-search)       | Easy       |          |
| Binary Search       | [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix) | Medium     |          |
| Binary Search       | [Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas) | Medium     |          |
| Binary Search       | [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array) | Medium     |          |
| Binary Search       | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array) | Medium     |          |
| Binary Search       | [Time Based Key-Value Store](https://leetcode.com/problems/time-based-key-value-store) | Medium     |          |
| Binary Search       | [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays) | Hard       |          |
| Sliding Window      | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock) | Easy       |          |
| Sliding Window      | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters) | Medium     |          |
| Sliding Window      | [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement) | Medium     |          |
| Sliding Window      | [Permutation in String](https://leetcode.com/problems/permutation-in-string) | Medium     |          |
| Sliding Window      | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring) | Hard       |          |
| Sliding Window      | [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum) | Hard       |          |
| Linked List         | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list) | Easy       |          |
| Linked List         | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists) | Easy       |          |
| Linked List         | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle) | Easy       |          |
| Linked List         | [Reorder List](https://leetcode.com/problems/reorder-list)         | Medium     |          |
| Linked List         | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list) | Medium     |          |
| Linked List         | [Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer) | Medium     |          |
| Linked List         | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers)    | Medium     |          |
| Linked List         | [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number) | Medium     |          |
| Linked List         | [LRU Cache](https://leetcode.com/problems/lru-cache)                | Medium     |          |
| Linked List         | [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists) | Hard       |          |
| Linked List         | [Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group) | Hard       |          |
| Trees               | [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree) | Easy       |          |
| Trees               | [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree) | Easy       |          |
| Trees               | [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree) | Easy       |          |
| Trees               | [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree) | Easy       |          |
| Trees               | [Same Tree](https://leetcode.com/problems/same-tree)                 | Easy       |          |
| Trees               | [Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree) | Easy       |          |
| Trees               | [Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree) | Medium     |          |
| Trees               | [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal) | Medium     |          |
| Trees               | [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view) | Medium     |          |
| Trees               | [Count Good Nodes In Binary Tree](https://leetcode.com/problems/count-good-nodes-in-binary-tree) | Medium     |          |
| Trees               | [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree) | Medium     |          |
| Trees               | [Kth Smallest Element In a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst) | Medium     |          |
| Trees               | [Construct Binary Tree From Preorder And Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal) | Medium     |          |
| Trees               | [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum) | Hard       |          |
| Trees               | [Serialize And Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree) | Hard       |          |
| Tries               | [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree) | Medium     |          |
| Tries               | [Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure) | Medium     |          |
| Tries               | [Word Search II](https://leetcode.com/problems/word-search-ii)      | Hard       |          |
| Backtracking        | [Subsets](https://leetcode.com/problems/subsets)                    | Medium     |          |
| Backtracking        | [Combination Sum](https://leetcode.com/problems/combination-sum)    | Medium     |          |
| Backtracking        | [Combination Sum II](https://leetcode.com/problems/combination-sum-ii) | Medium     |          |
| Backtracking        | [Permutations](https://leetcode.com/problems/permutations)          | Medium     |          |
| Backtracking        | [Subsets II](https://leetcode.com/problems/subsets-ii)              | Medium     |          |
| Backtracking        | [Word Search](https://leetcode.com/problems/word-search)            | Medium     |          |
| Backtracking        | [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning) | Medium     |          |
| Backtracking        | [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number) | Medium     |          |
| Backtracking        | [N Queens](https://leetcode.com/problems/n-queens)                  | Hard       |          |
| Heap / Priority Queue | [Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream) | Easy       |          |
| Heap / Priority Queue | [Last Stone Weight](https://leetcode.com/problems/last-stone-weight) | Easy       |          |
| Heap / Priority Queue | [K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin) | Medium     |          |
| Heap / Priority Queue | [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array) | Medium     |          |
| Heap / Priority Queue | [Task Scheduler](https://leetcode.com/problems/task-scheduler)      | Medium     |          |
| Heap / Priority Queue | [Design Twitter](https://leetcode.com/problems/design-twitter)      | Medium     |          |
| Heap / Priority Queue | [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream) | Hard       |          |
| Graphs              | [Number of Islands](https://leetcode.com/problems/number-of-islands) | Medium     |          |
| Graphs              | [Max Area of Island](https://leetcode.com/problems/max-area-of-island) | Medium     |          |
| Graphs              | [Clone Graph](https://leetcode.com/problems/clone-graph)            | Medium     |          |
| Graphs              | [Walls and Gates](https://leetcode.com/problems/walls-and-gates)    | Medium     |          |
| Graphs              | [Rotting Oranges](https://leetcode.com/problems/rotting-oranges)    | Medium     |          |
| Graphs              | [Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow) | Medium     |          |
| Graphs              | [Surrounded Regions](https://leetcode.com/problems/surrounded-regions) | Medium     |          |
| Graphs              | [Course Schedule](https://leetcode.com/problems/course-schedule)    | Medium     |          |
| Graphs              | [Course Schedule II](https://leetcode.com/problems/course-schedule-ii) | Medium     |          |
| Graphs              | [Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree)  | Medium     |          |
| Graphs              | [Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph) | Medium     |          |
| Graphs              | [Redundant Connection](https://leetcode.com/problems/redundant-connection) | Medium     |          |
| Graphs              | [Word Ladder](https://leetcode.com/problems/word-ladder)            | Hard       |          |
| 1-D Dynamic Programming | [Climbing Stairs](https://leetcode.com/problems/climbing-stairs) | Easy       |          |
| 1-D Dynamic Programming | [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs) | Easy       |          |
| 1-D Dynamic Programming | [House Robber](https://leetcode.com/problems/house-robber)         | Medium     |          |
| 1-D Dynamic Programming | [House Robber II](https://leetcode.com/problems/house-robber-ii)   | Medium     |          |
| 1-D Dynamic Programming | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring) | Medium     |          |
| 1-D Dynamic Programming | [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings) | Medium     |          |
| 1-D Dynamic Programming | [Decode Ways](https://leetcode.com/problems/decode-ways)           | Medium     |          |
| 1-D Dynamic Programming | [Coin Change](https://leetcode.com/problems/coin-change)           | Medium     |          |
| 1-D Dynamic Programming | [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray) | Medium     |          |
| 1-D Dynamic Programming | [Word Break](https://leetcode.com/problems/word-break)             | Medium     |          |
| 1-D Dynamic Programming | [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence) | Medium     |          |
| 1-D Dynamic Programming | [Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum) | Medium     |          |
| Intervals            | [Insert Interval](https://leetcode.com/problems/insert-interval)    | Medium     |          |
| Intervals            | [Merge Intervals](https://leetcode.com/problems/merge-intervals)    | Medium     |          |
| Intervals            | [Non Overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals) | Medium     |          |
| Intervals            | [Meeting Rooms](https://leetcode.com/problems/meeting-rooms)        | Easy       |          |
| Intervals            | [Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii)  | Medium     |          |
| Intervals            | [Minimum Interval to Include Each Query](https://leetcode.com/problems/minimum-interval-to-include-each-query) | Hard       |          |
| Greedy               | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray)  | Easy       |          |
| Greedy               | [Jump Game](https://leetcode.com/problems/jump-game)                | Medium     |          |
| Greedy               | [Jump Game II](https://leetcode.com/problems/jump-game-ii)          | Medium     |          |
| Greedy               | [Gas Station](https://leetcode.com/problems/gas-station)            | Medium     |          |
| Greedy               | [Hand of Straights](https://leetcode.com/problems/hand-of-straights) | Medium    |          |
| Greedy               | [Merge Triplets to Form Target Triplet](https://leetcode.com/problems/merge-triplets-to-form-target-triplet) | Medium     |          |
| Greedy               | [Partition Labels](https://leetcode.com/problems/partition-labels)  | Medium     |          |
| Greedy               | [Valid Parenthesis String](https://leetcode.com/problems/valid-parenthesis-string) | Medium     |          |
| Advanced Graphs      | [Network Delay Time](https://leetcode.com/problems/network-delay-time) | Medium     |          |
| Advanced Graphs      | [Reconstruct Itinerary](https://leetcode.com/problems/reconstruct-itinerary) | Medium     |          |
| Advanced Graphs      | [Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points) | Medium     |          |
| Advanced Graphs      | [Swim In Rising Water](https://leetcode.com/problems/swim-in-rising-water) | Hard       |          |
| Advanced Graphs      | [Alien Dictionary](https://leetcode.com/problems/alien-dictionary)  | Hard       |          |
| Advanced Graphs      | [Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops) | Medium     |          |
| 2-D Dynamic Programming | [Unique Paths](https://leetcode.com/problems/unique-paths)         | Medium     |          |
| 2-D Dynamic Programming | [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence) | Medium     |          |
| 2-D Dynamic Programming | [Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown) | Medium     |          |
| 2-D Dynamic Programming | [Coin Change II](https://leetcode.com/problems/coin-change-ii)     | Medium     |          |
| 2-D Dynamic Programming | [Target Sum](https://leetcode.com/problems/target-sum)             | Medium     |          |
| 2-D Dynamic Programming | [Interleaving String](https://leetcode.com/problems/interleaving-string) | Medium     |          |
| 2-D Dynamic Programming | [Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix) | Hard       |          |
| 2-D Dynamic Programming | [Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences) | Hard       |          |
| 2-D Dynamic Programming | [Edit Distance](https://leetcode.com/problems/edit-distance)       | Hard       |          |
| 2-D Dynamic Programming | [Burst Balloons](https://leetcode.com/problems/burst-balloons)     | Hard       |          |
| 2-D Dynamic Programming | [Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching) | Hard       |          |
| Bit Manipulation      | [Single Number](https://leetcode.com/problems/single-number)        | Easy       |          |
| Bit Manipulation      | [Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits)  | Easy       |          |
| Bit Manipulation      | [Counting Bits](https://leetcode.com/problems/counting-bits)        | Medium     |          |
| Bit Manipulation      | [Reverse Bits](https://leetcode.com/problems/reverse-bits)          | Easy       |          |
| Bit Manipulation      | [Missing Number](https://leetcode.com/problems/missing-number)      | Easy       |          |
| Bit Manipulation      | [Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers) | Easy       |          |
| Bit Manipulation      | [Reverse Integer](https://leetcode.com/problems/reverse-integer)    | Medium     |          |
| Math & Geometry       | [Rotate Image](https://leetcode.com/problems/rotate-image)           | Medium     |          |
| Math & Geometry       | [Spiral Matrix](https://leetcode.com/problems/spiral-matrix)         | Medium     |          |
| Math & Geometry       | [Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes) | Medium     |          |
| Math & Geometry       | [Happy Number](https://leetcode.com/problems/happy-number)           | Easy       |          |
| Math & Geometry       | [Plus One](https://leetcode.com/problems/plus-one)                   | Easy       |          |
| Math & Geometry       | [Pow(x, n)](https://leetcode.com/problems/powx-n)                    | Medium     |          |
| Math & Geometry       | [Multiply Strings](https://leetcode.com/problems/multiply-strings)   | Medium     |          |
| Math & Geometry       | [Detect Squares](https://leetcode.com/problems/detect-squares)       | Medium     |          |
