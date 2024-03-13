ALTER TABLE `DUTCHORDER`.`review`
    DROP FOREIGN KEY `FK_ordering_TO_review`; -- 주문 -> 리뷰
-- 주소
ALTER TABLE `DUTCHORDER`.`address`
    DROP FOREIGN KEY `FK_member_TO_address`; -- 회원 -> 주소
-- 주문금액분담
ALTER TABLE `DUTCHORDER`.`dutchpay`
	DROP FOREIGN KEY `FK_ordering_TO_dutchpay`; -- 주문 -> 주문금액분담
-- 주문상세
ALTER TABLE `DUTCHORDER`.`order_spec`
    DROP FOREIGN KEY `FK_ordering_TO_order_spec`; -- 주문 -> 주문상세
-- 주문상세
ALTER TABLE `DUTCHORDER`.`order_spec`
    DROP FOREIGN KEY `FK_menu_TO_order_spec`; -- 메뉴 -> 주문상세
-- 주문
ALTER TABLE `DUTCHORDER`.`ordering`
    DROP FOREIGN KEY `FK_member_TO_ordering`; -- 회원 -> 주문
-- 주문
ALTER TABLE `DUTCHORDER`.`ordering`
    DROP FOREIGN KEY `FK_shop_TO_ordering`; -- 가게정보 -> 주문
-- 메뉴
ALTER TABLE `DUTCHORDER`.`menu`
    DROP FOREIGN KEY `FK_shop_TO_menu`; -- 가게정보 -> 메뉴
-- 공지사항
ALTER TABLE `DUTCHORDER`.`notice`
    DROP FOREIGN KEY `FK_member_TO_notice`; -- 회원 -> 공지사항
-- 친구
ALTER TABLE `DUTCHORDER`.`member_friends`
    DROP FOREIGN KEY `FK_member_TO_member_friends`; -- 회원 -> 친구
-- 사업자 첨부파일
ALTER TABLE `DUTCHORDER`.`business_file`
    DROP FOREIGN KEY `FK_member_TO_business_file`; -- 회원 -> 사업자 첨부파일
-- 가게정보
ALTER TABLE `DUTCHORDER`.`shop`
    DROP FOREIGN KEY `FK_member_TO_shop`; -- 회원 -> 가게정보


============드랍 기본키===============
-- 리뷰
ALTER TABLE `DUTCHORDER`.`review`
    DROP PRIMARY KEY; -- 주소 기본키
-- 주소
ALTER TABLE `DUTCHORDER`.`address`
    DROP PRIMARY KEY; -- 주소 기본키
-- 주문금액분담
ALTER TABLE `DUTCHORDER`.`dutchpay`
	DROP PRIMARY KEY; -- 주문금액분담 기본키
-- 주문상세
ALTER TABLE `DUTCHORDER`.`order_spec`
    DROP PRIMARY KEY; -- 주문상세 기본키
-- 메뉴
ALTER TABLE `DUTCHORDER`.`menu`
    DROP PRIMARY KEY; -- 메뉴 기본키
-- 공지사항
ALTER TABLE `DUTCHORDER`.`notice`
    DROP PRIMARY KEY; -- 공지사항  기본키
-- 친구
ALTER TABLE `DUTCHORDER`.`member_friends`
    DROP PRIMARY KEY; -- 친구 기본키
-- 사업자 첨부파일
ALTER TABLE `DUTCHORDER`.`business_file`
    DROP PRIMARY KEY; -- 사업자 첨부파일  기본키
-- 가게정보
ALTER TABLE `DUTCHORDER`.`shop`
    DROP PRIMARY KEY; -- 가게정보 기본키
-- 회원
ALTER TABLE `DUTCHORDER`.`member`
    DROP PRIMARY KEY; -- 회원 기본키
-- 공통정보
ALTER TABLE `DUTCHORDER`.`common`
	DROP PRIMARY KEY; -- 공통정보 기본키
