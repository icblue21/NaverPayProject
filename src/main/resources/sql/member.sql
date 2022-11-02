CREATE TABLE MEMBERS (
                        mId VARCHAR(20) NOT NULL ,
                        mPw VARCHAR(20) NOT NULL,
                        mEmail VARCHAR(50),
                        mAddress VARCHAR(50),
                        mName VARCHAR(20) NOT NULL ,
                        mPoint VARCHAR(20) NOT NULL,
                        mPhoneNumber VARCHAR(20),
                        mCardCompany VARCHAR(20),
                        mCardNumber VARCHAR(20),
                        PRIMARY KEY (mId)
);

SELECT * FROM MEMBERS;