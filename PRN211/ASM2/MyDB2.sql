USE master
GO

Create Database [MyDB2]
GO

USE [MyDB2]
GO
/****** Object:  Table [dbo].[WordType]    Script Date: 08/13/2022 15:17:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[WordType](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[TypeName] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Dictionary]    Script Date: 08/13/2022 15:17:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Dictionary](
	[WordID] [int] IDENTITY(1,1) NOT NULL,
	[Word] [nvarchar](30) NOT NULL,
	[EditDate] [datetime] NOT NULL,
	[Meaning] [nvarchar](max) NOT NULL,
	[ID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[WordID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  ForeignKey [FK__Dictionary__ID__0519C6AF]    Script Date: 08/13/2022 15:17:52 ******/
ALTER TABLE [dbo].[Dictionary]  WITH CHECK ADD FOREIGN KEY([ID])
REFERENCES [dbo].[WordType] ([ID])
GO

SET IDENTITY_INSERT [dbo].[WordType] ON 

INSERT [dbo].[WordType] ([ID], [TypeName]) VALUES (1, N'Nound')
INSERT [dbo].[WordType] ([ID], [TypeName]) VALUES (2, N'Verb')
INSERT [dbo].[WordType] ([ID], [TypeName]) VALUES (3, N'Adjective')
INSERT [dbo].[WordType] ([ID], [TypeName]) VALUES (4, N'Adverb')
SET IDENTITY_INSERT [dbo].[WordType] OFF
GO
SET IDENTITY_INSERT [dbo].[Dictionary] ON 

INSERT [dbo].[Dictionary] ([WordID], [Word], [EditDate], [Meaning],[ID]) VALUES (1, N'Laptop', '2021-01-01', N'Máy tính xách tay',1)
INSERT [dbo].[Dictionary] ([WordID], [Word], [EditDate], [Meaning],[ID]) VALUES (2, N'Love', '2022-02-01', N'Yêu',2)
INSERT [dbo].[Dictionary] ([WordID], [Word], [EditDate], [Meaning],[ID]) VALUES (3, N'Carefully', '2022-12-05', N'Cẩn thận', 3)
INSERT [dbo].[Dictionary] ([WordID], [Word], [EditDate], [Meaning],[ID]) VALUES (4, N'Interesting', '2022-02-09', N'Thú vị', 4)
INSERT [dbo].[Dictionary] ([WordID], [Word], [EditDate], [Meaning],[ID]) VALUES (5, N'PC', '2022-08-04', N'Máy tính cá nhân', 1)
SET IDENTITY_INSERT [dbo].[Dictionary] OFF
GO

