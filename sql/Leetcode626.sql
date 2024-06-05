-- 625. Exhange Seats
SELECT
    CASE 
        WHEN MOD(id, 2) = 1 AND id = (SELECT MAX(id) FROM SEAT) THEN id
        WHEN MOD(id, 2) = 1 THEN id + 1
        ELSE id - 1
    END AS id,
    student
    FROM SEAT
    ORDER BY id ASC;