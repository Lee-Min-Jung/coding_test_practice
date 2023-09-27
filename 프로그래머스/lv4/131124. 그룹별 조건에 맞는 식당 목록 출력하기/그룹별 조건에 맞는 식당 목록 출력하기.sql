# 리뷰를 가장 많이 작성한 회원의 리뷰 조회
# 회원이름, 리뷰 텍스트, 리뷰작성일//리뷰작성일 오름차순, 리뷰 텍스트 오름차순
SELECT P.MEMBER_NAME, R2.REVIEW_TEXT, DATE_FORMAT(R2.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM REST_REVIEW R2

LEFT JOIN MEMBER_PROFILE P
ON R2.MEMBER_ID = P.MEMBER_ID

WHERE R2.MEMBER_ID = 
    (SELECT R.MEMBER_ID
    FROM REST_REVIEW R
    GROUP BY R.MEMBER_ID
    ORDER BY COUNT(R.REVIEW_ID) DESC
    LIMIT 1)

ORDER BY R2.REVIEW_DATE, R2.REVIEW_TEXT
