// the Julian calendar's leap years 는 (4로 나눠진다.) From 1700 ~ 1917
// the Julian calendar를 사용하고 2월 14일이 32번째 날임. 고로 2월은 총 15일(14~28  1918년은 윤년이 아님) in 1918
// the Gregorian calendar's leap years 는 (400으로 나눠진다 || (4로 나눠진다 && 100으로 나누어 떨어지지 않는다.)) Since 1919
function dayOfProgrammer(year) {

    let d = 13;

    // Used the Julian calendar
    if (year < 1919) {
        if (year === 1918) d+=13
        if (year % 4 === 0) {
            d--;
        }
    }
    // Used the Gregorian calendar
    else {
        if (year % 400 === 0 || (year % 4 === 0 && year % 100 !== 0)) {
            d--;
        }
    }

    return d.toString().concat(".09.").concat(year.toString());
}

console.log(dayOfProgrammer(1918));