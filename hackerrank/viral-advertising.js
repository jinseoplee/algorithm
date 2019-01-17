const viralAdvertising = (n) => {
    let result = 0;
    let adTarget = 5;
    for (let i = 0; i < n; i++) {
        result += Math.floor(adTarget / 2);
        adTarget = Math.floor(adTarget / 2) * 3;
    }
    return result;
};

(() => {
    console.log(viralAdvertising(3));
})();