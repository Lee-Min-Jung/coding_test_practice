SELECT I.ANIMAL_ID, I.NAME, I.SEX_UPON_INTAKE
FROM ANIMAL_INS I
WHERE NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY I.ANIMAL_ID