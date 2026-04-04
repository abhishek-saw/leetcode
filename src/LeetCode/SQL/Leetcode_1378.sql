-- LeetCode 1378: Replace Employee ID With The Unique Identifier
-- Problem: Return unique identifier for each employee. If employee has no unique ID, return NULL
-- Difficulty: Easy
--
-- Solution Approach:
-- - Use LEFT JOIN to connect Employees and EmployeeUNI tables
-- - LEFT JOIN ensures all employees are included even if they don't have a unique ID
-- - Preserves NULL values for employees without a unique identifier

Create table If Not Exists Employees2 (id int, name varchar(20));
Create table If Not Exists EmployeeUNI (id int, unique_id int);
Truncate table Employees2;
insert into Employees2 (id, name) values ('1', 'Alice');
insert into Employees2 (id, name) values ('7', 'Bob');
insert into Employees2 (id, name) values ('11', 'Meir');
insert into Employees2 (id, name) values ('90', 'Winston');
insert into Employees2 (id, name) values ('3', 'Jonathan');
Truncate table EmployeeUNI;
insert into EmployeeUNI (id, unique_id) values ('3', '1');
insert into EmployeeUNI (id, unique_id) values ('11', '2');
insert into EmployeeUNI (id, unique_id) values ('90', '3');

-- Solution: LEFT JOIN to get unique ID or NULL for employees without one
select u.unique_id, e.name from Employees2 e left join EmployeeUNI u on u.id=e.id;