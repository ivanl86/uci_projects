## Week 3
### 3-1
#### Common Error: Infinite Loops
- Off-by-one error: a loop executes one too few, or one too
many times
#### Summary
- A loop executes instructions repeatedly while a condition is true
- An off-by-one error is common when programming loops
    - Think through simple test cases to avoid this type of error
- The for loop is used when a value runs from a starting point to an ending point with a constant increment or decrement
- The do loop is appropriate when the loop body must be executed at least once
- When the body of a loop contains another loop, the loops are nested.

### 3-2
#### Arrays
- To make a true copy of an array, call the Arrays.copyOf method:

import java.util.Arrays;  
double[] values = {32.0, 60.3, 57.9};  
double[] prices = Arrays.copyOf(values, values.length);  

- Not suitable for all array algorithms
- Does not allow you to modify the contents of an array
- Use the enhanced for loop if you do not need the index values in the loop body

#### Enchanced For Loop
for (double element : values) {  
&nbsp;&nbsp;&nbsp;&nbsp;element = 0; // ERROR: this assignment does not modify array elements  
}  
for (int i = 0; i < values.length; i++) {  
&nbsp;&nbsp;&nbsp;&nbsp;values[i] = 0; // This assignment modifies array elements  
}  

#### Two-Dimensional Arrays
- Access elements by using two index values, array[row][col]

int medalCount = counts[3][1];  

- Number of rows: counts.length
- Number of columns: counts[row].length

#### Array Lists
ArrayList<String> names = new ArrayList<String>(); // Constructs an empty array list that can hold strings  
names.add("Ann"); // Adds elements to the end  
names.add("Cindy"); // Adds elements to the end  
System.out.println(names); // Prints [Ann, Cindy]  
names.add(1, "Bob"); // Inserts an element at index 1. names is now [Ann, Bob, Cindy]  
names.remove(0); // Removes the element at index 0. names is now [Bob, Cindy]  
names.set(0, "Bill"); // Replaces an element with a different value. names is now [Bill, Cindy]  
String name = names.get(i); // Gets an element at index i  
String last = names.get(names.size() - 1); // Gets the last element   
for (String name : names) {  
&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(name); // Visit all the elements and print  
}  
ArrayList<String> newNames = new ArrayList<String>(names); // Makes a copy of names  
ArrayList<Integer> squares = new ArrayList<Integer>();  
for (int i=0; i<10; i++) {  
&nbsp;&nbsp;&nbsp;&nbsp;squares.add(i * i); // Constructs an array list holding the first ten squares  
}  

#### Summary
- Use arrays for collecting values when the size of the collection never changes
- Use two-dimensional arrays for data that is arranged in rows and columns
- Use array lists for managing collections whose size can change
- The enhanced for loop can be used to visit all elements of an array or an array list

## Week 4
### 4-1
#### Discovering Classes
- A class represents a single concept from the problem domain
- The name of a class should be a noun that describes the concept
- Look for nouns in the problem description
- A class name should indicate what objects of the class will do: Paycheck is a better name than PaycheckProgram
- Do not turn a single operation action into a class: Paycheck is a better name than ComputePaycheck
- A class should represent a single concept
- The public interface of a class is cohesive if all of its features are related to the concept that the class represents
- The members of a cohesive team have a common goal

#### Minimizing Denpendcies
- Best to decouple input/output from the work of your classes
- Place the code for producing output or consuming input in a separate class

#### Separating Accessors and Mutators
- A mutator method changes the state of an object
- An accessor method asks an object to compute a result, without changing the state
- An immutable class has no mutator methods, e.g., String
- References to objects of an immutable class can be safely shared
- Most of the time, mutators should have return type void
    - Sometimes a mutator can return an informational value
        - ArrayList.remove method returns true if the removal was successful

#### Minimizing Side Effects
- A side effect of a method is any externally observable data modification
- Mutator methods have a side effect, namely the modification of the implicit parameter
- In general, a method should not modify its parameter variables
    - But there are exceptions!

public double getTotalBalance(ArrayList<String> accounts) {  
&nbsp;&nbsp;&nbsp;&nbsp;double sum = 0;  
&nbsp;&nbsp;&nbsp;&nbsp;while (studentNames.size() > 0) {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;BankAccount account = accounts.remove(0); // Not recommended  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;sum = sum + account.getBalance();  
&nbsp;&nbsp;&nbsp;&nbsp;}  
&nbsp;&nbsp;&nbsp;&nbsp;return sum;  
}  

#### Patterns for Object Data – Managing Properties of an Object
- A property is a value of an object that an object user can set and retrieve
- Provide an instance variable to store the property’s value and methods to get and set it
- It is common to add error checking to the setter method:

