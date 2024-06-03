# Write your MySQL query statement below
Select e.name , b.bonus 
from employee e
left join bonus b 
on e.empid = b.empid
where b.bonus < 1000
or bonus is null;