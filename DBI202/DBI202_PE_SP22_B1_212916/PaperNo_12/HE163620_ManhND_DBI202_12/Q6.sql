SELECT Products.ProductID, ProductName, NumberOfPurchaseOrders
FROM Products
LEFT JOIN (
	SELECT ProductID, NumberOfPurchaseOrders = COUNT(PurchaseOrderLineID)
	FROM PurchaseOrderLines
	GROUP BY ProductID
) NumberOfPurchaseOrdersTable
ON Products.ProductID = NumberOfPurchaseOrdersTable.ProductID
WHERE NumberOfPurchaseOrders >= ALL(
	SELECT COUNT(PurchaseOrderLineID)
	FROM PurchaseOrderLines
	GROUP BY ProductID
)
