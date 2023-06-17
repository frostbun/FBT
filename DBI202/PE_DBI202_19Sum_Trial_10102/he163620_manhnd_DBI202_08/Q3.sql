SELECT *
FROM Customer
WHERE CustomerName LIKE 'B%'
	AND (
		SELECT COUNT(ID)
		FROM Orders
		WHERE CustomerID = Customer.ID
			AND MONTH(OrderDate) = 12
			AND YEAR(OrderDate) = 2017
	) > 0
ORDER BY Segment DESC, CustomerName
