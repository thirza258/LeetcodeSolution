-- 1070. Product Sales Analysis III
WITH first_year as (
    SELECT product_id, MIN(year) as first_sale_year
    From Sales
    GROUP BY product_id
)
SELECT Sales.product_id, Sales.year as first_year, Sales.quantity, Sales.price 
From SALES
INNER JOIN first_year
ON Sales.product_id = first_year.product_id
AND Sales.year = first_year.first_sale_year