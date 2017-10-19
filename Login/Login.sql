create database Login;
use login;

create table usuario (
id int  (10) primary key auto_increment,
usuario varchar (20) ,
contrasenia varchar (20) 
);

insert into usuario values(
1, 'Juanito', 'mono'
);