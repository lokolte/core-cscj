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
	VALUES (2, '4295176', 'Veronica', 'Gayoso', now(), '0981719893', 'FEMENINO', 'Juan de Garay 1634');

INSERT INTO public.account(id, document, password, person_id)
	VALUES (2, '4295176', 'vrito', 2);

INSERT INTO public.account_roles(account_id, role_id)
    VALUES (2, 1);

INSERT INTO public.account_roles(account_id, role_id)
    VALUES (2, 2);

INSERT INTO public.account_roles(account_id, role_id)
    VALUES (2, 3);

-- lista de profesores del cscj --
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



-- Curso Pre-Jardin y sus Profesores
INSERT INTO public.curso(
    id, description, nombre, orden, nivel)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.curso), null, 'PRE JARDIN', -2, 0);
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '1518649'), (select id from public.curso where orden = -2));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2229847'), (select id from public.curso where orden = -2));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '797410'), (select id from public.curso where orden = -2));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4469096'), (select id from public.curso where orden = -2));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4322202'), (select id from public.curso where orden = -2));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3957835'), (select id from public.curso where orden = -2));


--Asignaturas del Pre-Jardin
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Lenguaje Oral y Escrito', 1, (select id from public.curso where orden = -2), (select id from public.person where document = '1518649'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Matemática', 2, (select id from public.curso where orden = -2), (select id from public.person where document = '1518649'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Expresión Artística', 3, (select id from public.curso where orden = -2), (select id from public.person where document = '1518649'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Medio Natural', 4, (select id from public.curso where orden = -2), (select id from public.person where document = '1518649'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Medio Social y cultural', 5, (select id from public.curso where orden = -2), (select id from public.person where document = '1518649'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Identidad', 6, (select id from public.curso where orden = -2), (select id from public.person where document = '1518649'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Autonomía', 7, (select id from public.curso where orden = -2), (select id from public.person where document = '1518649'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Convivencia', 8, (select id from public.curso where orden = -2), (select id from public.person where document = '1518649'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Vida Saludable', 9, (select id from public.curso where orden = -2), (select id from public.person where document = '1518649'));
--Asignaturas de Profesores especiales del Pre-Jardin
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'DANZA', 10, (select id from public.curso where orden = -2), (select id from public.person where document = '2229847'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educación física', 11, (select id from public.curso where orden = -2), (select id from public.person where document = '797410'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Música', 12, (select id from public.curso where orden = -2), (select id from public.person where document = '4469096'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Informática', 13, (select id from public.curso where orden = -2), (select id from public.person where document = '4322202'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Inglés', 14, (select id from public.curso where orden = -2), (select id from public.person where document = '3957835'));





-- Curso Jardin y sus Profesores
INSERT INTO public.curso(
    id, description, nombre, orden, nivel)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.curso), null, 'JARDIN', -1, 0);
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2208308'), (select id from public.curso where orden = -1));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2229847'), (select id from public.curso where orden = -1));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '797410'), (select id from public.curso where orden = -1));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4469096'), (select id from public.curso where orden = -1));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4322202'), (select id from public.curso where orden = -1));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3957835'), (select id from public.curso where orden = -1));


--Asignaturas del Jardin
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Lenguaje Oral y Escrito', 1, (select id from public.curso where orden = -1), (select id from public.person where document = '2208308'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Matemática', 2, (select id from public.curso where orden = -1), (select id from public.person where document = '2208308'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Expresión Artística', 3, (select id from public.curso where orden = -1), (select id from public.person where document = '2208308'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Medio Natural', 4, (select id from public.curso where orden = -1), (select id from public.person where document = '2208308'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Medio Social y cultural', 5, (select id from public.curso where orden = -1), (select id from public.person where document = '2208308'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Identidad', 6, (select id from public.curso where orden = -1), (select id from public.person where document = '2208308'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Autonomía', 7, (select id from public.curso where orden = -1), (select id from public.person where document = '2208308'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Convivencia', 8, (select id from public.curso where orden = -1), (select id from public.person where document = '2208308'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Vida Saludable', 9, (select id from public.curso where orden = -1), (select id from public.person where document = '2208308'));
--Asignaturas de Profesores especiales del Jardin
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'DANZA', 10, (select id from public.curso where orden = -1), (select id from public.person where document = '2229847'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educación física', 11, (select id from public.curso where orden = -1), (select id from public.person where document = '797410'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Música', 12, (select id from public.curso where orden = -1), (select id from public.person where document = '4469096'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Informática', 13, (select id from public.curso where orden = -1), (select id from public.person where document = '4322202'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Inglés', 14, (select id from public.curso where orden = -1), (select id from public.person where document = '3957835'));





-- Curso Pre Escolar y sus Profesores
INSERT INTO public.curso(
    id, description, nombre, orden, nivel)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.curso), null, 'PRE ESCOLAR', 0, 0);
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '1771708'), (select id from public.curso where orden = 0));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2229847'), (select id from public.curso where orden = 0));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '797410'), (select id from public.curso where orden = 0));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4469096'), (select id from public.curso where orden = 0));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4322202'), (select id from public.curso where orden = 0));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3957835'), (select id from public.curso where orden = 0));


