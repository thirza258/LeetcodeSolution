SELECT e1.employee_id, e1.department_id 
FROM Employee AS e1
WHERE e1.primary_flag = 'Y' 
   OR (e1.primary_flag = 'N' AND e1.employee_id NOT IN (
       SELECT e2.employee_id 
       FROM Employee AS e2
       WHERE e2.primary_flag = 'Y'
   ) AND e1.employee_id NOT IN (
       SELECT e3.employee_id
       FROM Employee AS e3
       WHERE e3.primary_flag = 'N'
       GROUP BY e3.employee_id
       HAVING COUNT(*) > 1
   ));
