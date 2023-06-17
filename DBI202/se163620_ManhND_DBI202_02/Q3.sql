SELECT Customer.ID, CustomerName, City, State
FROM Customer, Orders
WHERE Customer.ID = Orders.CustomerID
    AND OrderDate >= '2017-12-5 00:00:00.000'
    AND OrderDate < '2017-12-11 00:00:00.000'
    AND DATEDIFF(DAY, OrderDate, Shipdate) < 3
ORDER BY State, City DESC;
