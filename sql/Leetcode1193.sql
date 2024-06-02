-- Monthly Transactions I
-- Write your PostgreSQL query statement below
SELECT TO_CHAR(trans_date, 'YYYY-MM') AS month, country, COUNT(*) as trans_count, COUNT(CASE WHEN state = 'approved' THEN 1 ELSE NULL END) as approved_count, SUM(amount) as trans_total_amount, SUM(CASE WHEN state = 'approved' THEN amount ELSE 0 END) as approved_total_amount
FROM Transactions GROUP BY TO_CHAR(trans_date, 'YYYY-MM'), country ORDER BY TO_CHAR(trans_date, 'YYYY-MM'), country;
