# Write your MySQL query statement below

SELECT DISTINCT num AS ConsecutiveNums
FROM (
  SELECT *,
         ROW_NUMBER() OVER (ORDER BY id) -
         ROW_NUMBER() OVER (PARTITION BY num ORDER BY id) AS grp
  FROM Logs
) AS grouped
GROUP BY num, grp
HAVING COUNT(*) >= 3;