USE [master]
GO
/****** Object:  Database [NetfflixStatistics]    Script Date: 12-4-2020 14:28:33 ******/
CREATE DATABASE [NetfflixStatistics]
 CONTAINMENT = NONE
GO
ALTER DATABASE [NetfflixStatistics] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [NetfflixStatistics].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [NetfflixStatistics] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET ARITHABORT OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [NetfflixStatistics] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [NetfflixStatistics] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET  DISABLE_BROKER 
GO
ALTER DATABASE [NetfflixStatistics] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [NetfflixStatistics] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET RECOVERY FULL 
GO
ALTER DATABASE [NetfflixStatistics] SET  MULTI_USER 
GO
ALTER DATABASE [NetfflixStatistics] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [NetfflixStatistics] SET DB_CHAINING OFF 
GO
ALTER DATABASE [NetfflixStatistics] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [NetfflixStatistics] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [NetfflixStatistics] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'NetfflixStatistics', N'ON'
GO
ALTER DATABASE [NetfflixStatistics] SET QUERY_STORE = OFF
GO
USE [NetfflixStatistics]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 12-4-2020 14:28:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[accountName] [nvarchar](50) NULL,
	[accountId] [int] IDENTITY(1,1) NOT NULL,
	[streetName] [nvarchar](50) NULL,
	[houseNumber] [nvarchar](50) NULL,
	[zipcode] [nvarchar](50) NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[accountId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Episode]    Script Date: 12-4-2020 14:28:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Episode](
	[season] [int] NULL,
	[programId] [int] NOT NULL,
	[serieId] [int] NULL,
 CONSTRAINT [PK_Episode] PRIMARY KEY CLUSTERED 
(
	[programId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movie]    Script Date: 12-4-2020 14:28:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie](
	[genre] [nvarchar](50) NULL,
	[language] [nvarchar](50) NULL,
	[ageRating] [nvarchar](50) NULL,
	[programId] [int] NOT NULL,
 CONSTRAINT [PK_Movie] PRIMARY KEY CLUSTERED 
(
	[programId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Profile]    Script Date: 12-4-2020 14:28:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Profile](
	[profileName] [nvarchar](50) NULL,
	[dateOfBirth] [date] NULL,
	[profileId] [int] IDENTITY(1,1) NOT NULL,
	[accountID] [int] NULL,
 CONSTRAINT [PK_Profile] PRIMARY KEY CLUSTERED 
(
	[profileId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Program]    Script Date: 12-4-2020 14:28:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Program](
	[programId] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](50) NULL,
	[duration] [int] NULL,
	[episodeId] [int] NULL,
	[movieId] [int] NULL,
 CONSTRAINT [PK_Program] PRIMARY KEY CLUSTERED 
(
	[programId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Serie]    Script Date: 12-4-2020 14:28:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Serie](
	[serieId] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[ageRating] [int] NULL,
	[genre] [nvarchar](50) NULL,
	[suggestions] [nvarchar](50) NULL,
 CONSTRAINT [PK_Serie] PRIMARY KEY CLUSTERED 
(
	[serieId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[watched]    Script Date: 12-4-2020 14:28:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[watched](
	[programId] [int] NOT NULL,
	[profileId] [int] NOT NULL,
	[watchedTime] [int] NULL,
 CONSTRAINT [PK_WatchedMovies] PRIMARY KEY CLUSTERED 
(
	[programId] ASC,
	[profileId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([accountName], [accountId], [streetName], [houseNumber], [zipcode]) VALUES (N'Familie_Thomas', 1, N'Kerklaan', N'35', N'4451BE')
INSERT [dbo].[Account] ([accountName], [accountId], [streetName], [houseNumber], [zipcode]) VALUES (N'Familie_Coen', 2, N'Iritlaan', N'100', N'5562AC')
INSERT [dbo].[Account] ([accountName], [accountId], [streetName], [houseNumber], [zipcode]) VALUES (N'Familie_Marcello', 3, N'Molenstraat', N'221', N'4431NA')
INSERT [dbo].[Account] ([accountName], [accountId], [streetName], [houseNumber], [zipcode]) VALUES (N'John_Doe_Account', 7, N'Frazistraat', N'22', N'5030AM')
SET IDENTITY_INSERT [dbo].[Account] OFF
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 1, 1)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 2, 1)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 3, 1)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 4, 1)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 5, 1)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 6, 1)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (3, 7, 1)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (3, 8, 1)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (3, 9, 1)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 10, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 11, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 12, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 13, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 14, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 15, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 16, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 17, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 18, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 19, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 20, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 21, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 22, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 23, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 24, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 25, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 26, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 27, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 28, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 29, 2)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 30, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 31, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 32, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 33, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 34, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 35, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 36, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 37, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 38, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (1, 39, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 40, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 41, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 42, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 43, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 44, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 45, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 46, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 47, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 48, 3)
INSERT [dbo].[Episode] ([season], [programId], [serieId]) VALUES (2, 49, 3)
INSERT [dbo].[Movie] ([genre], [language], [ageRating], [programId]) VALUES (N'Detective ', N'Engels    ', N'12        ', 1)
INSERT [dbo].[Movie] ([genre], [language], [ageRating], [programId]) VALUES (N'Humor     ', N'Engels    ', N'12        ', 2)
INSERT [dbo].[Movie] ([genre], [language], [ageRating], [programId]) VALUES (N'Misdaad', N'Engels-Amerikaans', N'16        ', 3)
INSERT [dbo].[Movie] ([genre], [language], [ageRating], [programId]) VALUES (N'Erotiek', N'Nederlands', N'18', 4)
INSERT [dbo].[Movie] ([genre], [language], [ageRating], [programId]) VALUES (N'Misdaad', N'Engels-Amerikaans', N'16', 5)
INSERT [dbo].[Movie] ([genre], [language], [ageRating], [programId]) VALUES (N'Western', N'Engels-Amerikaans', N'12', 6)
INSERT [dbo].[Movie] ([genre], [language], [ageRating], [programId]) VALUES (N'Humor', N'Engels-Amerikaans', N'16', 7)
INSERT [dbo].[Movie] ([genre], [language], [ageRating], [programId]) VALUES (N'Humor', N'Nederlands', N'6', 8)
INSERT [dbo].[Movie] ([genre], [language], [ageRating], [programId]) VALUES (N'Oorlog', N'Duits', N'6', 9)
INSERT [dbo].[Movie] ([genre], [language], [ageRating], [programId]) VALUES (N'Humor', N'Vlaams', N'12', 10)
INSERT [dbo].[Movie] ([genre], [language], [ageRating], [programId]) VALUES (N'SF', N'Engels', N'16', 11)
SET IDENTITY_INSERT [dbo].[Profile] ON 

INSERT [dbo].[Profile] ([profileName], [dateOfBirth], [profileId], [accountID]) VALUES (N'Marcello_Haddeman', CAST(N'1996-07-04' AS Date), 1, 3)
INSERT [dbo].[Profile] ([profileName], [dateOfBirth], [profileId], [accountID]) VALUES (N'Zus_Marcello', CAST(N'1995-08-09' AS Date), 2, 3)
INSERT [dbo].[Profile] ([profileName], [dateOfBirth], [profileId], [accountID]) VALUES (N'Thomas_Meeusen', CAST(N'1996-04-11' AS Date), 3, 1)
INSERT [dbo].[Profile] ([profileName], [dateOfBirth], [profileId], [accountID]) VALUES (N'Vader_Thomas', CAST(N'1960-09-11' AS Date), 4, 1)
INSERT [dbo].[Profile] ([profileName], [dateOfBirth], [profileId], [accountID]) VALUES (N'Coen_Ribbens', CAST(N'1999-01-01' AS Date), 5, 2)
INSERT [dbo].[Profile] ([profileName], [dateOfBirth], [profileId], [accountID]) VALUES (N'Oma_Coen', CAST(N'1969-01-09' AS Date), 6, 2)
INSERT [dbo].[Profile] ([profileName], [dateOfBirth], [profileId], [accountID]) VALUES (N'Only_John_Doe', CAST(N'2010-04-08' AS Date), 8, 7)
SET IDENTITY_INSERT [dbo].[Profile] OFF
SET IDENTITY_INSERT [dbo].[Program] ON 

INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (2, N'The Abominable Bride', 89, NULL, 1)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (3, N'The Life of Brian', 94, NULL, 2)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (4, N'Pulp Fiction', 154, NULL, 3)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (5, N'Pruimebloesem', 80, NULL, 4)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (6, N'Reservoir Dogs', 99, NULL, 5)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (7, N'The Good, the Bad and the ugly', 161, NULL, 6)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (8, N'Andy Warhol''s Dracula', 103, NULL, 7)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (9, N'Ober', 97, NULL, 8)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (10, N'Der Untergang', 178, NULL, 9)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (11, N'De helaasheid der dingen', 108, NULL, 10)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (12, N'A Clockwlork Orange', 136, NULL, 11)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (13, N'A Study in Pink
', 88, 1, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (14, N'The Blind Banker', 88, 2, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (15, N'The Great Game
', 88, 3, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (16, N'A Scandal in Belgravia
', 88, 4, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (17, N'The Hounds of Baskerville
', 88, 5, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (18, N'The Reichenbach Fall
', 88, 6, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (19, N'The Reichenbach Fall
The Empty Hearse
', 88, 7, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (20, N'The Sign of Three
', 88, 8, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (21, N'His Last Vow
', 88, 9, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (22, N'Pilot
', 48, 10, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (23, N'Cat’s in the Bag…
', 48, 11, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (24, N'…And the Bag’s in the River
', 48, 12, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (25, N'Cancer Man
', 48, 13, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (26, N'Gray Matter
', 48, 14, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (27, N'Crazy Handful of Nothin’
', 48, 15, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (28, N'A No-Rough-Stuff-Type Deal
', 48, 16, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (29, N'Seven Thirty-Seven
', 48, 17, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (30, N'Grilled
', 48, 18, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (31, N'Bit by a Dead Bee
', 48, 19, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (32, N'Down', 48, 20, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (33, N'Breakage', 48, 21, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (34, N'Peekaboo', 48, 22, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (35, N'Negro Y Azul
', 48, 23, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (36, N'Better Call Saul
', 48, 24, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (37, N'4 Days Out
', 48, 25, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (38, N'Over', 48, 26, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (39, N'Mandala', 48, 27, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (40, N'Phoenix', 48, 28, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (41, N'ABQ', 48, 29, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (42, N'The Crocodile''s Dilemma
', 68, 30, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (43, N'The Rooster Prince
', 68, 31, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (44, N'A Muddy Road
', 68, 32, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (45, N'Eating the Blame
', 68, 33, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (46, N'The Six Ungraspables
', 68, 34, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (47, N'Buridan''s Ass

', 68, 35, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (48, N'Who Shaves the Barber?', 68, 36, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (49, N'The Heap', 68, 37, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (50, N'A Fox, a Rabbit, and a Cabbage', 68, 38, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (51, N'Morton''s Fork', 68, 39, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (52, N'Waiting for Dutch
', 68, 40, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (53, N'Before the Law
', 68, 41, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (54, N'The Myth of Sisyphus
', 68, 42, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (55, N'The Gift of the Magi
', 68, 43, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (56, N'Fear and Trembling
', 68, 44, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (57, N'Rhinoceros
', 68, 45, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (58, N'Did you do this? No, you did it!
', 68, 46, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (59, N'Loplop
', 68, 47, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (60, N'The Castle', 68, 48, NULL)
INSERT [dbo].[Program] ([programId], [title], [duration], [episodeId], [movieId]) VALUES (61, N'The Palindrome', 68, 49, NULL)
SET IDENTITY_INSERT [dbo].[Program] OFF
SET IDENTITY_INSERT [dbo].[Serie] ON 

INSERT [dbo].[Serie] ([serieId], [name], [ageRating], [genre], [suggestions]) VALUES (1, N'Sherlock', 12, N'Detective', N'Fargo')
INSERT [dbo].[Serie] ([serieId], [name], [ageRating], [genre], [suggestions]) VALUES (2, N'Breaking Bad', 16, N'Spanning', N'Fargo')
INSERT [dbo].[Serie] ([serieId], [name], [ageRating], [genre], [suggestions]) VALUES (3, N'Fargo', 16, N'Spanning', N'Breaking Bad')
SET IDENTITY_INSERT [dbo].[Serie] OFF
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (2, 2, 19)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (2, 3, 122)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (3, 5, 94)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (4, 2, 33)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (5, 8, 80)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (6, 1, 45)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (6, 6, 103)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (7, 1, 161)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (7, 3, 161)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (7, 5, 161)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (10, 1, 178)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (10, 3, 175)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (10, 4, 108)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (10, 5, 100)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (10, 6, 178)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (13, 1, 88)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (13, 3, 77)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (13, 4, 88)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (13, 6, 88)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (14, 1, 88)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (14, 3, 88)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (14, 6, 24)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (15, 1, 88)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (16, 1, 88)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (17, 1, 88)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (18, 1, 85)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (18, 6, 88)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (19, 1, 88)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (19, 6, 40)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (20, 1, 87)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (20, 3, 79)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (21, 3, 80)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (22, 1, 48)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (22, 6, 25)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (23, 2, 34)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (23, 5, 48)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (24, 1, 47)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (25, 1, 48)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (26, 2, 48)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (27, 2, 44)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (29, 1, 47)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (30, 1, 47)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (33, 5, 99)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (36, 3, 47)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (36, 4, 17)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (37, 1, 47)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (39, 6, 17)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (41, 6, 14)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (44, 2, 63)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (44, 4, 55)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (48, 3, 62)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (51, 1, 68)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (52, 2, 26)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (53, 5, 26)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (53, 8, 31)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (54, 2, 26)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (56, 2, 32)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (57, 8, 32)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (59, 6, 20)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (60, 5, 20)
INSERT [dbo].[watched] ([programId], [profileId], [watchedTime]) VALUES (61, 5, 32)
ALTER TABLE [dbo].[Episode]  WITH CHECK ADD  CONSTRAINT [FK_Episode_Serie] FOREIGN KEY([serieId])
REFERENCES [dbo].[Serie] ([serieId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Episode] CHECK CONSTRAINT [FK_Episode_Serie]
GO
ALTER TABLE [dbo].[Profile]  WITH CHECK ADD  CONSTRAINT [FK_Profile_Account] FOREIGN KEY([accountID])
REFERENCES [dbo].[Account] ([accountId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Profile] CHECK CONSTRAINT [FK_Profile_Account]
GO
ALTER TABLE [dbo].[Program]  WITH CHECK ADD  CONSTRAINT [FK_Program_Episode] FOREIGN KEY([episodeId])
REFERENCES [dbo].[Episode] ([programId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Program] CHECK CONSTRAINT [FK_Program_Episode]
GO
ALTER TABLE [dbo].[Program]  WITH CHECK ADD  CONSTRAINT [FK_Program_Movie1] FOREIGN KEY([movieId])
REFERENCES [dbo].[Movie] ([programId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Program] CHECK CONSTRAINT [FK_Program_Movie1]
GO
ALTER TABLE [dbo].[watched]  WITH CHECK ADD  CONSTRAINT [FK_watched_Program] FOREIGN KEY([programId])
REFERENCES [dbo].[Program] ([programId])
GO
ALTER TABLE [dbo].[watched] CHECK CONSTRAINT [FK_watched_Program]
GO
ALTER TABLE [dbo].[watched]  WITH CHECK ADD  CONSTRAINT [FK_WatchedMovies_Profile] FOREIGN KEY([profileId])
REFERENCES [dbo].[Profile] ([profileId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[watched] CHECK CONSTRAINT [FK_WatchedMovies_Profile]
GO
ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [CK_Account] CHECK  ((isnumeric(left([houseNumber],(1)))=(1)))
GO
ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [CK_Account]
GO
ALTER TABLE [dbo].[Program]  WITH NOCHECK ADD  CONSTRAINT [CK_Program] CHECK  (([episodeId] IS NULL AND [movieId] IS NOT NULL OR [movieId] IS NULL AND [episodeId] IS NOT NULL))
GO
ALTER TABLE [dbo].[Program] CHECK CONSTRAINT [CK_Program]
GO
USE [master]
GO
ALTER DATABASE [NetfflixStatistics] SET  READ_WRITE 
GO
