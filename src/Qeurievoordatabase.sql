USE [master]
GO

/****** Object:  Database [NetflixStatistics]    Script Date: 15-1-2020 11:49:27 ******/
CREATE DATABASE [NetflixStatistics]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'NetflixStatistics', FILENAME = N'D:\Microst SQL server\MSSQL14.MSSQLSERVER\MSSQL\DATA\NetflixStatistics.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'NetflixStatistics_log', FILENAME = N'D:\Microst SQL server\MSSQL14.MSSQLSERVER\MSSQL\DATA\NetflixStatistics_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [NetflixStatistics].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [NetflixStatistics] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [NetflixStatistics] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [NetflixStatistics] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [NetflixStatistics] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [NetflixStatistics] SET ARITHABORT OFF 
GO

ALTER DATABASE [NetflixStatistics] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [NetflixStatistics] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [NetflixStatistics] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [NetflixStatistics] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [NetflixStatistics] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [NetflixStatistics] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [NetflixStatistics] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [NetflixStatistics] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [NetflixStatistics] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [NetflixStatistics] SET  DISABLE_BROKER 
GO

ALTER DATABASE [NetflixStatistics] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [NetflixStatistics] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [NetflixStatistics] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [NetflixStatistics] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [NetflixStatistics] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [NetflixStatistics] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [NetflixStatistics] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [NetflixStatistics] SET RECOVERY FULL 
GO

ALTER DATABASE [NetflixStatistics] SET  MULTI_USER 
GO

ALTER DATABASE [NetflixStatistics] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [NetflixStatistics] SET DB_CHAINING OFF 
GO

ALTER DATABASE [NetflixStatistics] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [NetflixStatistics] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO

ALTER DATABASE [NetflixStatistics] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [NetflixStatistics] SET QUERY_STORE = OFF
GO

ALTER DATABASE [NetflixStatistics] SET  READ_WRITE 
GO
