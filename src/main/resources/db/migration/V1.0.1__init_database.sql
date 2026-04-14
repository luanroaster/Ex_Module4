CREATE DATABASE IF NOT EXISTS employee_management;
USE employee_management;

CREATE TABLE department
(
    id    INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)      not null NULL

);

CREATE TABLE employee
(
    id            INT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255)    NOT   NULL,
    dob           date            NOT   NULL,
    gender        ENUM ('MALE', 'FEMALE')   NOT   NULL,
    salary        DECIMAL(15,2)   NOT   NULL,
    phone         VARCHAR(255)    NOT   NULL,
    department_id INT             NOT   NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id)
);


INSERT INTO department
VALUES
    (1,'Human Resources'),
    (2,'Information Technology'),
    (3,'Finance'),
    (4,'Marketing');


INSERT INTO employee
VALUES (NULL, 'Nguyen Van A', '1998-05-10', 'MALE', 1200, '0901234567', 2),
       (NULL, 'Tran Thi B', '1999-08-21', 'FEMALE', 1100, '0901234568', 1),
       (NULL, 'Le Van C', '1997-12-15', 'MALE', 1500, '0901234569', 3),
       (NULL, 'Pham Thi D', '2000-03-01', 'FEMALE', 1300, '0901234570', 4)


