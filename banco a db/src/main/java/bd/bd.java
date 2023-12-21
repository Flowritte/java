package bd;

public class bd {
    /*
CREATE TABLE Funcionario(
id_funcionario INT NOT NULL AUTO_INCREMENT,
Nombre VARCHAR(64) NOT NULL,
Puesto VARCHAR(32) NOT NULL,
Agencia varchar(32) NOT NULL,
Salario DOUBLE NOT NULL,
clave VARCHAR(4) NOT NULL,
No_documento INT NOT NULL,
UNIQUE KEY id_funcionario_uq(id_funcionario)
);

CREATE TABLE cuentas(
id_cuenta INT NOT NULL ,
Nombre VARCHAR(64) NOT NULL,
telefono VARCHAR(32) NOT NULL,
No_documento INT NOT NULL,
Agencia varchar(32) NOT NULL,
Saldo DOUBLE NOT NULL,
UNIQUE KEY id_cuenta_uq (id_cuenta)
);


CREATE TABLE agencia(
agencia_id INT NOT NULL auto_increment,
control_agencia int not null,
control_cuenta int not null,
UNIQUE KEY id_agencia_uq(agencia_id),
foreign key cuenta_agencia (control_agencia) references cuentas(id_cuenta),
foreign key cuenta_funcionario(control_cuenta) references funcionario(id_funcionario)
);
     */
}
