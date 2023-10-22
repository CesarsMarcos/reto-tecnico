CREATE TABLE IF NOT EXISTS tipo_cambio (id SERIAL PRIMARY KEY,descripcion VARCHAR(20), compra decimal, venta decimal);

CREATE TABLE IF NOT EXISTS moneda (id SERIAL PRIMARY KEY,nomDivisa VARCHAR(20), compra decimal, venta decimal);

CREATE TABLE IF NOT EXISTS transaccion (idTransaccion SERIAL PRIMARY KEY, monto decimal, modenaOrigen decimal, monedaDestino decimal, montoFinal decimal);

CREATE TABLE IF NOT EXISTS usuario (id SERIAL PRIMARY KEY, nombres varchar(20), usuario  varchar(20), password varchar(20), estado boolean);