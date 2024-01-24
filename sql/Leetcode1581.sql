SELECT customer_id, COUNT(customer_id) as count_no_trans
FROM Visits AS V 
LEFT JOIN Transactions AS T ON T.visit_id = V.visit_id 
WHERE T.transaction_id IS NULL
GROUP BY v.customer_id
ORDER BY count_no_trans DESC;