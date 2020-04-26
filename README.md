#### San Jose State University
#### EnterpriseSoftware-CMPE172/Spring2020

 - Phillip Nguyen
 - Xiaohan Sun
 - Tsz Ching Tsoi


## :watermelon::banana::green_apple::peach:Supermarket Inventory System:strawberry::grapes::lemon::orange: 

#### **1.Project Introduction:**

#### **2.Sample Demo Screen shots:**
<img width="500" alt="1" src="https://github.com/tsoimavis/CMPE172Project_FinalSubmission/blob/master/cmpe172_project/frontend/src/Component/img/1.png">
<img width="500" alt="1" src="https://github.com/tsoimavis/CMPE172Project_FinalSubmission/blob/master/cmpe172_project/frontend/src/Component/img/2.png">
<img width="500" alt="1" src="https://github.com/tsoimavis/CMPE172Project_FinalSubmission/blob/master/cmpe172_project/frontend/src/Component/img/3.png">
<img width="500" alt="1" src="https://github.com/tsoimavis/CMPE172Project_FinalSubmission/blob/master/cmpe172_project/frontend/src/Component/img/4.png">

#### **3.Pre-requisites:**

_ _List of required software to download_ _
   - [Java JDK](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html): Build java mid tier with spring boot
   - [Maven](https://maven.apache.org/download.cgi): Build executable jar application with spring boot
   - [mySQL](https://dev.mysql.com/downloads/): Databasse tier to hold application data (mySQL workbench is recommended for SQL beginingers)
   - [Node.js](https://nodejs.org/en/download/): Build Front end UI with spring boot

_ _Set up steps_ _
 
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

#### **4. Instructions on how to run the project locally.**

Open terminal from /cmpe172_project directory
```
mvn install
```
When build success, run the following code
```
java -jar target/cmpe172_project-0.0.1-SNAPSHOT.jar
```
Open browert after the applicaiton is running. It should be on localhost port 8080
```
localhost:8080
```

#### **5. UML Diagrams**
 - Class and Sequence diagrams

#### **6. Schema**

#### **7. DatabaseQueries**

#### **8. MidtierAPIs**

#### **9. UI data transport**
