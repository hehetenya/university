CREATE TABLE lector
(
    id     BIGINT AUTO_INCREMENT PRIMARY KEY,
    name   VARCHAR(255) NOT NULL,
    degree VARCHAR(255) NOT NULL,
    salary DOUBLE NOT NULL
);

CREATE TABLE department
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    head_id BIGINT,
    FOREIGN KEY (head_id) REFERENCES lector (id)
);

CREATE TABLE department_lectors
(
    department_id BIGINT NOT NULL,
    lector_id     BIGINT NOT NULL,
    PRIMARY KEY (department_id, lector_id),
    FOREIGN KEY (department_id) REFERENCES department (id),
    FOREIGN KEY (lector_id) REFERENCES lector (id)
);
