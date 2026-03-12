# Task S1.07

## Level 1 Exercise 1
**Description**:
Create an object hierarchy with three classes: Worker,
OnlineWorker and OnsiteWorker.

The Worker class has the attributes name, surname, pricePerHour,
and the method calculateSalary() that receives the number of hours
worked as a parameter and multiplies it by the price per hour. The
child classes must override it using @Override.

From the main() of the Main class, make the necessary invocations
to demonstrate the @Override annotation in action.

For onsite workers, the method to calculate their salary will
receive as a parameter the number of hours worked per month.
When calculating the salary, the number of hours worked is
multiplied by the price per hour, plus the value of a static
attribute called fuel that we will add in this class.

For online workers, the method to calculate their salary will
receive as a parameter the number of hours worked per month.
When calculating the salary, the number of hours worked is
multiplied by the price per hour and the price of the flat
Internet fee is added, which will be a constant in the
OnlineWorker class.

## Level 1 Exercise 2
**Description**:
Add some deprecated methods to the child classes and use the
corresponding annotation. Invoke the deprecated methods from an
external class, suppressing the warnings for being deprecated
with the corresponding annotation.

## Level 2 Exercise 1
**Description**:
Create a custom annotation that allows serializing a Java object
to a JSON file. The annotation must receive the directory where
the resulting file will be placed.

## Level 3 Exercise 1
**Description**:
Add the possibility for the annotation created in the previous
level to be registered by the Virtual Machine at runtime.
Demonstrate that the annotation is read using Java Reflection.

## 🛠 Technologies
- Backend: Java - Maven

## 🚀 Installation and Execution
1. Clone the repository: `git clone https://github.com/Quint3in/Tasca_S1.07.git`
2. Run the application.
