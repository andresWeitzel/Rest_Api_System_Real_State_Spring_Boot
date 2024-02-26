
-- Eliminamos todos los registros de las tablas
-- delete from inmuebles cascade;
-- delete from propietarios_inmuebles cascade;

insert into propietarios_inmuebles (name, last_name, age , birthdate 
, document_type, document_number , address , main_phone_number
, secondary_phone_number , email, created_at, updated_at ) values
('Fabian', 'Gonzalez', 45, '1975/10/09', 'DNI', '45897677', 'San Vicente 879'
, '+549115674', '6578-3786', 'viccentin3k@gmail.com', now(), now());

-- insert into propietarios_inmuebles (name, last_name, age , birthdate 
-- , document_type, document_number , address , main_phone_number
-- , secondary_phone_number , email ) values
-- ('Fabian', 'Gonzalez', 45, '1975/10/09', 'DNI', '45897677', 'San Vicente 879'
-- , '+549115674', '6578-3786', 'viccentin3k@gmail.com'),
-- ('Marcela', 'Sanchez', 49, '1971/12/08', 'DNI', '4298762543', 'San AZUL 222'
-- , '+549117438', '+549117438', 'marcelaSanchez222@gmail.com'),
-- ('Guillermo', 'Zulenski', 65, '1955/10/09', 'DNI', '35897677', 'Av. Callao 879'
-- , '+549115678', '+549115678', 'zulenskiVentas2019@gmail.com'),
-- ('Sofia','Aguilar',56,'1967/11/09','DNI','645738444','Avenida Cordoba 1178'
-- ,'+5484933332','+5484933332','sofiaAguilar@gmail.com'),
-- ('Jos�','Castro',39,'1961/02/11','DNI','281121323','Paseo Col�n 221'
-- ,'+5411882911','+5411882911','joseCastro@gmail.com'),
-- ('Mart�n','Garcia',43,'1968/02/11','DNI','34928119','las asturias 9211'
-- ,'+5411738291', '+5411738291','martin.garcia@gmail.com'),
-- ('Juana','Martinez',52,'1963/12/06','DNI','387617888','vertes 917'
-- ,'+5411758677','+5411758677','ju.martinez@gmail.com'),
-- ('Marcos','Stevia',42,'1971/07/09','DNI','367228333','san sebastian 726'
-- ,'+5411819223','+5411819223','marcosStevia@gmail.com'),
-- ('Osvaldo','Perez',58,'1960/03/22','DNI','349282323','Av. Figueroa Alcorta 278'
-- ,'+5411890631','+5411890631','martin.garcia@gmail.com'),
-- ('Mart�n','Castro',60,'1961/06/11','DNI','35868693','Av. Diaz Velez 1226'
-- ,'+5411726165','+5411726165','martin.Castro@gmail.com');


/*
select * from propietarios_inmuebles;



-- ---------------------------------------------------------------------------
-- ---------------------------------------------------------------------------

-- ---------------------------------------------------------------------------
-- ---------------------------------------------------------------------------

-- ===================================
-- ======= TABLA INMUEBLES ===========
-- ===================================


select * from inmuebles;

select column_name, data_type, is_nullable from 
information_schema.columns where table_name = 'inmuebles';




-- -------------------------------------------------
-- ----------- INSERCI�N DE  REGISTROS ------------
-- -------------------------------------------------


insert into inmuebles (id_propietario_inmueble, descripcion , tipo, estado_inmueble 
, precio_inmueble_usd , direccion , ubicacion , sitio_web) values
('86667c08-28b0-4869-a1e4-e797e0179dac', 'PH de 4 Ambientes, 3 dormis, 2 ba�os, Amplio Espacio,jardin y balcon, Sin Expensas, Lujoso'
, 'PH/Casa','DISPONIBLE', 177.000, 'San Cristobla 456', 'Palermo', 'www.avisosAlInstante.com.ar'),
('902bdda8-086a-47b3-bb38-6cd7010bb5ae', 'Casa 3 Ambientes, 4 Dormitorios, 1 ba�o y Cochera', 'Casa','VENDIDO', 168.000
, 'Aristobulo del Valle 608 ', 'Belgrano', 'www.avisosAlInstante.com.ar'),
('e2610bf9-ebc6-4511-9317-c84d23f22db4' , 'Departamento de 2 Ambientes', 'Departamento','VENDIDO', 110.000, 'Av. Corrientes 112'
, 'Caballito', 'www.avisosAlInstante.com.ar'),
('ca139a54-32d5-4150-b90b-5e2bed4d8f55' , 'Departamento de 1 Ambiente', 'Departamento','DISPONIBLE', 90.000, 'San Juan 332'
, 'Parque Patricios', 'www.avisosAlInstante.com.ar'),
('4ec538e4-6081-48db-82d8-61ba6ec3ab08' , 'Departamento de 3 Ambientes', 'Departamento','DISPONIBLE', 125.000, 'Av Diaz Velez 1233'
, 'Castro Barros', 'www.avisosAlInstante.com.ar'),
('a74f6ca3-77e9-4fa6-af2f-ce8bd6fa89ee' , 'Departamento de 2 Ambientes', 'Departamento','NO_DISPONIBLE', 100.000, 'Av. Corrientes 5462'
, 'Palermo', 'www.avisosAlInstante.com.ar'),
('f0747a8a-5fd4-4c44-9305-a27a455a4274' , 'Casa de 5 Ambientes, 3 Dormitorios, 2 ba�o y 1 Cochera', 'Casa','DISPONIBLE', 230.000, 'San Sebastio 221'
, 'Monte Castro', 'www.avisosAlInstante.com.ar'),
('7d2cabe3-c5ee-4310-80e2-db53e19fc347' , 'Casa con 2 Dormitorios, 1 ba�o y Teraza', 'Casa','DISPONIBLE', 221.000, 'Av. Figueroa Alcorta 1345'
, 'Palermo Soho', 'www.avisosAlInstante.com.ar');



select * from inmuebles;

*/