--Asignaturas del Pre Escolar
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Lenguaje Oral y Escrito', 1, (select id from public.curso where orden = 0), (select id from public.person where document = '1771708'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Matemática', 2, (select id from public.curso where orden = 0), (select id from public.person where document = '1771708'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Expresión Artística', 3, (select id from public.curso where orden = 0), (select id from public.person where document = '1771708'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Medio Natural', 4, (select id from public.curso where orden = 0), (select id from public.person where document = '1771708'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Medio Social y cultural', 5, (select id from public.curso where orden = 0), (select id from public.person where document = '1771708'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Identidad', 6, (select id from public.curso where orden = 0), (select id from public.person where document = '1771708'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Autonomía', 7, (select id from public.curso where orden = 0), (select id from public.person where document = '1771708'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Convivencia', 8, (select id from public.curso where orden = 0), (select id from public.person where document = '1771708'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Vida Saludable', 9, (select id from public.curso where orden = 0), (select id from public.person where document = '1771708'));
--Asignaturas de Profesores especiales del Pre Escolar
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'DANZA', 10, (select id from public.curso where orden = 0), (select id from public.person where document = '2229847'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educación física', 11, (select id from public.curso where orden = 0), (select id from public.person where document = '797410'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Música', 12, (select id from public.curso where orden = 0), (select id from public.person where document = '4469096'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Informática', 13, (select id from public.curso where orden = 0), (select id from public.person where document = '4322202'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Inglés', 14, (select id from public.curso where orden = 0), (select id from public.person where document = '3957835'));





-- Curso 1er Grado y sus Profesores
INSERT INTO public.curso(
    id, description, nombre, orden, nivel)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.curso), null, 'PRIMER GRADO', 1, 1);
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3213716'), (select id from public.curso where orden = 1));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2229847'), (select id from public.curso where orden = 1));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '797410'), (select id from public.curso where orden = 1));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4469096'), (select id from public.curso where orden = 1));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4322202'), (select id from public.curso where orden = 1));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3957835'), (select id from public.curso where orden = 1));


--Asignaturas del 1er Grado
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
--Asignaturas de Profesores especiales del 1er Grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'DANZA', 9, (select id from public.curso where orden = 1), (select id from public.person where document = '2229847'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educación física', 10, (select id from public.curso where orden = 1), (select id from public.person where document = '797410'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Música', 11, (select id from public.curso where orden = 1), (select id from public.person where document = '4469096'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Informática', 12, (select id from public.curso where orden = 1), (select id from public.person where document = '4322202'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Inglés', 13, (select id from public.curso where orden = 1), (select id from public.person where document = '3957835'));





-- Curso 2do Grado y sus Profesores
INSERT INTO public.curso(
    id, description, nombre, orden, nivel)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.curso), null, 'SEGUNDO GRADO', 2, 1);
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2160566'), (select id from public.curso where orden = 2));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2229847'), (select id from public.curso where orden = 2));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '797410'), (select id from public.curso where orden = 2));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4469096'), (select id from public.curso where orden = 2));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4322202'), (select id from public.curso where orden = 2));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3957835'), (select id from public.curso where orden = 2));


--Asignaturas del 2do Grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), 'LENGUA MATERNA', 'CASTELLANO', 1, (select id from public.curso where orden = 2), (select id from public.person where document = '2160566'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), 'SEGUNDA LENGUA', 'GUARANI', 2, (select id from public.curso where orden = 2), (select id from public.person where document = '2160566'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'MATEMATICA', 3, (select id from public.curso where orden = 2), (select id from public.person where document = '2160566'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'VIDA SOCIAL Y TRABAJO', 4, (select id from public.curso where orden = 2), (select id from public.person where document = '2160566'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'MEDIO NATURAL', 5, (select id from public.curso where orden = 2), (select id from public.person where document = '2160566'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'SALUD', 6, (select id from public.curso where orden = 2), (select id from public.person where document = '2160566'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'CULTURA RELIGIOSA', 7, (select id from public.curso where orden = 2), (select id from public.person where document = '2160566'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'ARTES PLASTICAS', 8, (select id from public.curso where orden = 2), (select id from public.person where document = '2160566'));
--Asignaturas de Profesores especiales del 2do Grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'DANZA', 9, (select id from public.curso where orden = 2), (select id from public.person where document = '2229847'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educación física', 10, (select id from public.curso where orden = 2), (select id from public.person where document = '797410'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Música', 11, (select id from public.curso where orden = 2), (select id from public.person where document = '4469096'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Informática', 12, (select id from public.curso where orden = 2), (select id from public.person where document = '4322202'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Inglés', 13, (select id from public.curso where orden = 2), (select id from public.person where document = '3957835'));





-- Curso 3er Grado y sus Profesores
INSERT INTO public.curso(
    id, description, nombre, orden, nivel)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.curso), null, 'TERCER GRADO', 3, 1);
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3387407'), (select id from public.curso where orden = 3));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2229847'), (select id from public.curso where orden = 3));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '797410'), (select id from public.curso where orden = 3));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4469096'), (select id from public.curso where orden = 3));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4322202'), (select id from public.curso where orden = 3));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3957835'), (select id from public.curso where orden = 3));


