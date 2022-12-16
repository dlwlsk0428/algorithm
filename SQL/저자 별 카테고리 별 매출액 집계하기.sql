-- 코드를 입력하세요
SELECT b.AUTHOR_ID, (select AUTHOR_NAME from AUTHOR a where a.AUTHOR_ID = b.AUTHOR_ID) as AUTHOR_NAME, b.CATEGORY, sum(SALES) as TOTAL_SALES
from (SELECT BOOK.*, PRICE * sum(SALES) as SALES
from BOOK
join BOOK_SALES s
on BOOK.BOOK_ID = s.BOOK_ID
where Year(SALES_DATE) = 2022 and month(SALES_DATE) = 1
group by BOOK.BOOK_ID) as b
group by b.AUTHOR_ID, b.CATEGORY
order by b.AUTHOR_ID ASC, b.CATEGORY DESC;
