CREATE TRIGGER deleteSuppliers
ON Suppliers
AFTER DELETE
AS BEGIN
	SELECT SupplierID, SupplierName, deleted.SupplierCategoryID, SupplierCategoryName
	FROM deleted
	LEFT JOIN SupplierCategories
	ON deleted.SupplierCategoryID = SupplierCategories.SupplierCategoryID
END
