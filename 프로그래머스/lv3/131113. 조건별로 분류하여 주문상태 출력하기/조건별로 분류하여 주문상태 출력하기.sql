# 5월1일을 기준으로 주문 ID, 제품 ID, 출고일자, 출고여부 조회
# 출고여부는 5월 1일까지 출고완료, 이후는 출고 대기, 미정이면 출고미정 / 주문ID 오름차순

SELECT O.ORDER_ID, O.PRODUCT_ID, DATE_FORMAT(O.OUT_DATE, '%Y-%m-%d') AS OUT_DATE,
    CASE 
        WHEN O.OUT_DATE <= '2022-05-01'
        THEN '출고완료'
        WHEN O.OUT_DATE > '2022-05-01'
        THEN '출고대기'
        ELSE '출고미정'
    END
    AS '출고여부'
FROM FOOD_ORDER O

ORDER BY O.ORDER_ID