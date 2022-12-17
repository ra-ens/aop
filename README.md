# AOP and AspectJ
This repository contains a demonstrations of Aspect-Oriented Programming (AOP) using the AspectJ framework.

### What is AOP?
AOP is a programming paradigm that aims to increase modularity by allowing the separation of cross-cutting concerns. 
It does this by adding additional behavior to existing code without modifying the code itself. 
This can be accomplished by applying aspects to certain points, called "join points", in the code execution.

### What is AspectJ?
AspectJ is a Java-based AOP framework that allows developers to create and apply aspects in Java programs. 
It provides a set of tools and libraries for defining and applying aspects, including a compiler and a runtime environment.

### Prerequisites
To run this repository, you will need the following:

Java Development Kit (JDK)
AspectJ runtime library
A Java development environment (IDE) such as Eclipse or IntelliJ IDEA

### Getting Started
1. Clone the repository: `git clone https://github.com/ra-ens/aop.git`
2. Import the project into your preferred Java IDE
3. Run the project to see how AOP works in action

### Aspects
This repository contains the following aspects:

#### LoggingAspect
This aspect demonstrates how to use AspectJ to add logging to a Java program, the log is saved in a file called log.xml
```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<!DOCTYPE log SYSTEM "logger.dtd">
<log>
<record>
  <date>2022-12-17T14:33:14.461605100Z</date>
  <millis>1671287594461</millis>
  <nanos>605100</nanos>
  <sequence>0</sequence>
  <logger>aspects.Log</logger>
  <level>INFO</level>
  <class>aspects.Log</class>
  <method>afterAllServiceMethods</method>
  <thread>1</thread>
  <message>Sat Dec 17 15:33:14 WEST 2022 : addAccount executed for 0.1ms</message>
</record>
<record>
  <date>2022-12-17T14:33:17.473615200Z</date>
  <millis>1671287597473</millis>
  <nanos>615200</nanos>
  <sequence>1</sequence>
  <logger>aspects.Log</logger>
  <level>INFO</level>
  <class>aspects.Log</class>
  <method>afterAllServiceMethods</method>
  <thread>1</thread>
  <message>Sat Dec 17 15:33:17 WEST 2022 : getAccount executed for 0.1ms</message>
</record>
</log>
```

#### SecurityAspect
This aspect shows how to add an authentication layer to a Java application, the following is the authentication step before the app business logic started. 

![image](https://user-images.githubusercontent.com/96893314/208248035-e6eee576-d6e3-4d82-af6c-1a0654798faf.png)
![image](https://user-images.githubusercontent.com/96893314/208248274-fe4b09c6-1699-4d6c-8120-0a7816adffda.png)
![image](https://user-images.githubusercontent.com/96893314/208248302-4de0d2a7-6345-4edb-8512-b7bb5cf624f1.png)

#### PathAspect
This aspect illustrates how to use AOP to manage business logic
