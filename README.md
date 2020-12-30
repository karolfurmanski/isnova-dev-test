# isnova-dev-test

## Table of contents
* [Technologies](#technologies)
* [Setup](#setup)
* [Instruction](#instruction)

## Technologies
* Java 8
* JUnit 5.7.0
* Mockito 3.6.28
* Lombok 1.18.16
* Apache Commons Lang 3.11


## Setup
1. To build this project, execute command `mvn clean install` in the root directory.
2. To run this project, execute command `java -jar isnova-dev-test-1.0-SNAPSHOT.jar` in **target** directory.


## Instruction
The first element of the program after launching is the menu that allows you to run one of the three tasks:
```
Choose action:

1 - Task 1
2 - Task 2
3 - Task 3
4 - Exit
```

After selecting a specific task, please enter input values.
```
1
1 10 20 20 2 5
1 2 5 10 20
count: 6
distinct: 5
min: 1
max: 20
```

To exit the program please press number 4.
