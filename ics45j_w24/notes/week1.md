## Week 1
### 1-1
####  Intro
- Java is an object-oriented, portable, statically-typed, interpreted and compiled programming language
- Errors happen at either compile-time (programming language errors) or run-time (execution errors)
####  Objects and Classes
- Object: an entity in your program that you can manipulate by calling one or more of its methods
- Method: consists of a sequence of instructions that can access the data of an object
- Methods are attached to Objects
- You do not know what inside the method look like when calling a method
- All you know is what the inputs and the outputs are
- All objects of a particular class share the same behavior
- Different classes have different responsibilities
#### Variables
int quantity = 5;  
double price = 3.99;  
String greetings = "Hello Java!";  
int x = 3, y = 4;  
// Single line comments  
/*  
Multi-line comments  
*/  
#### Methods
- You use an object by calling its methods
- All objects of a given class share a common set of methods

modifier return-type method-name (parameter-list) {  

}  
#### API Docs
- Java classes are grouped into packages
- You do not need to import classes in the java.lang package such String, Math, and System
#### Constructing Objects

Rectangle box = new Rectangle(5, 10, 20, 30);  
#### Accessors and Mutators
- Accessor method: does not change the internal data of the object on which it is invoked
    - Returns information about the object
- Mutator method: changes the data of the object
#### Object references
- An object variable is a variable whose type is a class
    - Does not actually hold an object. Holds the memory location of an object
- Object reference: descibes the memory location of an object

Rectangle box = new Rectangle(5, 10, 20, 30);  
- Variable box refers to the Rectangle object returned by the new operator. The box variable does not contain. It refers to the object
- Multiple object variables can refer to the same object
- Numbers are not objects
    - Number variables actually store numbers

int luckyNumber = 13;  
- When you copy a number
    - The original and the copy are independent values

int luckyNumber  = 13;  
int luckyNumber2 = luckyNumber;  
luckyNumber2 = 12;  

- The value in luckyNumber is not changed
- When you copy an object reference
    - Both the original and the copy are references to the same object

Rectangle box = new Rectangles(5, 10, 20, 30);  
Rectangle box2 = box;  
box2.translate(15, 25);  

- The variable box is also changed since box and box2 both refer to the same object

#### Summary
- Objects are entities in your program that you manipulate by calling methods
- A class describes a set of objects with the same behavior
- Variables must have a type specified when declared, and must be initialized before you access them
- An accessor method does not change the internal data of the object on which it is invoked. A mutator mehtod changes the data
- The API documentation lists the classes and methods of the Java library
- Number variables store numbers; object variables store references

### 1-2
#### Summary
- An object's instance variables store the data required for executing its methods
- Encapsulation is the process of hiding implementation details and providing methods for data access
- The public interface of a class consists of its public constructors and methods
- The private implementation of a class consists of instance variables, and the bodies of constructors and methods
- Local and parameter variables belong to methods; instance variables belong to objects
- The this reference denotes the implicit parameter that is passed when a method is called

## Week 2
### 2-1
#### Constant: Final
- A final variable is a constant
- Once its value has been set, it cannot be changed
- Named constants make programs easier to read and maintain.
- Convention: use all uppercase names for constants:

final double QUARTER_VALUE = 0.25;  

#### Arithmetic Operators
- Division works as you would expect, as long as at least one of the numbers is a floating-point number.

double x = 7.0 / 4.0  
double y = 7 / 4.0  
double z = 7.0 / 4 
// x = y = z   

n % 10 // Always returns the last digit of n  
n / 10 // Always returns n without the last digit  
-n % 10 // The remainder is negative if the first argument is negative  

#### Cast Operator
- Cast operator has higher precedence than arithmetic operators

int x = (int) Math.random() * 26 + 18; // x = 18  
int x = (int) (Math.random() * 26) + 18; // x = (18 to 43)  

#### String Input
- Use the next method of the Scanner class to read a string containing a single word
- Only one word is read at a time
- Use a second call to in.next to get a second word

Scanner in = new Scanner(System.in);  
System.out.print("Please enter your name (first middle last): ");  
String firstName = in.next();  
String middleName = in.next();  
String lastName = in.next();  

#### Summary
- Java has eight primitive types, including four integer types and two floating-point types
- A final variable is a constant whose value cannot be changed
- Mixing integers and floating-point values in an arithmetic expression yields a floating-point value
- The Java library declares many mathematical functions, such as Math.sqrt and Math.pow
- Use the Scanner class to read keyboard input in a console window
- Use the printf method to specify how values should be formatted
- The most important Java String operations are length, substring, charAt, and + (concatenation)
- Use the next method of the Scanner class to read a string containing a single word

### 2-2
#### 