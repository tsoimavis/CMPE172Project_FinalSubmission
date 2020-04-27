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
 - Class Diagram
<img width="1000" alt="1" src="https://github.com/tsoimavis/CMPE172Project_FinalSubmission/blob/master/cmpe172_project/frontend/src/Component/img/IMG_3585.PNG">
 - Sequence diagrams

#### **6. Schema**

#### **7. DatabaseQueries**
 - Minimum price of product: select min(price) from product

 - Mean price of product: select avg(price) from product
 - Maximum price of product: select max(price) from product
 - Most purchased product: select name, sum(quantity) from product natural join sale group by name order by sum(quantity) desc limit 1

 - Least purchased product: select(name), sum(quantity) from product natural join sale group by name order by sum(quantity) limit 1

- Customer that spent the most: select customer.name, sum(price * quantity) as total from customer natural join sale, product where product.product_ID = sale.product_ID group by customer.name order by total desc limit 1


#### **8. MidtierAPIs**

@RequestMapping (“/api”)
 @GetMapping 

 * (“/customer”): Get the customers’ name, and email.
 * (“/customer/{id}"): Get the customer’s ID.
 * (“/product”): Get the product’s name, price, and category.
 * (“/product/{id}”): Get the product’s id.
 * (“/sale”): Get the customer’s ID, product’s ID, quantity and time.
 * (“/sale/{id}”): Get the sale’s ID. 
 * (“/analytics”): Get the minimum, mean and maximum price; Get most and least purchased; Get the customer who spent most.
 
 @PostMapping

 * (“/customer”): Add a new customer.
 * (“/product”): Add a new product.
 * (“/sale”): Add a new sale.
 
 @DeleteMapping 

 * ("/customer/{id}"): Delete a customer.
 * ("/product/{id}"): Delete a product. 
 * (“/sale/{id}”): Delete a sale.
 
 @PutMapping 

 * (“/customer”): Save the customer’s ID, name, and email. 
 * (“/product”): Save the product’s ID, name, price and category. 
 * (“/sale”): Save the sale’s ID, customer’s ID, product’s ID, quantity and time.

#### **9. UI data transport**

 * Customer: {“Customer ID”, “Name”, “Email”} from @GetMapping(“/api/customer”)
   * {“1”, “Phillip”, “phillip@gmail.com”} 
 * Product: {“Product ID”, “Name”, “Price”, “Category”} from @GetMapping (“/api/product”)
   * (“1”, “Apple”, “0.99”, “Fruits”) 
 * Sale: {“Sale ID”, “Product ID”, “Customer ID”, “Quantity”, “Time”} from @GetMapping (“api/sale”)
   * {“1”, “1”, “1”, “3”, “2020-04-25T09:44:00.000+0000”} 
 * Add Customer: {“Name”, “Email”} from @PutMapping(“/api/customer”)
   * {“Xiaohan”, “sunxiaohan0401@foxmail.com”} 
 * Add Product: {“Name”, “Price”, “Category”} from @PutMapping(“/api/product”)
   * (“Banana”, “2.99”, “Fruits”)
 * Add Sales: {“Product ID”, “Customer ID”, “Quantity”, “Time”} from @PutMapping(“/api/sale”)
   * {“1”, “1”, “3”, “2020-04-25T09:44:00.000+0000”}
* Analytics: {“Minimum Price”, “Mean Price”, “Maximum Price”, “Most Purchased”, “Least Purchased”, “Customer Who Spent Most”}   from @GetMapping(“/api/analytics”)
   * {“$0.99”, “$2.823”, “$9.99”, “Ice Cream”, “Rice”, “Mavis”}
