SELECT CustomerID = Customer.ID, CustomerName, NumberOfOrders = COUNT(Orders.ID)
FROM Customer, Orders
WHERE Customer.ID = Orders.CustomerID
GROUP BY Customer.ID, CustomerName
HAVING COUNT(Orders.ID) = (
    SELECT TOP 1 COUNT(Orders.ID)
    FROM Orders
    GROUP BY CustomerID
    ORDER BY COUNT(Orders.ID) DESC
);
