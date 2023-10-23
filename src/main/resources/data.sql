INSERT INTO usuarios (nombres,usuario,password, rol,estado) VALUES ('cesar','cmarcos','$2a$12$Tu4RW5wTbgbYnoZHw4cpiuWUv4kipoN1OoTSQhE7yjh9QMuMwDkjG', 'ROLE_ADMIN', true);

INSERT INTO monedas (descripcion,codigo,cotizacion, estado) VALUES ('SOLES PERUANOS','PEN', 3.14, true);
INSERT INTO monedas (descripcion,codigo,cotizacion, estado) VALUES ('DOLAR ESTADOUNIDENSE','USD',3.87624,true);
INSERT INTO monedas (descripcion,codigo,cotizacion, estado) VALUES ('PESO CHILENO','CLP',243.384,true); 
INSERT INTO monedas (descripcion,codigo,cotizacion, estado) VALUES ('PESO COLOMBIANO','COP',1089.14,true);


INSERT INTO cotizaciones (origen,destino,monto) VALUES (1,2,0.26);
INSERT INTO cotizaciones (origen,destino,monto) VALUES (1,3,0.24);
INSERT INTO cotizaciones (origen,destino,monto) VALUES (2,1,3.87);
INSERT INTO cotizaciones (origen,destino,monto) VALUES (2,3,0.95);
INSERT INTO cotizaciones (origen,destino,monto) VALUES (3,1,0.41);
INSERT INTO cotizaciones (origen,destino,monto) VALUES (3,2,1.06);