public void setName(String newName) {  
&nbsp;&nbsp;&nbsp;&nbsp;if (newName.length() > 0) { name = newName; }  
}  

#### Packages
- Package: Set of related classes
- In Java, related classes are grouped into packages

#### Summary
- A class should represent a single concept from a problem domain
- Design methods that are cohesive, consistent, and minimize side effects
- Use patterns to design the data representation of an object
- Static variables and methods belong to the class, not to any object of the class
    - Static methods are not invoked on an object
- Use packages to organize sets of related classes
- Use JUnit for writing unit tests

#### Unit Testing Frameworks
- Unit test frameworks simplify the task of writing classes that contain many test cases
- JUnit: http://junit.org
    - Built into some IDEs like BlueJ and Eclipse
- Philosophy:
    - Whenever you implement a class, also make a companion test class
    - Run all tests whenever you change your code
- Customary that the name of the test class ends in “Test”

### 4-2
#### Object: The Cosmic Superclass
- When you implement equals in a subclass, you should first call equals in the superclass to check whether the superclass instance variables
match
if (!super.equals(otherObject))  
&nbsp;&nbsp;&nbsp;&nbsp;{ return false; }  

#### Summary
- A subclass inherits data and behavior from a superclass
- You can always use a subclass object in place of a superclass object
- A subclass can override a superclass method by providing a new implementation
- Use the reserved word super to call a superclass method
- Polymorphism allows us to manipulate objects that share a set of tasks, even though
the tasks are executed in different ways
- All Java objects descend from the Object class
    - The toString and equals methods are useful to override in custom classes
- The instanceof operator tests whether an object belongs to a particular type

#### Quiz Highlights
##### 3-1
##### 3-2
##### 4-1
- Suppose your homework assignments are located in the directory /home/me/ics45j (c:\Users\me\ics45j on Windows). Your instructor tells you  to place your homework into packages. In which directory do you place the class hw1.problem1.TicTacToeTester?
- Your Answer:
    - c:\Users\me\ics45j\hw1\problem1\

##### 4-2
- Assuming SavingsAccount is a subclass of BankAccount, which of the following code fragments are  valid in Java? (Mark all that apply.)
    - BankAccount account = new SavingsAccount(); // (correct)
    - SavingsAccount account2 = new BankAccount();
    - SavingsAccount account2 = account;
- Only the first one is correct because a child class variable cannot hold a superclass type
- How could you declare an array quiz that can hold a mixture of Question and ChoiceQuestion objects?
    - Question[] quiz = new Question[SIZE]; // (correct)
    - Question[] quiz = new ChoiceQuestion[SIZE];
    - ChoiceQuestion[] quiz = new Question[SIZE];
    - ChoiceQuestion[] quiz = new ChoiceQuestion[SIZE];
- The first one is correct because only Question type can hold both Question and ChoiceQuestion objects
- Consider the following two classes:

public class ClassA {  
&nbsp;&nbsp;&nbsp;&nbsp;public void method1() {  
&nbsp;&nbsp;&nbsp;&nbsp;System.out.println( “J” );  
&nbsp;&nbsp;&nbsp;&nbsp;}	

&nbsp;&nbsp;&nbsp;&nbsp;public void method2()	{  
&nbsp;&nbsp;&nbsp;&nbsp;System.out.println( “K” );  	  
&nbsp;&nbsp;&nbsp;&nbsp;method1();  
&nbsp;&nbsp;&nbsp;&nbsp;}  
}  

public class ClassB extends ClassA {  
&nbsp;&nbsp;&nbsp;&nbsp;public void method1()	{  
&nbsp;&nbsp;&nbsp;&nbsp;System.out.println( “L” );  
&nbsp;&nbsp;&nbsp;&nbsp;}	 

&nbsp;&nbsp;&nbsp;&nbsp;public void method3()	{  
&nbsp;&nbsp;&nbsp;&nbsp;System.out.println( “M” );  
&nbsp;&nbsp;&nbsp;&nbsp;}  
}
- Which of the following is an invalid line of code given

ClassA test = new ClassB();  

- ? (Mark all that apply)

test.method1();  
test.method2();  
test.method3(); (correct)  

- test is declared as ClassA therefore it cannot invoke method3 unless it is being casted into ClassB

- Which of the following are true about abstract classes in Java? (Mark all that apply)

You cannot instantiate an object of an abstract class. (correct)  
Abstract classes can have constructors. (correct)  
Abstract classes can have private methods. (correct)  
Abstract classes can have non abstract methods. (correct)  
A class may inherit from multiple abstract classes.  