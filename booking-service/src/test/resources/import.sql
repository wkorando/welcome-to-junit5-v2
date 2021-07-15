CREATE TABLE customers (
id SERIAL, 
first_name varchar(20),
last_name varchar(20),
middle_name varchar(20),
suffix varchar(5));

INSERT INTO customers (first_name, last_name, middle_name, suffix) VALUES (4, 'John', 'Doe', 'Middle', '');	
INSERT INTO customers (first_name, last_name, middle_name, suffix) VALUES (5, 'Jane', 'Doesf', 'Middleth', '');