-- 이메일코드
ALTER TABLE `DUTCHORDER`.`email_code`
	DROP PRIMARY KEY; -- 이메일코드 기본키

============드랍 테이블============================
-- 공통정보
DROP TABLE IF EXISTS `DUTCHORDER`.`common` RESTRICT;
-- 회원
DROP TABLE IF EXISTS `DUTCHORDER`.`member` RESTRICT;
-- 가게정보
DROP TABLE IF EXISTS `DUTCHORDER`.`shop` RESTRICT;
-- 사업자 첨부파일
DROP TABLE IF EXISTS `DUTCHORDER`.`business_file` RESTRICT;
-- 친구
DROP TABLE IF EXISTS `DUTCHORDER`.`member_friends` RESTRICT;
-- 메뉴
DROP TABLE IF EXISTS `DUTCHORDER`.`menu` RESTRICT;
-- 주문
DROP TABLE IF EXISTS `DUTCHORDER`.`ordering` RESTRICT;
-- 주문상세
DROP TABLE IF EXISTS `DUTCHORDER`.`order_spec` RESTRICT;
-- 주문금액분담
DROP TABLE IF EXISTS `DUTCHORDER`.`dutchpay` RESTRICT;
-- 주소
DROP TABLE IF EXISTS `DUTCHORDER`.`address` RESTRICT;
-- 리뷰
DROP TABLE IF EXISTS `DUTCHORDER`.`review` RESTRICT;
-- 공지사항
DROP TABLE IF EXISTS `DUTCHORDER`.`notice` RESTRICT;
-- 이메일코드
DROP TABLE IF EXISTS `DUTCHORDER`.`email_code` RESTRICT;

==========================================================테이블 생성용=================================================================
-- (1)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- 공통정보      이 테이블은 다른 테이블들과 절대 참조 관계를 맺어선 안댐!!       
CREATE TABLE `DUTCHORDER`.`common` (
	`major`    INT         NOT NULL, -- 대분류
	`miner`    INT         NOT NULL, -- 중분류
	`keyvalue` VARCHAR(50) NOT NULL  -- 내용
);
-- 공통정보
ALTER TABLE `DUTCHORDER`.`common`
	ADD CONSTRAINT `COMMON` -- 공통정보 기본키
	PRIMARY KEY (
	`major`, -- 대분류
	`miner`  -- 중분류
	);
    
-- (2)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- 회원
CREATE TABLE `DUTCHORDER`.`member` (
    `mnum`     INT          NOT NULL, -- 회원번호
    `memail`   VARCHAR(100) NOT NULL, -- 이메일
    `mpw`      VARCHAR(20)  NOT NULL, -- 패스워드
    `mname`    VARCHAR(20)  NOT NULL, -- 이름
    `mtel`     VARCHAR(20)  NOT NULL, -- 연락처
    `mnic`     VARCHAR(20)  NULL, -- 닉네임
    `mgroup_makey`   INT          NOT NULL, -- 사업자 구분 대분류:100
    `mgroup_mikey`   INT          NOT NULL, -- 사업자 구분 중분류:101=개인 / 102=사업자 / 103=관리자
    `mstatus_makey`  INT          NOT NULL, -- 계정 상태 구분 대분류:200
    `mstatus_mikey`  INT          NOT NULL, -- 계정 상태 구분 중분류:201=생존 / 202=탈퇴
    `hiredate` DATE         NOT NULL  -- 등록 날짜
);
-- 회원
ALTER TABLE `DUTCHORDER`.`member`
    ADD CONSTRAINT `member` -- 회원 기본키
    PRIMARY KEY (
    `mnum` -- 회원번호
    );
-- ALTER TABLE `DUTCHORDER`.`member`
-- MODIFY COLUMN `mnum` INT;
alter table `DUTCHORDER`.`member`
add constraint mnic_unique unique (mnic);
alter table `DUTCHORDER`.`member`
add constraint memail_unique unique (memail);