--Asignaturas del 3er Grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), 'LENGUA MATERNA', 'CASTELLANO', 1, (select id from public.curso where orden = 3), (select id from public.person where document = '3387407'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), 'SEGUNDA LENGUA', 'GUARANI', 2, (select id from public.curso where orden = 3), (select id from public.person where document = '3387407'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'MATEMATICA', 3, (select id from public.curso where orden = 3), (select id from public.person where document = '3387407'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'VIDA SOCIAL Y TRABAJO', 4, (select id from public.curso where orden = 3), (select id from public.person where document = '3387407'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'MEDIO NATURAL', 5, (select id from public.curso where orden = 3), (select id from public.person where document = '3387407'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'SALUD', 6, (select id from public.curso where orden = 3), (select id from public.person where document = '3387407'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'CULTURA RELIGIOSA', 7, (select id from public.curso where orden = 3), (select id from public.person where document = '3387407'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'ARTES PLASTICAS', 8, (select id from public.curso where orden = 3), (select id from public.person where document = '3387407'));
--Asignaturas de Profesores especiales del 3er Grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'DANZA', 9, (select id from public.curso where orden = 3), (select id from public.person where document = '2229847'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educación física', 10, (select id from public.curso where orden = 3), (select id from public.person where document = '797410'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Música', 11, (select id from public.curso where orden = 3), (select id from public.person where document = '4469096'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Informática', 12, (select id from public.curso where orden = 3), (select id from public.person where document = '4322202'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Inglés', 13, (select id from public.curso where orden = 3), (select id from public.person where document = '3957835'));





-- Curso 4to Grado y sus Profesores
INSERT INTO public.curso(
    id, description, nombre, orden, nivel)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.curso), null, 'CUARTO GRADO', 4, 2);
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '922493'), (select id from public.curso where orden = 4));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2229847'), (select id from public.curso where orden = 4));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '797410'), (select id from public.curso where orden = 4));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4469096'), (select id from public.curso where orden = 4));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4322202'), (select id from public.curso where orden = 4));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3957835'), (select id from public.curso where orden = 4));


--Asignaturas del 4to Grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), 'LENGUA MATERNA', 'CASTELLANO', 1, (select id from public.curso where orden = 4), (select id from public.person where document = '922493'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), 'SEGUNDA LENGUA', 'GUARANI', 2, (select id from public.curso where orden = 4), (select id from public.person where document = '922493'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'MATEMATICA', 3, (select id from public.curso where orden = 4), (select id from public.person where document = '922493'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'CIENCIAS NATURALES', 4, (select id from public.curso where orden = 4), (select id from public.person where document = '922493'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'CIENCIAS SOCIALES', 5, (select id from public.curso where orden = 4), (select id from public.person where document = '922493'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'EDUC. PARA LA SALUD', 6, (select id from public.curso where orden = 4), (select id from public.person where document = '922493'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'TRABAJO Y TECNOLOGIA', 7, (select id from public.curso where orden = 4), (select id from public.person where document = '922493'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'ARTES PLASTICAS', 8, (select id from public.curso where orden = 4), (select id from public.person where document = '922493'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'CULTURA RELIGIOSA', 9, (select id from public.curso where orden = 4), (select id from public.person where document = '922493'));
--Asignaturas de Profesores especiales del 4to Grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'DANZA', 10, (select id from public.curso where orden = 4), (select id from public.person where document = '2229847'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educación física', 11, (select id from public.curso where orden = 4), (select id from public.person where document = '797410'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Música', 12, (select id from public.curso where orden = 4), (select id from public.person where document = '4469096'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Informática', 13, (select id from public.curso where orden = 4), (select id from public.person where document = '4322202'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Inglés', 14, (select id from public.curso where orden = 4), (select id from public.person where document = '3957835'));





-- Curso 5to Grado y sus Profesores
INSERT INTO public.curso(
    id, description, nombre, orden, nivel)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.curso), null, 'QUINTO GRADO', 5, 2);
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3806678'), (select id from public.curso where orden = 5));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2229847'), (select id from public.curso where orden = 5));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '797410'), (select id from public.curso where orden = 5));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4469096'), (select id from public.curso where orden = 5));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4322202'), (select id from public.curso where orden = 5));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3957835'), (select id from public.curso where orden = 5));


