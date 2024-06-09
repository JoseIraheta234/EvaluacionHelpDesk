create table tbUsuarioo(
uuid_Usuario varchar2(50),
correoElectronico varchar2(50),
clave varchar2(50)
);

create table tbTicket(
num_Tiket number,
titulo_Ticket varchar2(50),
descripcion_Ticket varchar(100),
autor_Ticket varchar2(50),
email_Contacto_Autor varchar2(70),
fecha_Creacion_Ticket date,
estado_Ticket varchar2(30),
feche_Finalizacion_Ticket date 
);


