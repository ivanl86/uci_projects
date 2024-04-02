## Week 7
### 7-1
#### Recursion
- A recursive computation solves a problem by using the solution to the same problem with simpler inputs
- Two key requirements for successful recursion:
    - Every recursive call must simplify the computation in some way
    - There must be special cases to handle the simplest computations directly
- Always check your base case first
#### Sorting in Java
- Arrays.parallelSort(...)
    - Uses a multi-threaded merge sort
    - Faster when you have many elements
- Arrays.sort(...)
    - Uses quicksort for primitives, merge sort for objects
- Collections.sort(...)
    - Uses merge sort
- All of these require that the objects being sorted implement the Comparable interface
#### Searching in Java
- The Arrays and Collections classes contain static binarySearch methods
    - The array/collection must be sorted before calling this method
    - If the element is not found, returns -k – 1
    - Where k is the position before which the element should be inserted

int[] a = { 1, 4, 9 };  
int v = 7;  
int pos = Arrays.binarySearch(a, v);  
// Returns –3; v should be inserted before position 2  
// -(2) - 1 = -3

#### Summary
- A recursive computation solves a problem by using the solution to the same problem with simpler inputs
- For a recursion to terminate, there must be special cases for the simplest values
- The Arrays class implements a sorting method that you should use for your Java programs
- The Collections class contains a sort method that can sort array lists
- Arrays.sort and Collection.sort sort objects of classes that implement the Comparable interface

### 7-2
#### Collections Overview
- A list is a collection that remembers the order of its elements
- A set is an unordered collection of unique elements
    - Arranges its elements so that finding, adding, and removing elements is more efficient
- Stack
    - Remembers the order of elements
    - But you can only add and remove at the top
- Queue
    - Add items to one end (the tail) and remove them from the other end (the head)
- Priority Queue
    - An unordered collection
    - Has an efficient operation for removing the element with the highest priority
- Map
    - Keeps associations between key and value objects
    - Every key in the map has an associated value
    - The map stores the keys, values, and the associations between them
#### Linked Lists
- Allows efficient addition and removal of elements in the middle of the sequence
- Adding and removing elements in the middle of a linked list is efficient
- Visiting the elements of a linked list in sequential order is efficient
- Random access is not efficient
- When to Use a Linked List
    - When you are concerned about the efficiency of inserting or removing elements
    - When you rarely need element access in “random” order
#### List Iterator
- Use a list iterator to access elements inside a linked list
- Encapsulates a portion anywhere inside the linked list
- Think of an iterator as pointing between two elements, much like the cursor in a word processor points between two characters

LinkedList`<String>` employeeNames = . . .;  
ListIterator`<String>` iterator = employeeNames.listIterator(); 

if (iterator.hasNext()) {  
&nbsp;&nbsp;&nbsp;&nbsp;String name = iterator.next();  
&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(name);  
&nbsp;&nbsp;&nbsp;&nbsp;iterator.remove(); // Removes the element returned by iterator.next()  
}  
- Be careful when calling remove:
    - It can be called only once after calling next or previous
    - You cannot call it immediately after a call to add
    - If you call it improperly, it throws an IllegalStateException
- iter.set(...)
    - The set method updates the last element returned by next or previous.
- iter.add(...)
    - Adds an element before the iterator position (ListIterator only).
#### Sets
- A set organizes its values in an order that is optimized for efficiency
- May not be the order in which you add elements
- Inserting and removing elements is more efficient with a set than with a list
- A set does not admit duplicates
- In a hash table
    - Set elements are grouped into smaller collections of elements that share the same characteristic
    - Elements in a hash table:
        - Must implement the method hashCode
        - Must have a properly defined equals method
- In a tree set
    - Elements are kept in sorted order
    - Elements are stored in nodes
    - The nodes are arranged in a tree shape
    - Not in a linear sequence
    - You can form tree sets for any class that implements the Comparable interface
- Use a TreeSet if you want to visit the set’s elements in sorted order
    - Otherwise choose a HashSet
    - It is a bit more efficient – if the hash function is well chosen

Set`<String>` names = new HashSet<>();  
// or  
Set`<String>` names = new TreeSet<>();  

- Sets don’t have duplicates
    - Adding a duplicate is ignored
- Attempting to remove an element that isn’t in the set is ignored
- To process all elements in the set, get an iterator
    - A set iterator visits the elements in the order in which the set implementation keeps them
- You cannot add an element to a set at an iterator position
- You can remove an element at an iterator position
- The iterator interface has no previous method

Iterator`<String>` iter = names.iterator();  
while (iter.hasNext()) {  
&nbsp;&nbsp;&nbsp;&nbsp;String name = iter.next();  
&nbsp;&nbsp;&nbsp;&nbsp;// Do something with name  
}  
#### Maps
- A map allows you to associate elements from a key set with elements from a value collection
- Use a map when you want to look up objects by using a key
- Two implementations of the Map interface:
    - HashMap – stored in random order
    - TreeMap – stored in sorted order by keys
