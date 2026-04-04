# LeetCode SQL Solutions

This directory contains solutions to LeetCode SQL problems covering various SQL concepts including joins, filtering, aggregation, and more.

## Problem Summary

| LeetCode ID | Problem Name | Difficulty | Key Concepts |
|---|---|---|---|
| 175 | Combine Two Tables | Easy | LEFT JOIN, multiple tables |
| 176 | Second Highest Salary | Medium | Subquery, OFFSET, MAX, DISTINCT |
| 577 | Employee Bonus | Easy | LEFT JOIN, WHERE clause with OR |
| 584 | Find Customer Referee | Easy | NULL handling, OR condition |
| 595 | Big Countries | Easy | WHERE clause, OR condition |
| 610 | Triangle Judgement | Easy | CASE statement, arithmetic conditions |
| 1068 | Product Sales Analysis I | Easy | INNER JOIN, multiple tables |
| 1148 | Article Views I | Easy | WHERE clause, DISTINCT |
| 1378 | Replace Employee ID | Easy | LEFT JOIN, NULL values |
| 1683 | Invalid Tweets | Easy | String functions, LENGTH() |
| 1757 | Recyclable and Low Fat Products | Easy | WHERE clause, AND condition |
| 1978 | Employees Whose Manager Left | Easy | WHERE clause, NOT IN, subquery |

## Detailed Solutions

### 1. [Leetcode_175.sql](Leetcode_175.sql) - Combine Two Tables
**Difficulty:** Easy  
**Key Concept:** LEFT JOIN  
**Problem:** Combine person and address information. Persons without addresses should have NULL for city and state.
```sql
SELECT p.firstName, p.lastName, a.city, a.state 
FROM Person p 
LEFT JOIN Address a ON p.personId = a.personId;
```

---

### 2. [Leetcode_176.sql](Leetcode_176.sql) - Second Highest Salary
**Difficulty:** Medium  
**Key Concepts:** Subquery, OFFSET, DISTINCT  
**Problem:** Find the second highest salary. Return NULL if it doesn't exist.
```sql
SELECT (SELECT DISTINCT salary 
        FROM Employee1 
        ORDER BY salary DESC 
        LIMIT 1 OFFSET 1) AS secondhighestsalary;
```

---

### 3. [Leetcode_577.sql](Leetcode_577.sql) - Employee Bonus
**Difficulty:** Easy  
**Key Concept:** LEFT JOIN, NULL handling  
**Problem:** Get employees with bonuses less than 1000 or no bonus.
```sql
SELECT e.name, b.bonus 
FROM Employee e 
LEFT JOIN Bonus b ON e.empId = b.empId 
WHERE b.bonus < 1000 OR b.bonus IS NULL;
```

---

### 4. [Leetcode_584.sql](Leetcode_584.sql) - Find Customer Referee
**Difficulty:** Easy  
**Key Concept:** NULL handling in WHERE clause  
**Problem:** Find customers NOT referred by customer 2.
```sql
SELECT name 
FROM Customer 
WHERE referee_id IS NULL OR referee_id != 2;
```
**Important:** Must explicitly check `IS NULL` because `NULL != 2` evaluates to NULL, not TRUE.

---

### 5. [Leetcode_595.sql](Leetcode_595.sql) - Big Countries
**Difficulty:** Easy  
**Key Concept:** WHERE clause with OR condition  
**Problem:** Find countries with area >= 3M km² OR population >= 25M.
```sql
SELECT name, population, area 
FROM world 
WHERE population >= 25000000 OR area >= 3000000;
```

---

### 6. [Leetcode_610.sql](Leetcode_610.sql) - Triangle Judgement
**Difficulty:** Easy  
**Key Concept:** CASE statement, arithmetic validation  
**Problem:** Determine if three sides form a valid triangle.
```sql
SELECT *, 
  CASE 
    WHEN x+y > z AND y+z > x AND x+z > y THEN 'Yes'
    ELSE 'No'
  END AS triangle
FROM Triangle;
```

---

