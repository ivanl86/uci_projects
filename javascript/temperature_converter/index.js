
const textBox = document.getElementById("textBox");
const toFahrenheit = document.getElementById("toFahrenheit");
const toCelsius = document.getElementById("toCelsius");
const conversion = document.getElementById("conversion");
let temperature;

const convert = () => {
    if (toFahrenheit.checked) {
        temperature = Number(textBox.value) * 9 / 5 + 32;
        conversion.textContent = temperature.toFixed(1) + " F";
    } else if (toCelsius.checked) {
        temperature = (Number(textBox.value) - 32) * 5 / 9;
        conversion.textContent = temperature.toFixed(1) + " C";
    } else {
        conversion.textContent = "Select an unit";
    }
}