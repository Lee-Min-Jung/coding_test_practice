SELECT M.MEMBER_ID, M.MEMBER_NAME, M.GENDER, DATE_FORMAT(M.DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
FROM MEMBER_PROFILE M
WHERE MONTH(M.DATE_OF_BIRTH) = '3' 
AND M.GENDER = 'W'
AND M.TLNO IS NOT NULL
ORDER BY M.MEMBER_ID
