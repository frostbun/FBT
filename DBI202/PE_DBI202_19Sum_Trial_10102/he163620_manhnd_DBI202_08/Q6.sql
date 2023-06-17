SELECT ProductID = ID, ProductName, NumberOfOrders
FROM Product,
	(
		SELECT ProductID, NumberOfOrders = COUNT(ProductID)
		FROM OrderDetails
		GROUP BY ProductID
	) NumberOfOrdersTable
WHERE Product.ID = ProductID
	AND NumberOfOrders = (
		SELECT TOP 1 COUNT(ProductID)
		FROM OrderDetails
		GROUP BY ProductID
		ORDER BY COUNT(ProductID)
	)
