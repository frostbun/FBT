CREATE TRIGGER InsertSubCategory
ON Subcategory
FOR INSERT
AS BEGIN
	SELECT SubCategoryName,
		CategoryName = (
			SELECT CategoryName
			FROM Category
			WHERE Category.ID = CategoryID
		)
	FROM inserted
END
