-- LeetCode 1757: Recyclable and Low Fat Products
-- Problem: Find product IDs where the product is low fat AND recyclable
-- Difficulty: Easy
--
-- Solution Approach:
-- - Filter products where both low_fats='Y' AND recyclable='Y'
-- - Uses PostgreSQL ENUM types for yes_no values
-- - Returns product_id of qualifying products
--
-- Note: This solution uses PostgreSQL syntax with ENUM types
-- For MySQL/standard SQL, columns would be CHAR(1) or VARCHAR(1)

-- Create ENUM types first (only once)
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'yes_no') THEN
        CREATE TYPE yes_no AS ENUM ('Y', 'N');
    END IF;
END$$;

-- Create table if not exists
CREATE TABLE IF NOT EXISTS Products (
    product_id INT PRIMARY KEY,
    low_fats yes_no,
    recyclable yes_no
);

-- Truncate table
TRUNCATE TABLE Products;

-- Insert test records
INSERT INTO Products (product_id, low_fats, recyclable) VALUES (0, 'Y', 'N');
INSERT INTO Products (product_id, low_fats, recyclable) VALUES (1, 'Y', 'Y');
INSERT INTO Products (product_id, low_fats, recyclable) VALUES (2, 'N', 'Y');
INSERT INTO Products (product_id, low_fats, recyclable) VALUES (3, 'Y', 'Y');
INSERT INTO Products (product_id, low_fats, recyclable) VALUES (4, 'N', 'N');

SELECT * FROM Products;

-- Solution: Find products that are both low fat AND recyclable
select product_id from Products where low_fats='Y' and recyclable='Y';
