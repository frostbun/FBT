SELECT *
FROM Orders
WHERE CONVERT(DATE, OrderDate) = (
    SELECT TOP 1 CONVERT(DATE, OrderDate)
    FROM Orders
    ORDER BY OrderDate DESC
);
