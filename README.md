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

 - Any set upsteps
 
1. Get SQL database directory, username and password ready for SQL connectivity later. 
For example,database directoryfor a amazon RDS connection point will be like
```
jdbc:mysql://aws-user.dshdigdlw3t54.us-west-1.rds.amazonaws.com/supermarket
```

2. create three mySQL table to in mySQL store application data as below.
   
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
3. In /cmpe172_project/src/main/resources/application.properties, 
```
spring.datasource.url=yourDatabaseURL
spring.datasource.username=yourUserName
spring.datasource.password=yourPassword
server.port=8080
```
Change yourDatabaseURL, yourUserName, yourPasswordto your own credentials.

**4. Instructions on how to run the project locally.**

```mvn install```

```java -jar target/cmpe172_project-0.0.1-SNAPSHOT.jar```

```localhost:8080```

**5. UML Diagrams**
 - Class and Sequence diagrams

**6. Schema**

**7. DatabaseQueries**

**8. MidtierAPIs**

**9. UI data transport**
