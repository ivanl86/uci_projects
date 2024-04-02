const weatherForm = document.querySelector(".weather-form");
const cityInput = document.querySelector(".city-input");
const card = document.querySelector(".card");
const apiKey = "";

weatherForm.addEventListener("submit", async event => {
    event.preventDefault();
    const city = cityInput.value;
    
    if(city) {
        try {
            const weatherData = await getWeatherData(city);
            displayWeatherInfo(weatherData)
        } catch (error) {
            console.error(error);
            displayError(error);
        }
    } else {
        displayError("Please enter a city");
    }
});

const getWeatherData = async city => {
    const apiUrl = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}`;

    const response = await fetch(apiUrl);

    if(!response.ok) {
        throw new Error("Could not find city");
    }

    return await response.json();
}

const displayWeatherInfo = data => {
    const {name: city,
            main: {temp, humidity},
            weather: [{description, id}]} = data;
    card.textContent = "";
    card.style.display = "flex"
    const displayCity = document.createElement("h1");
    const displayTemp = document.createElement("p");
    const displayHumidity = document.createElement("p");
    const displayDescription = document.createElement("p");
    const weatherEmoji = document.createElement("p");

    displayCity.textContent = city;
    displayTemp.textContent = `${((temp - 273.15) * 9 / 5 + 32).toFixed(1)} F`;
    displayHumidity.textContent = `Humidity: ${humidity}%`;
    displayDescription.textContent = description;
    weatherEmoji.textContent = getWeatherEmoji(id);

    displayCity.classList.add("display-city");
    displayTemp.classList.add("display-temperature");
    displayHumidity.classList.add("display-humidity");
    displayDescription.classList.add("display-description");
    weatherEmoji.classList.add("weather-emoji");

    card.appendChild(displayCity);
    card.appendChild(displayTemp);
    card.appendChild(displayHumidity);
    card.appendChild(displayDescription);
    card.appendChild(weatherEmoji);
}

const getWeatherEmoji = weatherId => {
    switch(true) {
        case weatherId >= 200 && weatherId < 300:
            return "⛈️";
        case weatherId >= 300 && weatherId < 400:
            return "🌦️";
        case weatherId >= 500 && weatherId < 600:
            return "🌧️";
        case weatherId >= 600 && weatherId < 700:
            return "🌨️";
        case weatherId >= 700 && weatherId < 800:
            return "🌫️";
        case weatherId === 800:
            return "☀️";
        case weatherId > 800 && weatherId < 810:
            return "☁️";
        default:
            return "❓"
    };
}

const displayError = errMsg => {
    const error = document.createElement("p");
    error.textContent = errMsg;
    error.classList.add("display-error");
    card.textContent = "";
    card.style.display = "flex";
    card.appendChild(error);
}