
// JSON = (JavaScript Object Notation) data-interchange format.
//        Used for exchanging data between a server and a web application.
//        JSON files {key:value} OR [value1, value2, value3]
//        JSON.stringify() = converts a JS object to a JSON string.
//        JOSN.parse() = converts a JSON string to a JS object.

// const names = ["Spongebob", "Patrick", "Squidward", "Sandy"];
// const person = {
//     "name": "Spongebob",
//     "age": 30,
//     "isEmployed": true,
//     "hobbies": ["Jellyfishing", "Karate", "Cooking"]
// };
// const people = [
//     {
//         "name": "Spongebob",
//         "age": 30,
//         "isEmployed": true
//     },
//     {
//         "name": "Patrick",
//         "age": 34,
//         "isEmployed": false
//     },
//     {
//         "name": "Squidward",
//         "age": 50,
//         "isEmployed": true
//     },
//     {
//         "name": "Sandy",
//         "age": 27,
//         "isEmployed": false
//     }
// ];

// const jsonNames = `["Spongebob", "Patrick", "Squidward", "Sandy"]`;
// const jsonPerson = `{
//     "name": "Spongebob",
//     "age": 30,
//     "isEmployed": true,
//     "hobbies": ["Jellyfishing", "Karate", "Cooking"]
// }`;
// const jsonPeople = `[
//     {
//         "name": "Spongebob",
//         "age": 30,
//         "isEmployed": true
//     },
//     {
//         "name": "Patrick",
//         "age": 34,
//         "isEmployed": false
//     },
//     {
//         "name": "Squidward",
//         "age": 50,
//         "isEmployed": true
//     },
//     {
//         "name": "Sandy",
//         "age": 27,
//         "isEmployed": false
//     }
// ]`;

// const jsonString = JSON.stringify(people);

// console.log(jsonString);

// const parsedData = JSON.parse(jsonPeople);

// console.log(parsedData);

// fetch("people.json")
//     .then(response => response.json())
//     .then(value => console.log(value));

// fetch("people.json")
//     .then(response => response.json())
//     .then(values => values.forEach(value => console.log(value.isEmployed)))
//     .catch(error => console.error(error));

// fetch = Function used for making HTTP requests to fetch resources.
//         (JSON style data, images, files)
//         Simplifies asynchronous data fetching in JavaScript and
//         used for interacting with APIs to retrieve and send data
//         asynchronously over the web.
//         fetch(url, {options})

// fetch("https://pokeapi.co/api/v2/pokemon/pikachu")
//     .then(response => {
//         if(!response.ok) {
//             throw new Error("Pokemon NOT found!");
//         }
//         return response.json();
//     })
//     .then(jsonData => console.log(jsonData.id))
//     .catch(error => console.error(error));

// const fetchPokemon = async () => {
//     try {
//         const response = await fetch("https://pokeapi.co/api/v2/pokemon/typhlosion");
//         if (!response.ok) {
//             throw new Error("Pokemon NOT found!");
//         }
//         const jsonData = await response.json();
//         console.log(jsonData.types[0].type.name);
//     } catch (error) {
//         console.error(error);
//     }
// }

// fetchPokemon();

const fetchPokemon = async () => {
    try {
        const pokemonName = document.getElementById("pokemon-name").value.toLowerCase();
        const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${pokemonName}`);
        if (!response.ok) {
            throw new Error("Pokemon NOT found!");
        }
        const jsonData = await response.json();
        const pokemonSprite = jsonData.sprites.front_default;
        const img = document.getElementById("pokemon-sprite");
        img.src = pokemonSprite;
        img.style.display = "block";
    } catch (error) {
        console.error(error);
    }
}