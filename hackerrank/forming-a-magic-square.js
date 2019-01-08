/**
 * 망가진 마방진 고치기
 * @param s 망가진 마방진 배열(더 좋은 방법에 대한 탐색 필요...)
 * @returns {number}
 */
function formingMagicSquare(s) {
    const newArray = [[[],[],[]],[[],[],[]],[[],[],[]],[[],[],[]],[[],[],[]],[[],[],[]],[[],[],[]],[[],[],[]]];
    const stdArray = [
        [2, 9, 4],
        [7, 5, 3],
        [6, 1, 8]
    ];
    let minCost = 72;

    newArray[0] = stdArray;
    newArray[1] = rotate(newArray[0]);
    newArray[2] = rotate(newArray[1]);
    newArray[3] = rotate(newArray[2]);
    newArray[4] = transpose(newArray[0]);
    newArray[5] = rotate(newArray[4]);
    newArray[6] = rotate(newArray[5]);
    newArray[7] = rotate(newArray[6]);

    for (let i = 0; i < newArray.length; i++) {
        let curCost = 0;
        for (let j = 0; j < 3; j++) {
            for (let k = 0; k < 3; k++) {
                if(newArray[i][j][k] !== s[j][k]) {
                    curCost += Math.abs(newArray[i][j][k] - s[j][k]);
                }
            }
        }
        if (curCost <= minCost) minCost = curCost;
    }

    return minCost;
}

/**
 * 행렬 회전
 * @param array
 * @returns {any[][]}
 */
const rotate = (array) => {
    const tempArray = Array(Array(), Array(), Array());
    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < 3; j++) {
            tempArray[j][3 - 1 - i] = array[i][j];
        }
    }
    return tempArray;
};

/**
 * 행렬 교차
 * @param array
 * @returns {any[][]}
 */
const transpose = (array) => {
    const tempArray = Array(Array(), Array(), Array());
    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < 3; j++) {
            tempArray[j][i] = array[i][j];
        }
    }
    return tempArray;
};

/**
 * Test case
 * @returns {number[][][]}
 */
const arrs = () => {
    return [
        [
            [4, 8, 2],
            [4, 5, 7],
            [6, 1, 6]
        ],
        [
            [5, 1, 6],
            [3, 7, 7],
            [4, 9, 1]
        ],
        [
            [4, 5, 8],
            [2, 4, 1],
            [1, 9, 7]
        ]
    ];
}

(() => {
    arrs().forEach(arr => {
        console.log(formingMagicSquare(arr));
    })
})();

/**
 * 3 x 3 마방진 경우의 수
 */
const magicArray = () => {
    [
        [8, 3, 4],
        [1, 5, 9],
        [6, 7, 2]
    ],
    [
        [6, 1, 8],
        [7, 5, 3],
        [2, 9, 4]
    ],
    [
        [2, 7, 6],
        [9, 5, 1],
        [4, 3, 8]
    ],
    [
        [4, 9, 2],
        [3, 5, 7],
        [8, 1, 6]
    ],
    [
        [4, 3, 8],
        [9, 5, 1],
        [2, 7, 6]
    ],
    [
        [2, 9, 4],
        [7, 5, 3],
        [6, 1, 8]
    ],
    [
        [6, 7, 2],
        [1, 5, 9],
        [8, 3, 4]
    ],
    [
        [8, 1, 6],
        [3, 5, 7],
        [4, 9, 2]
    ]
};


