# 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차에 대해서 자동차 ID, 자동차 종류, 대여 금액


# a테이블에서 자동차 id, 자동차 종류, 대여 금액을 뽑기
# b 테이블과 car id로 left join한 다음 대여 기간 조건 확인하기
# c 테이블과 car type로 left join한 다음 할인율 구해서 대여 금액에 적용

select distinct a.car_id, a.car_type, round(a.daily_fee * 30 * (1-0.01*c.discount_rate)) as FEE
from car_rental_company_car a
left join car_rental_company_rental_history b
on a.car_id = b.car_id
left join car_rental_company_discount_plan c
on a.car_type = c.car_type
where a.car_type in ('세단', 'SUV')
and a.car_id not in (
    select b2.car_id
    from car_rental_company_rental_history b2
    WHERE b2.end_date >= '2022-11-01' AND b2.start_date <= '2022-11-30' 
)
and duration_type = '30일 이상'
having FEE >= 500000 and FEE <= 2000000
order by FEE desc, a.car_type , a.car_id
