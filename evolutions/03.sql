create table participa (
		id_usuario int not null,
		id_evento int not null,
		avaliacao int null,
		comentario varchar(144) null,
        CONSTRAINT usuario_evento PRIMARY KEY (id_usuario, id_evento)
);
        

