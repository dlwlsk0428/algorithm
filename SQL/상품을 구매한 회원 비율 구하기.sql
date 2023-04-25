select @full := count(*) from user_info where year(joined) = 2021;

SELECT year(o.sales_date) as year, month(o.sales_date) as month, count(distinct(o.user_id)) as purchased_users, ROUND(count(distinct(o.user_id))/@full, 1) as PUCHASED_RATIO
from ONLINE_SALE o
join USER_INFO u
on o.user_id = u.user_id and year(u.joined) = 2021
group by year(o.sales_date), month(o.sales_date);