--Asignaturas del 5to Grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), 'LENGUA MATERNA', 'CASTELLANO', 1, (select id from public.curso where orden = 5), (select id from public.person where document = '3806678'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), 'SEGUNDA LENGUA', 'GUARANI', 2, (select id from public.curso where orden = 5), (select id from public.person where document = '3806678'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'MATEMATICA', 3, (select id from public.curso where orden = 5), (select id from public.person where document = '3806678'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'CIENCIAS NATURALES', 4, (select id from public.curso where orden = 5), (select id from public.person where document = '3806678'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'CIENCIAS SOCIALES', 5, (select id from public.curso where orden = 5), (select id from public.person where document = '3806678'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'EDUC. PARA LA SALUD', 6, (select id from public.curso where orden = 5), (select id from public.person where document = '3806678'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'TRABAJO Y TECNOLOGIA', 7, (select id from public.curso where orden = 5), (select id from public.person where document = '3806678'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'ARTES PLASTICAS', 8, (select id from public.curso where orden = 5), (select id from public.person where document = '3806678'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'CULTURA RELIGIOSA', 9, (select id from public.curso where orden = 5), (select id from public.person where document = '3806678'));
--Asignaturas de Profesores especiales del 5to Grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'DANZA', 10, (select id from public.curso where orden = 5), (select id from public.person where document = '2229847'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educación física', 11, (select id from public.curso where orden = 5), (select id from public.person where document = '797410'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Música', 12, (select id from public.curso where orden = 5), (select id from public.person where document = '4469096'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Informática', 13, (select id from public.curso where orden = 5), (select id from public.person where document = '4322202'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Inglés', 14, (select id from public.curso where orden = 5), (select id from public.person where document = '3957835'));






-- Curso 6to Grado y sus Profesores
INSERT INTO public.curso(
    id, description, nombre, orden, nivel)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.curso), null, 'SEXTO GRADO', 6, 2);
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3398929'), (select id from public.curso where orden = 6));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2229847'), (select id from public.curso where orden = 6));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '797410'), (select id from public.curso where orden = 6));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4469096'), (select id from public.curso where orden = 6));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4322202'), (select id from public.curso where orden = 6));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3957835'), (select id from public.curso where orden = 6));


--Asignaturas del 6to Grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), 'LENGUA MATERNA', 'CASTELLANO', 1, (select id from public.curso where orden = 6), (select id from public.person where document = '3398929'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), 'SEGUNDA LENGUA', 'GUARANI', 2, (select id from public.curso where orden = 6), (select id from public.person where document = '3398929'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'MATEMATICA', 3, (select id from public.curso where orden = 6), (select id from public.person where document = '3398929'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'CIENCIAS NATURALES', 4, (select id from public.curso where orden = 6), (select id from public.person where document = '3398929'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'CIENCIAS SOCIALES', 5, (select id from public.curso where orden = 6), (select id from public.person where document = '3398929'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'EDUC. PARA LA SALUD', 6, (select id from public.curso where orden = 6), (select id from public.person where document = '3398929'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'TRABAJO Y TECNOLOGIA', 7, (select id from public.curso where orden = 6), (select id from public.person where document = '3398929'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'ARTES PLASTICAS', 8, (select id from public.curso where orden = 6), (select id from public.person where document = '3398929'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'CULTURA RELIGIOSA', 9, (select id from public.curso where orden = 6), (select id from public.person where document = '3398929'));
--Asignaturas de Profesores especiales del 6to Grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'DANZA', 10, (select id from public.curso where orden = 6), (select id from public.person where document = '2229847'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educación física', 11, (select id from public.curso where orden = 6), (select id from public.person where document = '797410'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Música', 12, (select id from public.curso where orden = 6), (select id from public.person where document = '4469096'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Informática', 13, (select id from public.curso where orden = 6), (select id from public.person where document = '4322202'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Inglés', 14, (select id from public.curso where orden = 6), (select id from public.person where document = '3957835'));





-- Curso 7mo Grado y sus Profesores
INSERT INTO public.curso(
    id, description, nombre, orden, nivel)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.curso), null, 'SEPTIMO GRADO', 7, 3);
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4936007'), (select id from public.curso where orden = 7));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3249485'), (select id from public.curso where orden = 7));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2080938'), (select id from public.curso where orden = 7));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4582580'), (select id from public.curso where orden = 7));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3394798'), (select id from public.curso where orden = 7));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '797410'), (select id from public.curso where orden = 7));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '1267808'), (select id from public.curso where orden = 7));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3957835'), (select id from public.curso where orden = 7));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2036115'), (select id from public.curso where orden = 7));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '704894'), (select id from public.curso where orden = 7));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4322202'), (select id from public.curso where orden = 7));


