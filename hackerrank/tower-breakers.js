function towerBreakers(arr) {
    let result = arr.reduce((nimSum, val) => {
        return nimSum ^= val;
    }, 0);

    return parseInt(result.toString(2)) !== 0 ? 1 : 2;
}

//1
let arr = "796723 950929 183477 732159 779867 598794 596985 156054 445934 156030 99998 58097 459353 866372 333784 601251 142899 708233 651036 20590 56425 970129 722162 832631 938765 212387 779 181866 992436 183446 617621 304311 611791 524875 7068 432043 23068 291295".split(" ");

//2
let arr2 = "881650 992034 277965 99201 193998 401585 880015 800252 657709 204082 310999 555210 742516 733237 815303 616125 615117 188068 688040 355465 375345 783969 538818 554352 524278 5231 848239 761163 840154 35320 832869 745902 11035 202527 749715 958290 758848 368024 678532 327006 756436 148922 842161 305674 470425 876849 502164 996559 124743 368393 385463 448712 643511 722234 780576 886396 217259 593178 137854 391614 663192 412715 1881 695775 178413 3219 29078 619729 166923 355574 181361 794377 387761".split(" ");

//2
let arr3 = "724481 130740 792273 886804 404890 449886 654224 194667 354317 367843 525624 414224 481744 827725 176927 733780 387166 769479 964040 11034 248637 416248 133834 481453 418675 19197 790516 259872 582280 760462 681129 137141 189738 535431 619088 215251 323574 12124 834492 241256 629441 976094 198902".split(" ");
console.log(towerBreakers(arr3));