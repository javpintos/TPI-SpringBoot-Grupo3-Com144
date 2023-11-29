INSERT INTO servicio (nombre) VALUES ('Soporte Operativo Aplicaciones');
INSERT INTO servicio (nombre) VALUES ('Soporte Operativo Sistemas Operativos');
INSERT INTO servicio (nombre) VALUES ('Soporte Hardware');

INSERT INTO especialidad (nombre) VALUES ('Windows');
INSERT INTO especialidad (nombre) VALUES ('MacOS');
INSERT INTO especialidad (nombre) VALUES ('Linux Ubuntu');
INSERT INTO especialidad (nombre) VALUES ('SAP');
INSERT INTO especialidad (nombre) VALUES ('TANGO');

INSERT INTO tipo_usuario (tipo) VALUES ('Tecnico');
INSERT INTO tipo_usuario (tipo) VALUES ('RRHH');
INSERT INTO tipo_usuario (tipo) VALUES ('Area comercial');
INSERT INTO tipo_usuario (tipo) VALUES ('Mesa de ayuda');

INSERT INTO usuario (tipo_usuario_id, username, password) VALUES (1, 'javierpintos', '1234');
INSERT INTO usuario (tipo_usuario_id, username, password) VALUES (2, 'luciana', '1234');

INSERT INTO tipo_problema (tipo, tiempo) VALUES ('Preventivo',7);
INSERT INTO tipo_problema (tipo, tiempo) VALUES ('Correctivo',7);
INSERT INTO tipo_problema (tipo, tiempo) VALUES ('Adaptativo',7);

INSERT INTO incidente (nombre, tiempo_resolucion, servicio_id) VALUES ('Instalación de software', '1', '1');
INSERT INTO incidente (nombre, tiempo_resolucion, servicio_id) VALUES ('Recuperacion de Datos', '7', '1');
INSERT INTO incidente (nombre, tiempo_resolucion, servicio_id) VALUES ('Correción de Problemas', '3', '1');
INSERT INTO incidente (nombre, tiempo_resolucion, servicio_id) VALUES ('Mejorar Rendimiento', '2', '1');
INSERT INTO incidente (nombre, tiempo_resolucion, servicio_id) VALUES ('Actualización', '3', '1');
INSERT INTO incidente (nombre, tiempo_resolucion, servicio_id) VALUES ('Instalación de softwares', '1', '2');
INSERT INTO incidente (nombre, tiempo_resolucion, servicio_id) VALUES ('Recuperacion de Datos', '7', '2');
INSERT INTO incidente (nombre, tiempo_resolucion, servicio_id) VALUES ('Correción de Problemas', '3', '2');
INSERT INTO incidente (nombre, tiempo_resolucion, servicio_id) VALUES ('Mejorar Rendicmiento', '2', '2');
INSERT INTO incidente (nombre, tiempo_resolucion, servicio_id) VALUES ('Actualizacion', '3', '2');