--Asignaturas del 7mo Grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Lengua y Literatura Castellana', 1, (select id from public.curso where orden = 7), (select id from public.person where document = '4936007'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Lengua y Literatura Guaraní', 2, (select id from public.curso where orden = 7), (select id from public.person where document = '3249485'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Ciencias de la Naturaleza y la Salud', 3, (select id from public.curso where orden = 7), (select id from public.person where document = '2080938'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Matemática', 4, (select id from public.curso where orden = 7), (select id from public.person where document = '4582580'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Historia y Geografía', 5, (select id from public.curso where orden = 7), (select id from public.person where document = '3394798'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Formación Ética y Ciudadana', 6, (select id from public.curso where orden = 7), (select id from public.person where document = '3394798'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educación Física', 7, (select id from public.curso where orden = 7), (select id from public.person where document = '797410'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Trabajo y Tecnología', 8, (select id from public.curso where orden = 7), (select id from public.person where document = '1267808'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Desarrollo Personal', 9, (select id from public.curso where orden = 7), (select id from public.person where document = '1267808'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Inglés', 10, (select id from public.curso where orden = 7), (select id from public.person where document = '3957835'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educ. Artística – Música', 11, (select id from public.curso where orden = 7), (select id from public.person where document = '2036115'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educ. Artística – Danza', 12, (select id from public.curso where orden = 7), (select id from public.person where document = '704894'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Informática', 13, (select id from public.curso where orden = 7), (select id from public.person where document = '4322202'));
--INSERT INTO public.asignatura(
  --  id, description, nombre, orden, curso_id, person_id)
--VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'CULTURA RELIGIOSA', 14, (select id from public.curso where orden = 7), (select id from public.person where document = ''));





-- Curso 8vo Grado y sus Profesores
INSERT INTO public.curso(
    id, description, nombre, orden, nivel)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.curso), null, 'OCTAVO GRADO', 8, 3);
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4936007'), (select id from public.curso where orden = 8));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3249485'), (select id from public.curso where orden = 8));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2080938'), (select id from public.curso where orden = 8));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4582580'), (select id from public.curso where orden = 8));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3394798'), (select id from public.curso where orden = 8));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '797410'), (select id from public.curso where orden = 8));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '1267808'), (select id from public.curso where orden = 8));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3957835'), (select id from public.curso where orden = 8));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2036115'), (select id from public.curso where orden = 8));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '704894'), (select id from public.curso where orden = 8));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4322202'), (select id from public.curso where orden = 8));


--Asignaturas del 8vo Grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Lengua y Literatura Castellana', 1, (select id from public.curso where orden = 8), (select id from public.person where document = '4936007'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Lengua y Literatura Guaraní', 2, (select id from public.curso where orden = 8), (select id from public.person where document = '3249485'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Ciencias de la Naturaleza y la Salud', 3, (select id from public.curso where orden = 8), (select id from public.person where document = '2080938'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Matemática', 4, (select id from public.curso where orden = 8), (select id from public.person where document = '4582580'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Historia y Geografía', 5, (select id from public.curso where orden = 8), (select id from public.person where document = '3394798'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Formación Ética y Ciudadana', 6, (select id from public.curso where orden = 8), (select id from public.person where document = '3394798'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educación Física', 7, (select id from public.curso where orden = 8), (select id from public.person where document = '797410'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Trabajo y Tecnología', 8, (select id from public.curso where orden = 8), (select id from public.person where document = '1267808'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Desarrollo Personal', 9, (select id from public.curso where orden = 8), (select id from public.person where document = '1267808'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Inglés', 10, (select id from public.curso where orden = 8), (select id from public.person where document = '3957835'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educ. Artística – Música', 11, (select id from public.curso where orden = 8), (select id from public.person where document = '2036115'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educ. Artística – Danza', 12, (select id from public.curso where orden = 8), (select id from public.person where document = '704894'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Informática', 13, (select id from public.curso where orden = 8), (select id from public.person where document = '4322202'));
--INSERT INTO public.asignatura(
  --  id, description, nombre, orden, curso_id, person_id)
--VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'CULTURA RELIGIOSA', 14, (select id from public.curso where orden = 8), (select id from public.person where document = ''));





-- Curso 9no Grado y sus Profesores
INSERT INTO public.curso(
    id, description, nombre, orden, nivel)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.curso), null, 'NOVENO GRADO', 9, 3);
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4936007'), (select id from public.curso where orden = 9));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3249485'), (select id from public.curso where orden = 9));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2080938'), (select id from public.curso where orden = 9));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4582580'), (select id from public.curso where orden = 9));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3394798'), (select id from public.curso where orden = 9));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '797410'), (select id from public.curso where orden = 9));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '1267808'), (select id from public.curso where orden = 9));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3957835'), (select id from public.curso where orden = 9));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2036115'), (select id from public.curso where orden = 9));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '704894'), (select id from public.curso where orden = 9));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4322202'), (select id from public.curso where orden = 9));


