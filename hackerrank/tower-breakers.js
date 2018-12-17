function towerBreakers(arr) {
    return arr.length === 1 ? 1 : arr.length%2 === 0 ? 1 : 2;
}

const t = 2;    // Denoting the game of test cases.

let arrCount1 = 2; // Denoting the number of towers.
let arr = [1, 2]; // N space-separated integers, where each towers describes the height of tower.

console.log(towerBreakers(arr));

/*
arrCount = 3;
arr = [1, 2, 3];

console.log(towerBreakers(arr));

*/