### 7. [Leetcode_1068.sql](Leetcode_1068.sql) - Product Sales Analysis I
**Difficulty:** Easy  
**Key Concept:** INNER JOIN  
**Problem:** Get product name, year, and price for each sale.
```sql
SELECT p.product_name, s.year, s.price 
FROM Sales s 
INNER JOIN Product p ON p.product_id = s.product_id;
```

---

### 8. [Leetcode_1148.sql](Leetcode_1148.sql) - Article Views I
**Difficulty:** Easy  
**Key Concept:** DISTINCT, WHERE clause  
**Problem:** Find authors who viewed their own articles.
```sql
SELECT DISTINCT author_id AS id 
FROM Views 
WHERE author_id = viewer_id;
```

---

### 9. [Leetcode_1378.sql](Leetcode_1378.sql) - Replace Employee ID
**Difficulty:** Easy  
**Key Concept:** LEFT JOIN, NULL values  
**Problem:** Replace employee ID with unique identifier or NULL.
```sql
SELECT u.unique_id, e.name 
FROM Employees2 e 
LEFT JOIN EmployeeUNI u ON u.id = e.id;
```

---

### 10. [Leetcode_1683.sql](Leetcode_1683.sql) - Invalid Tweets
**Difficulty:** Easy  
**Key Concept:** String function LENGTH()  
**Problem:** Find tweets with content longer than 15 characters.
```sql
SELECT tweet_id 
FROM Tweets 
WHERE LENGTH(content) > 15;
```

---

### 11. [Leetcode_1757.sql](Leetcode_1757.sql) - Recyclable and Low Fat Products
**Difficulty:** Easy  
**Key Concept:** WHERE clause, AND condition  
**Problem:** Find products that are both low fat AND recyclable.
```sql
SELECT product_id 
FROM Products 
WHERE low_fats = 'Y' AND recyclable = 'Y';
```
**Note:** Uses PostgreSQL ENUM types. For MySQL, use CHAR(1) or VARCHAR(1).

---

### 12. [Leetcode_1978.sql](Leetcode_1978.sql) - Employees Whose Manager Left
**Difficulty:** Easy  
**Key Concept:** WHERE clause, NOT IN, subquery  
**Problem:** Find employees with salary < 30000 whose manager no longer works there.
```sql
SELECT employee_id 
FROM Employees1 
WHERE salary < 30000 
  AND manager_id NOT IN (SELECT employee_id FROM Employees1) 
ORDER BY employee_id;
```

---

## Key SQL Concepts Used

### Joins
- **INNER JOIN:** Returns matching records from both tables
- **LEFT JOIN:** Returns all records from left table, matching records from right table

### Filtering
- **WHERE clause:** Filter rows based on conditions
- **NULL handling:** Use `IS NULL` or `IS NOT NULL`, not `= NULL`
- **Arithmetic operators:** `>`, `<`, `>=`, `<=`, `=`, `!=`
- **Logical operators:** `AND`, `OR`, `NOT`, `IN`, `NOT IN`

### Aggregation
- **DISTINCT:** Remove duplicate rows
- **COUNT, MAX, MIN, AVG, SUM:** Aggregate functions

### String Functions
- **LENGTH():** Get string length
- **SUBSTRING():** Extract part of string
- **UPPER(), LOWER():** Case conversion

### Advanced
- **CASE statement:** Conditional logic
- **Subqueries:** Nested SELECT statements
- **OFFSET/LIMIT:** Pagination

## Tips for SQL Interview

1. Always handle NULL values explicitly
2. Use LEFT JOIN when you need to preserve all records from the left table
3. Use INNER JOIN when you only want matching records
4. ORDER BY and LIMIT can help with ranking problems
5. Use CASE statements for conditional output
6. Test with edge cases (NULL values, duplicates, empty sets)

## How to Run

Each file is standalone and contains:
1. Table creation with `CREATE TABLE IF NOT EXISTS`
2. Sample data insertion with `INSERT INTO`
3. The solution query

To run any solution:
```sql
-- Run the entire file in your SQL client (MySQL, PostgreSQL, etc.)
-- Each file is self-contained with its own data
```


