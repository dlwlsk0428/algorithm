SELECT MEMBER_NAME, REVIEW_TEXT, date_format(REVIEW_DATE, "%Y-%m-%d") as REVIEW_DATE
from rest_review r 
join member_profile m
on r.member_id = m.member_id
where r.member_id = (select member_id from rest_review group by member_id order by count(member_id) desc limit 1)
order by REVIEW_DATE, REVIEW_TEXT;
