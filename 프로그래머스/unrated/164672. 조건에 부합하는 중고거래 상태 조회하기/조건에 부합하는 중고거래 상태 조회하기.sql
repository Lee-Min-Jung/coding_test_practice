# 2022년 10월 5일에 등록된 중고거래 게시물 구하기
# 게시글 id, 작성자 ID, 게시글 제목, 가격, 거래상태 / 게시글 ID 내림차순

SELECT B.BOARD_ID, B.WRITER_ID, B.TITLE, B.PRICE,
    CASE 
        WHEN B.STATUS = 'SALE'
        THEN '판매중'
        WHEN B.STATUS = 'RESERVED'
        THEN '예약중'
        WHEN B.STATUS = 'DONE'
        THEN '거래완료'
    END
    AS STATUS
FROM USED_GOODS_BOARD B
WHERE B.CREATED_DATE = '2022-10-05'

ORDER BY B.BOARD_ID DESC