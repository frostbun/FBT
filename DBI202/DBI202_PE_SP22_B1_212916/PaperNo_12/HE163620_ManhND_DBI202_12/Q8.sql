CREATE PROC Proc1(
	@productid				INT,
	@fromDate				DATE,
	@toDate					DATE,
	@totalOrderedQuantity	INT		OUT
) AS BEGIN
	SELECT @totalOrderedQuantity = SUM(OrderedQuantity)
	FROM PurchaseOrderLines
	WHERE ProductID = @productid
	AND (
		SELECT OrderDate
		FROM PurchaseOrders
		WHERE PurchaseOrders.PurchaseOrderID = PurchaseOrderLines.PurchaseOrderID
	) BETWEEN @fromDate AND @toDate
END
