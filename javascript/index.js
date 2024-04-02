// console.log(`Hello`);
// console.log(`I like pizza!`);

// window.alert(`This is an alert!`)
// window.alert(`I like pizza!`)

// This is a comment
/*
    This
    is
    a
    comment
*/

// document.getElementById(`header`).textContent = `Hello Javascript`;
// document.getElementById(`paragraph`).textContent = `I love In N Out`;

// let age = 25;
// let price = 10.99;
// let gpa = 2.0
// let firstName = `Ivan`;

// console.log(typeof age);
// console.log(`You are ${age} years old`);
// console.log(`The price is $${price}`);
// console.log(`My name is ${firstName}`);

// let online = true;

// console.log(typeof online);
// console.log(typeof `Yo`);
// console.log(`Online: ${online}`);

// let firstName = `Ivan`;
// let lastName = `Leung`;
// let fullName = `${firstName} ${lastName}`;
// let age = 21;
// let isStudent = true;

// document.getElementById(`p1`).textContent = `My name is ${fullName}`;
// document.getElementById(`p2`).textContent = `I am ${age} years old`;
// document.getElementById(`p3`).textContent = `Enrolled in College: ${isStudent}`;

// let totalStudent = 30;
// // totalStudent **= 2;
// // totalStudent %= 4;
// totalStudent /= 4;
// console.log(totalStudent);

// User input
// Window prompt
// let username;
// username = window.prompt(`What is your username: `)
// console.log(username)

// document.getElementById(`userNameField`).textContent = `username: `
// document.getElementById(`submitButton`).textContent = `submit `

// // Using text field and submit button
// let username;
// document.getElementById(`submitButton`).onclick = function () {
//     username = document.getElementById(`textField`).value;
//     document.getElementById(`header`).textContent = username;
// }

// let age = Number(window.prompt(`How old are you`));
// age += 5;
// console.log(age);

// const pi = 3.14159;
// let radius = 0;
// let circumference = 0;

// document.getElementById(`submitButton`).onclick = () => {
//     radius = Number(document.getElementById(`textField`).value);
//     circumference = 2 * pi * radius;
//     document.getElementById(`calculatedCircumference`).textContent = circumference + ` cm`;
// }

// Counter
// const decreaseButton = document.getElementById(`decreaseButton`);
// const resetButton = document.getElementById(`resetButton`);
// const increaseButton = document.getElementById(`increaseButton`);
// const countLabel = document.getElementById(`countLabel`);
// let count = 0;

// decreaseButton.onclick = () => {
//     // --count;
//     countLabel.textContent = countLabel.textContent - 1;
//     // countLabel.textContent = count;
// }

// resetButton.onclick = () => {
//     count = 0;
//     countLabel.textContent = count;
// }

// increaseButton.onclick = () => {
//     ++count;
//     countLabel.textContent = count;
// }

// Random number between min (inclusive) to max (exclusive)
// const min = 0;
// const max = 10;
// let randomNum = Math.floor(Math.random() * (max - min)) + min;

// console.log(randomNum);

// const generateButton = document.getElementById(`generateButton`);
// const randomNumLabel1 = document.getElementById(`randomNumLabel1`);
// const randomNumLabel2 = document.getElementById(`randomNumLabel2`);
// const randomNumLabel3 = document.getElementById(`randomNumLabel3`);
// const min = 1;
// const max = 6;
// let randomNum1;
// let randomNum2;
// let randomNum3;

// generateButton.onclick = () => {
//     randomNum1 = Math.floor(Math.random() * max) + min;
//     randomNum2 = Math.floor(Math.random() * max) + min;
//     randomNum3 = Math.floor(Math.random() * max) + min;
//     randomNumLabel1.textContent = randomNum1;
//     randomNumLabel2.textContent = randomNum2;
//     randomNumLabel3.textContent = randomNum3;
// }

// Checkboxes
// const subscribeCheckBox = document.getElementById("subscribeCheckBox");
// const visaButton = document.getElementById("visaButton");
// const masterCardButton = document.getElementById("masterCardButton");
// const payPalButton = document.getElementById("payPalButton");
// const submitButton = document.getElementById("submitButton");
// const subscribeResult = document.getElementById("subscribeResult");
// const paymentResult = document.getElementById("paymentResult");

// submitButton.onclick = () => {
//     if (subscribeCheckBox.checked) {
//         subscribeResult.textContent = `You are subscribed!`;
//     } else {
//         subscribeResult.textContent = `You are NOT subscribed!`;
//     }

