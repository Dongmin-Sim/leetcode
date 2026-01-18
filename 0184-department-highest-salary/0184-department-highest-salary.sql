# Write your MySQL query statement below
select 
    t.Department,
    t.Employee,
    t.salary
from (
    select 
        d.name as Department,
        e.name as Employee, 
        e.salary,
        rank() over (partition by d.id order by e.salary desc) as rn
    from Employee e
    join Department d 
    on e.departmentId = d.id
) t
where rn = 1
;