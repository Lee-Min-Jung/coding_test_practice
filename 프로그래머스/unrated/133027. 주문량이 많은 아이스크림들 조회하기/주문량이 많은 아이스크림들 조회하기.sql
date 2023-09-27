#7월 아이스크림 총 주문량+상반기 아이스크림 총 주문량이 큰 순서대로 3개 맛 조회
SELECT A.FLAVOR
FROM
    (SELECT *
    from FIRST_HALF
    union
    SELECT *
    from JULY) A
GROUP BY A.FLAVOR
ORDER BY SUM(TOTAL_ORDER) DESC
LIMIT 3