//     if (visaButton.checked) {
//         paymentResult.textContent = `You are playing with Visa`;
//     }
//     else if (masterCardButton.checked) {
//         paymentResult.textContent = `You are playing with MaterCard`;
//     }
//     else if (payPalButton.checked) {
//         paymentResult.textContent = `You are playing with PayPal`;
//     }
//     else {
//         paymentResult.textContent = `You must select a payment type!`;
//     }
// }

// String slice
// const fullName = "Ivan Leung";
// let firstName = fullName.slice(0, fullName.indexOf(" "));
// let lastName = fullName.slice(fullName.indexOf(" ") + 1)
// console.log(firstName);
// console.log(lastName);

// const email = "ivanl8866@gmail.com";
// let username = email.slice(0, email.indexOf("@"));
// console.log(username);

// Array
// let fruits = ["apple", "orange", "banana"];
// fruits.push("coconut");
// console.log(fruits);
// // fruits.pop();
// fruits.unshift("mango");
// console.log(fruits);
// // fruits.shift();
// // console.log(fruits[0]);
// fruits.sort();
// for (let fruit of fruits) {
//     console.log(fruit);
// }

// Spread operator = expands an array into seperate elements
// let numbers = [1, 2, 3, 4, 5];
// let max = Math.max(...numbers);
// console.log(max);
// let email = "ivanl8866@gmail.com";
// let letters = [...email];
// console.log(letters);
// console.log(letters.join(""));
// let fruits = ["apple", "orange", "banana"];
// let veggies = ["broccoli", "carrot", "celery"];
// let meal = [...fruits, ...veggies, "eggs"];
// console.log(meal);

// Rest parameters = bundles seperate elements into an array
// let bread = "bread";
// let cheese = "cheese";
// let beefPatty = "beef patty";
// let lettuce = "lettuce";

// openFridge = (...ingrendients) => {
//     console.log(...ingrendients);
// }
// const makeBurger = (...ingrendients) => {
//     return ingrendients;
// }

// openFridge(bread, cheese, beefPatty, lettuce);
// console.log(makeBurger(bread, cheese, beefPatty, lettuce));

// Callback function = a function that is passed as an argument into another function
// const hello = (callback) => {
//     // setTimeout(() => {
//     // }, 3000)
//     console.log("Hello!");
//     callback();
// }

// const goodbye = () => {
//     console.log("Goodbye!");
// }

// hello(goodbye);

// Array.forEach() = method used to iterate over each element in an array and apply a specified function (callback) to each element
// element, index, array are provided
// let numbers = [1, 2, 3, 4, 5];
// let meats = ["beef", "lamb", "pork", "chicken"]
// const tripleValue = (n, i, arr) => {
//     arr[i] = 3 * n;
// }
// numbers.forEach(doubleValue);
// numbers.forEach((n, i, arr) => {
//     arr[i] = 2 * n;
// })
// numbers.forEach(tripleValue)
// numbers.forEach((n) => {
//     console.log(n);
// });
// meats.forEach((meat, index, arr) => {
//     arr[index] = meat.toUpperCase();
// })
// meats.forEach((meat) => {
//     console.log(meat);
// })

// Array.map() = accepts a callback and applies that function to each element of an array, then a new array

// const numbers = [1, 2, 3, 4, 5];
// let squaredNumbers = [];

// squaredNumbers = numbers.map((n) => {
//     return Math.pow(n, 2);
// })

// console.log(numbers);
// console.log(squaredNumbers);

// Array.filter() = creates a new array by filtering out elements
// const numbers = [1, 2, 3, 4, 5, 6];
// const ages = [12, 13, 17, 18, 22, 50];
// let oddNumbers = [];
// let evenNumbers = [];
// let adults = [];

// oddNumbers = numbers.filter((n) => {
//     return n & 1 === 1;
// })

// evenNumbers = numbers.filter((n) => {
//     return !(n & 1 === 1);
// })

// adults = ages.filter(n => {
//     return n >= 18
// })
// console.log(oddNumbers);
// console.log(evenNumbers);
// console.log(adults);

// Array.reduce() = reduces the elements of an array into a single value
// const prices = [5, 8, 12, 10, 20];
// const grades = [69, 75, 88, 91];
// let total;
// let max;

// total = prices.reduce((total, price) => {
//     return total + price;
// })

// max = grades.reduce((max, grade) => {
//     return Math.max(max, grade);
// })

// console.log(`$${total.toFixed(2)}`);
// console.log(max);

// Constructor
// function Car(make, model, year, color) {
//     this.make = make,
//     this.model = model,
//     this.year = year,
//     this.color = color
// }

// const car = new Car("Ford", "Mustang", 2024, "Red");
// console.log(car.make);

