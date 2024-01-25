SELECT 
    categories.category,
    COALESCE(subquery.accounts_count, 0) AS accounts_count
FROM 
    (
        SELECT 
            CASE
                WHEN income < 20000 THEN 'Low Salary'
                WHEN income BETWEEN 20000 AND 50000 THEN 'Average Salary'
                ELSE 'High Salary'
            END AS category,
            COUNT(*) AS accounts_count
        FROM 
            Accounts
        GROUP BY 
            category
    ) AS subquery
RIGHT JOIN (
    SELECT 'Low Salary' AS category
    UNION SELECT 'Average Salary' AS category
    UNION SELECT 'High Salary' AS category
) AS categories
ON subquery.category = categories.category;
