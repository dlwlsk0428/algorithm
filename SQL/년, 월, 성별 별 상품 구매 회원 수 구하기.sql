-- set 사용
set @gender = -1;
SELECT YEAR(sales_date) as year, MONTH(sales_date) as month, gender, count(distinct(online_sale.user_id)) as users
from online_sale 
join user_info
on online_sale.user_id = user_info.user_id
group by YEAR(sales_date), MONTH(sales_date), gender
having gender is not null
order by YEAR(sales_date), MONTH(sales_date), gender;