// Class
// class Product {
//     constructor(name, price,) {
//         this.name = name;
//         this.price = price;
//     }

//     displayProduct() {
//         console.log(`Product: ${this.name}`);
//         console.log(`Price: $${this.price.toFixed(2)}`)
//     }

//     calculateTotal(salesTax) {
//         return this.price + (this.price * salesTax);
//     }
// }

// const shirt = new Product("Shirt", 9.99);
// const pants = new Product("Pant", 39.99);
// const salesTax = 0.08
// shirt.displayProduct();
// console.log(shirt.calculateTotal(salesTax).toFixed(2));
// pants.displayProduct();
// console.log(pants.calculateTotal(salesTax).toFixed(2));

// static
// class MathUtil {
//     static PI = 3.14159;

//     static getDiameter(radius) {
//         return radius * 2;
//     }
// }

// console.log(MathUtil.PI);
// console.log(MathUtil.getDiameter(10));

// Inheritance
// class Animal {
//     alive = true;

//     constructor(name) {
//         this.name = name;
//     }

//     eat() {
//         console.log(`This ${this.name} is eating`)
//     }

//     sleep() {
//         console.log(`This ${this.name} is sleeping`)
//     }
// }

// class Rabbit extends Animal {
//     // name = "Rabbit";
//     hop() {
//         console.log(`${this.name} is hopping`)
//     }
// }

// class Fish extends Animal {
//     // name = "Fish";
//     swim() {
//         console.log(`${this.name} is swimming`)
//     }
// }

// const rabbit = new Rabbit("Bunny");
// const fish = new Fish("Salmon");

// console.log(rabbit.alive);
// rabbit.eat();
// rabbit.sleep();
// rabbit.hop();
// console.log(fish.alive);
// fish.eat();
// fish.sleep();
// fish.swim();

// super keyword
// class Animal {
//     constructor (name, age) {
//         this.name = name;
//         this.age = age;
//     }

//     move(speed) {
//         console.log(`The ${this.name} moves at a speed of ${speed} mph`);
//     }
// }

// class Fish extends Animal {
//     constructor (name, age, swimSpeed) {
//         super (name, age);
//         this.swimSpeed = swimSpeed;
//     }

//     swim() {
//         super.move(this.swimSpeed);
//     }
// }

// const fish = new Fish("fish", 10, 25);
// fish.swim();

// getter & setter
// class Rectangle {
//     constructor(width, height) {
//         this.width = width;
//         this.height = height;
//     }

//     set width(newWidth) {
//         if(newWidth > 0) {
//             this._width = newWidth;
//         } else {
//             console.error("Width must greater than zero");
//         }
//     }

//     set height(newHeight) {
//         if (newHeight > 0) {
//             this._height = newHeight;
//         } else {
//             console.error("Height must be greater than zero");
//         }
//     }

//     get width() {
//         return this._width.toFixed(1);
//     }

//     get height() {
//         return this._height.toFixed(1);
//     }

//     get area() {
//         return (this._width * this._height).toFixed(1);
//     }
// }

// const rectangle = new Rectangle(10, 15);

// console.log(rectangle.width);
// console.log(rectangle.height);
// console.log(rectangle.area);

// Destructuring
// let a = 3;
// let b = 7;
// console.log(a);
// console.log(b);
// [a, b] = [b, a]; // Swap 2 elements
// console.log(a);
// console.log(b);
// const colors = ["red", "green", "blue", "black", "white"];
// [colors[0], colors[3]] = [colors[3], colors[0]];
// console.log(colors);
// const [firstColor, secondColor, thirdColor, ...extraColors] = colors;
// console.log(firstColor);
// console.log(secondColor);
// console.log(thirdColor);
// console.log(extraColors);

// const person1 = {
//     firstName: "Spongebob",
//     lastName: "SquarePants",
//     age: 30,
//     job: "Fry Cook",
// }

// const person2 = {
//     firstName: "Patrick",
//     lastName: "Star",
//     age: 34,
// }

// const {firstName, lastName, age, job = "Unemployed"} = person2
// console.log(firstName, lastName, age, job);

// const displayPerson = ({firstName, lastName, age, job = "Unemployed"}) => {
//     console.log(`name: ${firstName} ${lastName}`);
//     console.log(`age: ${age}`);
//     console.log(`job: ${job}`);
// }

// displayPerson(person1)

// Nested Object
// class Person {
//     constructor(name, age, ...address) {
//         this.name = name;
//         this.age = age;
//         this.address = new Address(...address);
//     }
// }

// class Address {
//     constructor(street, city, country) {
//         this.street = street;
//         this.city = city;
//         this.country = country;
//     }
// }

