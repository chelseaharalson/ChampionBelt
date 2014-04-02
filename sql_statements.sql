INSERT INTO teams(teamName)
SELECT distinct team1 FROM scores;



INSERT INTO games(
	SELECT gameDate, team1.teamID, team1score, team2.teamID, team2score FROM scores
	JOIN teams AS team1 ON team1.teamName = scores.team1
	JOIN teams as team2 on team2.teamName = scores.team2
	ORDER BY gameDate);



SELECT t1.teamName, t2.teamName FROM games as g
JOIN teams AS t1 ON t1.teamID = g.team1ID
JOIN teams as t2 ON t2.teamID = g.team2ID
ORDER BY gameDate;



CREATE OR REPLACE FUNCTION getWinner2(winner int, gDate date)
RETURNS DATE AS $$
BEGIN
  RETURN (
  SELECT g.gameDate
  FROM games AS g
  WHERE g.team2ID = winner AND g.gameDate > gDate
  LIMIT 1);
END;
$$ LANGUAGE plpgsql;



WITH recursive winner(team1ID, gameDate) AS (
SELECT team1ID, gameDate 
FROM games
WHERE team1ID = 23 AND gameDate = '2013-10-29'
UNION ALL
SELECT g.team1ID, g.gameDate
FROM games AS g
JOIN winner AS w ON w.team1ID = g.team2ID
WHERE g.gameDate = getWinner2(w.team1ID, w.gameDate)
)
SELECT * FROM winner
JOIN teams ON teamID = team1ID
WHERE gameDate <= '2013-12-04'
ORDER BY gameDate DESC
LIMIT 1;