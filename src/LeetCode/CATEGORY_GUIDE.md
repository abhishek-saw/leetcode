# LeetCode Solutions - Category Guide

This document provides a detailed breakdown of each category with problem counts, key concepts, and learning recommendations.

## 📋 Detailed Category Index

### **1. Array (86 problems)**

**Subcategories:**
- Basic Operations: 15 files
- Searching & Sorting: 20 files
- Two Pointers: 12 files
- Sliding Window: 8 files
- Matrix Problems: 10 files
- Bit Manipulation in Arrays: 5 files
- Advanced Techniques: 16 files

**Key Algorithms:**
- Binary Search
- Two-pointer technique
- Sliding window
- Prefix/Suffix sums
- Merge operations
- Matrix transformations

**Most Important Problems:**
1. `LeetCode1_TwoSum` - Foundation problem
2. `LeetCode4_FindMedianSortedArrays` - Hard array problem
3. `LeetCode53_MaximumSubArray` - Kadane's algorithm
4. `LeetCode238_ProductExceptSelf` - Prefix/suffix
5. `LeetCode239_MaxSlidingWindow` - Sliding window

**Learning Path:**
- Start: Remove duplicates, merge sorted
- Intermediate: Two sum, three sum, sliding window
- Advanced: Median, trapping rain water, maximal rectangle

---

### **2. Linked List (22 problems)**

**Subcategories:**
- Basic Operations: 5 files
- Traversal & Search: 4 files
- Reversal: 4 files
- Merging: 3 files
- Special Cases: 6 files

**Key Algorithms:**
- Pointer manipulation
- Two-pointer (fast/slow)
- Dummy node technique
- Reverse iterative/recursive
- Merge operations

**Most Important Problems:**
1. `LeetCode206_ReverseList` - Basic reversal
2. `LeetCode141_LinkedListCycle` - Cycle detection
3. `LeetCode25_ReverseKGroup` - Advanced reversal
4. `LeetCode23_MergeKLists` - Merge optimization
5. `LeetCode2_AddTwoNumber` - Carry propagation

**Learning Path:**
- Start: Reverse, merge two lists
- Intermediate: Cycle detection, K-group reversal
- Advanced: Merge K lists, reorder list

---

### **3. String (25 problems)**

**Subcategories:**
- Pattern Matching: 6 files
- Palindrome Problems: 5 files
- Anagrams & Permutations: 4 files
- Transformation: 5 files
- Parsing & Conversion: 5 files

**Key Algorithms:**
- Sliding window
- Hash map for frequency
- Two-pointer
- Trie (for some)
- KMP/Pattern matching

**Most Important Problems:**
1. `LeetCode3_LengthOfLongestSubstring` - Sliding window
2. `LeetCode125_IsPalindrome` - Palindrome check
3. `LeetCode567_PermutationString` - Anagram finding
4. `LeetCode76_MinimumWindowSubstring` - Hard substring
5. `LeetCode151_ReverseWordsString` - String manipulation

**Learning Path:**
- Start: Palindrome, reverse, anagram
- Intermediate: Sliding window, longest substring
- Advanced: Minimum window, word ladder, alien dictionary

---

### **4. Trees (49 problems)**

**Subcategories:**
- Traversal: 8 files (inorder, preorder, postorder, level-order)
- Tree Properties: 8 files (symmetric, same, validate)
- Path Problems: 7 files (sum, count, paths)
- Construction: 4 files (build from traversal)
- Modification: 6 files (invert, merge, add row)
- BST Operations: 7 files (search, insert, delete)
- Advanced: 3 files (serialize, LCA, diameter)

**Key Algorithms:**
- DFS (recursive)
- BFS (iterative)
- In-order traversal for BST
- Tree construction
- LCA (Lowest Common Ancestor)

**Most Important Problems:**
1. `LeetCode94_InorderTraversalBT` - Core traversal
2. `LeetCode102_LevelOrderTraversalBT` - BFS
3. `LeetCode105_BuildBTPreIn` - Tree construction
4. `LeetCode236_LCABT` - Lowest common ancestor
5. `LeetCode98_IsValidBST` - BST validation

