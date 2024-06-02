-- 1164. Product Price at a Given Date
SELECT P.product_id,
COALESCE(
    (SELECT new_price
    FROM Products
    WHERE product_id = P.product_id
    AND change_date <= '2019-08-16'
    ORDER BY change_date DESC
    LIMIT 1),
    10
) as price
FROM (SELECT DISTINCT product_id FROM Products) as P