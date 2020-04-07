USE [master]
GO
/****** Object:  Database [NetfflixStatistics]    Script Date: 17-1-2020 22:37:13 ******/
CREATE DATABASE [NetfflixStatistics]
 CONTAINMENT = NONE
 
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
/****** Object:  Table [dbo].[Account]    Script Date: 17-1-2020 22:37:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[accountName] [nchar](10) NULL,
	[accountId] [int] NOT NULL,
	[streetName] [nvarchar](50) NULL,
	[houseNumber] [int] NULL,
	[zipcode] [nchar](10) NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[accountId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Episode]    Script Date: 17-1-2020 22:37:13 ******/
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
/****** Object:  Table [dbo].[Movie]    Script Date: 17-1-2020 22:37:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie](
	[genre] [nchar](10) NULL,
	[language] [nchar](10) NULL,
	[ageRating] [nchar](10) NULL,
	[programId] [int] NOT NULL,
 CONSTRAINT [PK_Movie] PRIMARY KEY CLUSTERED 
(
	[programId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Profile]    Script Date: 17-1-2020 22:37:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Profile](
	[profileName] [nvarchar](50) NULL,
	[dateOfBirth] [date] NULL,
	[profileId] [int] NOT NULL,
	[accountID] [int] NULL,
 CONSTRAINT [PK_Profile] PRIMARY KEY CLUSTERED 
(
	[profileId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Program]    Script Date: 17-1-2020 22:37:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Program](
	[programId] [int] NOT NULL,
	[title] [nvarchar](50) NULL,
	[duration] [int] NULL,
	[episodeId] [int] NOT NULL,
	[movieId] [int] NOT NULL,
 CONSTRAINT [PK_Program] PRIMARY KEY CLUSTERED 
(
	[programId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Serie]    Script Date: 17-1-2020 22:37:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Serie](
	[serieId] [int] NOT NULL,
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
/****** Object:  Table [dbo].[WatchedEpisodes]    Script Date: 17-1-2020 22:37:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[WatchedEpisodes](
	[profileId] [int] NOT NULL,
	[programId] [int] NOT NULL,
	[watchedTime] [int] NULL,
 CONSTRAINT [PK_WatchedEpisodes] PRIMARY KEY CLUSTERED 
(
	[profileId] ASC,
	[programId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[WatchedMovies]    Script Date: 17-1-2020 22:37:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[WatchedMovies](
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
ALTER TABLE [dbo].[Program]  WITH CHECK ADD  CONSTRAINT [FK_Program_Episode1] FOREIGN KEY([episodeId])
REFERENCES [dbo].[Episode] ([programId])
GO
ALTER TABLE [dbo].[Program] CHECK CONSTRAINT [FK_Program_Episode1]
GO
ALTER TABLE [dbo].[Program]  WITH CHECK ADD  CONSTRAINT [FK_Program_Movie1] FOREIGN KEY([movieId])
REFERENCES [dbo].[Movie] ([programId])
GO
ALTER TABLE [dbo].[Program] CHECK CONSTRAINT [FK_Program_Movie1]
GO
ALTER TABLE [dbo].[WatchedEpisodes]  WITH CHECK ADD  CONSTRAINT [FK_WatchedEpisodes_Episode] FOREIGN KEY([programId])
REFERENCES [dbo].[Episode] ([programId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[WatchedEpisodes] CHECK CONSTRAINT [FK_WatchedEpisodes_Episode]
GO
ALTER TABLE [dbo].[WatchedEpisodes]  WITH CHECK ADD  CONSTRAINT [FK_WatchedEpisodes_Profile] FOREIGN KEY([profileId])
REFERENCES [dbo].[Profile] ([profileId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[WatchedEpisodes] CHECK CONSTRAINT [FK_WatchedEpisodes_Profile]
GO
ALTER TABLE [dbo].[WatchedMovies]  WITH CHECK ADD  CONSTRAINT [FK_WatchedMovies_Movie] FOREIGN KEY([programId])
REFERENCES [dbo].[Movie] ([programId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[WatchedMovies] CHECK CONSTRAINT [FK_WatchedMovies_Movie]
GO
ALTER TABLE [dbo].[WatchedMovies]  WITH CHECK ADD  CONSTRAINT [FK_WatchedMovies_Profile] FOREIGN KEY([profileId])
REFERENCES [dbo].[Profile] ([profileId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[WatchedMovies] CHECK CONSTRAINT [FK_WatchedMovies_Profile]
GO
ALTER TABLE [dbo].[Program]  WITH CHECK ADD  CONSTRAINT [CK_Program] CHECK  (([episodeId] IS NULL AND [movieId] IS NOT NULL OR [movieId] IS NULL AND [episodeId] IS NULL))
GO
ALTER TABLE [dbo].[Program] CHECK CONSTRAINT [CK_Program]
GO
USE [master]
GO
ALTER DATABASE [NetfflixStatistics] SET  READ_WRITE 
GO