-- (3)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- 가게정보
CREATE TABLE `DUTCHORDER`.`shop` (
    `bnum`      INT          NOT NULL, -- 사업자일련번호
    `fcategory_makey` INT          NOT NULL, -- 음식종류 대분류:300
    `fcategory_mikey` INT          NOT NULL, -- 음식종류 중분류:301=한식 / 302=중식 / 303=일식 / 304=분식
    `saddr`     VARCHAR(200) NOT NULL, -- 주소
    `stel`      VARCHAR(20)  NOT NULL, -- 가게연락처
    `sname`     VARCHAR(100) NOT NULL, -- 상호명
    `start_time`     VARCHAR(10) NOT NULL, -- 오픈시간
    `end_time`     VARCHAR(10) NOT NULL, -- 마감시간
    `sstatus_makey`   INT          NOT NULL, -- 영업상태 구분 대분류:400
    `sstatus_mikey`   INT          NOT NULL, -- 영업상태 구분 중분류:401=영업중 / 402=영업종료
    `mnum`      INT          NOT NULL, -- 회원번호
    `bid`       VARCHAR(100) NOT NULL, -- 사업자번호
    `bstaus_makey`    INT          NOT NULL, -- 승인여부 상태 대분류:500
    `bstaus_mikey`    INT          NOT NULL, -- 승인여부 상태 중분류:501=승인대기 / 502=승인 / 503=승인거절 504=영업정지처분
    `simg1`     VARCHAR(1000)         NOT NULL, -- 이미지1
    `simg2`     VARCHAR(1000)         NULL,     -- 이미지2
    `simg3`     VARCHAR(1000)         NULL,     -- 이미지3
    `sconfirm`  timestamp         NULL      -- 승인 날짜
);
-- 가게정보
ALTER TABLE `DUTCHORDER`.`shop`
    ADD CONSTRAINT `shop` -- 가게정보 기본키
    PRIMARY KEY (
    `bnum` -- 사업자일련번호
    );
-- 가게정보
ALTER TABLE `DUTCHORDER`.`shop`
    ADD CONSTRAINT `FK_member_TO_shop` -- 회원 -> 가게정보
    FOREIGN KEY (
    `mnum` -- 회원번호
    )
    REFERENCES `DUTCHORDER`.`member` ( -- 회원
    `mnum` -- 회원번호
    );
alter table `DUTCHORDER`.`shop`
add constraint sname_unique unique (sname);
alter table `DUTCHORDER`.`shop`
add constraint bid_unique unique (bid);

-- (4)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- 사업자 첨부파일
CREATE TABLE `DUTCHORDER`.`business_file` (
    `mnum`   INT  NOT NULL, -- 회원번호
    `bfnum`  INT  NOT NULL, -- 첨부파일 번호
    `bftype_makey` INT  NOT NULL, -- 증 구분 대분류:600
    `bftype_mikey` INT  NOT NULL, -- 증 구분 중분류:601=사업자등록증 / 602=영업신고증
    `bfimg1`  VARCHAR(1000) NOT NULL,  -- 파일이미지1
    `bfimg2`  VARCHAR(1000) NULL  -- 파일이미지2
);
-- 사업자 첨부파일
ALTER TABLE `DUTCHORDER`.`business_file`
    ADD CONSTRAINT `business_file` -- 사업자 첨부파일  기본키
    PRIMARY KEY (
    `mnum`,  -- 회원번호
    `bfnum`  -- 첨부파일 번호
    );
-- 사업자 첨부파일
ALTER TABLE `DUTCHORDER`.`business_file`
    ADD CONSTRAINT `FK_member_TO_business_file` -- 회원 -> 사업자 첨부파일
    FOREIGN KEY (
    `mnum` -- 회원번호
    )
    REFERENCES `DUTCHORDER`.`member` ( -- 회원
    `mnum` -- 회원번호
    );
    
