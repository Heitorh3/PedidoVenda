CREATE TABLE localtrabalho (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

 create table emprestimo (
        id integer not null auto_increment,
        data_devolucao datetime not null,
        data_emprestimo datetime not null,
        descricao varchar(255),
        localdevolucao varchar(255),
        localretirado varchar(255),
        statusEmprestimo varchar(255),
        usuario_id bigint,
        primary key (id)
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

    create table equipamento (
        id bigint not null auto_increment,
        modelo varchar(255),
        patrimonio varchar(255) not null,
        tipoequipamento varchar(255),
        fabricante_id bigint,
        primary key (id)
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
    
    create table fabricante (
        id bigint not null auto_increment,
        nome varchar(80) not null,
        primary key (id)
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
    
    create table item_emprestimo (
        id bigint not null auto_increment,
        emprestimo tinyblob,
        equipamento tinyblob,
        quantidade integer,
        primary key (id)
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
    
    create table usuario (
        id bigint not null auto_increment,
        email varchar(255),
        login varchar(255),
        matricula varchar(255),
        nome varchar(255),
        perfil varchar(255),
        senha varchar(255),
        sexo varchar(255),
        telefone varchar(255),
        localTrabalho_id bigint not null,
        primary key (id)
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
     
    create table usuario_permissao (
        login varchar(255) not null,
        permissao varchar(255),
        codigo_usuario bigint,
        primary key (login)
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
     
    alter table emprestimo 
        add constraint FK_ew9k4vcdbhup8ylwne4tqg94c 
        foreign key (usuario_id) 
        references usuario (id);
 
    alter table equipamento 
        add constraint FK_plhddwea64dgf0aeaml6s2yju 
        foreign key (fabricante_id) 
        references fabricante (id);
    
    alter table item_emprestimo 
        add constraint FK_qlw9vs8y5hyuaqouw038pxv2u 
        foreign key (emprestimo) 
        references emprestimo (id)