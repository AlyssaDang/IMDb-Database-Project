# IMDb-Database-Project

NOTE: THIS PROJECT HAS BEEN COMPLETED (locally) AND THIS REPOSITORY WILL NO LONGER BE UPDATED

Dataset Link: https://datasets.imdbws.com/

Types of databases: Ones run on your personal computer, ones run on a server (that you own), ones run using a service like AWS

Using PuTTY:
psql -h imdb.cfj1htplvy5o.us-east-1.rds.amazonaws.com  --port=5432 --username=alyssadng1 --password --dbname=imdb

The password is *******

How to Create a Database using Amazon AWS:
1.	Create an AWS or an AWS Educate Account
2.	Go to AWS Management Console
3.	Find the section that says Database
4.	Click on RDS
5.	Click on Create a Database
   -	Standard Create
   -	Click PostgreSQL
   -	Free Tier
   -	DB instance identifier is imdb
   -	Master username is your username (mine is alyssadng1)
   -	Master password is studentpwd
   - 	Scroll Down To Where It Says Connectivity: Select YES for Publicly Accessible
      o  YOU WILL NOT BE ABLE TO CONNECT WITHOUT DOING THIS
   -	Scroll Down To Additional Configuration
   -	For Initial database name, type imdb
6.	Wait for your database to be created
      o	You have to wait until the status says available
7.	Click on the database (the name should be a blue link)
8.	Under Security – VPC, Click on the blue link
   -	The link should look something like: vpc-7dec8507 or vpc-whatever
9.	Right Click on the security group
10.	Select Edit Inbound Rules
11.	Where It Says Source, Select Anywhere
12.	Done

You should be able to access it using:
psql -h imdb.cfj1htplvy5o.us-east-1.rds.amazonaws.com  --port=5432 --username=yourUsername --password --dbname=imdb

Replace: imdb.cfj1htplvy5o.us-east-1.rds.amazonaws.com  with yours, you can find this under your database information
Replace: the username as well


In Java Replace:
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   static final String DB_URL = "jdbc:postgresql://db-315.cse.tamu.edu/hnpatel97_db";
   static final String USER = "hnpatel97";
   static final String PASS = "*******";
  
  With
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   static final String DB_URL = "jdbc:postgresql://imdb.cfj1htplvy5o.us-east-1.rds.amazonaws.com/imdb";
   static final String USER = "alyssadng1";
   static final String PASS = "*******";
