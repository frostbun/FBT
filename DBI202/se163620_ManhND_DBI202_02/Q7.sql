SELECT *
FROM (
    SELECT TOP 5 SubCategoryID, NumberOfProducts = COUNT(SubCategoryID)
    FROM Product
    GROUP BY SubCategoryID
    ORDER BY NumberOfProducts DESC
) Top5
UNION
SELECT *
FROM (
    SELECT TOP 5 SubCategoryID, NumberOfProducts = COUNT(SubCategoryID)
    FROM Product
    GROUP BY SubCategoryID
    ORDER BY NumberOfProducts
) Bot5
ORDER BY NumberOfProducts DESC;
