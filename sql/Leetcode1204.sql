-- 1204. Last Person to Fit in the Bus
WITH cumulative_weight AS (
    SELECT person_name, SUM(weight) OVER (ORDER BY turn ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) as total_weight turn
    FROM Queue
)
SELECT person_name
FROM cumulative_weight
WHERE total_weight <= 1000
ORDER BY turn DESC
LIMIT 1