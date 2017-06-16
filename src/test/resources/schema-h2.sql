-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

DROP TABLE PERSON;

CREATE TABLE PERSON (
ID NUMBER(10,0) NOT NULL AUTO_INCREMENT,
NE VARCHAR2(255) DEFAULT NULL,
AE NUMBER(10, 0) DEFAULT NULL,
PRIMARY KEY (ID));

DROP SEQUENCE hibernate_sequence;

CREATE SEQUENCE hibernate_sequence;