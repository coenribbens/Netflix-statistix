/* Om een query uit te voeren: */
/* Stap 1: uncomment de sectie van de qeury die u wilt uitvoeren. */
/* Stap 2: Vervang eventuele vraagtekens met data. De applicatitie zelf maakt gebruik van prepared statements, waar bij de vraagtekens worden vervangen met data. Dit is om veiligheidsredenen. */


  /* Query 1: getAccountById */
-- SELECT * FROM account WHERE accountId = ?

  /* Query 2: getAllAccounts  */
-- SELECT * FROM account

  /* Query 3: getAccountsWithOneProfile  */
-- SELECT * FROM account
-- JOIN (SELECT accountID 
-- FROM profile
-- GROUP BY accountID
-- HAVING COUNT(1) = 1 )AS profileAccounts
-- ON profileAccounts.accountID = account.accountID
 
  /* Query 4: createAccount */
-- INSERT INTO account (accountName, streetName, houseNumber, zipCode)
-- VALUES (?, ?, ?, ?)

  /* Query 5: updateAccount */
-- UPDATE account SET accountName = ?, streetName = ?, houseNumber = ?, zipCode = ? WHERE accountID = ?

  /* Query 6: deleteAccount */
-- DELETE FROM account WHERE accountID = ?

  /* Query 7: getAllEpisodes */
-- SELECT * FROM Episode INNER JOIN Program ON Episode.programId = Program.programId

  /* Query 8: getEpisodesById */
-- SELECT * FROM episode INNER JOIN Program ON Program.programId = episode.programId WHERE Episode.programId = ?
 
  /* Query 9: getEpisodesWatchedByProfile */
-- SELECT * FROM episode INNER JOIN program ON episode.programId = program.programId INNER JOIN watched ON watched.programId = episode.programId 
-- INNER JOIN profile ON profile.profileID = watched.profileID WHERE profile.profileID = ?

  /* Query 10: getAverageWatchTimeForEpisodePerProfile */
-- SELECT * FROM watched WHERE programId = ? AND profileID = ?

  /* Query 11: getAverageWatchTimeForEpisode */
-- SELECT AVG(watchedTime) AS 'gemiddeldBekeken

  /* Query 12: addWatchedPercentage  */
-- INSERT INTO watched(profileID, programId, percentage) VALUES(?, ?, ?)

 /* Query 13: updateWatchedPercentage */
-- UPDATE watched SET percentage = ? WHERE programId = ? AND profileID = ?

  /* Query 14:  */
-- DELETE FROM watched WHERE programID=? AND profileID = ?

  /* Query 15: getEpisodesWatchedPerProfilePerSerie */
-- SELECT Program.programId, title, duration, season FROM Episode
-- INNER JOIN Program ON Episode.programId = Program.episodeId
-- INNER JOIN watched ON watched.programId = Program.programId
-- INNER JOIN Serie ON Serie.serieId = Episode.serieId
-- WHERE profileId = ? AND serie.serieId = ?

  /* Query 16: getAllMovies */
-- SELECT program.programId, title, duration, genre, language, ageRating FROM movie join program on movie.programId = program.movieId

  /* Query 17: getMovieById */
-- SELECT Program.programId, title, duration, genre, language, ageRating
-- FROM Program
-- INNER JOIN Movie ON Movie.programId = Program.movieId
-- WHERE Program.programId = ?

  /* Query 18: getMoviesWatchedByProfile */
-- SELECT * FROM watched WHERE profileId = ?

  /* Query 19: getFullywatchedMovies */
-- select count (profileId)  as DoorHoeveelBekeken from watched
-- join Program on watched.programId = program.programId
-- Where program.programId = ?

  /* Query 20: getLongestMovieForAgeLowerThen16 */
-- select top 1 *
-- from movie
-- join program on movie.programId = program.movieId
-- where program.movieId IS NOT NULL and movie.ageRating < 16
-- ORDER BY DURATION desc 

  /* Query 21: getAllProfiles */
-- SELECT * FROM profile

  /* Query 22: getProfileById */
-- SELECT * FROM profile WHERE profileId = ?

  /* Query 23: createNewProfile */
-- INSERT INTO profile (profileName, dateOfbirth, accountId)
-- VALUES (?, ?, ?)

  /* Query 24: updateProfile */
-- UPDATE profile SET profileName = ?, dateOfBirth = ?, accountId = ? WHERE profileId = ?

  /* Query 25: deleteProfile */
-- DELETE FROM profile
-- WHERE profileId = ?

  /* Query 25: getProfilesOfAccount */
-- SELECT * FROM profile WHERE accountId = ?

/* Qeuries voor de WATCHED tabel */

  /* Query 26: markSeriesAsWatched (if)*/
-- UPDATE watched SET watchedTime = ?
-- WHERE programId = ? AND profileId = ?

  /* Query 27: markSeriesAsWatched (else) */
-- INSERT INTO watched (programId, profileId, watchedTime)
-- VALUES (?, ?, ?)

  /* Query 28: hasMediaBeenWatched */
-- SELECT *
-- FROM watched
-- WHERE programId = ? AND profileId = ?

  /* Query 29: markSeriesAsUnwatched */
-- DELETE FROM watched
-- WHERE programId = ? AND profileId = ?

  /* Query 30: getAllSeries */
-- SELECT * FROM serie

  /* Query 31: getSerieById */
-- SELECT * FROM serie WHERE serieId = ?

  /* Query 32: getAllEpisodesBySerie */
-- SELECT Program.programId, title, duration, season FROM serie
-- INNER JOIN episode ON episode.serieID = serie.serieID
-- INNER JOIN Program ON Program.episodeId = Episode.programId
-- WHERE serie.serieId = ?

  /* Query 33: getAverageWatchTime */
-- SELECT AVG(watchedTime) AS avgPercentage FROM watched
-- INNER JOIN episode ON episode.programId = watched.programId
-- WHERE SerieId = ?

  /* Query 34: getWatchedSeriesByProfile */
-- SELECT DISTINCT serie.serieId, name, ageRating, genre, suggestions FROM serie 
-- INNER JOIN episode ON episode.serieId = serie.serieId 
-- INNER JOIN Program ON Program.episodeId = Episode.programId 
-- INNER JOIN watched ON watched.programId = program.programId 
-- INNER JOIN profile ON profile.profileId = watched.profileId 
-- WHERE profile.profileId = ?

  /* Query 35: updateSerie */
-- UPDATE serie SET serieName = ? WHERE serieId = ?

 
 