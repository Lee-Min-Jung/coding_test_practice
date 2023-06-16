select h.flavor
from first_half h
inner join july j
on h.flavor = j.flavor
group by h.flavor
order by sum(h.total_order+j.total_order) desc
limit 3

# SELECT FLAVOR
# FROM FIRST_HALF A
# JOIN JULY B USING (FLAVOR)
# GROUP BY FLAVOR
# ORDER BY SUM(A.TOTAL_ORDER + B.TOTAL_ORDER) DESC
# LIMIT 3;