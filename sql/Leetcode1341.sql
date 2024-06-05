-- 1341. Movie Rating
(SELECT u.name as results
FROM Users as u
JOIN MovieRating as mr ON u.user_id = mr.user_id
GROUP BY u.name
ORDER BY COUNT(*) DESC, u.name ASC
LIMIT 1)
UNION ALL
(SELECT m.title 
FROM Movies as m
JOIN MovieRating as mr ON m.movie_id = mr.movie_id
WHERE DATE(mr.created_at) BETWEEN '2020-02-01' AND '2020-02-29'
GROUP BY m.title
ORDER BY AVG(mr.rating) DESC, m.title ASC
LIMIT 1);
