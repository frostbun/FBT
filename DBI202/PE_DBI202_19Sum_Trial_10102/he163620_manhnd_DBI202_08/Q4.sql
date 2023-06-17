SELECT SubCategoryID = ID, SubCategoryName, NumberOfProducts
FROM SubCategory,
	(
		SELECT SubcategoryID, NumberOfProducts = COUNT(ID)
		FROM Product
		GROUP BY SubCategoryID
	) NumberOfProductsTable
WHERE Subcategory.ID = SubCategoryID
	AND NumberOfProducts > 100
ORDER BY NumberOfProducts DESC
