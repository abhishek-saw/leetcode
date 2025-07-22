Create table If Not Exists Employee1 (id int, salary int);
Truncate table Employee1;
insert into Employee1 (id, salary) values ('1', '100');
insert into Employee1 (id, salary) values ('2', '200');
insert into Employee1 (id, salary) values ('3', '300');
select max(salary) as secondhighestsalary from Employee1
where Employee1.salary<(select max(salary)from Employee1);


select ( select distinct salary
from Employee1 order by salary DESC LIMIT 1 OFFSET 1) as secondhighestsalary ;