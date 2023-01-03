SELECT DISTINCT(T.CART_ID )
from (select CART_ID, NAME from CART_PRODUCTS where NAME = "Milk") as T
where T.CART_ID in (select CART_ID from CART_PRODUCTS where NAME = "Yogurt");
