-- LeetCode 176: Second Highest Salary
-- Problem: Find the second highest salary in the Employee table
-- If there is no second highest salary, return NULL
-- Difficulty: Medium
--
-- Solution Approaches:
-- Approach 1: Find max salary that is less than the overall max salary
-- Approach 2: Use OFFSET with ORDER BY to get second highest distinct salary

Create table If Not Exists Employee1 (id int, salary int);
Truncate table Employee1;
insert into Employee1 (id, salary) values ('1', '100');
insert into Employee1 (id, salary) values ('2', '200');
insert into Employee1 (id, salary) values ('3', '300');

-- Approach 1: Find salary less than max salary
select max(salary) as secondhighestsalary from Employee1
where Employee1.salary<(select max(salary)from Employee1);

-- Approach 2: Use OFFSET to skip the highest and get the second one
select ( select distinct salary
from Employee1 order by salary DESC LIMIT 1 OFFSET 1) as secondhighestsalary ;