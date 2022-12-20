select flavor from (select flavor, sum(total_order) as total from
(SELECT * from JULY union all select * from first_half) as new_table
group by flavor) as new_table2 order by total desc limit 3;
