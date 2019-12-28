INSERT INTO COURSE(ID, NAME, CREATE_DATE, LAST_UPDATE_DATE) VALUES (1000, 'Training Dogs', SYSDATE(), SYSDATE());
INSERT INTO COURSE(ID, NAME, CREATE_DATE, LAST_UPDATE_DATE) VALUES (1001, 'Training Cats', SYSDATE(), SYSDATE());
INSERT INTO COURSE(ID, NAME, CREATE_DATE, LAST_UPDATE_DATE) VALUES (1002, 'Training Rabbits', SYSDATE(), SYSDATE());
INSERT INTO COURSE(ID, NAME, CREATE_DATE, LAST_UPDATE_DATE) VALUES (1003, 'Training All pets', SYSDATE(), SYSDATE());

INSERT INTO PASSPORT(ID, PASSPORT_NUMBER) VALUES (3000, 'BAT123456');
INSERT INTO PASSPORT(ID, PASSPORT_NUMBER) VALUES (3001, 'SUP123456');
INSERT INTO PASSPORT(ID, PASSPORT_NUMBER) VALUES (3002, 'DEA123456');
INSERT INTO PASSPORT(ID, PASSPORT_NUMBER) VALUES (3003, 'SPID12345');

INSERT INTO STUDENT(ID, NAME, PASSPORT_ID) VALUES (2000, 'Batman', 3000);
INSERT INTO STUDENT(ID, NAME, PASSPORT_ID) VALUES (2001, 'Superman', 3001);
INSERT INTO STUDENT(ID, NAME, PASSPORT_ID) VALUES (2002, 'Deadpool', 3002);
INSERT INTO STUDENT(ID, NAME, PASSPORT_ID) VALUES (2003, 'Spiderman', 3003);

INSERT INTO REVIEW(ID, RATING, DESCRIPTION) VALUES (4000, 5, 'Best Course');
INSERT INTO REVIEW(ID, RATING, DESCRIPTION) VALUES (4001, 4, 'Good One');
INSERT INTO REVIEW(ID, RATING, DESCRIPTION) VALUES (4002, 3, 'Okay Okay..');
INSERT INTO REVIEW(ID, RATING, DESCRIPTION) VALUES (4003, 3, 'Could be better');