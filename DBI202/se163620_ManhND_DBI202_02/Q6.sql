SELECT ProductID, ProductName, NumberOfOrders
FROM Product,
    (
        SELECT NumberOfOrders = COUNT(ProductID), ProductID
        FROM OrderDetails
        GROUP BY ProductID
    ) NumberOfOrders
WHERE Product.ID = NumberOfOrders.ProductID
    AND NumberOfOrders = (
        SELECT TOP 1 COUNT(ProductID)
        FROM OrderDetails
        GROUP BY ProductID
        ORDER BY COUNT(ProductID) ASC
    )
;