-- (5)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- 친구
CREATE TABLE `DUTCHORDER`.`member_friends` (
    `mnum`     INT         NOT NULL, -- 회원번호
    `mfnic`    VARCHAR(20) NOT NULL, -- 친구닉네임
    `mfstatus_makey` INT         NOT NULL,  -- 친구상태 대분류:700
    `mfstatus_mikey` INT         NOT NULL  -- 친구상태 중뷴류:701=수락대기중 / 702=수락완료
);
-- 친구
ALTER TABLE `DUTCHORDER`.`member_friends`
    ADD CONSTRAINT `member_friends` -- 친구 기본키
    PRIMARY KEY (
    `mnum`,  -- 회원번호
    `mfnic`  -- 친구닉네임
    );
-- 친구
ALTER TABLE `DUTCHORDER`.`member_friends`
    ADD CONSTRAINT `FK_member_TO_member_friends` -- 회원 -> 친구
    FOREIGN KEY (
    `mnum` -- 회원번호
    )
    REFERENCES `DUTCHORDER`.`member` ( -- 회원
    `mnum` -- 회원번호
    );
alter table `DUTCHORDER`.`member_friends`
add constraint mfnic_unique unique (mfnic);

-- (6)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- 공지사항
CREATE TABLE `DUTCHORDER`.`notice` (
    `nonum`   INT           NOT NULL, -- 글NO
    `mnum`    INT           NOT NULL, -- 회원번호
    `notitle` VARCHAR(100)  NOT NULL, -- 제목
    `nocon`   VARCHAR(1000) NOT NULL, -- 내용
    `nodate`  timestamp          NOT NULL  -- 작성일
);
-- 공지사항
ALTER TABLE `DUTCHORDER`.`notice`
    ADD CONSTRAINT `notice` -- 공지사항  기본키
    PRIMARY KEY (
    `nonum`, -- 글NO
    `mnum`   -- 회원번호
    );
-- 공지사항
ALTER TABLE `DUTCHORDER`.`notice`
    ADD CONSTRAINT `FK_member_TO_notice` -- 회원 -> 공지사항
    FOREIGN KEY (
    `mnum` -- 회원번호
    )
    REFERENCES `DUTCHORDER`.`member` ( -- 회원
    `mnum` -- 회원번호
    );
    
-- (7)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- 메뉴
CREATE TABLE `DUTCHORDER`.`menu` (
    `bnum`    INT          NOT NULL, -- 사업자일련번호
    `fnum`    INT          NOT NULL, -- 메뉴 번호
    `fname`   VARCHAR(50)  NOT NULL, -- 메뉴명
    `fprice`  INT          NOT NULL, -- 금액
    `fimg`    VARCHAR(1000)         NOT NULL, -- 메뉴이미지
    `finfo`   VARCHAR(500) NOT NULL, -- 설명
    `foption` INT          NOT NULL  -- 옵션: 1=곱배기가 없는 메뉴 / 2=곱배기가 있는 메뉴
);
-- 메뉴
ALTER TABLE `DUTCHORDER`.`menu`
    ADD CONSTRAINT `menu` -- 메뉴 기본키
    PRIMARY KEY (
    `bnum`, -- 사업자일련번호
    `fnum`  -- 메뉴 번호
    );
-- 메뉴
ALTER TABLE `DUTCHORDER`.`menu`
    ADD CONSTRAINT `FK_shop_TO_menu` -- 가게정보 -> 메뉴
    FOREIGN KEY (
    `bnum` -- 사업자일련번호
    )
    REFERENCES `DUTCHORDER`.`shop` ( -- 가게정보
    `bnum` -- 사업자일련번호
    );
-- 메뉴
ALTER TABLE `DUTCHORDER`.`menu`
ADD INDEX `idx_fnum` (`fnum`);

