-- 1321. Restaurant Growth
WITH amounts AS (
    SELECT visited_on, ROUND(SUM(amount), 2) AS sum_amount
    FROM Customer
    GROUP BY visited_on
),
average_amount AS (
    SELECT visited_on, 
           ROUND(AVG(sum_amount) OVER (ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW), 2) AS avg_amount
    FROM amounts
),
days_amount AS (
    SELECT visited_on, 
    ROUND(SUM(sum_amount) OVER (ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW), 2) as amount
    FROM amounts
)
SELECT a.visited_on, 
       c.amount AS amount,
       b.avg_amount AS average_amount
FROM amounts a
JOIN average_amount b ON a.visited_on = b.visited_on
JOIN days_amount c ON a.visited_on = c.visited_on
WHERE a.visited_on >= (
        SELECT (MIN(visited_on) + INTERVAL '6 DAY')
        FROM customer
    )
ORDER BY a.visited_on ASC;
