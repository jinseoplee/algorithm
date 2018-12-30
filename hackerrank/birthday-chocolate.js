// Length of the segment === Ron's birth month 2
// The sum of the integers on the squares === His birth day 4
// 353268
function birthday(s, d, m) {
    let count = 0;
    for (let idx=0; idx<s.length-(m-1); idx++)  {
        if(s.slice(idx, idx+m).reduce((sum, val) => sum+val, 0) === d) count++;
    }
    return count;
}


console.log(birthday([4], 4, 1));