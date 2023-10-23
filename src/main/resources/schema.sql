CREATE TABLE IF NOT EXISTS tipo_cambios (id SERIAL PRIMARY KEY, moneda_destino VARCHAR(20), moneda_origen VARCHAR(20), monto DECIMAL(10, 2),nuevo_monto DECIMAL(10, 2) );

CREATE TABLE IF NOT EXISTS monedas (id SERIAL PRIMARY KEY, descripcion VARCHAR(40), codigo VARCHAR(10), cotizacion DECIMAL(10, 2),estado boolean );

CREATE TABLE IF NOT EXISTS cotizaciones (id SERIAL PRIMARY KEY, origen NUMBER ,destino NUMBER , monto DECIMAL(10, 2));

CREATE TABLE IF NOT EXISTS usuarios (id SERIAL PRIMARY KEY, nombres varchar(20), usuario  varchar(20), password varchar(300), rol varchar(15),estado boolean);