// const person1 = new Person("Spongebob", 30,
//                             "124 Conch St.", "Bikini Bottom", "Int. Waters");
// const person2 = new Person("Patrick", 34,
//                             "333 Conch St.", "Bikini Bottom", "Int. Waters");
// console.log(person1)
// console.log(person2)

// Sort
// let numbers = [3, 5, 1, 6, 9, 4, 8, 2, 7, 10];
// numbers.sort((a, b) => a - b); // Sort the numbers depends on the returned value is
// console.log(numbers);
// const people = [{name: "Spongebob", age: 30, gpa: 3.0},
//                 {name: "Patrick", age: 37, gpa: 1.5},
//                 {name: "Squidward", age: 51, gpa: 2.5},
//                 {name: "Sandy", age: 27, gpa: 4.0}]
// people.sort((a, b) => a.gpa - b.gpa); // Sort by numbers
// people.sort((a, b) => a.name.localeCompare(b.name)); // Sort by lexicographic order
// console.log(people);

// Shuffle => Fisher-Yates alogrithm
// const shuffle = (arr) => {
//     for (let i = arr.length - 1; i > 0; --i) {
//         const random = Math.floor(Math.random() * (i + 1));
//         [arr[i], arr[random]] = [arr[random], arr[i]];
//     }
// }
// const cards = ['A', 2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K'];
// shuffle(cards);
// console.log(cards);

// Date objects = Objects that contain values that represent dates and times
// Month = Jan - Dec = 0 - 11
// Day of Week = Sun - Sat = 0 - 6
// (Year, Month, Day, Hour (24), Minute, Second, Millisecond)
// const date = new Date(2024, 0, 1, 2, 3, 4, 5);
// const year = "2024";
// const month = "03";
// const day = "04";
// const hour = "12";
// const minute = "00";
// const second = "00";
// const date = new Date(`2024-01-02T12:00:00`);
// const date = new Date(`${year}-${month}-${day}T${hour}:${minute}:${second}`);

// const date = new Date();
// date.setDate(24);
// const year = date.getFullYear();
// const month = date.getMonth();
// const day = date.getDate();
// const hour = date.getHours();
// const minutes = date.getMinutes();
// const seconds = date.getSeconds();
// const dayOfWeek = date.getDay();
// console.log(date);
// console.log(year);
// console.log(month);
// console.log(day);
// console.log(hour);
// console.log(minutes);
// console.log(seconds);
// console.log(dayOfWeek);
// const date1 = new Date("2023-12-31");
// const date2 = new Date("2024-01-01");
// console.log(date1 < date2);

// Closure = A function defined inside of another function.
//           The inner function has access to the variables
//           and scope of the outer function.
//           Allow for private variables and state maintenance.
//           Used frequently in JS frameworks: Angular, React, Vue.

// const outer = () => {
//     const inner = () => {
//         console.log(message);
//     }

//     let message = "Hello";
//     inner();
// }

// outer();

// const createCounter = () => {
//     const increment = () => {
//         ++count;
//         console.log(`Count increased to ${count}`);
//     }

//     const getCount = () => {
//         return count;
//     }

//     let count = 0;
//     return {increment, getCount};
// }

// const counter = createCounter();
// counter.increment();
// counter.increment();
// counter.increment();
// console.log(counter.getCount());

// const createGame = () => {
//     let increaseScore = (points) => {
//         score += points;
//         console.log(`+${points} pts`);
//     }

//     let decreaseScore = (points) => {
//         score -= points;
//         console.log(`-${points} pts`);
//     }

//     let getScore = () => {
//         return score;
//     }
    
//     let score = 0;

//     return {increaseScore, decreaseScore, getScore};
// }

// const game = createGame();
// game.increaseScore(7);
// game.decreaseScore(4);
// console.log(`The final score is ${game.getScore()} pts`);

// setTimeout(callback, delay) function
// const sayHello = () => {
//     window.alert("Hello");
// }

// // setTimeout(sayHello, 3000);
// const timeoutId = setTimeout(() => window.alert("Hello"), 3000);
// clearTimeout(timeoutId); // clear the timeout

// ES6 Modules
// import {pi, getCircumference, getArea, getVolume} from "./math-util.js";

// console.log(pi);
// const circumference = getCircumference(10);
// const area = getArea(10);
// const volume = getVolume(10);
// console.log(`${circumference.toFixed(2)} cm`);
// console.log(`${area.toFixed(2)} cm^2`);
// console.log(`${volume.toFixed(2)} cm^3`);

