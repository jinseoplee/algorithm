/**
 * pdf의 highlight된 영역의 면적을 구하라.
 * 단어의 알파벳 중 높이가 가장 높은것 * 단어의 글자 수
 * @param h 각각의 알파벳들의 높이
 * @param word 단어
 * @returns {number}
 */
const designerPdfViewer = (h, word) => {
    const alphabet = "abcdefghijklmnopqrstuvwxyz";
    const max = word.split("").reduce((max, w) => h[alphabet.indexOf(w)] > max ? h[alphabet.indexOf(w)] : max, 0);
    return max * word.length
};

const designerPdfViewer2 = (h, word) => {
    const charToIndex = c => c.charCodeAt(0) - 97;
    const max = word.split("").reduce((max, w) => h[charToIndex(w)] > max ? h[charToIndex(w)] : max, 0);
    return word.length * max;
};

(() => {
    let h = "1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5".split(" ").map(a => parseInt(a, 10));
    let word = "abc";
    console.log(designerPdfViewer2(h, word));
})();