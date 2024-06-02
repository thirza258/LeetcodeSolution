--185. Department Top Three Salaries
SELECT 
    Department.name AS Department,
    emp1.name AS Employee,
    emp1.salary 
FROM
    Employee emp1 JOIN Department
ON 
    emp1.departmentId = Department.Id 
WHERE 
    3 > (
        SELECT 
            COUNT(DISTINCT emp2.salary)
        FROM 
            Employee emp2
        WHERE 
            emp2.salary > emp1.salary
            AND
            emp1.DepartmentId = emp2.DepartmentId
    );