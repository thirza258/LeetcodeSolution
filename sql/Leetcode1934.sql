# Confirmation Rate
SELECT 
  SignUps.user_id, 
  ROUND((SUM(CASE WHEN action = 'confirmed' THEN 1 ELSE 0 END)::float / COUNT(*))::numeric, 2) AS confirmation_rate
FROM 
  SignUps
LEFT OUTER JOIN 
  Confirmations ON SignUps.user_id = Confirmations.user_id 
GROUP BY 
  SignUps.user_id;
