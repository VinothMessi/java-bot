DROP TABLE IF EXISTS visa;
CREATE TABLE visa AS SELECT * FROM CSVREAD('classpath:tables/visa.csv');