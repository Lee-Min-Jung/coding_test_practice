# 2021년에 가입한 전체 회원들 중 상품을 구매한 회원수와 
# 상품을 구매한 회원의 비율(=2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)을 년, 월 별로 출력



SELECT YEAR(S.SALES_DATE) AS YEAR, 
        MONTH(S.SALES_DATE) AS MONTH, 
        COUNT(DISTINCT U.USER_ID) AS PUCHASED_USERS, 
        ROUND((COUNT(DISTINCT U.USER_ID) / 
         (SELECT COUNT(DISTINCT U.USER_ID)
               FROM USER_INFO U                                                 
               WHERE YEAR(U.JOINED) = '2021')),1)                                                                              AS PUCHASED_RATIO
FROM USER_INFO U
RIGHT JOIN ONLINE_SALE S
ON U.USER_ID = S.USER_ID
WHERE YEAR(U.JOINED) = '2021'
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH