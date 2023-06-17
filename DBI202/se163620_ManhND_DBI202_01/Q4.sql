SELECT SubCategoryID = Subcategory.ID, SubCategoryName, NumberOfProducts = COUNT(Product.ID) 
FROM SubCategory, Product
WHERE SubCategory.ID = Product.SubCategoryID
GROUP BY SubCategory.ID, SubCategoryName
HAVING COUNT(Product.ID) > 100
ORDER BY NumberOfProducts DESC;