**Learning Path:**
- Start: Traversals, symmetric/same tree
- Intermediate: Path sum, BST operations, LCA
- Advanced: Serialize/deserialize, construct from traversals

---

### **5. Dynamic Programming (20 problems)**

**Subcategories:**
- 1D DP: 8 files (climbing stairs, house robber)
- 2D DP: 6 files (paths, matrix, coins)
- Subsequence: 3 files (LCS, LPS, word break)
- String DP: 3 files (edit distance, palindrome)

**Key Concepts:**
- Memoization (Top-down)
- Tabulation (Bottom-up)
- State definition
- Recurrence relation

**Most Important Problems:**
1. `LeetCode70_ClimbStairs` - Basic 1D DP
2. `LeetCode198_HouseRobber` - 1D DP constraint
3. `LeetCode322_CoinChange` - Unbounded knapsack
4. `LeetCode72_EditDistance` - 2D DP string
5. `LeetCode1143_LongestCommonSubsequence` - Subsequence

**Learning Path:**
- Start: Climbing stairs, unique paths
- Intermediate: House robber, coin change, word break
- Advanced: Edit distance, distinct subsequences, min cost

---

### **6. Graph (9 problems)**

**Subcategories:**
- Union-Find: 3 files (connected components, parents)
- Shortest Path: 2 files (Dijkstra concepts)
- Graph Traversal: 2 files (DFS, BFS implicit)
- Special Cases: 2 files (star graph, matrix)

**Key Algorithms:**
- Union-Find (Disjoint Set Union)
- Dijkstra's algorithm
- BFS for shortest path
- DFS for connected components

**Most Important Problems:**
1. `LeetCode1334_FindTheCity` - Floyd-Warshall
2. `LeetCode1791_CenterStarGraph` - Graph analysis
3. `LeetCode1579_MaxNumEdgesToRemove` - Union-Find

**Learning Path:**
- Start: Graph basics, Union-Find
- Intermediate: Shortest path, MST
- Advanced: Complex graph algorithms

---

### **7. Backtracking (15 problems)**

**Subcategories:**
- Permutations: 2 files (with/without duplicates)
- Combinations: 2 files (with/without duplicates)
- Subsets: 2 files (all subsets, with duplicates)
- Constraint Problems: 5 files (N-Queens, Sudoku)
- Path Problems: 4 files (combination sum, partition)

**Key Concepts:**
- Recursive branching
- Pruning conditions
- Backtrack/undo operations
- Constraint satisfaction

**Most Important Problems:**
1. `LeetCode46_Permutations` - Basic permutation
2. `LeetCode78_Subsets` - Subset generation
3. `LeetCode77_Combinations` - Combination generation
4. `LeetCode39_CombinationSum` - Combination with constraint
5. `LeetCode51_NQueen` - Constraint satisfaction

**Learning Path:**
- Start: Permutations, combinations, subsets
- Intermediate: Combination sum, partition palindrome
- Advanced: N-Queens, word search, sudoku solver

---

### **8. Hash Maps (20 problems)**

**Subcategories:**
- Frequency Counting: 5 files
- Grouping: 3 files (anagrams, duplicates)
- Lookup: 4 files (intersection, unique)
- Subarray/Substring: 5 files (sum equals K)
- Design: 3 files (cache-like structures)

**Key Techniques:**
- Hash map for frequency
- Hash set for presence
- HashMap with custom objects
- Handling collisions (rarely needed in LeetCode)

**Most Important Problems:**
1. `LeetCode242_ValidAnagram` - Frequency matching
2. `LeetCode287_FindDuplicate` - Duplicate finding
3. `LeetCode560_SubArraySumEqualsK` - Prefix sum with hash
4. `LeetCode349_IntersectionTwoArrays` - Set intersection
5. `LeetCode438_FindAnagrams` - Sliding window + hash

**Learning Path:**
- Start: Valid anagram, duplicate number
- Intermediate: Subarray sum, intersection
- Advanced: Complex frequency problems

---

### **9. Stack (8 problems)**

**Subcategories:**
- Expression Evaluation: 2 files
- Monotonic Stack: 3 files
- Parentheses: 2 files
- Other: 1 file

