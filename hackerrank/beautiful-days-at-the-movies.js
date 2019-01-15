const beautifulDays = (i, j, k) => {
    let count = 0;
    for (; i < j+1; i++) {
        if (Math.abs(i - parseInt(i.toString().split("").reverse().join(""), 10)) % k === 0) {
            count++;
        }
    }
    return count;
};

(() => {
    console.log(beautifulDays(20, 23, 6));
    console.log(beautifulDays(13, 45, 3));
})();