// Synchronous = Executes line by line consecutively in a sequential manner.
//               Code that waits for an operation to complete.
// Asynchronous = Allows multiple operations to be performed concurrently without waiting.
//                Does not block the execution flow and allows the program to continue.
//                (I/O operations, network requests, fetching data)
//                Hadneld with: Callbacks, Promises, Async/Await

// const func1 = callback => {
//     setTimeout(() => {
//         console.log("Task 1");
//         callback();},
//         3000);
// }

// const func2 = () => {
//     console.log("Task 2");
//     console.log("Task 3");
//     console.log("Task 4");
// }

// func1(func2);

// Error = An object that is created to represent a problem that occurs.
//         Occur often with user input or establishing a connection.

// try {
//     console.log("Hello");
//     // Network Errors
//     // Promise Rejections
//     // Security Errors
// } catch (error) {
//     console.error(error);
// } finally {
//     // Close Files
//     // Close Connections
//     // Release Resources
//     console.log("Always executed");
// }

// console.log("The END");

// try {
//     const dividend = Number(window.prompt("Enter a dividend:"));
//     const divisor = Number(window.prompt("Enter a divisor:"));

//     if (divisor === 0) {
//         throw new Error("You cannot divide by zero!");
//     }

//     if (isNaN(dividend) || isNaN(divisor)) {
//         throw new Error("Values must be a number");
//     }

//     const result = dividend / divisor;
//     console.log(result);
// } catch (error) {
//     console.error(error);
// }

// console.log("The END");

// DOM = Document Object Model
//       Object that represents the page you see in the web browser
//       and provide you with an API to interact with it.
//       Web browser constructs the DOM when it loads an HTML document,
//       and structures all the elements in a tree-like representation.
//       JavaScript can access the DOM to dynamically
//       change the content, structure, and style of a web page.

// document.title = "New Title";
// const username = "Ivan";
// document.body.style.backgroundColor = "hsl(0, 0%, 15%)"
// const header = document.getElementById("header");
// header.textContent += username === "" ? "Guest" : username;

// Element selectors
// document.getElementByID()       // Element or Null
// document.getElementsByClassName() // HTML Collection
// document.getElementsByTagName() // HTML Collection
// document.querySelector()        // Element or Null
// document.querySelectorAll()     // NodeList

// const header = document.getElementById("header");
// header.style.backgroundColor = "yellow";
// header.style.textAlign = "center";

// const fruits = document.getElementsByClassName("fruits")
// console.log(fruits)
// fruits[2].style.backgroundColor = "yellow";
// for (let fruit of fruits) {
//     fruit.style.backgroundColor = "yellow";
// }
// Array.from(fruits).forEach(fruit => {
//     fruit.style.backgroundColor = "yellow";
// });
// const h4Elements = document.getElementsByTagName("h4");
// const liElements = document.getElementsByTagName("li");
// console.log(h4Elements);
// h4Elements[1].style.backgroundColor = "yellow";
// for (let h4Element of h4Elements) {
//     h4Element.style.backgroundColor = "yellow";
// }
// for (let liElement of liElements) {
//     liElement.style.backgroundColor = "lightgreen";
// }

// Array.from(h4Elements).forEach(h4Element => {
//     h4Element.style.backgroundColor = "yellow";
// })

// Array.from(liElements).forEach(liElement => {
//     liElement.style.backgroundColor = "lightgreen";
// })

// const element = document.querySelector("ol"); // Select the first class or tagname
// element.style.backgroundColor = "yellow";

// const foods = document.querySelectorAll("li");

// foods[5].style.backgroundColor = "yellow";
// foods.forEach(food => {
//     food.style.backgroundColor = "yellow";
// });

// DOM Navigation = The process of navigating through the structure
//                  of an HTML document using Javascript
// .firstElementChild
// .lastElementChild
// .nextElementSibling
// .previousElementSibling
// .parentElement
// .children

// const element = document.getElementById("desserts");
// const firstChild = element.firstElementChild;
// firstChild.style.backgroundColor = "yellow"

// const ulElements = document.querySelectorAll("ul");
// ulElements.forEach(ulElement => {
//     const firstChild = ulElement.firstElementChild;
//     firstChild.style.backgroundColor = "yellow";
// });

// const element = document.getElementById("desserts");
// const lastChild = element.lastElementChild;
// lastChild.style.backgroundColor = "yellow";

// const ulElements = document.querySelectorAll("ul");
// ulElements.forEach(ulElement => {
//     const lastChild = ulElement.lastElementChild;
//     lastChild.style.backgroundColor = "yellow";
// });

// const element = document.getElementById("vegetables");
// const nextSibling = element.nextElementSibling;
// nextSibling.style.backgroundColor = "yellow";

