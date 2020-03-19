create user test identified by test;
grant connect, resource to test;
conn test/test@xe;

CREATE TABLE BILLING
(
  BILLINGDATE  VARCHAR2(40 BYTE),
  PRICE        NUMBER(2),
  BILLINGID    VARCHAR2(40 BYTE),
  TAX          NUMBER(2),
  PRIMARY KEY
  (BILLINGID)
  ENABLE VALIDATE
)
LOGGING 
NOCOMPRESS 
NOCACHE
RESULT_CACHE (MODE DEFAULT)
NOPARALLEL
MONITORING;


CREATE TABLE CUSTOMER
(
  NAME         VARCHAR2(34 BYTE),
  ADDRESS      VARCHAR2(60 BYTE),
  CUSTOMERID   VARCHAR2(29 BYTE)                NOT NULL,
  PHONENUMBER  VARCHAR2(20 BYTE),
  CUSTOMERKEY  VARCHAR2(26 BYTE),
  AGE          NUMBER(2),
  CONSTRAINT CUSTOMER_PK
  PRIMARY KEY
  (CUSTOMERID)
  ENABLE VALIDATE
,  UNIQUE (PHONENUMBER)
  ENABLE VALIDATE
)
LOGGING 
NOCOMPRESS 
NOCACHE
RESULT_CACHE (MODE DEFAULT)
NOPARALLEL
MONITORING;


CREATE TABLE EVENT
(
  NAME     VARCHAR2(20 BYTE),
  EVENTID  VARCHAR2(10 BYTE),
  PRIMARY KEY
  (EVENTID)
  ENABLE VALIDATE
)
LOGGING 
NOCOMPRESS 
NOCACHE
RESULT_CACHE (MODE DEFAULT)
NOPARALLEL
MONITORING;


CREATE TABLE GET
(
  EVENTNAME    VARCHAR2(40 BYTE),
  CUSTOMER_ID  VARCHAR2(29 BYTE),
  PRIMARY KEY
  (CUSTOMER_ID, EVENTNAME)
  ENABLE VALIDATE
,  FOREIGN KEY (CUSTOMER_ID) 
  REFERENCES CUSTOMER (CUSTOMERID)
  ENABLE VALIDATE
)
LOGGING 
NOCOMPRESS 
NOCACHE
RESULT_CACHE (MODE DEFAULT)
NOPARALLEL
MONITORING;


CREATE TABLE SALESAGENT
(
  AGENTNUMBER  VARCHAR2(10 BYTE),
  AGENTTYPE    VARCHAR2(20 BYTE),
  PRIMARY KEY
  (AGENTNUMBER)
  ENABLE VALIDATE
)
LOGGING 
NOCOMPRESS 
NOCACHE
RESULT_CACHE (MODE DEFAULT)
NOPARALLEL
MONITORING;


CREATE TABLE TICKET
(
  SALOONNUMBER  VARCHAR2(3 BYTE),
  TICKETID      VARCHAR2(10 BYTE),
  TICKETDAY     VARCHAR2(10 BYTE),
  TICKETTIME    VARCHAR2(10 BYTE),
  SEATNUMBER    VARCHAR2(10 BYTE),
  EVENTID       VARCHAR2(10 BYTE),
  EVENTNAME     VARCHAR2(30 BYTE)               NOT NULL,
  UNIQUE (SEATNUMBER)
  ENABLE VALIDATE
)
LOGGING 
NOCOMPRESS 
NOCACHE
RESULT_CACHE (MODE DEFAULT)
NOPARALLEL
MONITORING;

CREATE SEQUENCE sequence_1
start with 1
increment by 1
minvalue 0
maxvalue 100


SET DEFINE OFF;
Insert into CUSTOMER
   (NAME, ADDRESS, CUSTOMERID, PHONENUMBER, CUSTOMERKEY, 
    AGE)
 Values
   ('Ahmet ÖZALAN', 'Eryaman Mah 271Sk OYAK 555 Konutlarý Etimesgut/ANKARA', '2', '5052546789', 'abc123A', 
    22);
Insert into CUSTOMER
   (NAME, ADDRESS, CUSTOMERID, PHONENUMBER, CUSTOMERKEY, 
    AGE)
 Values
   ('Hasan DURAN', 'Gül Mah Taþ Sokak Tandoðan apt. no 54 ', '5409836574', '5065678767', 'adbc123', 
    30);