--Asignaturas del 9no Grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Lengua y Literatura Castellana', 1, (select id from public.curso where orden = 9), (select id from public.person where document = '4936007'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Lengua y Literatura Guaraní', 2, (select id from public.curso where orden = 9), (select id from public.person where document = '3249485'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Ciencias de la Naturaleza y la Salud', 3, (select id from public.curso where orden = 9), (select id from public.person where document = '2080938'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Matemática', 4, (select id from public.curso where orden = 9), (select id from public.person where document = '4582580'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Historia y Geografía', 5, (select id from public.curso where orden = 9), (select id from public.person where document = '3394798'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Formación Ética y Ciudadana', 6, (select id from public.curso where orden = 9), (select id from public.person where document = '3394798'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educación Física', 7, (select id from public.curso where orden = 9), (select id from public.person where document = '797410'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Trabajo y Tecnología', 8, (select id from public.curso where orden = 9), (select id from public.person where document = '1267808'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Desarrollo Personal', 9, (select id from public.curso where orden = 9), (select id from public.person where document = '1267808'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Inglés', 10, (select id from public.curso where orden = 9), (select id from public.person where document = '3957835'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educ. Artística – Música', 11, (select id from public.curso where orden = 9), (select id from public.person where document = '2036115'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educ. Artística – Danza', 12, (select id from public.curso where orden = 9), (select id from public.person where document = '704894'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Informática', 13, (select id from public.curso where orden = 9), (select id from public.person where document = '4322202'));
--INSERT INTO public.asignatura(
  --  id, description, nombre, orden, curso_id, person_id)
--VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'CULTURA RELIGIOSA', 14, (select id from public.curso where orden = 9), (select id from public.person where document = ''));






-- Curso 1ero de la Media y sus Profesores
INSERT INTO public.curso(
    id, description, nombre, orden, nivel)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.curso), null, 'PRIMER CURSO', 10, 4);
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4936007'), (select id from public.curso where orden = 10));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3249485'), (select id from public.curso where orden = 10));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3957835'), (select id from public.curso where orden = 10));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2080938'), (select id from public.curso where orden = 10));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4582580'), (select id from public.curso where orden = 10));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '1555523'), (select id from public.curso where orden = 10));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '797410'), (select id from public.curso where orden = 10));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4469096'), (select id from public.curso where orden = 10));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '704894'), (select id from public.curso where orden = 10));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '420526'), (select id from public.curso where orden = 10));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4549970'), (select id from public.curso where orden = 10));


--Asignaturas del 1ero de la Media
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Lengua Castellana y Literatura', 1, (select id from public.curso where orden = 10), (select id from public.person where document = '4936007'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Guaraní Ñe´e', 2, (select id from public.curso where orden = 10), (select id from public.person where document = '3249485'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Inglés', 3, (select id from public.curso where orden = 10), (select id from public.person where document = '3957835'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Ciencias Naturales y Salud', 4, (select id from public.curso where orden = 10), (select id from public.person where document = '2080938'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Matemática', 5, (select id from public.curso where orden = 10), (select id from public.person where document = '4582580'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Historia y Geografía', 6, (select id from public.curso where orden = 10), (select id from public.person where document = '1555523'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Psicología', 7, (select id from public.curso where orden = 10), (select id from public.person where document = '1555523'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Antropología Social', 8, (select id from public.curso where orden = 10), (select id from public.person where document = '1555523'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educación Física', 9, (select id from public.curso where orden = 10), (select id from public.person where document = '797410'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Artes – Música', 10, (select id from public.curso where orden = 10), (select id from public.person where document = '4469096'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Artes – Danza', 11, (select id from public.curso where orden = 10), (select id from public.person where document = '704894'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Lógica Matemática', 12, (select id from public.curso where orden = 10), (select id from public.person where document = '420526'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Geología', 13, (select id from public.curso where orden = 10), (select id from public.person where document = '2080938'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educación Ambiental', 14, (select id from public.curso where orden = 10), (select id from public.person where document = '1267808'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Cultura Religiosa', 15, (select id from public.curso where orden = 10), (select id from public.person where document = '4549970'));





-- Curso 2do de la Media y sus Profesores
INSERT INTO public.curso(
    id, description, nombre, orden, nivel)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.curso), null, 'SEGUNDO CURSO', 11, 4);
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4936007'), (select id from public.curso where orden = 11));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3249485'), (select id from public.curso where orden = 11));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3957835'), (select id from public.curso where orden = 11));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2080938'), (select id from public.curso where orden = 11));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '420526'), (select id from public.curso where orden = 11));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4440797'), (select id from public.curso where orden = 11));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4582580'), (select id from public.curso where orden = 11));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '1555523'), (select id from public.curso where orden = 11));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '797410'), (select id from public.curso where orden = 11));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4469096'), (select id from public.curso where orden = 11));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '704894'), (select id from public.curso where orden = 11));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4549970'), (select id from public.curso where orden = 11));


