/**
 * 시간 맞춰서 온 학생 수가 k보다 이상이어야 교수님의 수업이 취소되지 않는다.
 * 교수님의 수업은 취소되었을까...
 * @param k 수업 취소 기준점
 * @param a 학생들의 지각시간 (Negative number는 일찍 온 친구들, 0은 정시에 온 친구들)
 * @returns {string}
 */
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