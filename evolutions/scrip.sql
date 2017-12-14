create schema eventapp;
USE eventapp;

-- Criando a tabela "usuario" --
create table usuario (
		id Int not null AUTO_INCREMENT,
		nome Varchar(50) not null,
		usuario Varchar(30) not null unique
		email Varchar(50) not null,
		senha Varchar(255) not null,
        PRIMARY KEY (id)
);

-- Criando a tabela "evento" --
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
  
-- Criando a tabela "participa" --      
create table participa (
		id_usuario int not null,
		id_evento int not null,
		avaliacao int null,
		comentario varchar(144) null,
        CONSTRAINT usuario_evento PRIMARY KEY (id_usuario, id_evento)
);
        

