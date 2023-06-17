SELECT Products.ProductID, ProductName, UnitPrice, Color, TotalOrderedQuantity, NumberOfPurchaseOrders = ISNULL(NumberOfPurchaseOrders, 0)
FROM Products
LEFT JOIN (
	SELECT ProductID, TotalOrderedQuantity = SUM(OrderedQuantity), NumberOfPurchaseOrders = COUNT(PurchaseOrderLineID)
	FROM PurchaseOrderLines
	WHERE (
		SELECT OrderDate
		FROM PurchaseOrders
		WHERE PurchaseOrders.PurchaseOrderID = PurchaseOrderLines.PurchaseOrderID
	) BETWEEN '2013-5-1' AND '2013-5-31'
	GROUP BY ProductID
) NumberOfPurchaseOrdersTable
ON Products.ProductID = NumberOfPurchaseOrdersTable.ProductID
WHERE UnitPrice = 18
AND Color in ('Black', 'White')
ORDER BY TotalOrderedQuantity DESC, ProductName
