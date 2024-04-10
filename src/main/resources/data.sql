CREATE TABLE note (
    id int NOT NULL AUTO_INCREMENT,
    title varchar(255),
    body varchar(255),
    PRIMARY KEY (id)
);

INSERT INTO note(title, body) VALUES ('note1', 'contents of note 1');
INSERT INTO note(title, body) VALUES ('note2', 'contents of note 2');
INSERT INTO note(title, body) VALUES ('anote3', 'note 3');