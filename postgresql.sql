create table tipo_servico
(
	tps_id serial not null primary key,
	tps_descricao varchar(60)
);	

create table laboratorio_sala
(
	lab_id serial not null primary key,
	lab_nome varchar(40)
);

create table pessoa
(
	pes_id serial not null primary key,
	pes_nome varchar(60),
	pes_cpf_cnpj varchar(18),
	pes_telefone varchar(20),
	pes_email varchar(60),
	pes_funcao varchar(40),
	pes_login varchar(40),
	pes_senha varchar(128),
	pes_perfil varchar(60)
);

create table ordem_servico
(
	ose_id	serial not null primary key,
	tps_id	integer	not null, 
	lab_id	integer not null,
	pes_id_func	integer not null,
	pes_id_cli	integer not null,
	ose_data_emissao	date,
	ose_data_fechamento	date,
	ose_status	varchar(30),
	ose_descricao	text,
	ose_local	varchar(40),
	constraint rel_tiposervico_ordem_servico foreign key(tps_id) references tipo_servico(tps_id),
	constraint rel_labsala_ordemservico foreign key(lab_id) references laboratorio_sala(lab_id),
	constraint rel_funcionario_ordemservico foreign key(pes_id_func) references pessoa(pes_id),
	constraint rel_cliente_ordemservico foreign key(pes_id_cli) references pessoa(pes_id)

);

create table historico
(
	his_id	serial not null primary key,
	ose_id	integer	not null, 
	pes_id	integer not null,
	his_data	date,
	his_status	varchar(30),
	constraint rel_ordemservico_historico foreign key(ose_id) references ordem_servico(ose_id),
	constraint rel_funcionario_historico foreign key(pes_id) references pessoa(pes_id)

);

select * from historico, laboratorio_sala, ordem_servico, pessoa, tipo_servico	;
