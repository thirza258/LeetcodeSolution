-- 180. Consecutive Numbers
SELECT num as ConsecutiveNums
FROM (
  SELECT id, num, 
         LEAD(num, 1) OVER (ORDER BY id) as next_num_1,
         LEAD(num, 2) OVER (ORDER BY id) as next_num_2,
         LEAD(id, 1) OVER (ORDER BY id) as next_id_1,
         LEAD(id, 2) OVER (ORDER BY id) as next_id_2
  FROM Logs
) 
WHERE num = next_num_1 AND num = next_num_2 AND next_id_1 = id + 1 AND next_id_2 = id + 2
GROUP BY num