// const element = document.getElementById("desserts");
// const previousSibling = element.previousElementSibling;
// previousSibling.style.backgroundColor = "yellow";

// const element = document.getElementById("ice-cream");
// const parent = element.parentElement;
// parent.style.backgroundColor = "yellow";

// const element = document.getElementById("fruits");
// const children = element.children;

// children[1].style.backgroundColor = "yellow";

// console.log(children);
// Array.from(children).forEach(child => {
//     child.style.backgroundColor = "yellow";
// });

// Add & Change HTML Elements

// Step 1 Create the element
// const newH1 = document.createElement("h1");
// newH1.id = "header";
// newH1.style.color = "tomato";
// newH1.style.textAlign = "center";

// const newListItem = document.createElement("li");

// Step 2 Add attributes & properties
// newH1.textContent = "I like IN N OUT!";

// newListItem.textContent = "Coconut";
// newListItem.id = "coconut";
// newListItem.style.fontWeight = "bold";
// newListItem.style.backgroundColor = "lightgreen";

// Step 3 Append element to DOM
// document.body.append(newH1);
// document.body.prepend(newH1);
// document.getElementById("box1").append(newH1);
// document.getElementById("box4").prepend(newH1);

// const box2 = document.getElementById("box2");
// document.body.insertBefore(newH1, box2);

// const boxes = document.querySelectorAll(".box");
// document.body.insertBefore(newH1, boxes[0])

// document.body.append(newListItem);
// document.body.prepend(newListItem);
// document.getElementById("fruits").append(newListItem);
// document.getElementById("fruits").prepend(newListItem);
// const apple = document.getElementById("apple");
// document.getElementById("fruits").insertBefore(newListItem, apple);

// const listItems = document.querySelectorAll("#fruits li")
// document.getElementById("fruits").insertBefore(newListItem, listItems[2])

// Optional Remove HTML element
// document.body.removeChild(newH1);
// document.getElementById("box1").removeChild(newH1);

// document.getElementById("fruits").removeChild(newListItem);

// eventListener = Listen for specific events to create interactive web pages.
//                 Events: click, mouseover, mouseout
//                 .addEventListener(event, callback);

// const myBox = document.getElementById("myBox");
// const myButton = document.getElementById("myButton");

// const changeColor = (event) => {
//     event.target.style.backgroundColor = "tomato";
//     event.target.textContent = "OUCH!";
// }

// myBox.addEventListener("click", (event) => {
//     event.target.style.backgroundColor = "tomato";
//     event.target.textContent = "OUCH!";
// });

// myBox.addEventListener("mouseover", (event) => {
//     event.target.style.backgroundColor = "yellow";
//     event.target.textContent = "Do not do it";
// });

// myBox.addEventListener("mouseout", (event) => {
//     event.target.style.backgroundColor = "lightgreen";
//     event.target.textContent = "Click Me";
// });

// myButton.addEventListener("click", (event) => {
//     event.target.style.backgroundColor = "tomato";
//     event.target.textContent = "OUCH!";
// });

// myButton.addEventListener("mouseover", (event) => {
//     event.target.style.backgroundColor = "yellow";
//     event.target.textContent = "Do not do it";
// });

// myButton.addEventListener("mouseout", (event) => {
//     event.target.style.backgroundColor = "lightgreen";
//     event.target.textContent = "Click Me";
// });

// myButton.addEventListener("click", (event) => {
//     myBox.style.backgroundColor = "tomato";
//     myBox.textContent = "OUCH!";
// });

// myButton.addEventListener("mouseover", (event) => {
//     myBox.style.backgroundColor = "yellow";
//     myBox.textContent = "Do not do it";
// });

// myButton.addEventListener("mouseout", (event) => {
//     myBox.style.backgroundColor = "lightgreen";
//     myBox.textContent = "Click Me";
// });

// Key events

// const myBox = document.getElementById("myBox");

// document.addEventListener("keydown", event => {
//     myBox.textContent = event.key;
//     myBox.style.backgroundColor = "tomato";
//     // console.log(event.key);
// });

// document.addEventListener("keyup", event => {
//     myBox.textContent = "Box";
//     myBox.style.backgroundColor = "lightblue";
//     // console.log(event.key);
// });

// const moveAmount = 10;
// let x = 0;
// let y = 0;

// document.addEventListener("keydown", event => {
//     if (event.key.startsWith("Arrow")) {

//         event.preventDefault();

