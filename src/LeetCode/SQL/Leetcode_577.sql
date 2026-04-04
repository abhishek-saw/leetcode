-- LeetCode 577: Employee Bonus
-- Problem: For each employee, get their name and bonus amount
-- If an employee's bonus is less than 1000 or NULL, include them in results
-- Difficulty: Easy
--
-- Solution Approach:
-- - Use LEFT JOIN to combine Employee and Bonus tables
-- - LEFT JOIN ensures all employees are included
-- - Filter for bonuses < 1000 OR bonus IS NULL (employees without bonuses)
-- - This shows employees who either have low bonuses or no bonus at all

Create table If Not Exists Employee (empId int, name varchar(255), supervisor int, salary int);
Create table If Not Exists Bonus (empId int, bonus int);
Truncate table Employee;
insert into Employee (empId, name, supervisor, salary) values ('3', 'Brad', NULL, '4000');
insert into Employee (empId, name, supervisor, salary) values ('1', 'John', '3', '1000');
insert into Employee (empId, name, supervisor, salary) values ('2', 'Dan', '3', '2000');
insert into Employee (empId, name, supervisor, salary) values ('4', 'Thomas', '3', '4000');
Truncate table Bonus;
insert into Bonus (empId, bonus) values ('2', '500');
insert into Bonus (empId, bonus) values ('4', '2000');

-- Solution: LEFT JOIN to get bonuses and filter for bonus < 1000 or NULL
select e.name, b.bonus from Employee e left join Bonus b on e.empId=b.empId where b.bonus<1000 or b.bonus is null;