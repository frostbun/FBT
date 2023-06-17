SELECT Suppliers.SupplierID, SupplierName,
    NumberOfPurchaseOrders = COUNT(PurchaseOrders.PurchaseOrderID),
    TotalOrderedQuantity = SUM(OrderedQuantity)
FROM Suppliers
LEFT JOIN PurchaseOrders
ON Suppliers.SupplierID = PurchaseOrders.SupplierID
LEFT JOIN PurchaseOrderLines
ON PurchaseOrders.PurchaseOrderID = PurchaseOrderLines.PurchaseOrderID
GROUP BY Suppliers.SupplierID, SupplierName
ORDER BY NumberOfPurchaseOrders DESC, SupplierName
