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

INSERT INTO public.account(id, document, password, person_id, role_id)
	VALUES (1, '4204613', 'l0k0lte.', 1, 3);

INSERT INTO public.person(id, document, name, lastname, birth_date, phone, sex, address)
	VALUES (2, '4653346', 'Veronica', 'Gayoso', now(), '0981719893', 'FEMENINO', 'Juan de Garay 1634');

INSERT INTO public.account(id, document, password, person_id, role_id)
	VALUES (2, '4295176', 'vrito', 2, 1);