**Key Concepts:**
- Stack operations (push, pop)
- Monotonic stack pattern
- Expression evaluation
- Bracket matching

**Most Important Problems:**
1. `LeetCode20_IsValid` - Valid parentheses
2. `LeetCode739_DailyTemperatures` - Monotonic stack
3. `LeetCode1190_ReverseParentheses` - Stack manipulation
4. `LeetCode2390_RemoveStars` - Stack operations

**Learning Path:**
- Start: Valid parentheses
- Intermediate: Daily temperatures, remove stars
- Advanced: Expression evaluation, complex monotonic stack

---

### **10. Greedy Algorithm (7 problems)**

**Subcategories:**
- Activity Selection: 2 files
- Assignment: 2 files
- Optimization: 3 files

**Key Concepts:**
- Greedy choice property
- Optimal substructure
- Proof of correctness
- Exchange argument

**Most Important Problems:**
1. `LeetCode455_AssignCookies` - Greedy matching
2. `LeetCode860_LemonadeChange` - State tracking
3. `LeetCode55_JumpGame` - Reachability
4. `LeetCode2037_MinMovesToSeat` - Sorting + greedy

**Learning Path:**
- Start: Assign cookies, jump game
- Intermediate: Lemonade change
- Advanced: Complex optimization problems

---

### **11. Math (13 problems)**

**Subcategories:**
- Number Theory: 3 files (prime, power, palindrome)
- Bit Operations: 2 files
- Modular Arithmetic: 2 files
- Digits: 3 files
- Probability/Simulation: 1 file
- Geometry: 1 file
- Misc: 1 file

**Key Concepts:**
- Prime checking
- Power functions
- Digit manipulation
- GCD/LCM
- Modular arithmetic

**Most Important Problems:**
1. `LeetCode7_ReverseInteger` - Digit manipulation
2. `LeetCode50_PowerXN` - Power calculation
3. `LeetCode69_Sqrt` - Binary search for sqrt
4. `LeetCode204_CountPrimes` - Sieve algorithm
5. `LeetCode9_PalindromeNumber` - Number property

**Learning Path:**
- Start: Palindrome, reverse integer, power of two
- Intermediate: Count primes, sqrt
- Advanced: Complex math problems

---

### **12. Priority Queue / Heap (11 problems)**

**Subcategories:**
- K-th Element: 3 files (largest, smallest)
- Top-K: 2 files (frequent, pairs)
- Heap Operations: 3 files
- Streaming: 1 file
- Optimization: 2 files

**Key Concepts:**
- Min-heap and max-heap
- Heap property maintenance
- Heap sort concept
- Priority ordering

**Most Important Problems:**
1. `LeetCode215_KthLargestElement` - K-th largest
2. `LeetCode347_TopKFrequent` - Top-K frequent
3. `LeetCode703_KthLargestStream` - Streaming K-th
4. `LeetCode373_KSmallestPairs` - K smallest pairs
5. `LeetCode857_MinimumCostToHireKWorkers` - Complex heap

**Learning Path:**
- Start: K-th largest, top-K frequent
- Intermediate: Merge K lists, K smallest pairs
- Advanced: Complex optimization with heaps

---

### **13. SQL (12 problems)**

**Detailed Guide:** See [SQL README](SQL/README.md)

**Categories:**
- Joins: 4 problems (INNER, LEFT)
- Subqueries: 2 problems
- Aggregation: 2 problems
- String Functions: 1 problem
- CASE Statements: 1 problem
- NULL Handling: 1 problem
- Complex: 1 problem

**Key SQL Concepts:**
- JOIN operations
- Subqueries and nesting
- Aggregation functions
- NULL handling
- CASE statements
- String functions

---

### **14. Contest Problems (13 files)**

**Recent Contests:**
- Weekly contests: 8 problems
- Biweekly contests: 5 problems

**Characteristics:**
- Mixed difficulty (mostly easy-medium)
- Varied algorithms
- Recent problem styles
- Good for practice

**Learning Value:**
- Real contest experience
- Time-pressure practice
- Current problem trends

---

### **15. Recursion (1 file)**

