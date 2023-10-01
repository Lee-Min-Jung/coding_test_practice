SELECT O.ANIMAL_ID, O.NAME
FROM ANIMAL_OUTS O

LEFT JOIN ANIMAL_INS I
ON O.ANIMAL_ID = I.ANIMAL_ID

ORDER BY DATEDIFF(O.DATETIME, I.DATETIME) DESC

LIMIT 2