-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

DROP TABLE PERSON;

CREATE TABLE PERSON (
ID NUMBER(10,0) NOT NULL AUTO_INCREMENT,
NAME VARCHAR2(255) DEFAULT NULL,
AGE NUMBER(10, 0) DEFAULT NULL,
PRIMARY KEY (ID));

DROP SEQUENCE hibernate_sequence;

CREATE SEQUENCE hibernate_sequence;