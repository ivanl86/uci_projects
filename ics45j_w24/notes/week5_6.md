## Week 5
### 5-1
#### Defining an Interface Type
public interface InterfaceName {  
&nbsp;&nbsp;&nbsp;&nbsp;method header;  
}  

- Difference between classes and interfaces:
    - An interface type does not have instance vairables
    - All methods in an interface type are abstract
        - They have a name, parameters, and a return type, but no implementation
    - All methods in an interface type are automatically public
    - An interface type has no constructor
        - You cannot construct objects of an interface type
    - Java 8 introduced static, default, and private methods to interfaces, as well as static final variables
#### Comparing Interfaces and Inheritance
- A class can implement more than one interface:

public class Country implements Measurable, Named {...}   

- A class can only extend (inherit from) a single superclass
- An interfaces specifices the behavior that an implementing class should supply
    - "Behaves-like-a" relationship
- A superclass provides some implementation that a subclass inherits
    - "Is-a" relationship
- Develop interfaces when you have code that process objects of different classes in a common way
- In Java 8 and above you can now supply a default implementation
#### Summary
- A java interface type declares the methods that can be applied to a variable of that type
- Use interfaces for making a service available to multiple classes and to make code more reusable
- The main advantage of interfaces over abstract classes is that a class can implement several interfaces but extend only one superclass
- Develop interfaces when you have code that processes objects of different classes in a common way
### 5-2
#### Inner Classes
- An inner class is a class that is declared inside another class
- You can declare an inner class inside an enclosing class, but outside its methods
- It is avaviable to all methods of the enclosing class

public class outter {  
&nbsp;&nbsp;&nbsp;&nbsp;class inner {...}  
&nbsp;&nbsp;&nbsp;&nbsp;...  
}  

- Inner classes are commonly used for utility classes that shold not be visible elsewhere in a program

#### Summary
- Implement the Comparable interface so that objects of your class can be compared, for example, in a sort method
- A callback is a mechanism for specifying code that is executed at a later time
- Use inner classes to limit the scope of a utility class

## Week 6
### 6-1
#### Reading Text Files
- Use the Scanner class for reading text files
- To read from a disk file
    - Construct a File object represneting the input file
    - Use this File object to construct a Scanner object
    - Use Scanner methods to read data from the file
        - next, nextLine, nextInt, and nextDouble

File inputFile = new File ("input.txt");  
Scanner in = new Scanner(inputFile);  
while (in.hasNextDouble()) {  
&nbsp;&nbsp;&nbsp;&nbsp;double value = in.nextDouble();  
&nbsp;&nbsp;&nbsp;&nbsp;// Process value  
}  

#### Writing Text Files
- To write to a file, construct a PrintWriter object
    - If file already exists, it is emptied before the new data is written into it
    - If file doesn't exist, an empty file is created
    - Use print and println to write into a PrintWriter

PrintWriter out = new PringWriter("output.txt");  
out.println("Hello, Java!");  
out.printf("Total: %8.2f\n", total);  


- You must close a file when you are done processing it:

in.close();  
out.close();  

#### Text Input and Output
- The next method returns any sequence of characters that is not white space
- White space includes: spaces, tab characters, and the newline characters that separate lines
- When next is called
    - Input characters that are white spaces are consumed - removed from the input

#### Reading Characters
- To read one character at a time, set the delimiter pattern to the empty string:

Scanner in = new Scanner(...);  
in.useDelimiter("");  

While (in.hasNext()) {  
&nbsp;&nbsp;&nbsp;&nbsp;char ch = in.next().charAt(0);  
&nbsp;&nbsp;&nbsp;&nbsp;// Process ch  
}  

#### Exception Handling
- Exceptions fall into three categories:
    - Internal errors are reported by descendants of the type Error
        - Example: OutOfMemoryError
    - Descendants of RuntimeException
        - Example: IndexOutOfBoundsException or IllegalArgumentException
        - Indicate errors in your code
        - They are called **unchecked** exceptions
        - The compiler does not check whether you handle an unchecked exception
    - All other exceptions are called **checked** exceptions
        - Example: IOException
        - Indicate that something has gone wrong for some external reason beyond your control
        - The compiler checks that your program handles these exceptions
- Use the try-with-resources statement:
    - If no exception occurs, out.close() is called after writeData() returns
    - If an exception occurs, out.close() is called before exception is passed to its handler

