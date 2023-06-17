SELECT PurchaseOrderID, SupplierID, OrderDate, DeliveryMethod, ExpectedDeliveryDate
FROM PurchaseOrders
WHERE DeliveryMethod LIKE '%Air Freight%'
ORDER BY DeliveryMethod, OrderDate DESC