Insert into CUSTOMER
   (NAME, ADDRESS, CUSTOMERID, PHONENUMBER, CUSTOMERKEY, 
    AGE)
 Values
   ('Turan ÇÝMEN', 'Gündoðdu Mahallesi hasdoðan sokak 3/12  ', '5054506859', '5054560808', 'qwerty123', 
    18);
Insert into CUSTOMER
   (NAME, ADDRESS, CUSTOMERID, PHONENUMBER, CUSTOMERKEY, 
    AGE)
 Values
   ('Kaan GÜNSÜ', 'eryaman mah gümüþ sokak 12/34', '5604098512', '5054561232', 'ghjyu42', 
    25);
Insert into CUSTOMER
   (NAME, ADDRESS, CUSTOMERID, PHONENUMBER, CUSTOMERKEY, 
    AGE)
 Values
   ('Mehmet EKÝNCÝ', 'Tunalý mah aþaðý sokak 12/40', '5058304117', '5061223369', 'bnm456', 
    21);
Insert into CUSTOMER
   (NAME, ADDRESS, CUSTOMERID, PHONENUMBER, CUSTOMERKEY, 
    AGE)
 Values
   ('Dilara ERDEM', 'Mithatpaþa Cadesi tunabahçe sokak 34/45', '5839545351', '5534567897', 'ME123', 
    19);
Insert into CUSTOMER
   (NAME, ADDRESS, CUSTOMERID, PHONENUMBER, CUSTOMERKEY, 
    AGE)
 Values
   ('Tuðçe ERDEM', 'Deniz Caddesi kum sokak 12/12', '5050456794', '5534560798', 'TE34', 
    36);
Insert into CUSTOMER
   (NAME, ADDRESS, CUSTOMERID, PHONENUMBER, CUSTOMERKEY, 
    AGE)
 Values
   ('Çicek YAÐIZ', 'palmiye sokak güneþ mahallesi 32/43', '5869584789', '5555894853', 'ABN23', 
    40);
Insert into CUSTOMER
   (NAME, ADDRESS, CUSTOMERID, PHONENUMBER, CUSTOMERKEY, 
    AGE)
 Values
   ('Umut BAÞAR', 'canalan sokak gümüþsoy mahallesi 56/21', '5685940594', '5062342345', 'ASD123', 
    15);
Insert into CUSTOMER
   (NAME, ADDRESS, CUSTOMERID, PHONENUMBER, CUSTOMERKEY, 
    AGE)
 Values
   ('Yiðit KOÇ', 'misket sokak ata mahallesi 3/32', '5349085309', '5075349534', 'BNG123', 
    26);
Insert into CUSTOMER
   (NAME, ADDRESS, CUSTOMERID, PHONENUMBER, CUSTOMERKEY, 
    AGE)
 Values
   ('hakan ahmet tekin', NULL, '12312421', '5345643', '3242', 
    22);
Insert into CUSTOMER
   (NAME, ADDRESS, CUSTOMERID, PHONENUMBER, CUSTOMERKEY, 
    AGE)
 Values
   ('Selma E. Hurley', 'Ap #650-9249 Scelerisque Ave', '1675013005999', '0500 442 4023', 'augue', 
    24);
Insert into CUSTOMER
   (NAME, ADDRESS, CUSTOMERID, PHONENUMBER, CUSTOMERKEY, 
    AGE)
 Values
   ('Blaze A. Burks', '4711 A St.', '1634012939099', '0512 712 5640', 'nec', 
    29);
Insert into CUSTOMER
   (NAME, ADDRESS, CUSTOMERID, PHONENUMBER, CUSTOMERKEY, 
    AGE)
 Values
   ('Mehmet Günsoy', 'Tunabahçe Sokak ertuðrul Caddesi ', '1887', '5055555633', '1887', 
    50);
Insert into CUSTOMER
   (NAME, ADDRESS, CUSTOMERID, PHONENUMBER, CUSTOMERKEY, 
    AGE)
 Values
   ('Hasan Akçatepe', 'Mithatpaþa Caddesi 255 sk kýzýlay', '007', '5055435678', '007', 
    33);
COMMIT;


SET DEFINE OFF;
Insert into BILLING
   (BILLINGDATE, PRICE, BILLINGID, TAX)
 Values
   ('13.11.2019', 44, '11', 3);
Insert into BILLING
   (BILLINGDATE, PRICE, BILLINGID, TAX)
 Values
   ('9.10.2019', 56, '12', 5);
Insert into BILLING
   (BILLINGDATE, PRICE, BILLINGID, TAX)
 Values
   ('11.02.2019', 60, '13', 12);
