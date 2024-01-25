SELECT *
FROM users
WHERE
    mail ~ '^[a-zA-Z][a-zA-Z0-9._-]*@leetcode\.com$';