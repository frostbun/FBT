SELECT *
FROM (
    SELECT TOP 5 *
    FROM Product
    ORDER BY UnitPrice DESC
) Top5
UNION
SELECT *
FROM (
    SELECT TOP 5 *
    FROM Product
    ORDER BY UnitPrice
) Bot5
ORDER BY UnitPrice DESC;
