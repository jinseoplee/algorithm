/**
 * 순열 방정식
 * @param p
 * @returns {Array}
 */
const permutationEquation = (p) => {
    const array = [];
    for (let i = 0; i < p.length; i++) {
        array[i] = p[p[i]-1];
    }

    const result = [];
    for (let i = 0; i < p.length; i++) {
        result[i] = array.indexOf(i+1)+1;
    }

   return result;
};

(() => {
    console.log(permutationEquation([2, 3, 1]))
    console.log(permutationEquation([4, 3, 5, 1, 2]))

})();