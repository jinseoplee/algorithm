/**
 * 등산을 한다! 출발과 끝은 같은 Depth이고 그곳이 해수면이다. 해수면 아래로 내려갔다가 올라올 때마다 하나의 Valley를
 * 지나온것이다. 총 몇번의 Valley를 지나왔을까?
 * @param n 걸음 수
 * @param s 기록한 코스(U: Up hill. D: Down hill)
 */
function countingValleys(n, s) {
    const valleysCheck = {"depth":0, "valleys":0};
    s.split("").forEach(function(val){
        if (val === "U") {
            valleysCheck["depth"]++;
            if (valleysCheck["depth"] === 0) {
                valleysCheck["valleys"]++;
            }
        } else {
            valleysCheck["depth"]--;
        }

        return valleysCheck["valleys"];
    }) ;

    return valleysCheck["valleys"];
}

console.log(countingValleys(8, "DDUUUUDD"));
console.log(countingValleys(8, "UDDDUDUU"));
