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
INSERT INTO MENU_ITEM (restaurant_id, NAME, PRICE) VALUES (1, 'Food1', 2000);
INSERT INTO MENU_ITEM (restaurant_id, NAME, PRICE) VALUES (1, 'Food2', 3000);
INSERT INTO RESTAURANT (NAME) VALUES ('R2');
INSERT INTO MENU_ITEM (restaurant_id, NAME, PRICE) VALUES (2, 'Food1', 4000);
INSERT INTO MENU_ITEM (restaurant_id, NAME, PRICE) VALUES (2, 'Food2', 6000);

CREATE TABLE VOTE (
  ID INT AUTO_INCREMENT,
  USER_ID INT,                  -- Outlives User
  RESTAURANT_ID INT NOT NULL,   -- Outlives restaurant
  TIME TIMESTAMP
);

INSERT INTO VOTE (USER_ID, RESTAURANT_ID, TIME) VALUES (11, 11, CURRENT_TIMESTAMP());



