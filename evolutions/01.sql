create table usuario (
		id Int not null AUTO_INCREMENT,
		nome Varchar(50) not null,
		usuario Varchar(30) not null,
		email Varchar(50) not null,
		senha Varchar(255) not null,
        PRIMARY KEY (id)
);
