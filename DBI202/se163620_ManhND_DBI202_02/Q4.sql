SELECT OrderID, OrderDate, TotalAmount
FROM Orders,
    (
        SELECT TotalAmount = SUM(Quantity * SalePrice * (1-Discount)), OrderID
        FROM OrderDetails
        GROUP BY OrderID
    ) TotalAmount
WHERE Orders.ID = TotalAmount.OrderID
    AND TotalAmount > 8000
ORDER BY TotalAmount DESC;
