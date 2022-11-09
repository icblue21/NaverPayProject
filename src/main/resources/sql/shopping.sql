
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

SELECT * FROM SHOPPING;