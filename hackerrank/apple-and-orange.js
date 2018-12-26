function countApplesAndOranges(s, t, a, b, apples, oranges) {
    const appleCnt = apples.reduce((count, val) => {
        a + val > s-1 && a + val < t+1 ? count+=1 : count;
        return count;
    }, 0);
    const orangeCnt = oranges.reduce((count, val) => {
        b + val > s-1 && b + val < t+1 ? count+=1 : count;
        return count;
    }, 0);
    return [appleCnt, orangeCnt].join(" ");
}

const s = 7; // Starting point of Sam's house location.
const t = 11; // Ending point of Sam's house location.
const a = 5; // Location of the Apple tree.
const b = 15; // Location of the Orange tree.
const apples = [-2, 2, 1]; // Distances at which each apple falls from the tree.
const oranges = [5, -6]; // Distances at which each orange falls from the tree.

//console.log(countApplesAndOranges(s, t, a, b ,apples, oranges));