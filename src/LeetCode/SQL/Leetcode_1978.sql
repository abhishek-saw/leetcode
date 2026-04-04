-- LeetCode 1978: Employees Whose Manager Left The Company
-- Problem: Find employees with salary < 30000 whose manager no longer works at the company
-- Difficulty: Easy
--
-- Solution Approach:
-- - Filter employees with salary < 30000
-- - Check if their manager_id is NOT in the list of employee IDs
-- - This means the manager no longer works at the company
-- - Sort results by employee_id in ascending order

Create table If Not Exists Employees1 (employee_id int, name varchar(20), manager_id int, salary int);
Truncate table Employees1;
insert into Employees1 (employee_id, name, manager_id, salary) values ('3', 'Mila', '9', '60301');
insert into Employees1 (employee_id, name, manager_id, salary) values ('12', 'Antonella', NULL, '31000');
insert into Employees1 (employee_id, name, manager_id, salary) values ('13', 'Emery', NULL, '67084');
insert into Employees1 (employee_id, name, manager_id, salary) values ('1', 'Kalel', '11', '21241');
insert into Employees1 (employee_id, name, manager_id, salary) values ('9', 'Mikaela', NULL, '50937');
insert into Employees1 (employee_id, name, manager_id, salary) values ('11', 'Joziah', '6', '28485');

-- Solution: Find employees with salary < 30000 whose manager_id is not an employee
select employee_id from Employees1 where salary <30000 and
manager_id not in (select employee_id from Employees1) order by employee_id ;
