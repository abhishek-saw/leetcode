-- LeetCode 175: Combine Two Tables
-- Problem: Get person's first name, last name, city, and state from Person and Address tables
-- For people without an address, city and state should be NULL
-- Difficulty: Easy
--
-- Solution Approach:
-- - Use LEFT JOIN to combine Person and Address tables
-- - LEFT JOIN ensures all persons are included even if they don't have an address
-- - Returns first name, last name, city, and state

Create table If Not Exists Person (personId int, firstName varchar(255), lastName varchar(255));
Create table If Not Exists Address (addressId int, personId int, city varchar(255), state varchar(255));
Truncate table Person;
insert into Person (personId, lastName, firstName) values ('1', 'Wang', 'Allen');
insert into Person (personId, lastName, firstName) values ('2', 'Alice', 'Bob');
Truncate table Address;
insert into Address (addressId, personId, city, state) values ('1', '2', 'New York City', 'New York');
insert into Address (addressId, personId, city, state) values ('2', '3', 'Leetcode', 'California');

select * from Person;
select * from Address;

-- Solution: LEFT JOIN to combine person info with address (or NULL if no address)
select p.firstName,p.lastName,a.city,a.state from Person p left join Address a on p.personId=a.personId;