# 보호소에 들어올 당시에는 중성화되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회
SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME 
FROM ANIMAL_INS I
INNER JOIN ANIMAL_OUTS O
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE LEFT(I.SEX_UPON_INTAKE, 6) = 'Intact' 
AND(LEFT(O.SEX_UPON_OUTCOME, 6) = 'Spayed' OR LEFT(O.SEX_UPON_OUTCOME, 8) = 'Neutered')
ORDER BY I.ANIMAL_ID