-- (8)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- 주문
CREATE TABLE `DUTCHORDER`.`ordering` (
    `mnum`    INT          NOT NULL, -- 회원번호
    `bnum`    INT          NOT NULL, -- 사업자 일련번호
    `onum`    INT          NOT NULL, -- 주문 일련번호
    `oaddr`   VARCHAR(200) NOT NULL,  -- 배달주소
    `otel`	  VARCHAR(20)  NOT NULL, -- 주문용 연락처
    `omsg`    VARCHAR(100) NULL,     -- 요청사항
    `odate`   timestamp		NULL,	 -- 주문날짜
    `ostatus_makey` INT          NOT NULL, -- 상태코드 대분류:800
    `ostatus_mikey` INT          NOT NULL -- 상태코드 중분류:801=장바구니 / 802=주문수락대기 / 803=조리중 / 804=배달시작 / 805=배달완료
);
-- 주문
ALTER TABLE `DUTCHORDER`.`ordering`
    ADD CONSTRAINT `order` -- 주문 기본키
    PRIMARY KEY (
    `mnum`, -- 회원번호
    `bnum`, -- 사업자 일련번호
    `onum`  -- 주문 일련번호
    );
-- 주문
ALTER TABLE `DUTCHORDER`.`ordering`
    ADD CONSTRAINT `FK_member_TO_ordering` -- 회원 -> 주문
    FOREIGN KEY (
    `mnum` -- 회원번호
    )
    REFERENCES `DUTCHORDER`.`member` ( -- 회원
    `mnum` -- 회원번호
    );
-- 주문
ALTER TABLE `DUTCHORDER`.`ordering`
    ADD CONSTRAINT `FK_shop_TO_ordering` -- 가게정보 -> 주문
    FOREIGN KEY (
    `bnum` -- 사업자일련번호
    )
    REFERENCES `DUTCHORDER`.`shop` ( -- 가게정보
    `bnum` -- 사업자일련번호
    );
ALTER TABLE `DUTCHORDER`.`ordering`
ADD INDEX `idx_onum` (`onum`);

-- (9)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- 주문상세
CREATE TABLE `DUTCHORDER`.`order_spec` (
    `onum`           INT        NOT NULL, -- 주문 일련번호
    `osnum`          INT        NOT NULL, -- 주문상세 일련번호
    `fnum`           INT        NOT NULL, -- 메뉴번호
    `foption_makey`  INT        NOT NULL, -- 메뉴옵션 대분류	major=1100
    `foption_mikey`  INT        NOT NULL,  -- 메뉴옵션 소분류	minor=1101/기본 , 1102/곱배기
    `fcount`		 INT        NOT NULL,  -- 메뉴수량
    `osprice`		 INT        NOT NULL   -- 메뉴별 금액
);
-- 주문상세
ALTER TABLE `DUTCHORDER`.`order_spec`
    ADD CONSTRAINT `order_spec` -- 주문상세 기본키
    PRIMARY KEY (
    `onum`,  -- 주문 일련번호
    `osnum`  -- 주문상세 일련번호
    );
-- 주문상세
ALTER TABLE `DUTCHORDER`.`order_spec`
    ADD CONSTRAINT `FK_ordering_TO_order_spec` -- 주문 -> 주문상세
    FOREIGN KEY (
    `onum` -- 결제일련번호
    )
    REFERENCES `DUTCHORDER`.`ordering` ( -- 주문
    `onum`  -- 결제일련번호
    );
alter table `DUTCHORDER`.`order_spec`
	ADD CONSTRAINT `FK_menu_TO_order_spec`	-- 메뉴 -> 주문상세
    foreign key (
    `fnum` -- 음식번호
    )
    references `DUTCHORDER`.`menu` (
    `fnum` -- 음식번호
    );
    
-- (10)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- 주문금액분담
CREATE TABLE `DUTCHORDER`.`dutchpay` (
	`onum`   INT NOT NULL, -- 주문 일련번호
	`dpmem`  VARCHAR(20) NOT NULL, -- 결제회원 닉네임
	`dpprice` INT NOT NULL,  -- 분담금액
    `dpstatus_makey` INT NOT NULL,  -- 결제상태 대분류:900
    `dpstatus_mikey` INT NOT NULL   -- 결제상태 중분류:901=결제중 / 902=결제완료
);
-- 주문금액분담
ALTER TABLE `DUTCHORDER`.`dutchpay`
	ADD CONSTRAINT `dutchpay` -- 주문금액분담 기본키
	PRIMARY KEY (
	`onum`,  -- 주문 일련번호
	`dpmem`  -- 결제회원
	);
