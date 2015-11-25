CREATE TABLE RESTAURANT (
	ID INT AUTO_INCREMENT,
  NAME VARCHAR(255) NOT NULL
);

CREATE TABLE MENU_ITEM (
  ID INT AUTO_INCREMENT NOT NULL,
  restaurant_id INT NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES RESTAURANT(ID) on delete cascade,
  NAME VARCHAR(255) NOT NULL,
  PRICE INT NOT NULL
);

INSERT INTO RESTAURANT (NAME) VALUES ('R1');
INSERT INTO MENU_ITEM (restaurant_id, NAME, PRICE) VALUES (1, 'Food1a', 2000);
INSERT INTO MENU_ITEM (restaurant_id, NAME, PRICE) VALUES (1, 'Food2a', 3000);
INSERT INTO RESTAURANT (NAME) VALUES ('R2');
INSERT INTO MENU_ITEM (restaurant_id, NAME, PRICE) VALUES (2, 'Food1b', 4000);
INSERT INTO MENU_ITEM (restaurant_id, NAME, PRICE) VALUES (2, 'Food2b', 6000);
INSERT INTO RESTAURANT (NAME) VALUES ('R3');
INSERT INTO MENU_ITEM (restaurant_id, NAME, PRICE) VALUES (3, 'Food1c', 4000);
INSERT INTO MENU_ITEM (restaurant_id, NAME, PRICE) VALUES (3, 'Food2c', 6000);

CREATE TABLE VOTE (
  ID INT AUTO_INCREMENT,
  USER_ID INT,                  -- Outlives User
  RESTAURANT_ID INT NOT NULL,   -- Outlives Restaurant
  TIME TIMESTAMP
);

INSERT INTO VOTE (USER_ID, RESTAURANT_ID, TIME) VALUES (11, 1, CURRENT_TIMESTAMP());
INSERT INTO VOTE (USER_ID, RESTAURANT_ID, TIME) VALUES (12, 2, CURRENT_TIMESTAMP());
INSERT INTO VOTE (USER_ID, RESTAURANT_ID, TIME) VALUES (13, 3, CURRENT_TIMESTAMP());
INSERT INTO VOTE (USER_ID, RESTAURANT_ID, TIME) VALUES (14, 1, CURRENT_TIMESTAMP());
INSERT INTO VOTE (USER_ID, RESTAURANT_ID, TIME) VALUES (15, 2, CURRENT_TIMESTAMP());
INSERT INTO VOTE (USER_ID, RESTAURANT_ID, TIME) VALUES (16, 2, CURRENT_TIMESTAMP());
INSERT INTO VOTE (USER_ID, RESTAURANT_ID, TIME) VALUES (17, 3, CURRENT_TIMESTAMP());
INSERT INTO VOTE (USER_ID, RESTAURANT_ID, TIME) VALUES (18, 3, CURRENT_TIMESTAMP());

