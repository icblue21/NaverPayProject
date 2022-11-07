DROP TABLE PAYMENT;

CREATE TABLE PAYMENT (
                    pId VARCHAR(20) NOT NULL ,
                    sId VARCHAR(20) NOT NULL,
                    pMethod VARCHAR(20) NOT NULL ,
                    pDetailPayMethod VARCHAR(20) NOT NULL,
                    pInfo VARCHAR(20) NOT NULL,
                    pDate VARCHAR(20) NOT NULL,
                    paymentByMethod INT NOT NULL,
                    paymentByPoint INT,
                    totalPayment INT NOT NULL,
                    PRIMARY KEY (pId)
);

INSERT INTO PAYMENT VALUES ( '20221106NPa1', 'a1', '카드 간편 결제', '신한 9400-1111-1111','일시불','2022.11.06 14:18:15',1000000,0,1000000);
INSERT INTO PAYMENT VALUES ( '20221102NPa2', 'a2', '카드 간편 결제', '신한 9400-1111-1111','일시불','2022.11.02 13:33:10',100000,0,100000);
INSERT INTO PAYMENT VALUES ( '20221104NPa3', 'a3', '카드 간편 결제', '신한 9400-1111-1111','일시불','2022.11.04 21:11:22',56000,2000,58000);

SELECT * FROM PAYMENT;