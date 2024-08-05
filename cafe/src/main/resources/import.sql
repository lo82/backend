INSERT INTO usuario(apellido, email,estado ,foto, nombre, nombre_usuario, password, rut,tipo,timer) VALUES ('alexis', 'a@a.a','inactivo','5b1ab969-8c7d-4a0b-a26b-4ffd24227183_2023-04-01-19_21_55.8080100.jpg','alexis' ,'alexis' , '$2a$10$g1NiG2AiQpTxg/a8HkvB.ObqopcO1QCk76jywtelrv17BMpulR4F2', '123456','admin',0);
	
INSERT INTO usuario(apellido, email,estado ,foto, nombre, nombre_usuario, password, rut,tipo,timer) VALUES ('mesero', 's@s.s','inactivo','869182d4-a988-426a-9269-38994c869d96_sona_lingerie_by_lifeisafiction_dfcy0nv-fullview.jpg', 'mesero', 'mesero', '$2a$10$1LBaC082dl.Y.WTZpyRoNesxNi/uxtqRXq.1NufvNHyAO2sNnCYJy', '1234569','garzon',0);
	
INSERT INTO usuario(apellido, email,estado ,foto, nombre, nombre_usuario, password, rut,tipo,timer) VALUES ('chica', 'u@u.u','inactivo','a21315e8-39e2-43f7-b7ef-71d3d95487cd_280443466_606102284214511_4304388199877668259_n(1).jpg', 'chica', 'chica','$2a$10$yAO7lcrRfVhpPvdvGucVQONwlewtyA.tvQ1zAXPTVjZj.hJ.UMpbm', '98765432','anfritriona',3600);



INSERT INTO rol (rol_nombre) VALUES ('ROLE_ADMIN'), ('ROLE_CHICA'), ('ROLE_MESERO'), ('ROLE_BAILARIONA');




INSERT INTO usuario_rol(usuario_id, rol_id)	VALUES (1, 1);
INSERT INTO usuario_rol(usuario_id, rol_id)	VALUES (2, 3);
INSERT INTO usuario_rol(usuario_id, rol_id)	VALUES (3, 2);
INSERT INTO usuario_rol(usuario_id, rol_id)	VALUES (4, 3);




INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', 'efectivo', '---','alcohol','0');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','3800', 'devito', 'trago 20 mil','alcohol','20000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','5700', 'credito', 'trago 30 mil','bebida','30000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','7600', 'credito', 'trago 40 mil','bebida','40000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'energetica','bebida','3000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'cerveza','alcohol','3000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'kunstman','alcohol','4000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'bebida','bebida','5000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'tonica','alcohol','5000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'energetica','bebida','5000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'agua mineral','alcohol','5000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'wisky','bebida','10000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'cerveza','bebida','10000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'piscola','alcohol','10000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'ron','bebida','10000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'tequila','bebida','10000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'cocktekles','alcohol','10000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'cigarro','cigarros','10000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'vodska','alcohol','12000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'wisky','alcohol','12000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'nobel','bebida','12000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'jager','bebida','12000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'campary','alcohol','12000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'wisky','bebida','15000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'bayleis','bebida','15000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'wisky_black','alcohol','18000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'sherindans','bebida','18000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'wisky_doble_black','bebida','20000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'wisky','alcohol','30000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'vinos','bebida','50000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'B_pisco_mistral','bebida','60000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'B_pisco_alto_carmen','alcohol','60000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'b_wisky_rojo','bebida','80000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'b_pisco_nobel','bebida','80000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'b_ron','alcohol','80000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'b_jack_daniels','bebida','120000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'b_chivas_regal','bebida','120000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'b_jhonny_waker_negro','alcohol','120000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'b_jager','bebida','120000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'b_vodska_absolut','bebida','120000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'b_jhonny_waker_double_black','alcohol','150000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'jhonny_waker_green_label','bebida','180000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'jhonny_waker_gold_label','bebida','180000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'jack_daniels_gentlenman_jack','alcohol','180000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'jhonny_waker_blue_label','bebida','800000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'champaña_120','bebida','120000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'champaña_160','alcohol','160000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'champaña_200','bebida','200000');
INSERT INTO trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', '', 'champaña_240','bebida','240000');


INSERT INTO horario(estado, horario_entrada, horario_salida) VALUES (1, 'valido', '23:00', '03:00');
INSERT INTO horario(estado, horario_entrada, horario_salida) VALUES (2, 'valido', '22:00', '02:00');
INSERT INTO horario(estado, horario_entrada, horario_salida) VALUES (3, 'valido', '21:00', '01:00');
INSERT INTO horario(estado, horario_entrada, horario_salida) VALUES (1, 'valido', '24:00', '04:00');
INSERT INTO horario(estado, horario_entrada, horario_salida) VALUES (1, 'valido', '20:00', '24:00');

INSERT INTO control(fecha, usuario_id)	VALUES ('2023-07-05', 1);
INSERT INTO control(fecha, usuario_id)	VALUES ('2023-07-06', 1);
INSERT INTO control(fecha, usuario_id)	VALUES ('2023-07-07', 1);

INSERT INTO servicios(detalle_servicio, estado_servicio, iva, metodo_pago, nombre_servicio, pieza, tipo_servicio, valor)	VALUES ('perro', 'activo', 0, 'efe', '---', 's', 'sad', 0);
INSERT INTO servicios(detalle_servicio, estado_servicio, iva, metodo_pago, nombre_servicio, pieza, tipo_servicio, valor)	VALUES ('perro', 'activo', 1000, 'efe', 'asd', 's', 'sad', 1000);

INSERT INTO acciones(adelanto, caja, comisiones, dia_activo, estado, estado_de_pago, fecha_dia, pendiente, tipo_accion,  servicio_id, tragos_id, usuario_id) VALUES ( 10000, 0, 0, '2023-07-24', 'pagado', 'p', '2023-07-24', 's', 's', 1, 2, 1);
INSERT INTO acciones(adelanto, caja, comisiones, dia_activo, estado, estado_de_pago, fecha_dia, pendiente, tipo_accion,  servicio_id, tragos_id, usuario_id) VALUES ( 5000, 0, 0, '2023-07-24', 'pagado', 'p', '2023-07-24', 's', 's', 1, 2, 1);
INSERT INTO total_dia(fechadia,ingreso_caja,total) VALUES ('2023-05-17',1000,1000);
insert into clientes(nombre_cliente)values('seleccione');

insert into garzon(estado,nombre_garzon) values ('activo','bryan');
insert into garzon(estado,nombre_garzon) values ('activo','miguel');
INSERT INTO usuario(id,apellido, email,estado ,foto, nombre, nombre_usuario, rut) VALUES (4,'bar', 'a@a.a','inactivo','5b1ab969-8c7d-4a0b-a26b-4ffd24227183_2023-04-01-19_21_55.8080100.jpg','bar' ,'bar' , '123456');