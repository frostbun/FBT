USE [PRJ301_PE_SUMMER_2022_B1]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 7/1/2022 9:57:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[userid] [varchar](150) NOT NULL,
	[password] [varchar](150) NOT NULL,
	[dislayname] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[userid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Application]    Script Date: 7/1/2022 9:57:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Application](
	[aid] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
	[registered_by] [varchar](150) NOT NULL,
	[register_date] [date] NOT NULL,
	[isActive] [bit] NOT NULL,
 CONSTRAINT [PK_Application] PRIMARY KEY CLUSTERED 
(
	[aid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Application_Category]    Script Date: 7/1/2022 9:57:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Application_Category](
	[cid] [int] NOT NULL,
	[aid] [int] NOT NULL,
	[relatedDegree] [float] NOT NULL,
 CONSTRAINT [PK_Application_Category] PRIMARY KEY CLUSTERED 
(
	[cid] ASC,
	[aid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Book]    Script Date: 7/1/2022 9:57:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Book](
	[bid] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
	[added_by] [varchar](150) NOT NULL,
	[added_date] [date] NOT NULL,
	[isOnline] [bit] NOT NULL,
 CONSTRAINT [PK_Book] PRIMARY KEY CLUSTERED 
(
	[bid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Book_Reviewer]    Script Date: 7/1/2022 9:57:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Book_Reviewer](
	[rid] [int] NOT NULL,
	[bid] [int] NOT NULL,
	[rating] [int] NOT NULL,
 CONSTRAINT [PK_Book_Reviewer] PRIMARY KEY CLUSTERED 
(
	[rid] ASC,
	[bid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 7/1/2022 9:57:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[cid] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Reviewer]    Script Date: 7/1/2022 9:57:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reviewer](
	[rid] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Reviewer] PRIMARY KEY CLUSTERED 
(
	[rid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([userid], [password], [dislayname]) VALUES (N'mra', N'mra', N'Mr A')
INSERT [dbo].[Account] ([userid], [password], [dislayname]) VALUES (N'mrb', N'mrb', N'Mr B')
INSERT [dbo].[Account] ([userid], [password], [dislayname]) VALUES (N'mrc', N'mrc', N'Mr C')
INSERT [dbo].[Account] ([userid], [password], [dislayname]) VALUES (N'mrd', N'mrd', N'Mr D')
GO
INSERT [dbo].[Application] ([aid], [name], [registered_by], [register_date], [isActive]) VALUES (1, N'Application 1', N'mra', CAST(N'2022-06-30' AS Date), 1)
INSERT [dbo].[Application] ([aid], [name], [registered_by], [register_date], [isActive]) VALUES (2, N'Application 2', N'mra', CAST(N'2022-05-05' AS Date), 0)
INSERT [dbo].[Application] ([aid], [name], [registered_by], [register_date], [isActive]) VALUES (3, N'Application 3', N'mra', CAST(N'2022-06-15' AS Date), 1)
INSERT [dbo].[Application] ([aid], [name], [registered_by], [register_date], [isActive]) VALUES (4, N'Application 4', N'mrb', CAST(N'2022-06-25' AS Date), 1)
INSERT [dbo].[Application] ([aid], [name], [registered_by], [register_date], [isActive]) VALUES (5, N'Application 5', N'mrb', CAST(N'2022-03-21' AS Date), 0)
GO
INSERT [dbo].[Application_Category] ([cid], [aid], [relatedDegree]) VALUES (1, 1, 6.5)
INSERT [dbo].[Application_Category] ([cid], [aid], [relatedDegree]) VALUES (3, 4, 8)
GO
INSERT [dbo].[Book] ([bid], [name], [added_by], [added_date], [isOnline]) VALUES (1, N'Book 1', N'mra', CAST(N'2022-07-01' AS Date), 1)
INSERT [dbo].[Book] ([bid], [name], [added_by], [added_date], [isOnline]) VALUES (2, N'Book 2', N'mra', CAST(N'2022-06-29' AS Date), 0)
INSERT [dbo].[Book] ([bid], [name], [added_by], [added_date], [isOnline]) VALUES (3, N'Book 3', N'mra', CAST(N'2022-06-29' AS Date), 1)
INSERT [dbo].[Book] ([bid], [name], [added_by], [added_date], [isOnline]) VALUES (4, N'Book 4', N'mrb', CAST(N'2022-05-14' AS Date), 0)
INSERT [dbo].[Book] ([bid], [name], [added_by], [added_date], [isOnline]) VALUES (5, N'Book 5', N'mrc', CAST(N'2022-03-02' AS Date), 1)
GO
INSERT [dbo].[Book_Reviewer] ([rid], [bid], [rating]) VALUES (1, 1, 4)
INSERT [dbo].[Book_Reviewer] ([rid], [bid], [rating]) VALUES (3, 4, 8)
GO
INSERT [dbo].[Category] ([cid], [name]) VALUES (1, N'Education')
INSERT [dbo].[Category] ([cid], [name]) VALUES (2, N'Technology')
INSERT [dbo].[Category] ([cid], [name]) VALUES (3, N'Utilities')
INSERT [dbo].[Category] ([cid], [name]) VALUES (4, N'Game')
GO
INSERT [dbo].[Reviewer] ([rid], [name]) VALUES (1, N'Bob')
INSERT [dbo].[Reviewer] ([rid], [name]) VALUES (2, N'Alex')
INSERT [dbo].[Reviewer] ([rid], [name]) VALUES (3, N'Alice')
INSERT [dbo].[Reviewer] ([rid], [name]) VALUES (4, N'Michael')
GO
ALTER TABLE [dbo].[Application]  WITH CHECK ADD  CONSTRAINT [FK_Application_Account] FOREIGN KEY([registered_by])
REFERENCES [dbo].[Account] ([userid])
GO
ALTER TABLE [dbo].[Application] CHECK CONSTRAINT [FK_Application_Account]
GO
ALTER TABLE [dbo].[Application_Category]  WITH CHECK ADD  CONSTRAINT [FK_Application_Category_Application] FOREIGN KEY([aid])
REFERENCES [dbo].[Application] ([aid])
GO
ALTER TABLE [dbo].[Application_Category] CHECK CONSTRAINT [FK_Application_Category_Application]
GO
ALTER TABLE [dbo].[Application_Category]  WITH CHECK ADD  CONSTRAINT [FK_Application_Category_Category] FOREIGN KEY([cid])
REFERENCES [dbo].[Category] ([cid])
GO
ALTER TABLE [dbo].[Application_Category] CHECK CONSTRAINT [FK_Application_Category_Category]
GO
ALTER TABLE [dbo].[Book]  WITH CHECK ADD  CONSTRAINT [FK_Book_Account] FOREIGN KEY([added_by])
REFERENCES [dbo].[Account] ([userid])
GO
ALTER TABLE [dbo].[Book] CHECK CONSTRAINT [FK_Book_Account]
GO
ALTER TABLE [dbo].[Book_Reviewer]  WITH CHECK ADD  CONSTRAINT [FK_Book_Reviewer_Book] FOREIGN KEY([bid])
REFERENCES [dbo].[Book] ([bid])
GO
ALTER TABLE [dbo].[Book_Reviewer] CHECK CONSTRAINT [FK_Book_Reviewer_Book]
GO
ALTER TABLE [dbo].[Book_Reviewer]  WITH CHECK ADD  CONSTRAINT [FK_Book_Reviewer_Reviewer] FOREIGN KEY([rid])
REFERENCES [dbo].[Reviewer] ([rid])
GO
ALTER TABLE [dbo].[Book_Reviewer] CHECK CONSTRAINT [FK_Book_Reviewer_Reviewer]
GO
