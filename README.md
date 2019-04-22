# springboot-aws-dynamodb
Spring Boot Application With AWS DynamoDB 
# What is AWS DynamoDB ?
Amazon DynamoDB is a fully managed proprietary NoSQL database service that supports key-value and document data structures.
Amazon DynamoDB is a fully managed NoSQL database service that provides fast and predictable performance with seamless scalability. 

DynamoDB lets you offload the administrative burdens of operating and scaling a distributed database, so that you don't have to worry about hardware provisioning, setup and configuration, replication, software patching, or cluster scaling. 
With DynamoDB, you can create database tables that can store and retrieve any amount of data, and serve any level of request traffic. 

You can scale up or scale down your tables' throughput capacity without downtime or performance degradation, and use the AWS Management Console to monitor resource utilization and performance metrics.

Amazon DynamoDB provides on-demand backup capability. It allows you to create full backups of your tables for long-term retention and archival for regulatory compliance needs.

### Pricing
DynamoDB charges per GB of disk space a table consumes. The first 25 GB consumed per month is free, and prices start at $0.25 per GB-month thereafter.

### High Availability and Durability
DynamoDB automatically spreads the data and traffic for your tables over a sufficient number of servers to handle your throughput and storage requirements, while maintaining consistent and fast performance.

### DynamoDB supports two types of primary key attributes

``` 
single attribute - Hash Key/Partition Key
this hash key is used to calculate the hash value which is then used to determine the physical 
location where the data will be stored
no two keys can have same values in single attribute 

composite attribute - Hash Key + Range Key/Sort Key
this is a combination of hash key and a range key.
two items can have same hash key but different range key
```

DynamoDBMapper is a Object mapper for domain-object interaction with DynamoDB.

Create a AWS account to access the aws console and create a table in DynamoDB

<img width="1198" alt="Screen Shot 2019-04-13 at 17 59 14" src="https://user-images.githubusercontent.com/30971809/56082191-fccb0b00-5e15-11e9-8d79-9d533ccda9d3.png">

# CRUD Operations from Spring Boot Application to AWS DynamoDB :

Create Employee - POST : http://localhost:9001/dynamoDb

Get Employee - GET : http://localhost:9001/dynamoDb?employeeId=<ID>&lastName=<NAME>

Update Employee - PUT : http://localhost:9001/dynamoDb

Delete Employee - DELETE : http://localhost:9001/dynamoDb/<ID>/<NAME>
