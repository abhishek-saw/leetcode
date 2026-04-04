-- LeetCode 1068: Product Sales Analysis I
-- Problem: For each sale, get the product name, year, and price
-- Difficulty: Easy
--
-- Solution Approach:
-- - Use INNER JOIN to combine Sales and Product tables
-- - Match records based on product_id
-- - Returns product details for each sale

Create table If Not Exists Sales (sale_id int, product_id int, year int, quantity int, price int);
Create table If Not Exists Product (product_id int, product_name varchar(10));
Truncate table Sales;
insert into Sales (sale_id, product_id, year, quantity, price) values ('1', '100', '2008', '10', '5000');
insert into Sales (sale_id, product_id, year, quantity, price) values ('2', '100', '2009', '12', '5000');
insert into Sales (sale_id, product_id, year, quantity, price) values ('7', '200', '2011', '15', '9000');
Truncate table Product;
insert into Product (product_id, product_name) values ('100', 'Nokia');
insert into Product (product_id, product_name) values ('200', 'Apple');
insert into Product (product_id, product_name) values ('300', 'Samsung');

-- Solution: Inner join to get product name with sales data
select p.product_name, s.year, s.price from Sales s inner join Product p on p.product_id=s.product_id;