- The get method returns the value associated with a key:
    - If you ask for a key that isn’t associated with any values, the get method returns null

Color julietsFavoriteColor = favoriteColors.get("Juliet");  

- The keySet method yields the set of keys

Set`<String>` keySet = m.keySet();  
for (String key : keySet) {  
&nbsp;&nbsp;&nbsp;&nbsp;Color value = m.get(key); System.out.println(key + "->" + value);  
}   

score.put("Sally", 100) // Adds keys and values to the map or modifies the value of an existing key  
score.remove("Sally") // Removes the key and value  
#### Stacks
- A stack lets you insert and remove elements only at one end:
    - Called the top of the stack
    - Removes items in the opposite order than they were added
        - Last-in, first-out, or LIFO order
#### Queues
- Add items to one end of the queue (the tail)
- Remove items from the other end of the queue (the head)
- Items are moved in the same order in which they were added
    - First-in, first-out, or FIFO order
- The LinkedList class implements the Queue interface
- When you need a queue, initialize a Queue variable with a LinkedList object:

Queue`<String>` q = new LinkedList<>();  
q.add("A");  
q.add("B");  
q.add("C");  
while (q.size() > 0) {  
&nbsp;&nbsp;&nbsp;&nbsp;System.out.print(q.remove() + " ");  
} // Prints A B C  

#### Priority Queues
- A priority queue collects elements, each of which has a priority
- Example: a collection of work requests, some of which may be more urgent than others
- Does not maintain a first-in, first-out discipline
- Elements are retrieved according to their priority
    - The lower a priority value, the more urgent the priority
    - Each removal extracts the minimum element
- When you retrieve an item from a priority queue, you always get the most urgent one
- Elements should belong to a class that implements the Comparable interface
#### Summary
- A collection groups together elements and allows them to be retrieved later
- A list is a collection that remembers the order of its elements
    - E.g., ArrayList
- A set is an unordered collection of unique elements
    - The HashSet and TreeSet classes both implement the Set interface
- A map keeps associations between key and value objects
    - The HashMap and TreeMap classes both implement the Map interface
- A linked list consists of a number of nodes, each of which has a reference to the next node
- A stack is a collection of elements with “last-in, first-out” retrieval
- A queue is a collection of elements with “first-in, first-out” retrieval
- When removing an element from a priority queue, the element with the most urgent priority is retrieved


## Week 8
### 8-1
#### Generic Classes and Type Parameters
- Generic programming: creating programming constructs that can be used with many different types

public class Pair`<T, S>` {  
&nbsp;&nbsp;&nbsp;&nbsp;private T first;  
&nbsp;&nbsp;&nbsp;&nbsp;private S second;  
&nbsp;&nbsp;&nbsp;&nbsp;public Pair(...) {...}  
&nbsp;&nbsp;&nbsp;&nbsp;public T getFirst() {...}  
&nbsp;&nbsp;&nbsp;&nbsp;public S getSecond() {...}  
}  

#### Generic Methods (I)
- Generic method: method with a type parameter
- Can be declared inside non-generic class

public static `<E>` void print(E[] a) {  
&nbsp;&nbsp;&nbsp;&nbsp;for (E e : a) {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.print(e + " ");  
&nbsp;&nbsp;&nbsp;&nbsp;}  
&nbsp;&nbsp;&nbsp;&nbsp;System.out.println();  
}

#### Constraining Type Variables
- When writing a generic method min to find the smallest element in an array list,  
    - Require that type parameter E implements Comparable`<E>`:  
public static `<E extends Comparable<E>>` E min(ArrayList`<E>` objects) {  
&nbsp;&nbsp;&nbsp;&nbsp;E smallest = objects.get(0);  
&nbsp;&nbsp;&nbsp;&nbsp;for (int i = 1; i < objects.size(); i++) {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;E obj = objects.get(i);  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if (obj.compareTo(smallest) < 0) {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;smallest = obj;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}  
&nbsp;&nbsp;&nbsp;&nbsp;}  
&nbsp;&nbsp;&nbsp;&nbsp;return smallest;  
}  

- Because of the type constraint, obj must have a method of this form:

int compareTo(E other)  

- So the following call is valid:

obj.compareTo(smallest)  

- The virtual machine erases type parameters, replacing them with their bounds or Objects
- Knowing about type erasure helps you understand limitations of Java generics
- You cannot construct new objects of a generic type
- For example, trying to fill an array with copies of default objects would be wrong:

public static `<E>` void fillWithDefaults(E[] a) {  
&nbsp;&nbsp;&nbsp;&nbsp;for (int i = 0; i < a.length; i++)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a[i] = new E(); // ERROR  
}  

- Because the array construction expression new E[] would be erased to new Object[]

- Another solution is to use an array of objects and cast when reading elements from the array:

