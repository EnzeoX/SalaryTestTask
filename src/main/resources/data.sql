DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
    emp_id NUMBER(4) NOT NULL,
    last_name VARCHAR2(30) NOT NULL,
    first_name VARCHAR2(30),
    dept_id NUMBER(2),
    job_cat VARCHAR2(30),
    salary NUMERIC
);

DROP TABLE IF EXISTS departmets;

CREATE TABLE departments (
    dept_id NUMBER(4) NOT NULL,
    dept_name VARCHAR2(30) NOT NULL
);