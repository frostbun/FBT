CREATE DATABASE Lab4_HE163620;
USE Lab4_HE163620;

-- 1
CREATE TABLE Departments (
    DeptID          VARCHAR(4),
    Name            NVARCHAR(50)    NOT NULL,
    NoOfStudents    INT
);

CREATE TABLE Students (
    StudentID       VARCHAR(4),
    LastName        NVARCHAR(30),
    FirstName       NVARCHAR(10),
    Sex             VARCHAR(1)      CHECK(Sex IN ("M", "F")),
    DateOfBirth     DATE,
    PlaceOfBirth    NVARCHAR(30),
    DeptID          VARCHAR(4),
    Scholarship     FLOAT,
    AverageScore    NUMERIC(4,2)
);

CREATE TABLE Courses (
    CourseID        VARCHAR(4),
    Name            NVARCHAR(35),
    Credits         TINYINT
);

CREATE TABLE Results (
    StudentID       VARCHAR(4),
    CourseID        VARCHAR(4),
    Year            INT,
    Semester        INT,
    Mark            FLOAT(1),
    Grade           VARCHAR(6)
);

INSERT INTO Departments(DeptID, Name)
VALUES
    ("IS", N"Information Systems"),
    ("NC", N"Network and Communication"),
    ("SE", N"Software Engineering"),
    ("CE", N"Computer Engineering"),
    ("CS", N"Computer Science")
;

INSERT INTO Students(StudentID, LastName, FirstName, Sex, DateOfBirth, PlaceOfBirth, DeptID, Scholarship)
VALUES
    ("S001", N"Lê", N"Kim Lan", "F", "23/02/1990", N"Hà Nội", "IS", 130000),
    ("S002", N"Trần", N"Minh Chánh", "M", "24/12/1992", N"Bình Định", "NC", 150000),
    ("S003", N"Lê", N"An Tuyết", "F", "21/02/1991", N"Hải Phòng", "IS", 170000),
    ("S004", N"Trần", N"Anh Tuấn", "M", "20/12/1993", N"TpHCM", "NC", 80000),
    ("S005", N"Trần", N"Thị Mai", "F", "12/08/1991", N"TpHCM", "SE", 0),
    ("S006", N"Lê", N"Thị Thu Thủy", "F", "02/01/1991", N"An Giang", "IS", 0),
    ("S007", N"Nguyễn", N"Kim Thư", "F", "02/02/1992", N"Hà Nội", "SE", 180000),
    ("S008", N"Lê", N"Văn Long", "M", "08/12/1992", N"TpHCM", "IS", 190000)
;

INSERT INTO Courses(CourseID, Name, Credits)
VALUES
    ("DS01", N"Database Systems", 3),
    ("AI01", N"Artificial Intelligence", 3),
    ("CN01", N"Computer Network", 3),
    ("CG01", N"Computer Graphics", 4),
    ("DSA1", N"Data Structures and Algorithms", 4)
;

INSERT INTO Results(StudentID, CourseID, Year, Semester, Mark)
VALUES
    ("S001", "DS01", 2017, 1, 3),
    ("S001", "DS01", 2017, 2, 6),
    ("S001", "AI01", 2017, 1, 4.5),
    ("S001", "AI01", 2017, 2, 6),
    ("S001", "CN01", 2017, 3, 5),
    ("S002", "DS01", 2016, 1, 4.5),
    ("S002", "DS01", 2017, 1, 7)
    ("S002", "CN01", 2016, 3, 10),
    ("S002", "DSA1", 2016, 3, 9),
    ("S003", "DS01", 2017, 1, 2),
    ("S003", "DS01", 2017, 3, 5),
    ("S003", "CN01", 2017, 2, 2.5),
    ("S003", "CN01", 2017, 3, 4),
    ("S004", "DS01", 2017, 3, 4.5),
    ("S004", "DSA1", 2018, 1, 10),
    ("S005", "DS01", 2017, 2, 7),
    ("S005", "CN01", 2017, 2, 2.5),
    ("S005", "CN01", 2018, 1, 5),
    ("S006", "AI01", 2018, 1, 6),
    ("S006", "CN01", 2018, 2, 10)
;

-- 2
UPDATE Departments
SET NoOfStudents = (
    SELECT COUNT(StudentID)
    FROM Students
    WHERE Students.DeptID = Departments.DeptID
);

-- 3
UPDATE Students
SET AverageScore = AVG(
    SELECT MAX(Mark)
    FROM Results
    GROUP BY CourseID, StudentID
);

-- 4
UPDATE Results
SET Grade = "Passed"
WHERE Mark >= 5 AND Mark <= 10;

UPDATE Results
SET Grade = "Failed"
WHERE Mark >= 0 AND Mark < 5;

-- 5
SELECT StudentID, CONCAT(FirstName, " ", LastName) AS Fullname, DateOfBirth, PlaceOfBirth, DeptID, Scholarship
FROM Students
WHERE Scholarship <= 160000
ORDER BY Scholarship DESC;

-- 6
SELECT DeptID, Name AS DepartmentName, StudentID, LastName, FirstName
FROM Departments
FULL OUTER JOIN Students
ON Students.DeptID = Departments.DeptID

-- 7
SELECT Students.StudentID, LastName, FirstName, COUNT(Results.StudentID) AS NumberOfCourses
FROM Students
JOIN Results ON Students.StudentID = Results.StudentID

-- 8

-- 9

-- 10

