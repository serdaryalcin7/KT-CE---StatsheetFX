DROP TABLE IF EXISTS StatLine;
DROP TABLE IF EXISTS Game;
DROP TABLE IF EXISTS Player;
DROP TABLE IF EXISTS Team;






CREATE TABLE Team(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Player(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    number INT NOT NULL,
    team_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (team_id) REFERENCES Team(id)
);

CREATE TABLE Game(
    id INT NOT NULL AUTO_INCREMENT,
    home_team_id INT NOT NULL,
    guest_team VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (home_team_id) REFERENCES Team(id)
);

CREATE TABLE StatLine(
    id INT NOT NULL AUTO_INCREMENT,
    game_id INT NOT NULL,
    player_id INT NOT NULL,
    FGA2 INT,
    FGM2 INT,
    FGA3 INT,
    FGM3 INT,
    FTA INT,
    FTM INT,
    OREB INT,
    DREB INT,
    TOT INT,
    ASS INT,
    STL INT,
    TOS INT,
    BLK INT,
    PF INT,
    FF INT,
    PTS INT,
    PER INT,
    PRIMARY KEY (id),
    FOREIGN KEY (game_id) REFERENCES Game(id),
    FOREIGN KEY (player_id) REFERENCES Player(id)
);



