SELECT
    ProductID,
    ProductName = (
        SELECT ProductName
        FROM Product
        WHERE Product.ID = ProductID
    ),
    Quantity
FROM OrderDetails
WHERE Quantity >= (
    SELECT MAX(Quantity)
    FROM OrderDetails
);
