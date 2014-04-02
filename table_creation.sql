CREATE TABLE scores(
	gameDate date,
	team1 VARCHAR(55),
	team1score INT,
	team2 VARCHAR(55),
	team2score INT
);

CREATE TABLE teams(
	teamID serial PRIMARY KEY,
	teamName VARCHAR(55)
);

CREATE TABLE games(
	gameDate date,
	team1ID INT,
	team1score INT,
	team2ID INT,
	team2score INT
);

