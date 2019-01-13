const utopianTree = (n) => {
    let count = 1;
    for (let i = 1; i < n+1; i++) {
        if (i % 2 === 0) count++;
        else count*=2;
    }
    return count;
};

(() => {
    "014".split("").map(a => parseInt(a, 10)).forEach(n => {
        console.log(utopianTree(n));
    });
})();