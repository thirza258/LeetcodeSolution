-- Immediate Food Delivery II
WITH first_orders AS (
  SELECT customer_id, MIN(order_date) AS first_order_date
  FROM Delivery
  GROUP BY customer_id
)
SELECT 
  ROUND(
    (COUNT(CASE WHEN D.order_date = D.customer_pref_delivery_date THEN 1 ELSE NULL END)::float 
    / COUNT(*))::numeric * 100, 2
  )  AS immediate_percentage
FROM Delivery D
INNER JOIN first_orders FO
ON D.customer_id = FO.customer_id AND D.order_date = FO.first_order_date;
