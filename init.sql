INSERT INTO public.role(id, name)
	VALUES (1, 'ADMIN');
INSERT INTO public.role(id, name)
	VALUES (2, 'COORDINADOR');
INSERT INTO public.role(id, name)
	VALUES (3, 'PROFESOR');
INSERT INTO public.role(id, name)
	VALUES (4, 'TUTOR');
INSERT INTO public.role(id, name)
	VALUES (5, 'ALUMNO');

INSERT INTO public.person(id, document, name, lastname, birth_date, phone, sex, address)
	VALUES (1, '4204613', 'Jesus', 'Aguilar', now(), '0982912326', 'MASCULINO', 'Juan de Garay 1634');

INSERT INTO public.account(id, document, password, person_id)
	VALUES (1, '4204613', 'l0k0lte.', 1);

INSERT INTO public.account_roles(account_id, role_id)
    VALUES (1, 1);

INSERT INTO public.account_roles(account_id, role_id)
    VALUES (1, 2);

INSERT INTO public.account_roles(account_id, role_id)
    VALUES (1, 3);

INSERT INTO public.person(id, document, name, lastname, birth_date, phone, sex, address)
	VALUES (2, '4653346', 'Veronica', 'Gayoso', now(), '0981719893', 'FEMENINO', 'Juan de Garay 1634');

INSERT INTO public.account(id, document, password, person_id)
	VALUES (2, '4295176', 'vrito', 2);

INSERT INTO public.account_roles(account_id, role_id)
    VALUES (1, 1);

INSERT INTO public.account_roles(account_id, role_id)
    VALUES (1, 2);

INSERT INTO public.account_roles(account_id, role_id)
    VALUES (1, 3);


INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person), null, null, '1518649', 'Irala Caballero', 'Marta Eugenia', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '1518649', '1518649', (select id from public.person where document = '1518649'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '1518649'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '2208308', 'Paats  Garay', 'María Laura', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '2208308', '2208308', (select id from public.person where document = '2208308'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '2208308'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '1771708', 'Romero  Machain', 'Carina Mariela', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '1771708', '1771708', (select id from public.person where document = '1771708'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '1771708'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '1365310', 'Mereles', 'Xenia', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '1365310', '1365310', (select id from public.person where document = '1365310'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '1365310'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '3213716', 'Abramo', 'Paola', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '3213716', '3213716', (select id from public.person where document = '3213716'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '3213716'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '2160566', 'Cespedes', 'Liz', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '2160566', '2160566', (select id from public.person where document = '2160566'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '2160566'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '3387407', 'Cuenca', 'Carolina', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '3387407', '3387407', (select id from public.person where document = '3387407'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '3387407'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '922493', 'Castanigno', 'Sonia', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '922493', '922493', (select id from public.person where document = '922493'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '922493'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '3806678', 'Arza', 'Sandra', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '3806678', '3806678', (select id from public.person where document = '3806678'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '3806678'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '3398929', 'Vasquez', 'Silvia', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '3398929', '3398929', (select id from public.person where document = '3398929'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '3398929'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '2229847', 'Ruiz Diaz', 'Selene', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '2229847', '2229847', (select id from public.person where document = '2229847'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '2229847'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '797410', 'Gimenez Ozuna', 'Lidia Carmen', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '797410', '797410', (select id from public.person where document = '797410'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '797410'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '4469096', 'Gill Aquino', 'Clarisse Nathalia', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '4469096', '4469096', (select id from public.person where document = '4469096'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '4469096'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '4322202', 'Ocampo', 'Francisco', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '4322202', '4322202', (select id from public.person where document = '4322202'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '4322202'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '3957835', 'Ramirez Nuñez', 'Amaya María José', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '3957835', '3957835', (select id from public.person where document = '3957835'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '3957835'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '4936007', 'Cardozo Isasi', 'Viviana Fabiola', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '4936007', '4936007', (select id from public.person where document = '4936007'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '4936007'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '3249485', 'López Real', 'Elías', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '3249485', '3249485', (select id from public.person where document = '3249485'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '3249485'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '2080938', 'Battilana de Paciello', 'Rossana Mabel', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '2080938', '2080938', (select id from public.person where document = '2080938'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '2080938'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '4582580', 'Gonzalez Melgarejo', 'Fátima Clarisse', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '4582580', '4582580', (select id from public.person where document = '4582580'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '4582580'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '3394798', 'Martinetti Fariña', 'Ireneo', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '3394798', '3394798', (select id from public.person where document = '3394798'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '3394798'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '1267808', 'Pérez Viera', 'Mirna Elizabeth', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '1267808', '1267808', (select id from public.person where document = '1267808'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '1267808'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '2036115', 'Fleytas Cabral', 'Liz Eusebia', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '2036115', '2036115', (select id from public.person where document = '2036115'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '2036115'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '704894', 'Solano López Escurra', 'Corinna Adelayde' , null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '704894', '704894', (select id from public.person where document = '704894'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '704894'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '1555523', 'Rojas Dominguez', 'Pablo Raul ', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '1555523', '1555523', (select id from public.person where document = '1555523'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '1555523'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '420526', 'Duarte de Candia', 'Nancy Estela', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '420526', '420526', (select id from public.person where document = '420526'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '420526'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '4440797', 'Ortega Ibarrola', 'Griselda Belén', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '4440797', '4440797', (select id from public.person where document = '4440797'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '4440797'), 3);
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person),null, null, '4549970', 'Florentín Isasi', 'Julio Cesar', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '4549970', '4549970', (select id from public.person where document = '4549970'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '4549970'), 3);




INSERT INTO public.curso(
    id, description, nombre, orden, nivel)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.curso), null, 'PRIMER GRADO', 1, 1);
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3213716'), (select id from public.curso where orden = 1));



INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), 'LENGUA MATERNA', 'CASTELLANO', 1, (select id from public.curso where orden = 1), (select id from public.person where document = '3213716'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), 'SEGUNDA LENGUA', 'GUARANI', 2, (select id from public.curso where orden = 1), (select id from public.person where document = '3213716'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'MATEMATICA', 3, (select id from public.curso where orden = 1), (select id from public.person where document = '3213716'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'VIDA SOCIAL Y TRABAJO', 4, (select id from public.curso where orden = 1), (select id from public.person where document = '3213716'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'MEDIO NATURAL', 5, (select id from public.curso where orden = 1), (select id from public.person where document = '3213716'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'SALUD', 6, (select id from public.curso where orden = 1), (select id from public.person where document = '3213716'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'CULTURA RELIGIOSA', 7, (select id from public.curso where orden = 1), (select id from public.person where document = '3213716'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'ARTES PLASTICAS', 8, (select id from public.curso where orden = 1), (select id from public.person where document = '3213716'));