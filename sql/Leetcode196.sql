WITH deduplicated_person AS (
    DELETE FROM person p1
    WHERE id NOT IN (
        SELECT MIN(id)
        FROM person p2
        WHERE p1.email = p2.email
        GROUP BY p2.email
    )
    RETURNING *
)
SELECT *
FROM deduplicated_person
ORDER BY id;
