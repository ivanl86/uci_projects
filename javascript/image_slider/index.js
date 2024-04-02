
const colors = ["black", "blue", "red", "sliver", "white"];
const slides = document.querySelectorAll(".slides img");
let slideIndex = 0;
let intervalId = null;

const initSlider = () => {
    if(slides.length > 0) {
        slides[slideIndex].classList.add("display-slide");
        intervalId = setInterval(nextSlide, 5000);
    }
}

const showSlide = index => {
    slides.forEach(slide => {
        slide.classList.remove("display-slide");
    });

    slideIndex = slideIndex < 0 ? slideIndex + slides.length : slideIndex % slides.length;

    slides[slideIndex].classList.add("display-slide");
}

const prevSlide = () => {
    clearInterval(intervalId);
    --slideIndex;
    showSlide(slideIndex);

}

const nextSlide = () => {
    ++slideIndex;
    showSlide(slideIndex);
}

document.addEventListener("DOMContentLoaded", initSlider);
