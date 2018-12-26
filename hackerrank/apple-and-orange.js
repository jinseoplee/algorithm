function countApplesAndOranges(s, t, a, b, apples, oranges) {
    const appleCnt = apples.reduce((count, val) => {
        a + val > s-1 && a + val < t+1 ? count++ : count;
        return count;
    }, 0);
    const orangeCnt = oranges.reduce((count, val) => {
        b + val > s-1 && b + val < t+1 ? count++ : count;
        return count;
    }, 0);

    console.log([appleCnt, orangeCnt].join("\n"));
}



const s = 7; // Starting point of Sam's house location.
const t = 11; // Ending point of Sam's house location.
const a = 5; // Location of the Apple tree.
const b = 15; // Location of the Orange tree.
const apples = [-2, 2, 1]; // Distances at which each apple falls from the tree.
const oranges = [5, -6]; // Distances at which each orange falls from the tree.

countApplesAndOranges(s, t, a, b ,apples, oranges);



Array.prototype.sum = function(f) {
    return this.reduce((s, v) => s + f(v), 0);
}

console.log(apples.sum(d => s - a <= d && d <= t - a));
console.log(oranges.sum(d => s - b <= d && d <= t - b));

