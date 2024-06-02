-- Game Play Analysis IV
WITH first_login AS (
    SELECT player_id, MIN(event_date) as first_login
    FROM Activity
    GROUP BY player_id
),
second_day as (
    SELECT Activity.player_id, event_date
    FROM Activity
    INNER JOIN first_login ON Activity.player_id = first_login.player_id
    WHERE (Activity.event_date - first_login.first_login) = 1
)
SELECT ROUND(
    (SELECT COUNT(DISTINCT player_id) FROM second_day)::numeric 
    / (SELECT COUNT(DISTINCT player_id) FROM Activity), 
    2
) as fraction