public class Stack<E> {  
&nbsp;&nbsp;&nbsp;&nbsp;private Object[] elements;  
&nbsp;&nbsp;&nbsp;&nbsp;private int currentSize;  
&nbsp;&nbsp;&nbsp;&nbsp;. . .  
&nbsp;&nbsp;&nbsp;&nbsp;public Stack() {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;elements = new Object[MAX_SIZE]; // Ok  
&nbsp;&nbsp;&nbsp;&nbsp;}  
&nbsp;&nbsp;&nbsp;&nbsp;. . .  
&nbsp;&nbsp;&nbsp;&nbsp;public E pop() {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;size--;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;return (E) elements[currentSize];  
&nbsp;&nbsp;&nbsp;&nbsp;}  
}  

- The cast (E) generates a warning because it cannot be checked at compile time

#### Summary
- A generic Java class has one or more type parameters
    - Type parameters make generic code safer and easier to read
- Type variables of a generic class follow the class name and are enclosed in angle brackets
- Use type parameters for the types of generic instance variables, method parameter variables, and return values
- A generic method is a method with a type parameter
- Type parameters can be constrained with bounds
- The virtual machine erases type parameters, replacing them with their bounds or Objects

### Quiz Hightlights

#### 7-1
- Consider the following recursive method:

public static int mystery(int n) {  
&nbsp;&nbsp;&nbsp;&nbsp;if (n <= 0) { return 0; }  
&nbsp;&nbsp;&nbsp;&nbsp;else {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int smaller = n - 1;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;return mystery(smaller) + n * n;  
&nbsp;&nbsp;&nbsp;&nbsp;}  
}  

- What is mystery(4)?
- Your Answer:

mystery(4) -> mystery(3) + 4 * 4 = 14 + 16 = 30  

mystery(3) -> mystery(2) + 3 * 3 = 5 + 9 = 14  

mystery(2) -> mystery(1) + 2 * 2 = 1 + 4 = 5  

mystery(1) -> mystery(0) + 1 * 1 = 0 + 1 = 1  

mystery(0) -> 0  

- mystery(4) returns 30

#### 7-2

#### 8-1
- Modify the min method that you just saw (shown again below) to compute the minimum of an array list of elements that implements the Measurable interface.

public static `<E extends Comparable<E>>` E min(ArrayList`<E>` objects) {  
&nbsp;&nbsp;&nbsp;&nbsp;E smallest = objects.get(0);  
&nbsp;&nbsp;&nbsp;&nbsp;for (int i = 1; i < objects.size(); i++) {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;E obj = objects.get(i);  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if (obj.compareTo(smallest) < 0) {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;smallest = obj;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}  
&nbsp;&nbsp;&nbsp;&nbsp;}  
&nbsp;&nbsp;&nbsp;&nbsp;return smallest;  
}  

- Your Answer:

public static `<E extends Measurable>` E min(ArrayList`<E>` objects) {  
&nbsp;&nbsp;&nbsp;&nbsp;E smallest = objects.get(0);  
&nbsp;&nbsp;&nbsp;&nbsp;for (int i = 1; i < objects.size(); i++) {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;E obj = objects.get(i);  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if (obj.getMeasure() < smallest.getMeasure()) {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;smallest = obj;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}  
&nbsp;&nbsp;&nbsp;&nbsp;}  
&nbsp;&nbsp;&nbsp;&nbsp;return smallest;  
}  

- Could we have declared the min method of the last problem without type parameters, like this?

public static Measurable min(ArrayList`<Measurable>` a)  

- Your Answer:
    - Yes, but ArrayList of a type cannot be casted ArrayList of another type.

- Consider min method from earlier in the lecture:

public static `<E extends Comparable<E>>` E min(ArrayList`<E>` objects) {  
&nbsp;&nbsp;&nbsp;&nbsp;E smallest = objects.get(0);  
&nbsp;&nbsp;&nbsp;&nbsp;for (int i = 1; i < objects.size(); i++) {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;E obj = objects.get(i);  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if (obj.compareTo(smallest) < 0) {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;smallest = obj;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}  
&nbsp;&nbsp;&nbsp;&nbsp;}  
&nbsp;&nbsp;&nbsp;&nbsp;return smallest;  
}  

- Suppose we want to eliminate the type bound in the method by declaring the parameter variable as an array of Comparable objects. Why doesn't this work?

- Your Answer:
    - We cannot have an ArrayList of generic type.

- What is the erasure of the following print method from earlier in the lecture?

public static `<E>` void print(E[] a) {  
&nbsp;&nbsp;&nbsp;&nbsp;for (E e : a) {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.print(e + " ");  
&nbsp;&nbsp;&nbsp;&nbsp;}  
&nbsp;&nbsp;&nbsp;&nbsp;System.out.println();  
}  

- Your Answer:

public static `<Object>` void print(Object[] objs) {  

&nbsp;&nbsp;&nbsp;&nbsp;for (Object obj : objs) {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.print(obj + " ");  
&nbsp;&nbsp;&nbsp;&nbsp;}  
&nbsp;&nbsp;&nbsp;&nbsp;System.out.println();  
}  