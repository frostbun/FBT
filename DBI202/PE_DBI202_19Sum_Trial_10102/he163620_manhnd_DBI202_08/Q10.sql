INSERT INTO Category(CategoryName)
VALUES ('Sports')

INSERT INTO SubCategory(SubCategoryName, CategoryID)
VALUES
	('Tennis', (SELECT ID FROM Category WHERE CategoryName = 'Sports')),
	('Football', (SELECT ID FROM Category WHERE CategoryName = 'Sports'))
