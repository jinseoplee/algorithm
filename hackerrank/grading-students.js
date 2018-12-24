/**
 * Every student receives a grade in the inclusive range from 0 to 100.
 * Any grade less than 40 is a failing grade.
 *
 * If the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next multiple of 5.
 * If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.
 * @param grades
 * @returns {Uint8Array | BigInt64Array | any[] | Float64Array | Int8Array | Float32Array | Int32Array | Uint32Array | Uint8ClampedArray | BigUint64Array | Int16Array | Uint16Array}
 */
function gradingStudents(grades) {
    let result = grades.map((v) => {
        if (v > 37 && 5 - v % 5 < 3) {
            return v + (5 - v % 5);
        } else {
            return v;
        }
    });
    return result;
}

let grades = [73, 67 ,38, 33];
console.log(gradingStudents(grades).join("\n") + "\n");