Insert into BILLING
   (BILLINGDATE, PRICE, BILLINGID, TAX)
 Values
   ('14.04.2019', 55, '14', 10);
Insert into BILLING
   (BILLINGDATE, PRICE, BILLINGID, TAX)
 Values
   ('6.05.2019', 40, '15', 8);
Insert into BILLING
   (BILLINGDATE, PRICE, BILLINGID, TAX)
 Values
   ('5.06.2019', 25, '16', 8);
Insert into BILLING
   (BILLINGDATE, PRICE, BILLINGID, TAX)
 Values
   ('23.05.2019', 57, '17', 9);
Insert into BILLING
   (BILLINGDATE, PRICE, BILLINGID, TAX)
 Values
   ('31.11.2020', 30, '18', 7);
COMMIT;


SET DEFINE OFF;
Insert into EVENT
   (NAME, EVENTID)
 Values
   ('Tiyatro', '101');
Insert into EVENT
   (NAME, EVENTID)
 Values
   ('Tiyatro', '102');
Insert into EVENT
   (NAME, EVENTID)
 Values
   ('Tiyatro', '103');
Insert into EVENT
   (NAME, EVENTID)
 Values
   ('Sinema', '104');
Insert into EVENT
   (NAME, EVENTID)
 Values
   ('Sinema', '105');
Insert into EVENT
   (NAME, EVENTID)
 Values
   ('Sinema', '106');
Insert into EVENT
   (NAME, EVENTID)
 Values
   ('Futbol', '107');
Insert into EVENT
   (NAME, EVENTID)
 Values
   ('Futbol', '108');
Insert into EVENT
   (NAME, EVENTID)
 Values
   ('Futbol', '109');
Insert into EVENT
   (NAME, EVENTID)
 Values
   ('Basketbol', '110');
Insert into EVENT
   (NAME, EVENTID)
 Values
   ('Basketbol', '111');
Insert into EVENT
   (NAME, EVENTID)
 Values
   ('Basketbol', '112');
Insert into EVENT
   (NAME, EVENTID)
 Values
   ('Festival', '113');
Insert into EVENT
   (NAME, EVENTID)
 Values
   ('Festival', '114');
Insert into EVENT
   (NAME, EVENTID)
 Values
   ('Festival', '115');
Insert into EVENT
   (NAME, EVENTID)
 Values
   ('Bowling', '2421');
COMMIT;


SET DEFINE OFF;
Insert into GET
   (EVENTNAME, CUSTOMER_ID)
 Values
   ('HellBoy', '1887');
Insert into GET
   (EVENTNAME, CUSTOMER_ID)
 Values
   ('Zalgris Kaunas-Anadolu Efes', '2');
Insert into GET
   (EVENTNAME, CUSTOMER_ID)
 Values
   ('Bursaspor-Konyaspor', '2');
Insert into GET
   (EVENTNAME, CUSTOMER_ID)
 Values
   ('HellBoy', '2');
Insert into GET
   (EVENTNAME, CUSTOMER_ID)
 Values
   ('Yedi Kocalý Hürmüz', '2');
Insert into GET
   (EVENTNAME, CUSTOMER_ID)
 Values
   ('Daruþafaka Doðuþ-Banvit', '2');
Insert into GET
   (EVENTNAME, CUSTOMER_ID)
 Values
   ('Ezhel', '2');
Insert into GET
   (EVENTNAME, CUSTOMER_ID)
 Values
   ('Fenerbahçe-Konyaspor', '007');
Insert into GET
   (EVENTNAME, CUSTOMER_ID)
 Values
   ('Fenerbahçe Ülker-Anadolu Efes', '007');
Insert into GET
   (EVENTNAME, CUSTOMER_ID)
 Values
   ('Guneþ Dogarken', '007');
Insert into GET
   (EVENTNAME, CUSTOMER_ID)
 Values
   ('HellBoy', '007');
Insert into GET
   (EVENTNAME, CUSTOMER_ID)
 Values
   ('Guguk Kuþu', '007');
COMMIT;


SET DEFINE OFF;
Insert into SALESAGENT
   (AGENTNUMBER, AGENTTYPE)
 Values
   ('12', 'Web');
Insert into SALESAGENT
   (AGENTNUMBER, AGENTTYPE)
 Values
   ('11', 'BookStore');
Insert into SALESAGENT
   (AGENTNUMBER, AGENTTYPE)
 Values
   ('13', 'Web');
Insert into SALESAGENT
   (AGENTNUMBER, AGENTTYPE)
 Values
   ('14', 'Web');
