SELECT Customer.*
FROM Customer, Orders
WHERE Customer.ID = Orders.CustomerID
    AND CustomerName LIKE 'B%'
    AND YEAR(Orders.OrderDate) = 2017
    AND MONTH(Orders.OrderDate) = 12
ORDER BY Segment DESC, CustomerName;