try (PrintWriter out = new PrintWriter(filename)) {  
&nbsp;&nbsp;&nbsp;&nbsp;writeData(out);  
} // out.close() is always called  

#### Summary
- Use the Scanner class for reading text files and the PrintWriter class for writing text files
- Process text in files using the next and nextLine methods, the Character class methods, and Integer.parseInt or Double.parseDouble
- Programs that start from the command line receive the command line arguments in the main method
- Use exception handling to transfer control from an error location to an error handler using try, catch, and throws clauses

### 6-2
- When designing a program, you work from a requirements specification
    - The designer's task is to dicover structures that make it possible to implement the requirements
- To discover classes, look for nouns in the problem description
- Find methods by looking for verbs in the task description
- After you have a set of classes
    - Define the behavior (methods) of each class
- Look for verbs in the task description
    - Match the verbs to the appropriate objects
- The invoice program needs to compute the amount due
    - Which class is responsible for this method?
        - Invoice class
- To find the class responsibilities, use the CRC card mehtod
- A CRC card describes a class, its responsibilities, and its collabortating classes
    - CRC = "classes", "responsibilities", "collaborators"
- Use an index card for each class
- Pick the class that should be responsible for each method (verb)
- Write the responsibility onto the class card
- Indicate what other classes are needed to fulfill responsibility (collaborators)

#### Relationships Between Classes
- The most common types of relationships:
    - Dependency
    - Aggregation
    - Inheritance

#### Dependency
- A class depends on another class if it uses objects of that class
    - The "knows about" relationship
- Example: CashRegister depends on Coin
- It is good practice to minimize the coupling (e.g., dependency) between classes
- When a class changes, coupled classes may also need updating

#### Aggregation
- A class aggregates another if its objects contain object(s) of the other class
    - The "has-a" relationship
- Example: A quiz class aggregates a Question class
- Aggregation is a stronger form of dependency
- Use aggregation to remember another object between method calls
- A class may use another class (e.g., Scanner) without ever declaring an instance variable of class Scanner
    - E.g., by getting it passed in as a parameter
    - This is dependency, **NOT** aggregation

#### Inheritance
- Inheritance is a relationship between a more general class (the superclass) and a more specialized class (the subclass)
    - The "is-a" relationship
    - Example: Every truck is a vehicle
- Every car is a vehicle (Inheritance)
- Every car has a tire (or four) (Aggregation)
- Aggregation denotes that objects of one class contain reference(s) to object(s) of another class
#### Five-Part Program Development Process
- Gather requirements
- Use CRC cards to find classes, responsibilities, and collaborators
- Use UML diagrams to record class relationships
- Use javadoc to document mehtod behavior
- Implement your program

#### Summary
- To discover classes, look for nouns in the problem description
- A CRC card describes a class, its responsibilities, and its collaborating classes
- The main relationships between classes are dependency, inheritance, and aggregation
- It is good practice to minimize the coupling/dependency between classes

### Quiz Highlights
#### 5-1
- What is an abstract class
    - An abstract class contains at least one abstract method and the class itself is declared abstract
- In an abstract class, why is it better to use an abstract method rather than an empty method?
    - An abstract method enforces that all the subclasses must define the abstract method. You do not want to assume the subclass will override the empty method

#### 5-2
- Define concrete class
    - A concrete class has all of its methods defined and must not be an abstract class

#### 6-1
- Suppose r contains a reference to a new Rectangle(5, 10, 20, 30). Which of the following assignments is legal?
    - Rectangle a = r; // Correct
    - Shape b = r; // Correct
    - String c = r;
    - ActionListener d = r;
    - Measurable e = r;
    - Serializable f = r; // Correct
    - Object g = r; // Correct
- Suppose the input contains the characters **995.0 Fred**. What are the values of number and input after this code fragment?

int number = 0;  
if (in.hasNextInt()) {  
    nmber = in.nextInt();  
}  
String input = in.next();  

- number = 0
- input = "995.0"


- Suppose the input contains the characters **6000000 6,995.00**. What are the values of x1 and x2 after this code fragment?

double x1 = in.nextDouble();  
double x2 = in.nextDouble();  

- x1 = 6000000.00
- x2 = 6995.00

#### 6-2
- Why is an ArrayIndexOutOfBoundsException not a checked exception?
    - Because it is the programmer's responsibility to make sure that the index is not out of bounds.
- Why should coupling be minimized between classes?
    - When making changes in one classes, low coupling can minimize the chance of breaking other classes