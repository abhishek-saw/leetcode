-- LeetCode 584: Find Customer Referee
-- Problem: Get names of customers who were NOT referred by customer with id=2
-- This includes customers with referee_id = NULL
-- Difficulty: Easy
--
-- Solution Approach:
-- - Filter customers where referee_id is NULL OR referee_id != 2
-- - Important: Must check IS NULL explicitly, not just != 2
-- - In SQL, NULL != 2 evaluates to NULL, not TRUE
-- - So we must use OR referee_id IS NULL to include customers with no referee

Create table If Not Exists Customer (id int, name varchar(25), referee_id int);
Truncate table Customer;
insert into Customer (id, name, referee_id) values ('1', 'Will', NULL);
insert into Customer (id, name, referee_id) values ('2', 'Jane', NULL);
insert into Customer (id, name, referee_id) values ('3', 'Alex', '2');
insert into Customer (id, name, referee_id) values ('4', 'Bill', NULL);
insert into Customer (id, name, referee_id) values ('5', 'Zack', '1');
insert into Customer (id, name, referee_id) values ('6', 'Mark', '2');

-- Solution: Filter customers not referred by customer 2 (include NULL values)
select name from Customer where referee_id is null or referee_id!=2;