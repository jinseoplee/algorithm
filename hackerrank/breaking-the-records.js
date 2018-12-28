function breakingRecords(scores) {
    let maxminScore = [scores[0], scores[0]];
    let maxminCnt = [0, 0];
    for (let idx = 1; idx <scores.length; idx++) {
        if (maxminScore[0] < scores[idx]) {
            maxminScore[0] = scores[idx];
            maxminCnt[0]+=1;
        }
        if (maxminScore[1] > scores[idx]) {
            maxminScore[1] = scores[idx];
            maxminCnt[1]+=1;
        }
    }
    return maxminCnt;
}

console.log(breakingRecords([3,4,21,36,10,28,35,5,24,42]));
