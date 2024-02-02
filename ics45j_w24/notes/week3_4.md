## Week 3
### 3-1
#### Summary
- A loop executes instructions repeatedly while a condition is true
- An off-by-one error is common when programming loops
    - Think through simple test cases to avoid this type of error
- The for loop is used when a value runs from a starting point to an ending point with a constant increment or decrement
- The do loop is appropriate when the loop body must be executed at least once
- When the body of a loop contains another loop, the loops are nested.

### 3-2
#### Summary
- Use arrays for collecting values when the size of the collection never changes
- Use two-dimensional arrays for data that is arranged in rows and columns
- Use array lists for managing collections whose size can change
- The enhanced for loop can be used to visit all elements of an array or an array list

## Week 4
### 4-1
#### Summary
- A class should represent a single concept from a problem domain
- Design methods that are cohesive, consistent, and minimize side effects
- Use patterns to design the data representation of an object
- Static variables and methods belong to the class, not to any object of the class
    - Static methods are not invoked on an object
- Use packages to organize sets of related classes
- Use JUnit for writing unit tests

### 4-2
#### Object: The Cosmic Superclass

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
##### 4-1
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