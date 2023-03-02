select * from (
SELECT date_format(sales_date, '%Y-%m-%d') as sales_date, PRODUCT_ID, USER_ID, SALES_AMOUNT from ONLINE_SALE
union all 
select date_format(sales_date, '%Y-%m-%d') as sales_date, PRODUCT_ID, null as USER_ID, SALES_AMOUNT from OFFLINE_SALE
) as T
where sales_date between '2022-03-01' and '2022-03-31'
order by sales_date, product_id, user_id;