Insert into SALESAGENT
   (AGENTNUMBER, AGENTTYPE)
 Values
   ('15', 'Web');
Insert into SALESAGENT
   (AGENTNUMBER, AGENTTYPE)
 Values
   ('16', 'BookStore');
Insert into SALESAGENT
   (AGENTNUMBER, AGENTTYPE)
 Values
   ('17', 'BookStrore');
COMMIT;


SET DEFINE OFF;
Insert into TICKET
   (SALOONNUMBER, TICKETID, TICKETDAY, TICKETTIME, SEATNUMBER, 
    EVENTID, EVENTNAME)
 Values
   ('G', '58476', '13-05-2019', '20:06', 'G16', 
    '101', 'Bir Delinin Hatýra Defteri');
Insert into TICKET
   (SALOONNUMBER, TICKETID, TICKETDAY, TICKETTIME, SEATNUMBER, 
    EVENTID, EVENTNAME)
 Values
   ('1', '02958', '22-06-2019', '18:45', 'G10', 
    '104', 'Avengers');
Insert into TICKET
   (SALOONNUMBER, TICKETID, TICKETDAY, TICKETTIME, SEATNUMBER, 
    EVENTID, EVENTNAME)
 Values
   ('2', '39084', '29-06-2019', '20:00', 'H17', 
    '105', 'HellBoy');
Insert into TICKET
   (SALOONNUMBER, TICKETID, TICKETDAY, TICKETTIME, SEATNUMBER, 
    EVENTID, EVENTNAME)
 Values
   ('2', '13400', '30-06-2019', '17:00', 'H10', 
    '106', 'Dedektif Pikachu');
Insert into TICKET
   (SALOONNUMBER, TICKETID, TICKETDAY, TICKETTIME, SEATNUMBER, 
    EVENTID, EVENTNAME)
 Values
   ('H10', '12398', '24-06-2019', '21:00', '206', 
    '108', 'Fenerbahçe-Galatasaray');
Insert into TICKET
   (SALOONNUMBER, TICKETID, TICKETDAY, TICKETTIME, SEATNUMBER, 
    EVENTID, EVENTNAME)
 Values
   ('B6', '23904', '22-06-2019', '22:00', '120', 
    '108', 'Ankaragücü-Trabzonpor');
Insert into TICKET
   (SALOONNUMBER, TICKETID, TICKETDAY, TICKETTIME, SEATNUMBER, 
    EVENTID, EVENTNAME)
 Values
   ('N5', '41240', '22-07-2019', '21:00', '89', 
    '109', 'Beþiktaþ-Çengelköy');
Insert into TICKET
   (SALOONNUMBER, TICKETID, TICKETDAY, TICKETTIME, SEATNUMBER, 
    EVENTID, EVENTNAME)
 Values
   ('B4', '43242', '24-08-2019', '19.30', '22', 
    '110', 'Zalgris Kaunas-Fenerbahçe');
Insert into TICKET
   (SALOONNUMBER, TICKETID, TICKETDAY, TICKETTIME, SEATNUMBER, 
    EVENTID, EVENTNAME)
 Values
   ('N6', '95408', '26-008-201', '22:00', '53', 
    '111', 'Beþiktaþ-CSKA Moskova');
Insert into TICKET
   (SALOONNUMBER, TICKETID, TICKETDAY, TICKETTIME, SEATNUMBER, 
    EVENTID, EVENTNAME)
 Values
   ('M5', '42358', '20-07-2019', '21:00', '77', 
    '112', 'Anadolu Efes-Maccabi Tel Aviv');
Insert into TICKET
   (SALOONNUMBER, TICKETID, TICKETDAY, TICKETTIME, SEATNUMBER, 
    EVENTID, EVENTNAME)
 Values
   ('Fre', '64509', '20-07-2019', '18:00', 'Free', 
    '113', 'Zeytinli Rock Festival');
COMMIT;



insert into billing values ('13.11.2019',44,sequence1.nextval,3);
insert into billing values ('9.10.2019',56,sequence1.nextval,5);
insert into billing values ('11.02.2019',60,sequence1.nextval,12);
insert into billing values ('14.04.2019',55,sequence1.nextval,10);
insert into billing values ('6.05.2019',40,sequence1.nextval,8);
insert into billing values ('5.06.2019',25,sequence1.nextval,8);
insert into billing values ('23.05.2019',57,sequence1.nextval,9);
insert into billing values ('31.11.2020',30,sequence1.nextval,7);
