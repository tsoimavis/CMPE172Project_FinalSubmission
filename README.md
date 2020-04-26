### San Jose State University
EnterpriseSoftware-CMPE172/Spring2020

  * Phillip Nguyen
  * Xiaohan Sun 
  * Tsz Ching Tsoi

# Supermarket Inventory System

**1.Project Introduction:**

**2.Sample Demo Screen shots:**

**3.Pre-requisites:**
  - List of required software to download
  - Java JDK
  - Maven
  - mySQL
  - Node.js

**-Any set upsteps**

SQL
```
CREATE TABLE product (
product_ID int NOT NULL PRIMARY KEY AUTO_INCREMENT, 
name varchar(50) DEFAULT NULL,
price double DEFAULT '0.00', 
category varchar(50) DEFAULT NULL);

CREATE TABLE customer (
cus_ID int NOT NULL PRIMARY KEY AUTO_INCREMENT, 
name varchar(50) DEFAULT NULL,
email varchar(50) DEFAULT NULL);

CREATE TABLE sales (
sales_ID int NOT NULL PRIMARY KEY AUTO_INCREMENT, 
product_ID int NOT NULL,
cus_ID int NOT NULL,
quantity int  NOT NULL,
time datetime NOT NULL);
```
  

**Instructions on how to run the project locally.**
```mvn install```

```java -jar target/cmpe172_project-0.0.1-SNAPSHOT.jar```

```localhost:8080```
**UML Diagrams**
  - Class and Sequence diagrams

**Schema**

**DatabaseQueries**

**MidtierAPIs**

**UIdata transport**

**xml,jsonetc**
