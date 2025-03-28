SELECT
    U.USER_ID,
    U.NICKNAME,
    SUM(B.PRICE) AS TOTAL_SALES
FROM
    USED_GOODS_USER AS U
JOIN
    USED_GOODS_BOARD AS B ON U.USER_ID = B.WRITER_ID
WHERE
    B.STATUS = 'DONE' -- 완료된 거래
GROUP BY
    U.USER_ID
HAVING
    TOTAL_SALES >= 700000 -- 총 거래된 금액이 700,000원 이상
ORDER BY
    TOTAL_SALES ASC;