    -- menu query 메뉴
    insert into menu values(1001, (select coalesce(max(a.fnum), 0)+1 from menu a), '비빔밥', 7000, 'D:\\dbimg\\la.jpg', '나물이 들어간 비빔밥', 1);
    insert into menu values(1001, (select coalesce(max(a.fnum), 0)+1 from menu a), '김치찌개', 8000, 'D:\\dbimg\\gi.jpg', '묵은지가 들어간 찌개', 1);
    insert into menu values(1002, (select coalesce(max(a.fnum), 0)+1 from menu a), '자장면', 10000, 'D:\\dbimg\\la.jpg', '좋은기계로 뽑은 자장면', 2);
    insert into menu values(1002, (select coalesce(max(a.fnum), 0)+1 from menu a), '짬뽕', 10000, 'D:\\dbimg\\gi.jpg', '얼큰한 짬뽕', 2);
    insert into menu values(1003, (select coalesce(max(a.fnum), 0)+1 from menu a), '연어초밥', 7000, 'D:\\dbimg\\bi.jpg', '아쿠아리움에서 잡아온 연어로 만든 초밥', 1);
    insert into menu values(1003, (select coalesce(max(a.fnum), 0)+1 from menu a), '냉소바', 8000, 'D:\\dbimg\\ggi.jpg', '시원한 소바', 1);
    insert into menu values(1004, (select coalesce(max(a.fnum), 0)+1 from menu a), '볶음밥', 8000, 'D:\\dbimg\\ja.jpg', '잘볶은 밥', 1);
    insert into menu values(1004, (select coalesce(max(a.fnum), 0)+1 from menu a), '펩시제로', 2000, 'D:\\dbimg\\jjam.jpg', '무설탕 콜라', 1);

    -- ordering query 주문
    insert into ordering values(1001, 1001, (select coalesce(max(a.onum), 1000)+1 from ordering a), '이대', '000-0000-0000', null, null, 800, 805);
    insert into ordering values(1001, 1001, (select coalesce(max(a.onum), 1000)+1 from ordering a), '홍대', '000-0000-0000', null, null, 800, 805);
    insert into ordering values(1002, 1002, (select coalesce(max(a.onum), 1000)+1 from ordering a), '신촌', '000-0000-0000', null, null, 800, 805);
    insert into ordering values(1002, 1002, (select coalesce(max(a.onum), 1000)+1 from ordering a), '이대', '000-0000-0000', null, null, 800, 805);

    -- order_spec query 주문상세
    insert into order_spec values(1001, (select coalesce(max(a.osnum), 1000)+1 from order_spec a), 1, 1100, 1101, 1, 7000);
    insert into order_spec values(1001, (select coalesce(max(a.osnum), 1000)+1 from order_spec a), 2, 1100, 1101, 2, 16000);
    insert into order_spec values(1001, (select coalesce(max(a.osnum), 1000)+1 from order_spec a), 3, 1100, 1102, 1, 11000);
    insert into order_spec values(1001, (select coalesce(max(a.osnum), 1000)+1 from order_spec a), 4, 1100, 1102, 1, 11000);

    insert into shop(bnum, fcategory_makey, fcategory_mikey, saddr, stel, sname, start_time, end_time, sstatus_makey, sstatus_mikey, mnum, bid, bstaus_makey, bstaus_mikey, simg1)
    values((select coalesce(max(a.bnum), 1000)+1 from shop a), 300, 301, '이대역', '000-0000-0000', '육수당', '09:00', '20:00', 400, 401, 1006,
    '1234-01-1234', 500, 502, 'D:\\dbimg\\bu1.jpg');
    insert into shop(bnum, fcategory_makey, fcategory_mikey, saddr, stel, sname, start_time, end_time, sstatus_makey, sstatus_mikey, mnum, bid, bstaus_makey, bstaus_mikey, simg1)
    values((select coalesce(max(a.bnum), 1000)+1 from shop a), 300, 302, '이대역', '000-0000-0000', '무릉도원', '09:00', '20:00', 400, 401, 1007,
    '1234-01-1235', 500, 502, 'D:\\dbimg\\bu2.jpg');
    insert into shop(bnum, fcategory_makey, fcategory_mikey, saddr, stel, sname, start_time, end_time, sstatus_makey, sstatus_mikey, mnum, bid, bstaus_makey, bstaus_mikey, simg1)
    values((select coalesce(max(a.bnum), 1000)+1 from shop a), 300, 303, '이대역', '000-0000-0000', '한끼마끼', '09:00', '20:00', 400, 401, 1008,
    '1234-01-1236', 500, 502, 'D:\\dbimg\\ko1.jpg');
    insert into shop(bnum, fcategory_makey, fcategory_mikey, saddr, stel, sname, start_time, end_time, sstatus_makey, sstatus_mikey, mnum, bid, bstaus_makey, bstaus_mikey, simg1)
    values((select coalesce(max(a.bnum), 1000)+1 from shop a), 300, 304, '이대역', '000-0000-0000', '천진분식', '09:00', '20:00', 400, 401, 1009,
    '1234-01-1237', 500, 502, 'D:\\dbimg\\cu1.jpg');

SET foreign_key_checks = 1;
