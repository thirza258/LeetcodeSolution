-- 602. Friend Requests II: Who Has the Most Friends
SELECT id, COUNT(*) as num
FROM (
    SELECT requester_id as id FROM RequestAccepted
    UNION ALL 
    SELECT accepter_id as id FROM RequestAccepted
) as all_ids
GROUP BY id
ORDER BY num DESC
LIMIT 1;