//         switch(event.key) {
//             case "ArrowUp":
//                 y -= moveAmount;
//                 break;
//             case "ArrowDown":
//                 y += moveAmount;
//                 break;
//             case "ArrowLeft":
//                 x -= moveAmount;
//                 break;
//             case "ArrowRight":
//                 x += moveAmount;
//                 break;
//         }

//         myBox.style.top = `${y}px`;
//         myBox.style.left = `${x}px`;
//     }
// })

// Hide/Show HTML

// const hideShow = document.getElementById("hide-show");
// const myImg = document.getElementById("myImg");

// hideShow.addEventListener("click", event => {
//     if (myImg.style.visibility === "hidden") {
//         myImg.style.visibility = "visible";
//         hideShow.textContent ="Hide";
//     } else {
//         myImg.style.visibility = "hidden";
//         hideShow.textContent ="Show";
//     }
// });

// NodeList = Static collection of HTML elements by (id, class, element)
//            Can be created by using querySelectorAll()
//            Similar to an array, but no (map, filter, reduce)
//            NodeList will not automatically update to reflect changes

// let buttons = document.querySelectorAll(".buttons");

// console.log(buttons);

// buttons.forEach(button => {
//     button.style.backgroundColor = "green";
//     button.textContent = "newButton"
// });

// buttons.forEach(button => {
//     button.addEventListener("click", event => {
//         event.target.style.backgroundColor = "tomato";
//     })
// });

// buttons.forEach(button => {
//     button.addEventListener("mouseover", event => {
//         event.target.style.backgroundColor = "hsl(205, 100%, 40%)";
//     })
// });

// buttons.forEach(button => {
//     button.addEventListener("mouseout", event => {
//         event.target.style.backgroundColor = "hsl(205, 100%, 60%)";
//     })
// });

// // Add an element
// const newButton = document.createElement("button"); // Step 1
// newButton.textContent = "Button 5"; // Step 2
// newButton.classList = "buttons";
// document.body.appendChild(newButton) // Step 3

// buttons = document.querySelectorAll(".buttons");

// // Remove an element
// buttons.forEach(button => {
//     button.addEventListener("click", event => {
//         event.target.remove();
//         buttons = document.querySelectorAll(".buttons"); // Update NodeList after remove
//     });
// });

// ClassList = Element property in JavaScript used to interact
//             with an element's list of classes (CSS classes).
//             Allows you to make reusable classes for many elements
//             across your webpage.

// const myButton = document.getElementById("myButton");

// myButton.classList.add("enabled");
// myButton.classList.remove("enabled");
// myButton.addEventListener("mouseover", event => {
//     // event.target.classList.add("hover");
//     event.target.classList.toggle("hover");
// });

// myButton.addEventListener("mouseout", event => {
//     // event.target.classList.remove("hover");
//     event.target.classList.toggle("hover");
// });

// const myH1 = document.getElementById("myH1");

// myH1.classList.add("enabled");
// myButton.classList.add("enabled");

// myButton.addEventListener("click", event => {
//     if(event.target.classList.contains("disabled")) {
//         event.target.textContent += "Angry";
//     } else {
//         event.target.classList.replace("enabled", "disabled");
//     }
// });

// myH1.addEventListener("click", event => {
//     if(event.target.classList.contains("disabled")) {
//         event.target.textContent += "Angry";
//     } else {
//         event.target.classList.replace("enabled", "disabled");
//     }
// });

// let buttons = document.querySelectorAll(".my-buttons");

// buttons.forEach(button => {
//     button.classList.add("enabled");
// });

// buttons.forEach(button => {
//     button.addEventListener("mouseover", event => {
//         event.target.classList.toggle("hover");
//     });
// });

// buttons.forEach(button => {
//     button.addEventListener("mouseout", event => {
//         event.target.classList.toggle("hover");
//     });
// });

// buttons.forEach(button => {
//     button.addEventListener("click", event => {
//         if(event.target.classList.contains("disabled")) {
//             event.target.textContent += "Angry";
//         } else {
//             event.target.classList.replace("enabled", "disabled");
//         }
//     });
// });

// Callback Hell = Situation in JavaScript where callbacks
//                 are nested within other callbacks to the
//                 degree where the code is difficult to read.
//                 Old pattern to handle asynchronous functions.
//                 Use Promises + async/await to avoid Callback Hell.

// const taskOne = (callback) => {
//     setTimeout(() => {
//         console.log("Task 1 completed...");
//         callback();
//     }, 2000);
// };
// const taskTwo = (callback) => {
//     setTimeout(() => {
//         console.log("Task 2 completed...");
//         callback();
//     }, 1000);
// };
// const taskThree = (callback) => {
//     setTimeout(() => {
//         console.log("Task 3 completed...");
//         callback();
//     }, 3000);
// };
// const taskFour = (callback) => {
//     setTimeout(() => {
//         console.log("Task 4 completed...");
//         callback();
//     }, 1500);
// };

