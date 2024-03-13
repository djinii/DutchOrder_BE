    insert into common values(100, 999, '사업자 구분');
    insert into common values(100, 101, '개인');
    insert into common values(100, 102, '사업자');
    insert into common values(100, 103, '관리자');
    insert into common values(200, 999, '계정상태 구분');
    insert into common values(200, 201, '유효회원');
    insert into common values(200, 202, '탈퇴회원');
    insert into common values(300, 999, '음식 카테고리 분류');
    insert into common values(300, 301, '한식');
    insert into common values(300, 302, '중식');
    insert into common values(300, 303, '일식');
    insert into common values(300, 304, '분식');
    insert into common values(400, 999, '영업상태 분류');
    insert into common values(400, 401, '영업중');
    insert into common values(400, 402, '영업종료');
    insert into common values(500, 999, '가게상태 분류');
    insert into common values(500, 501, '관리자 승인 대기');
    insert into common values(500, 502, '관리자 승인');
    insert into common values(500, 503, '관리자 승인 거부');
    insert into common values(500, 504, '영업정지');
    insert into common values(600, 999, '증명서 분류');
    insert into common values(600, 601, '사업자등록증');
    insert into common values(600, 602, '영업신고증');
    insert into common values(700, 999, '친구상태 분류');
    insert into common values(700, 701, '친구요청');
    insert into common values(700, 702, '수락완료');
    insert into common values(700, 703, '수락거절');
    insert into common values(800, 999, '주문상태 분류');
    insert into common values(800, 801, '장바구니');
    insert into common values(800, 802, '주문수락 대기');
    insert into common values(800, 803, '조리중');
    insert into common values(800, 804, '배달 시작');
    insert into common values(800, 805, '배달 완료');
    insert into common values(900, 999, '결제상태 분류');
    insert into common values(900, 901, '결제중');
    insert into common values(900, 902, '결제완료');
    insert into common values(1000, 999, '답글여부 분류');
    insert into common values(1000, 1001, '답글없음');
    insert into common values(1000, 1002, '답글있음');
    insert into common values(1100, 999, '메뉴옵션 분류');
    insert into common values(1100, 1101, '기본');
    insert into common values(1100, 1102, '곱배기');
    
    -- member insert query 회원
    insert into member (mnum, memail, mpw, mname, mtel, mnic, mgroup_makey, mgroup_mikey, mstatus_makey, mstatus_mikey, hiredate)
				values((select coalesce(max(a.mnum), 1000)+1 from member a), 'aaa@naver.com', '1234' , '홍길동1', '010-1234-5678', 'aaa', 100, 101, 200, 201, sysdate());
	insert into member (mnum, memail, mpw, mname, mtel, mnic, mgroup_makey, mgroup_mikey, mstatus_makey, mstatus_mikey, hiredate)
				values((select coalesce(max(a.mnum), 1000)+1 from member a), 'bbb@naver.com', '1234' , '홍길동2', '010-1234-5678', 'bbb', 100, 101, 200, 201, sysdate());
	insert into member (mnum, memail, mpw, mname, mtel, mnic, mgroup_makey, mgroup_mikey, mstatus_makey, mstatus_mikey, hiredate)
				values((select coalesce(max(a.mnum), 1000)+1 from member a), 'ccc@naver.com', '1234' , '홍길동3', '010-1234-5678', 'ccc', 100, 101, 200, 201, sysdate());
	insert into member (mnum, memail, mpw, mname, mtel, mnic, mgroup_makey, mgroup_mikey, mstatus_makey, mstatus_mikey, hiredate)
				values((select coalesce(max(a.mnum), 1000)+1 from member a), 'ddd@naver.com', '1234' , '홍길동4', '010-1234-5678', 'ddd', 100, 101, 200, 201, sysdate());
	insert into member (mnum, memail, mpw, mname, mtel, mnic, mgroup_makey, mgroup_mikey, mstatus_makey, mstatus_mikey, hiredate)
				values((select coalesce(max(a.mnum), 1000)+1 from member a), 'eee@naver.com', '1234' , '홍길동5', '010-1234-5678', 'eee', 100, 101, 200, 201, sysdate());
	insert into member (mnum, memail, mpw, mname, mtel, mnic, mgroup_makey, mgroup_mikey, mstatus_makey, mstatus_mikey, hiredate)
				values((select coalesce(max(a.mnum), 1000)+1 from member a), 'fff@naver.com', '1234' , '홍길동6', '010-1234-5678', null, 100, 102, 200, 201, sysdate());
	insert into member (mnum, memail, mpw, mname, mtel, mnic, mgroup_makey, mgroup_mikey, mstatus_makey, mstatus_mikey, hiredate)
				values((select coalesce(max(a.mnum), 1000)+1 from member a), 'ggg@naver.com', '1234' , '홍길동7', '010-1234-5678', null, 100, 102, 200, 201, sysdate());
	insert into member (mnum, memail, mpw, mname, mtel, mnic, mgroup_makey, mgroup_mikey, mstatus_makey, mstatus_mikey, hiredate)
				values((select coalesce(max(a.mnum), 1000)+1 from member a), 'hhh@naver.com', '1234' , '홍길동8', '010-1234-5678', null, 100, 102, 200, 201, sysdate());
	insert into member (mnum, memail, mpw, mname, mtel, mnic, mgroup_makey, mgroup_mikey, mstatus_makey, mstatus_mikey, hiredate)
				values((select coalesce(max(a.mnum), 1000)+1 from member a), 'jjj@naver.com', '1234' , '홍길동9', '010-1234-5678', null, 100, 102, 200, 201, sysdate());
	insert into member (mnum, memail, mpw, mname, mtel, mnic, mgroup_makey, mgroup_mikey, mstatus_makey, mstatus_mikey, hiredate)
				values((select coalesce(max(a.mnum), 1000)+1 from member a), 'iii@naver.com', '1234' , '관리자', '010-1234-5678', null, 100, 103, 200, 201, sysdate());
                
    -- shop insert query 가게정보
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
    
    -- business_file query 사업자첨부파일
    insert into business_file(bfnum, mnum, bftype_makey, bftype_mikey, bfimg1)
    values((select coalesce(max(a.bfnum), 1000)+1 from business_file a), 1006, 600, 601, 'D:\\dbimg\\na1.jpg');
    insert into business_file(bfnum, mnum, bftype_makey, bftype_mikey, bfimg1)
    values((select coalesce(max(a.bfnum), 1000)+1 from business_file a), 1007, 600, 601, 'D:\\dbimg\\na1.jpg');
    insert into business_file(bfnum, mnum, bftype_makey, bftype_mikey, bfimg1)
    values((select coalesce(max(a.bfnum), 1000)+1 from business_file a), 1008, 600, 601, 'D:\\dbimg\\na1.jpg');
    insert into business_file(bfnum, mnum, bftype_makey, bftype_mikey, bfimg1)
    values((select coalesce(max(a.bfnum), 1000)+1 from business_file a), 1009, 600, 601, 'D:\\dbimg\\na1.jpg');
    
    -- member_friend query 친구추가
    insert into member_friends values(1001, 'bbb', 700, 702);
    insert into member_friends values(1001, 'ccc', 700, 702);
    insert into member_friends values(1002, 'ddd', 700, 702);
    insert into member_friends values(1002, 'eee', 700, 702);
    
    -- notice query 공지사항
    insert into notice values((select coalesce(max(a.nonum), 0)+1 from notice a), 1010, '공지1', '공지여', sysdate());
    insert into notice values((select coalesce(max(a.nonum), 0)+1 from notice a), 1010, '공지2', '공지여', sysdate());
    insert into notice values((select coalesce(max(a.nonum), 0)+1 from notice a), 1010, '공지3', '공지여', sysdate());
    insert into notice values((select coalesce(max(a.nonum), 0)+1 from notice a), 1010, '공지4', '공지여', sysdate());
    insert into notice values((select coalesce(max(a.nonum), 0)+1 from notice a), 1010, '공지5', '공지여', sysdate());
    insert into notice values((select coalesce(max(a.nonum), 0)+1 from notice a), 1010, '공지6', '공지여', sysdate());
    insert into notice values((select coalesce(max(a.nonum), 0)+1 from notice a), 1010, '공지7', '공지여', sysdate());
    insert into notice values((select coalesce(max(a.nonum), 0)+1 from notice a), 1010, '공지8', '공지여', sysdate());
    insert into notice values((select coalesce(max(a.nonum), 0)+1 from notice a), 1010, '공지9', '공지여', sysdate());
    insert into notice values((select coalesce(max(a.nonum), 0)+1 from notice a), 1010, '공지10', '공지여', sysdate());

    -- address query 주소
    insert into address values(1001, (select coalesce(max(a.adnum), 0)+1 from address a), '이대');
    insert into address values(1001, (select coalesce(max(a.adnum), 0)+1 from address a), '홍대');
    insert into address values(1002, (select coalesce(max(a.adnum), 0)+1 from address a), '신촌');
    insert into address values(1002, (select coalesce(max(a.adnum), 0)+1 from address a), '이대');
    insert into address values(1003, (select coalesce(max(a.adnum), 0)+1 from address a), '아현');
    insert into address values(1003, (select coalesce(max(a.adnum), 0)+1 from address a), '홍대입구');
    insert into address values(1004, (select coalesce(max(a.adnum), 0)+1 from address a), '종로');
    insert into address values(1005, (select coalesce(max(a.adnum), 0)+1 from address a), '을지로');
    
    -- menu query 메뉴
    insert into menu values(1001, (select coalesce(max(a.fnum), 0)+1 from menu a), '비빔밥', 7000, 'D:\\dbimg\\la.jpg', '나물이 들어간 비빔밥', 1);
    insert into menu values(1001, (select coalesce(max(a.fnum), 0)+1 from menu a), '김치찌개', 8000, 'D:\\dbimg\\gi.jpg', '묵은지가 들어간 찌개', 1);
    insert into menu values(1002, (select coalesce(max(a.fnum), 0)+1 from menu a), '자장면', 10000, 'D:\\dbimg\\la.jpg', '좋은기계로 뽑은 자장면', 2);
    insert into menu values(1002, (select coalesce(max(a.fnum), 0)+1 from menu a), '짬뽕', 10000, 'D:\\dbimg\\gi.jpg', '얼큰한 짬뽕', 2);
    insert into menu values(1003, (select coalesce(max(a.fnum), 0)+1 from menu a), '연어초밥', 7000, 'D:\\dbimg\\bi.jpg', '아쿠아리움에서 잡아온 연어로 만든 초밥', 1);
    insert into menu values(1003, (select coalesce(max(a.fnum), 0)+1 from menu a), '냉소바', 8000, 'D:\\dbimg\\ggi.jpg', '시원한 소바', 1);
    insert into menu values(1004, (select coalesce(max(a.fnum), 0)+1 from menu a), '볶음밥', 8000, 'D:\\dbimg\\ja.jpg', '잘볶은 밥', 1);
    insert into menu values(1004, (select coalesce(max(a.fnum), 0)+1 from menu a), '펩시제로', '2000', 'D:\\dbimg\\jjam.jpg', '무설탕 콜라', 1);
    
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
    
    -- dutchpay query 주문금액분담
    insert into dutchpay values(1001, 'bbb', 10000, 900, 902);
    insert into dutchpay values(1001, 'ccc', 8000, 900, 902);
    insert into dutchpay values(1002, 'ddd', 10000, 900, 902);
    insert into dutchpay values(1002, 'eee', 10000, 900, 902);
    
    -- review query 리뷰
    insert into review values((select coalesce(max(a.rnum), 0)+1 from review a), 1001, 1001, 1001, null, 5, sysdate(), null, 1000, 1001, null);	-- 마지막에서 두번쨰는 답글 달린지 안달린지 구분, 마지막은 답글입력내용
    insert into review values((select coalesce(max(a.rnum), 0)+1 from review a), 1002, 1002, 1003, '음식 재료가 상한거 같아요', 1, sysdate(), null, 1000, 1002, '어쩌라고 ㅋㅋ');