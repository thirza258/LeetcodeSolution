SELECT * FROM Patients 
WHERE POSITION('DIAB1' IN conditions) > 0 AND POSITION('SADIAB1' IN conditions) = 0;
