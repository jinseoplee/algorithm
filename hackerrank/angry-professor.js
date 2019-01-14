const angryProfessor = (k, a) => {
    return a.filter((value) => value < 1).length >= k ? `NO` : `YES`;
};

const parameters = [
    {"k" : 3, "a" : [-1, -3, 4, 2]},
    {"k" : 2, "a" : [0, -1, 2, 1]}
];

(() => {
    parameters.forEach((param) => {
       console.log(angryProfessor(param["k"], param["a"]));
    });
})();