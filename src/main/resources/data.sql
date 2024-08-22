INSERT INTO lector (id, name, degree, salary)
VALUES (1, 'Ivan Melnyk', 'PROFESSOR', 5000);
INSERT INTO lector (id, name, degree, salary)
VALUES (2, 'Maria Shevchenko', 'ASSOCIATE_PROFESSOR', 4000);
INSERT INTO lector (id, name, degree, salary)
VALUES (3, 'Yuriy Kovalenko', 'ASSISTANT', 3000);
INSERT INTO lector (id, name, degree, salary)
VALUES (4, 'Anna Bondarenko', 'PROFESSOR', 6000);

INSERT INTO department (id, name, head_id)
VALUES (1, 'Computer Science', 1);
INSERT INTO department (id, name, head_id)
VALUES (2, 'Mathematics', 2);

INSERT INTO department_lectors (department_id, lector_id)
VALUES (1, 1);
INSERT INTO department_lectors (department_id, lector_id)
VALUES (1, 2);
INSERT INTO department_lectors (department_id, lector_id)
VALUES (2, 2);
INSERT INTO department_lectors (department_id, lector_id)
VALUES (2, 3);
INSERT INTO department_lectors (department_id, lector_id)
VALUES (2, 4);
