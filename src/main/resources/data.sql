INSERT INTO servicio (nombre) VALUES ('Servicio 1');
INSERT INTO servicio (nombre) VALUES ('Servicio 2');
INSERT INTO servicio (nombre) VALUES ('Servicio 3');

INSERT INTO especialidad (nombre) VALUES ('Especialidad 1');
INSERT INTO especialidad (nombre) VALUES ('Especialidad 2');
INSERT INTO especialidad (nombre) VALUES ('Especialidad 3');

INSERT INTO tipo_usuario (tipo) VALUES ('Tecnico');
INSERT INTO tipo_usuario (tipo) VALUES ('RRHH');
INSERT INTO tipo_usuario (tipo) VALUES ('Area comercial');
INSERT INTO tipo_usuario (tipo) VALUES ('Mesa de ayuda');

INSERT INTO usuario (tipo_usuario_id, username, password) VALUES (1, 'admin', '1234');

INSERT INTO tipo_problema (tipo) VALUES ('Tipo Problema 1');
INSERT INTO tipo_problema (tipo) VALUES ('Tipo Problema 2');
INSERT INTO tipo_problema (tipo) VALUES ('Tipo Problema 3');

INSERT INTO incidente (nombre, tiempo_resolucion, servicio_id) VALUES ('Incidente 1', '0', '1');
INSERT INTO incidente (nombre, tiempo_resolucion, servicio_id) VALUES ('Incidente 2', '0', '2');
INSERT INTO incidente (nombre, tiempo_resolucion, servicio_id) VALUES ('Incidente 3', '0', '3');


