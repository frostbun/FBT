SELECT *
FROM (
		SELECT TOP 5 SubCategoryID = ID,
			NumberOfProducts = (
				SELECT COUNT(ID)
				FROM Product
				WHERE SubCategoryID = SubCategory.ID
			)
		FROM SubCategory
		ORDER BY NumberOfProducts DESC
	) Top5
UNION
SELECT *
FROM (
		SELECT TOP 5 SubCategoryID = ID,
			NumberOfProducts = (
				SELECT COUNT(ID)
				FROM Product
				WHERE SubCategoryID = SubCategory.ID
			)
		FROM SubCategory
		ORDER BY NumberOfProducts
	) Bot5
ORDER BY NumberOfProducts DESC
