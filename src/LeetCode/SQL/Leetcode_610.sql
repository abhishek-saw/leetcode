-- LeetCode 610: Triangle Judgement
-- Problem: For each set of three sides, determine if they form a valid triangle
-- A valid triangle requires: x + y > z AND y + z > x AND x + z > y
-- Difficulty: Easy
--
-- Solution Approach:
-- - Use CASE statement to validate triangle inequality theorem
-- - Check all three conditions: sum of any two sides must be greater than the third
-- - Return 'Yes' if valid triangle, 'No' otherwise

Create table If Not Exists Triangle (x int, y int, z int);
Truncate table Triangle;
insert into Triangle (x, y, z) values ('13', '15', '30');
insert into Triangle (x, y, z) values ('10', '20', '15');

-- Solution: Use CASE statement to check triangle inequality conditions
select *,
case 
when x+y>z and y+z>x and x+z>y Then 'Yes'
else 'No'
end as triangle
from Triangle;