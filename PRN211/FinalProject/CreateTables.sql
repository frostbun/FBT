USE [master]

DROP DATABASE IF EXISTS [FinalProject];

CREATE DATABASE [FinalProject];

USE [FinalProject];

CREATE TABLE [Events](
	[id] INT PRIMARY KEY IDENTITY(1, 1),
	[name] NVARCHAR(256) NOT NULL,
	[time] DATETIME NOT NULL,
	[repeat] VARCHAR(256) NOT NULL
);

CREATE TABLE [Notifications](
	[id] INT PRIMARY KEY IDENTITY(1, 1),
	[days] INT NOT NULL,
	[hours] INT NOT NULL,
	[minutes] INT NOT NULL,
	[event_id] INT NOT NULL FOREIGN KEY REFERENCES [Events]([id]) ON DELETE CASCADE
);
