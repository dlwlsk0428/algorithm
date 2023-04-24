SELECT FOOD_TYPE,	REST_ID,	REST_NAME,	FAVORITES
from REST_INFO 
where (FOOD_TYPE, favorites) in (select FOOD_TYPE, max(favorites) from rest_info group by food_type)
order by food_type desc;