-- 주문금액분담
ALTER TABLE `DUTCHORDER`.`dutchpay`
	ADD CONSTRAINT `FK_ordering_TO_dutchpay` -- 주문 -> 주문금액분담
	FOREIGN KEY (
	`onum`  -- 주문 일련번호
	)
	REFERENCES `DUTCHORDER`.`ordering` ( -- 주문
	`onum`  -- 주문 일련번호
	);
    
-- (11)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- 주소
CREATE TABLE `DUTCHORDER`.`address` (
    `mnum`   INT          NOT NULL, -- 회원번호
    `adnum`	 INT          NOT NULL, -- 주소일련번호
    `adaddr` VARCHAR(200) NOT NULL  -- 주소
);
-- 주소
ALTER TABLE `DUTCHORDER`.`address`
    ADD CONSTRAINT `address` -- 주소 기본키
    PRIMARY KEY (
    `mnum`, -- 회원번호
    `adnum` -- 주소일련번호
    );
-- 주소
ALTER TABLE `DUTCHORDER`.`address`
    ADD CONSTRAINT `FK_member_TO_address` -- 회원 -> 주소
    FOREIGN KEY (
    `mnum` -- 회원번호
    )
    REFERENCES `DUTCHORDER`.`member` ( -- 회원
    `mnum` -- 회원번호
    );
    
-- (12)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- 리뷰
CREATE TABLE `DUTCHORDER`.`review` (
    `rnum`     INT           NOT NULL, -- 리뷰seq
    `mnum`     INT           NOT NULL, -- 회원번호
    `bnum`     INT           NOT NULL, -- 사업자일련번호
    `onum`     INT           NOT NULL, -- 결제일련번호
    `rcontent` VARCHAR(1000) NULL,     -- 내용
    `rstar`    INT           NOT NULL, -- 별점
    `rdate`    timestamp          NOT NULL, -- 작성일
    `rimg`     VARCHAR(1000)          NULL,      -- 리뷰사진
    `rstatus_makey`  INT           NOT NULL, -- 답글상태 대분류:1000
    `rstatus_mikey`  INT           NOT NULL, -- 답글상태 중분류:1001=답글없음 / 1002=답글있음
    `rcomment` VARCHAR(1000) NULL      -- 가게 사장이 리뷰에 답글 입력 내용
);
-- 리뷰
ALTER TABLE `DUTCHORDER`.`review`
    ADD CONSTRAINT `review` -- 리뷰 기본키
    PRIMARY KEY (
    `rnum` -- 리뷰seq
    );
-- 리뷰
ALTER TABLE `DUTCHORDER`.`review`
    ADD CONSTRAINT `FK_ordering_TO_review` -- 주문 -> 리뷰
    FOREIGN KEY (
    `mnum`, -- 회원번호
    `bnum`, -- 사업자일련번호
    `onum`  -- 주문 일련번호
    )
    REFERENCES `DUTCHORDER`.`ordering` ( -- 주문
    `mnum`, -- 회원번호
    `bnum`, -- 사업자일련번호
    `onum`  -- 주문 일련번호
    );
    
-- (13)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- 이메일 코드
CREATE TABLE `DUTCHORDER`.`email_code` (
	`ecnum`			int					not null,	-- 기본키 일련번호
    `ecmail`		varchar(100)		not null,	-- 이메일
    `eccode`		varchar(100)		not null,   -- 인증코드
    `verified`		int					not null    -- 인증여부	1:인증x / 2:인증o
);
-- 이메일 코드
ALTER TABLE `DUTCHORDER`.`email_code`
    ADD CONSTRAINT `email_code` -- 이메일 코드 기본키
    PRIMARY KEY (
    `ecnum` -- seq
    );