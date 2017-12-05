create table evento (
		id int not null AUTO_INCREMENT,
		nome varchar(50) not null,
		descricao Varchar(200) not null,
        data_inicio Varchar(15) not null,
        data_fim Varchar(15) not null,
        id_criador int not null,
        local_evento varchar(100) not null,
        PRIMARY KEY (id),
        FOREIGN KEY (id) REFERENCES usuario(id)
);
        

