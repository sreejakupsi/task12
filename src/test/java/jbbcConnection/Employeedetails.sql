create database emply;
use emply;
create table employeeDetails(
	empno int unique,
    empname varchar(25) not null,
    job varchar(20),
    mgr int,
    hiredate varchar(15),
    sal decimal (10,4),
    comm decimal(6,4),
    deptno int
);
ALTER TABLE employeeDetails MODIFY comm DECIMAL(8,4);


insert into employeeDetails(empno, empname, job ,mgr , hiredate, sal, comm, deptno) values(8369,'SMIT','CLERK',8902,'1990-12-18','800.00',NULL,20);
insert into employeeDetails(empno, empname, job ,mgr , hiredate, sal, comm, deptno) values(8499,'ANYA','SALESMAN',8698,'1991-02-20','1600.00','300.00',30);
insert into employeeDetails(empno, empname, job ,mgr , hiredate, sal, comm, deptno) values(8521,'SETH','SALESMAN',8698,'1991-02-22','1250.00','500.00',30);
insert into employeeDetails(empno, empname, job ,mgr , hiredate, sal, comm, deptno) values(8566,'MAHADEVAN','MANAGER',8839,'1991-04-02','2985.00',NULL,20);
insert into employeeDetails(empno, empname, job ,mgr , hiredate, sal, comm, deptno) values(8654,'MOMIN','SALESMAN',8698,'1991-09-28','1250.00',1400.00,30);
insert into employeeDetails(empno, empname, job ,mgr , hiredate, sal, comm, deptno) values(8698,'BINA','MANAGER',8839,'1991-05-01','2850.00',NULL,30);
insert into employeeDetails(empno, empname, job ,mgr , hiredate, sal, comm, deptno) values(8882,'SHIVANSH','MANAGER',8839,'1991-06-09','2450.00',NULL,10);
insert into employeeDetails(empno, empname, job ,mgr , hiredate, sal, comm, deptno) values(8888,'SCOOT','ANALYST',8566,'1992-12-09','3000.00',NULL,20);
insert into employeeDetails(empno, empname, job ,mgr , hiredate, sal, comm, deptno) values(8839,'AMIR','PRESIDENT',NULL,'1991-11-18','5000.00',NULL,10);
insert into employeeDetails(empno, empname, job ,mgr , hiredate, sal, comm, deptno) values(8844,'KULDEEP','SALESMAN',8698,'1991-09-08','1500.00',0.00,30);

ALTER TABLE employeeDetails MODIFY empname varchar(25);
UPDATE employeeDetails SET empname='SMITH' WHERE empno=8369;
SELECT * FROM employeeDetails;

-- empname and sal whose salary is greater and equal to 2200
SELECT empname,sal FROM employeeDetails where sal >=2200;

-- employee not getting commission
SELECT * from employeeDetails where comm IS NULL;

-- employee name and salary who dont have their salary range of 2500 to 4000
SELECT empname,sal from employeeDetails WHERE sal  NOT BETWEEN 2400 and 4000;

-- employee name job and salary of employees who dont have manager
SELECT empname,job,sal from employeeDetails WHERE mgr IS NULL;

-- employees who has A as third alphabet
SELECT empname from employeeDetails WHERE empname LIKE '__A%';

-- employees who has T as last alphabet
SELECT empname from employeeDetails WHERE empname LIKE '%T';

 -- use DetailsOfEmpl_JDBC;
 -- SELECT * from DetailsOfEmpl_JDBC;