- `LeetCode1823_FindTheWinner` - Josephus problem variant

---

### **16. Extra/Miscellaneous (4 files)**

- Various difficulty levels and algorithms
- Can be used as practice material

---

## 🎯 Suggested Study Order

### **Phase 1: Foundations (Weeks 1-4)**
1. Array (Easy) - 20 problems
2. String (Easy) - 10 problems
3. LinkedList (Easy) - 8 problems

### **Phase 2: Core Structures (Weeks 5-8)**
4. Trees (Easy-Medium) - 15 problems
5. Hash Maps (Easy-Medium) - 10 problems
6. Stack (Easy-Medium) - 8 problems

### **Phase 3: Algorithms (Weeks 9-14)**
7. Dynamic Programming (Easy-Medium) - 15 problems
8. Backtracking (Medium) - 10 problems
9. Graph (Medium) - 8 problems

### **Phase 4: Advanced & Specialized (Weeks 15-20)**
10. Hard problems across all categories - 15 problems
11. SQL (if needed) - 12 problems
12. Contest problems - 13 problems

---

## 📊 Problem Difficulty Distribution by Category

```
Easy          Medium        Hard
Array: ████████  ███████░     ██░
String: ████████  ██░░░░░     ██░
LinkedList: █████  ████████    ███
Trees: ██████  ████████    ███░
DP: ███░░░░  █████░░░░    ███░
Graph: ░░░  ███████░  ████
Backtrack: ░░░  ██████░░  ███░
HashMap: ░░░░  ████████    ██░░
Stack: ███░░  ██░░░░░░    ░░░
Greedy: ███░░  ███░░░░░    ░░░
Math: ███░░  ████░░░░    █░░░
PriorityQ: ░░░  ███████░    ███
SQL: ███████░  █░░░░░░  ░░░░░
```

---

## 🏆 Top Problems by Category (Must-Know)

| Category | Problem 1 | Problem 2 | Problem 3 |
|----------|-----------|-----------|-----------|
| Array | TwoSum | MaxSubarray | MergeSorted |
| String | LongestSubstring | Palindrome | Anagram |
| LinkedList | ReverseList | MergeLists | DetectCycle |
| Trees | InorderTraversal | BuildTree | LCA |
| DP | ClimbStairs | HouseRobber | CoinChange |
| Graph | UnionFind | ShortestPath | ConnectedComp |
| Backtrack | Permutations | Subsets | NQueens |
| HashMap | ValidAnagram | FindDuplicate | GroupAnagrams |
| Stack | ValidParentheses | DailyTemps | ReverseParens |
| Greedy | AssignCookies | JumpGame | LemonadeChange |
| Math | ReverseInteger | PalindromeNum | CountPrimes |
| PriorityQ | KthLargest | TopKFrequent | KSmallestPairs |
| SQL | CombineTables | EmployeeBonus | JoinQueries |

---

## 📈 Recommended Daily Practice

### **Daily Schedule (2 hours/day)**
- **30 min**: Review a new concept or problem type
- **60 min**: Solve 2-3 problems (easy-medium)
- **30 min**: Review, optimize, and discuss solutions

### **Weekly Review (2 hours)**
- Revisit 5 challenging problems
- Optimize solutions
- Document learnings

### **Monthly Goals**
- Complete all problems in one category
- Practice all difficulty levels in category
- Teach/explain solutions to others

---

## 🔗 Category Links

- [Array](Array/)
- [String](String/)
- [LinkedList](LinkedList/)
- [Trees](Trees/)
- [DynamicProgramming](DynamicProgramming/)
- [Graph](Graph/)
- [BackTracking](BackTracking/)
- [HashMaps](HashMaps/)
- [Stack](Stack/)
- [GreedyAlgo](GreedyAlgo/)
- [Math](Math/)
- [PriorityQueue](PriorityQueue/)
- [SQL](SQL/)
- [AllLeetCodeContest](AllLeetCodeContest/)
- [Recursion](Recursion/)
- [Xtra](Xtra/)

---

*Last Updated: April 5, 2026*  
*Total Categories: 16*  
*Total Problems: 415+*

