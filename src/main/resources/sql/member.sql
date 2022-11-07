DROP TABLE MEMBERS;

CREATE TABLE MEMBERS (
                        mId VARCHAR(20) NOT NULL ,
                        mPw VARCHAR(20) NOT NULL,
                        mName VARCHAR(20) NOT NULL ,
                        mPoint INT NOT NULL,
                        mMoney INT NOT NULL,
                        mCardCompany VARCHAR(20),
                        mCardNumber VARCHAR(20),
                        PRIMARY KEY (mId)
);

INSERT INTO MEMBERS VALUES ('a','a1234','nameA',0,0,'신한','9400-1111-1111');
INSERT INTO MEMBERS VALUES ('b','b1234','nameB',0,0,'국민','9400-2222-2222');
INSERT INTO MEMBERS VALUES ('c','c1234','nameC',0,0,'기업','9400-3333-3333');

SELECT * FROM MEMBERS;