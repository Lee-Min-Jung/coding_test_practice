# SELECT
#     DATE_FORMAT(SALES_DATE, '%Y') AS YEAR,
#     CAST(DATE_FORMAT(SALES_DATE, '%m') AS SIGNED) AS MONTH,
#     count(distinct(o.user_id)) as PUCHASED_USERS,
#     round(
#         count(distinct(o.user_id)) / (
#                                     SELECT count(*) 
#                                     FROM USER_INFO 
#                                     WHERE DATE_FORMAT(JOINED, '%Y') = '2021'
#                                     ),
#         1) 
#         as PUCHASED_RATIO
# FROM ONLINE_SALE O
# JOIN USER_INFO U ON O.USER_ID = U.USER_ID
# WHERE DATE_FORMAT(JOINED, '%Y') = '2021'
# GROUP BY YEAR, MONTH;

SELECT 
    YEAR(S.SALES_DATE) AS YEAR, 
    MONTH(S.SALES_DATE) AS MONTH, 
    COUNT(DISTINCT(S.USER_ID)) AS PUCHASED_USERS, 
    ROUND(
        COUNT(DISTINCT(S.USER_ID)) / 
                        (SELECT COUNT(*) 
                        FROM USER_INFO U WHERE YEAR(U.JOINED) = '2021'),1) 
    AS PUCHASED_RATIO
FROM USER_INFO U
INNER JOIN ONLINE_SALE S
ON U.USER_ID = S.USER_ID
WHERE YEAR(U.JOINED) = '2021'
GROUP BY YEAR(S.SALES_DATE), MONTH(S.SALES_DATE)
ORDER BY YEAR, MONTH