--Asignaturas del 2do de la Media
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Lengua Castellana y Literatura', 1, (select id from public.curso where orden = 11), (select id from public.person where document = '4936007'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Guaraní Ñe´e', 2, (select id from public.curso where orden = 11), (select id from public.person where document = '3249485'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Inglés', 3, (select id from public.curso where orden = 11), (select id from public.person where document = '3957835'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Ciencias Naturales y Salud', 4, (select id from public.curso where orden = 11), (select id from public.person where document = '2080938'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Física', 5, (select id from public.curso where orden = 11), (select id from public.person where document = '420526'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Química', 6, (select id from public.curso where orden = 11), (select id from public.person where document = '4440797'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Matemática', 7, (select id from public.curso where orden = 11), (select id from public.person where document = '4582580'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Historia y Geografía', 8, (select id from public.curso where orden = 11), (select id from public.person where document = '1555523'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Formación Ética y Ciudadana', 9, (select id from public.curso where orden = 11), (select id from public.person where document = '1555523'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Filosofía', 10, (select id from public.curso where orden = 11), (select id from public.person where document = '1555523'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educación Física', 11, (select id from public.curso where orden = 11), (select id from public.person where document = '797410'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Artes – Música', 12, (select id from public.curso where orden = 11), (select id from public.person where document = '4469096'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Artes – Danza', 13, (select id from public.curso where orden = 11), (select id from public.person where document = '704894'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Orientación', 14, (select id from public.curso where orden = 11), (select id from public.person where document = '1555523'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Estadística', 15, (select id from public.curso where orden = 11), (select id from public.person where document = '4582580'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Cultura Religiosa', 16, (select id from public.curso where orden = 11), (select id from public.person where document = '4549970'));





-- Curso 3ro de la Media y sus Profesores
INSERT INTO public.curso(
    id, description, nombre, orden, nivel)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.curso), null, 'TERCER CURSO', 12, 4);
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4936007'), (select id from public.curso where orden = 12));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3249485'), (select id from public.curso where orden = 12));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '3957835'), (select id from public.curso where orden = 12));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '420526'), (select id from public.curso where orden = 12));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4440797'), (select id from public.curso where orden = 12));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4582580'), (select id from public.curso where orden = 12));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '1555523'), (select id from public.curso where orden = 12));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '1267808'), (select id from public.curso where orden = 12));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '797410'), (select id from public.curso where orden = 12));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '2080938'), (select id from public.curso where orden = 12));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4549970'), (select id from public.curso where orden = 12));


--Asignaturas del 3ro de la Media
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Lengua Castellana y Literatura', 1, (select id from public.curso where orden = 12), (select id from public.person where document = '4936007'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Guaraní Ñe´e', 2, (select id from public.curso where orden = 12), (select id from public.person where document = '3249485'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Inglés', 3, (select id from public.curso where orden = 12), (select id from public.person where document = '3957835'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Física PC', 4, (select id from public.curso where orden = 12), (select id from public.person where document = '420526'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Química PC', 5, (select id from public.curso where orden = 12), (select id from public.person where document = '4440797'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Matemática', 6, (select id from public.curso where orden = 12), (select id from public.person where document = '4582580'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Historia y Geografía', 7, (select id from public.curso where orden = 12), (select id from public.person where document = '1555523'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Economía y Gestión', 8, (select id from public.curso where orden = 12), (select id from public.person where document = '1267808'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Educación Física', 9, (select id from public.curso where orden = 12), (select id from public.person where document = '797410'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Orientación', 10, (select id from public.curso where orden = 12), (select id from public.person where document = '1555523'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Física PE', 11, (select id from public.curso where orden = 12), (select id from public.person where document = '420526'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Química PE', 12, (select id from public.curso where orden = 12), (select id from public.person where document = '4440797'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Biología', 13, (select id from public.curso where orden = 12), (select id from public.person where document = '2080938'));
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Cultura Religiosa', 14, (select id from public.curso where orden = 12), (select id from public.person where document = '4549970'));
--INSERT INTO public.asignatura(
  --  id, description, nombre, orden, curso_id, person_id)
--VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Metodología de la Investigación', 15, (select id from public.curso where orden = 12), (select id from public.person where document = ''));

------Modificaciones post puesta en produccion

-- Asignacion de Coordinadores a cursos con sus roles
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '1365310'), (select id from public.curso where orden = -2));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '1365310'), (select id from public.curso where orden = -1));
INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '1365310'), (select id from public.curso where orden = 0));
INSERT INTO public.account_roles(account_id, role_id)
VALUES (6, 2);

--Modificaciones a los nombres de los cursos
UPDATE public.curso SET  nombre='Pre Jardín' WHERE id=1;
UPDATE public.curso SET  nombre='Jardín' WHERE id=2;
UPDATE public.curso SET  nombre='Pre Escolar' WHERE id=3;
UPDATE public.curso SET  nombre='Primer Grado' WHERE id=4;
UPDATE public.curso SET  nombre='Segundo Grado' WHERE id=5;
UPDATE public.curso SET  nombre='Tercer Grado' WHERE id=6;
UPDATE public.curso SET  nombre='Cuarto Grado' WHERE id=7;
UPDATE public.curso SET  nombre='Quinto Grado' WHERE id=8;
UPDATE public.curso SET  nombre='Sexto Grado' WHERE id=9;
UPDATE public.curso SET  nombre='Séptimo Grado' WHERE id=10;
UPDATE public.curso SET  nombre='Octavo Grado' WHERE id=11;
UPDATE public.curso SET  nombre='Noveno Grado' WHERE id=12;
UPDATE public.curso SET  nombre='Primer Curso' WHERE id=13;
UPDATE public.curso SET  nombre='Segundo Curso' WHERE id=14;
UPDATE public.curso SET  nombre='Tercer Curso' WHERE id=15;

--- borrando asignaturas incorrectas
DELETE FROM public.asignatura WHERE id=12;
DELETE FROM public.asignatura WHERE id=26;
DELETE FROM public.asignatura WHERE id=40;
--- arreglando el orden de las materias
UPDATE public.asignatura SET orden=12 WHERE id=13;
UPDATE public.asignatura SET orden=13 WHERE id=14;
UPDATE public.asignatura SET orden=12 WHERE id=27;
UPDATE public.asignatura SET orden=13 WHERE id=28;
UPDATE public.asignatura SET orden=12 WHERE id=41;
UPDATE public.asignatura SET orden=13 WHERE id=42;

