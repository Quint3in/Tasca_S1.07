# Task S1.06

## Level 1 Exercise 1
**Description**:
Create a class named NoGenericMethods that stores three arguments of the same type, along with:

    a constructor that initializes them,
    and getElement1(), getElement2(), getElement3() methods to access them.

## Level 1 Exercise 2
**Description**:
Create a Person class with the attributes name, surname, and age. Then create a class named GenericMethods
with a generic method named printElements() that accepts three generic arguments and prints them to the screen.

In the main() of the main class, call this method with different parameter types (for example: a Person object,
a String, and a primitive numeric value).

## Level 2 Exercise 1
**Description**:
Modify the previous exercise so that one of the arguments of the generic method is not generic, but a fixed type,
such as String. The other two arguments must remain generic.

## Level 2 Exercise 2
**Description**:
Adapt the previous exercise so that the method accepts a variable number of generic arguments (varargs). The name
of the method can be printAll().

## Level 3 Exercise 1
**Description**:
Create an interface named Phone with the method call().

Then create three classes:

    Smartphone, which implements Phone and adds the takePhoto() method.
    GenericUtils, with two generic methods:
        The first, named usePhone(), accepts an argument bounded by the Phone interface (T extends Phone) and calls call().
        The second, named useSmartphone(), accepts an argument bounded by the Smartphone class (T extends Smartphone) and calls both call() and takePhoto().
    Main, with the main() method, where a Smartphone object is created and passed to both methods of the GenericUtils class.

## Questions
**Can the method bounded by the Phone interface, inside GenericUtils, call takePhoto()? Why or why not? Reflect on it
and check it in code.**

*<T extends Phone>
You can only call methods of Phone.
If takePhoto() is not in Phone, then it does not compile even if the real object is a Smartphone.*

## 🛠 Technologies
- Backend: Java - Maven

## 🚀 Installation and Execution
1. Clone the repository: `git clone https://github.com/Quint3in/Tasca_S1.06.git`
2. Run the application.