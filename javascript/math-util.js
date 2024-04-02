
export const pi = 3.14159;

export const getCircumference = (radius) => {
    return 2 * pi * radius;
}

export const getArea = radius => {
    return pi * radius * radius;
}

export const getVolume = (radius) => {
    return 4 / 3 * pi * radius * radius * radius;
}