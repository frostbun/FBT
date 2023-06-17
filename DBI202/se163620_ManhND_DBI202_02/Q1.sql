CREATE TABLE Students (
    StudentID       INT             PRIMARY KEY,
    Name            NVARCHAR(50),
    Gender          CHAR(1),
    Address         NVARCHAR(200)
);

CREATE TABLE Teachers (
    TeacherID       INT             PRIMARY KEY,
    Name            NVARCHAR(50),
    Gender          CHAR(1),
    Address         NVARCHAR(200)
);

CREATE TABLE Classes (
    ClassID         INT             PRIMARY KEY,
    GroupID         CHAR(6),
    courseID        CHAR(6),
    NoCredits       INT,
    Semester        CHAR(10),
    year            INT,
    Teacher         INT             FOREIGN KEY REFERENCES Teachers(TeacherID)
);

CREATE TABLE Attend (
    Date            DATE,
    Slot            INT,
    Attend          BIT,
    Student         INT             FOREIGN KEY REFERENCES Students(StudentID),
    Class           INT             FOREIGN KEY REFERENCES Classes(ClassID),
	PRIMARY KEY (Date, Slot, Student, Class)
);
