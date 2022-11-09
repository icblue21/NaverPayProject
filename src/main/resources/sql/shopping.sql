DROP TABLE SHOPPING;

CREATE TABLE SHOPPING (
                        mId VARCHAR(20) NOT NULL ,
                        sId VARCHAR(20) NOT NULL,
                        sTitle VARCHAR(50) NOT NULL ,
                        sCount INT NOT NULL,
                        sPayment INT NOT NULL,
                        sDate  VARCHAR(20) NOT NULL,
                        sStatus VARCHAR(20) NOT NULL,
                        seller VARCHAR(20) NOT NULL,
                        sellerPhoneNumber VARCHAR(20) NOT NULL,
                        PRIMARY KEY (sId),
                        FOREIGN KEY (mId) REFERENCES MEMBERS(MID)
);

INSERT INTO SHOPPING VALUES ('a','a1','아이폰 14 pro',1,1000000,'2022.11.06','배송중','애플','080–330–8877');
INSERT INTO SHOPPING VALUES ('a','a2','치킨 외 2',3,100000,'2022.11.02','구매 완료','교촌치킨','032-518-9800');
INSERT INTO SHOPPING VALUES ('a','a3','후드티 외 1건',2,58000,'2022.11.04','구매 취소','무신사스토어','1544-7199');

INSERT INTO SHOPPING VALUES ('b','b1','갤럭시 버즈2',1,100000,'2022.11.06','입금 대기중','삼성','080–111–2222');
INSERT INTO SHOPPING VALUES ('b','b2','파인애플피자 외 2',3,67000,'2022.11.01','구매 완료','피자헛','080-222-3333');
INSERT INTO SHOPPING VALUES ('b','b3','멀티 비타민 외 1',2,40000,'2022.10.08','구매 완료','나우푸드','1544-1577');

INSERT INTO SHOPPING VALUES ('c','c1','핸드폰 케이스',1,10000,'2022.11.05','구매 완료','애플','080–330–8877');
INSERT INTO SHOPPING VALUES ('c','c2','보쌈 외 2',3,200000,'2022.10.25','구매 완료','원할머니보쌈','031-777-8888');
INSERT INTO SHOPPING VALUES ('c','c3','청바지 외 1건',2,60000,'2022.08.03','배송 완료','무신사스토어','1544-7199');

SELECT * FROM SHOPPING;