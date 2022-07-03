## 1. General

What is Oracle Functions?

Oracle Functions is a serverless platform that lets developers create, run, and scale
applications without managing any infrastructure. Functions integrate with Oracle Cloud
Infrastructure, platform services and SaaS applications. Functions is based on the open
source [Fn Project](https://fnproject.io/). Code based on Functions typically runs for a short duration, and
customers pay only for the resources they use while their function is running.

Which languages does Oracle Functions support?

Oracle Functions is based on open source Fn Project which provides function development
kits (FDKs) for Java (including, the GraalVM native image), Python, Node, Go and Ruby, and
in addition, lets you bring your own Dockerfile.

# 2.About MysqlFunction

- MySqlFunction is developed based on Fn Project written in Java and manages the user inputs/outputs and use MySqlWrapper class to help user interact with mysql instance 
- Dockerfile contains configurations
- func.yaml contains input method to be invoked and version details
- pom.xml contains dependencies(mysql-connector-java and some helpers)

# 2.How to use 

To clone this repository:
```
git clone https://github.com/iabhilash/function-mysqlwrapper-fdk.git
```

Get inside the project folder:
```
cd function-mysqlwrapper-fdk
```

Build the project and execute the unit tests:
```
mvn clean install
```