--Modificaciones a datos de usuarios que estuvieron incorrectos
UPDATE public.person SET document='2160565' WHERE document='2160566';
UPDATE public.person SET lastname='Castagnino' WHERE document='922493';
UPDATE public.person SET lastname='Vazquez' WHERE document='3398929';

---agregar cursos a un usuario faltante
INSERT INTO public.person_cursos(person_id, curso_id) VALUES ((SELECT id FROM public.person where document='2036115'), (SELECT id FROM public.curso where orden='10'));
INSERT INTO public.person_cursos(person_id, curso_id) VALUES ((SELECT id FROM public.person where document='2036115'), (SELECT id FROM public.curso where orden='11'));
INSERT INTO public.person_cursos(person_id, curso_id) VALUES ((SELECT id FROM public.person where document='2036115'), (SELECT id FROM public.curso where orden='12'));

---crear usuario faltante
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person), null, null, '1399974', 'Rodríguez Argaña', 'Marta Raquel', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '1399974', '1399974', (select id from public.person where document = '1399974'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '1399974'), 2);
---agregar permisos sobre los cursos para ultiimo usuario
INSERT INTO public.person_cursos(person_id, curso_id) VALUES ((SELECT id FROM public.person where document='1399974'), (SELECT id FROM public.curso where orden='1'));
INSERT INTO public.person_cursos(person_id, curso_id) VALUES ((SELECT id FROM public.person where document='1399974'), (SELECT id FROM public.curso where orden='2'));
INSERT INTO public.person_cursos(person_id, curso_id) VALUES ((SELECT id FROM public.person where document='1399974'), (SELECT id FROM public.curso where orden='3'));
INSERT INTO public.person_cursos(person_id, curso_id) VALUES ((SELECT id FROM public.person where document='1399974'), (SELECT id FROM public.curso where orden='4'));
INSERT INTO public.person_cursos(person_id, curso_id) VALUES ((SELECT id FROM public.person where document='1399974'), (SELECT id FROM public.curso where orden='5'));
INSERT INTO public.person_cursos(person_id, curso_id) VALUES ((SELECT id FROM public.person where document='1399974'), (SELECT id FROM public.curso where orden='6'));




--- datos de prueba
INSERT INTO public.person(id,
                          address, birth_date, document, lastname, name, phone, sex)
VALUES ((select max(id)+1 from public.person), null, null, '654321', 'Perez', 'Juan', null, null);
INSERT INTO public.account(id, document, password, person_id)
VALUES ((select max(id)+1 from public.account), '654321', '654321', (select id from public.person where document = '654321'));
INSERT INTO public.account_roles(account_id, role_id)
VALUES ((select id from public.account where document = '654321'), 5);

INSERT INTO public.person_cursos(person_id, curso_id) VALUES ((SELECT id FROM public.person where document='654321'), (SELECT id FROM public.curso where orden='1'));


--- creacion de materias sin confirmar 7mo grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Cultura Religiosa', 14, (select id from public.curso where orden = 7), (select id from public.person where document = '4549970'));

--- creacion de materias sin confirmar 8vo grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Cultura Religiosa', 14, (select id from public.curso where orden = 8), (select id from public.person where document = '4549970'));

--- creacion de materias sin confirmar 9no grado
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Cultura Religiosa', 14, (select id from public.curso where orden = 9), (select id from public.person where document = '4549970'));

INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4549970'), (select id from public.curso where orden = 7));

INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4549970'), (select id from public.curso where orden = 8));

INSERT INTO public.person_cursos(
    person_id, curso_id)
VALUES ((select id from public.person where document = '4549970'), (select id from public.curso where orden = 9));


--- Crear materias de tercer curso
INSERT INTO public.asignatura(
    id, description, nombre, orden, curso_id, person_id)
VALUES ((select coalesce(max(id)::integer, 0) + 1 as id from public.asignatura), null, 'Metodología de la Investigación', 15, (select id from public.curso where orden = 12), (select id from public.person where document = '2080938'));

-- cambiar de profesor en la materia de estadistica de segundo anho
UPDATE public.asignatura SET person_id=(select id from public.person where document = '420526') WHERE curso_id=(select id from public.curso where orden = 11) and orden=15;

-- cambiar de profesor en la materia de musica de 7, 8, 9
UPDATE public.asignatura SET person_id=(select id from public.person where document = '4469096') WHERE curso_id=(select id from public.curso where orden = 7) and orden=11;
UPDATE public.asignatura SET person_id=(select id from public.person where document = '4469096') WHERE curso_id=(select id from public.curso where orden = 8) and orden=11;
UPDATE public.asignatura SET person_id=(select id from public.person where document = '4469096') WHERE curso_id=(select id from public.curso where orden = 9) and orden=11;

