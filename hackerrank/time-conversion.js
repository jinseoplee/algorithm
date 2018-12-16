function timeConversion(s) {
    let AMPM = s.slice(-2);
    let hour = s.slice(0, -2).split(":");

    if(AMPM === "AM") {
        hour[0] = hour[0] === "12" ? "00" : hour[0];
    } else {
        hour[0] = hour[0] === "12" ? hour[0] : parseInt(hour) + 12;
    }
    return hour.join(":");
}


const s = "07:05:45PM";
let result = timeConversion(s);
console.log(result);