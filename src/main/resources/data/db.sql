
CREATE DATABASE employee_management;
USE employee_management;

--  Tạo bảng department với khóa chính tự tăng
CREATE TABLE department
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

--  Tạo bảng employee dùng UUID làm id
CREATE TABLE employee
(
    id            BINARY(16) PRIMARY KEY,
    name          VARCHAR(100) NOT NULL,
    dob           DATE,
    gender        ENUM ('MALE', 'FEMALE', 'OTHER'),
    salary        DOUBLE,
    phone         VARCHAR(15) UNIQUE,
    department_id INT,
    CONSTRAINT fk_employee_department
        FOREIGN KEY (department_id) REFERENCES department (id)
);

--  Trigger tự tạo UUID nếu id = NULL
DELIMITER $$

CREATE TRIGGER before_insert_employee
    BEFORE INSERT
    ON employee
    FOR EACH ROW
BEGIN
    IF NEW.id IS NULL OR NEW.id = '' THEN
        SET NEW.id = UUID();
    END IF;
END$$

DELIMITER ;

-- 5) Insert dữ liệu mẫu vào bảng department
INSERT INTO department (name)
VALUES ('Human Resources'),
       ('Information Technology'),
       ('Finance'),
       ('Marketing');

-- Insert dữ liệu mẫu vào bảng employee
-- Có thể để id = NULL để trigger tự sinh UUID
INSERT INTO employee (id, name, dob, gender, salary, phone, department_id)
VALUES (NULL, 'Nguyen Van A', '1998-05-10', 'MALE', 1200, '0901234567', 2),
       (NULL, 'Tran Thi B', '1999-08-21', 'FEMALE', 1100, '0901234568', 1),
       (NULL, 'Le Van C', '1997-12-15', 'MALE', 1500, '0901234569', 3),
       (NULL, 'Pham Thi D', '2000-03-01', 'FEMALE', 1300, '0901234570', 4);