// taskOne();
// taskTwo();
// taskThree();
// taskFour();
// console.log("All tasks completed...");

// taskOne(() => {
//     taskTwo(() => {
//         taskThree(() => {
//             taskFour(() => {
//                 console.log("All tasks completed...");
//             });
//         });
//     });
// });

// Promise = An object that manages asynchronous operations.
//           Wrap a Promise Object around {asynchronous code}
//           "I promise to return a value"
//           PENDING -> RESOLVED or REJECTED
//           new Promise((resolve, reject) => {asynchronus code})


// DO THESE CHORES IN ORDER
// 1. WALK THE DOG
// 2. CLEAN THE KITCHEN
// 3. TAKE OUT THE TRASH

// const walkTheDog = (callback) => {
//     setTimeout(() => {
//         console.log("You walked the dog");
//         callback();
//     }, 1500);
// }

// const cleanTheKitchen = (callback) => {
//     setTimeout(() => {
//         console.log("You cleaned the kitchen");
//         callback();
//     }, 2500);
// }

// const takeOutTheTrash = (callback) => {
//     setTimeout(() => {
//         console.log("You took out the trash");
//         callback();
//     }, 500);
// }

// walkTheDog(() => {
//     cleanTheKitchen(() => {
//         takeOutTheTrash(() => {
//             console.log("You finished all the chores");
//         })
//     })
// })

// const walkTheDog = () => {
//     return new Promise((resolve, reject) => {
//         setTimeout(() => {
//             const dogWalked = true;
//             if(dogWalked) {
//                 resolve("You walked the dog");
//             } else {
//                 reject("You DIDN'T walk the dog");
//             }
//         }, 1500);
//     });
// }

// const cleanTheKitchen = () => {
//     return new Promise((resolve, reject) => {
//         setTimeout(() => {
//             const kitchenCleaned = true;
//             if(kitchenCleaned) {
//                 resolve("You cleaned the kitchen");
//             } else {
//                 reject("You DIDN'T clean the kitchen");
//             }
//         }, 2500);
//     });
// }

// const takeOutTheTrash = () => {
//     return new Promise((resolve, reject) => {
//         setTimeout(() => {
//             const trashTakenOut = true;
//             if(trashTakenOut) {
//                 resolve("You took out the trash");
//             } else {
//                 reject("You DIDN'T take out the trash");
//             }
//         }, 500);
//     });
// }

// walkTheDog().then(resolve => {
//     console.log(resolve);
//     return cleanTheKitchen();
// }).then(resolve => {
//     console.log(resolve);
//     return takeOutTheTrash();
// }).then(resolve => {
//     console.log(resolve);
//     console.log("You finished all the chores");
// }).catch(error => console.error(error));

// Async/Await = Async = makes a function return a Promise
//               Await = makes an async function wait for a Promise
//               Allows you write asynchronous code in a synchronous manner.
//               Async doesn't have resolve or reject parameters.
//               Everythin after Await is placed in an event queue.

// const walkTheDog = () => {
//     return new Promise((resolve, reject) => {
//         setTimeout(() => {
//             const dogWalked = true;
//             if(dogWalked) {
//                 resolve("You walked the dog");
//             } else {
//                 reject("You DIDN'T walk the dog");
//             }
//         }, 1500);
//     });
// }

// const cleanTheKitchen = () => {
//     return new Promise((resolve, reject) => {
//         setTimeout(() => {
//             const kitchenCleaned = true;
//             if(kitchenCleaned) {
//                 resolve("You cleaned the kitchen");
//             } else {
//                 reject("You DIDN'T clean the kitchen");
//             }
//         }, 2500);
//     });
// }

// const takeOutTheTrash = () => {
//     return new Promise((resolve, reject) => {
//         setTimeout(() => {
//             const trashTakenOut = true;
//             if(trashTakenOut) {
//                 resolve("You took out the trash");
//             } else {
//                 reject("You DIDN'T take out the trash");
//             }
//         }, 500);
//     });
// }

// const doChores = async () => {
//     try {
//         const dogWalked = await walkTheDog();
//         console.log(dogWalked);

//         const kitchenCleaned = await cleanTheKitchen();
//         console.log(kitchenCleaned);

//         const trashTakenOut = await takeOutTheTrash();
//         console.log(trashTakenOut);

//         console.log("You finished all the chores");
//     } catch (error) {
//         console.error(error);
//     }
// }

// doChores();

console.log(false == 0);