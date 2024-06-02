-- 1045. Customers Who Bought All Products
WITH count_order AS (
    SELECT customer_id, COUNT(DISTINCT product_key) as product_count
    FROM Customer
    GROUP BY customer_id
),
count_product AS (
    SELECT COUNT(DISTINCT product_key) as product_count
    FROM Product
)
SELECT customer_id
FROM count_order
WHERE product_count = (SELECT product_count FROM count_product)