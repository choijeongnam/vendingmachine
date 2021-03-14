create table VM(
    VM_NO VARCHAR2(20) CONSTRAINT VM_NO_PK Primary key,
    LOC varchar2(20) not null,
    company varchar2(20) not null,
    model_name varchar2(20) not null,
    SV_ID varchar2(20) references SUPERVISOR(SV_ID)
);

create table SUPERVISOR(
    SV_ID varchar2(20) constraint sv_no_pk Primary key,
    Password number not null
);

commit;

create table MENU(
    MENU_CODE NUMBER CONSTRAINT MENU_CODE_PK PRIMARY KEY,
    MENU_NAME VARCHAR(20) NOT NULL,
    PRICE NUMBER NOT NULL
);

CREATE SEQUENCE GOODS_SEQ NOCACHE;

CREATE TABLE GOODS(
    GOODS_SEQ NUMBER PRIMARY KEY,
    MENU_CODE NUMBER REFERENCES MENU(MENU_CODE),
    VM_NO VARCHAR2(20) REFERENCES VM(VM_NO),
    STOCK NUMBER NOT NULL
);

CREATE SEQUENCE ORDER_SEQ NOCACHE;

CREATE TABLE ORDERS(
    ORDER_SEQ NUMBER PRIMARY KEY,
    MENU_CODE NUMBER REFERENCES MENU(MENU_CODE),
    VM_NO VARCHAR2(20) REFERENCES VM(VM_NO),
    QTY NUMBER NOT NULL,
    TOTAL_PRICE NUMBER NOT NULL,
    SALE_DATE VARCHAR2(20) NOT NULL
);

SELECT * FROM ORDERS;
SELECT * FROM MENU;
SELECT * FROM VM;
SELECT * FROM GOODS;
SELECT * FROM SUPERVISOR;

COMMIT;

ALTER TABLE MENU ADD KCAL NUMBER NOT NULL;

INSERT INTO MENU VALUES(100, '참치샐러드', 5000, 300);
INSERT INTO MENU VALUES(200, '과일샐러드', 4000, 277);
INSERT INTO MENU VALUES(300, '연어샐러드', 5500, 256);
INSERT INTO MENU VALUES(400, '치킨샐러드', 4500, 320);
INSERT INTO MENU VALUES(500, '시저샐러드', 3500, 266);

INSERT INTO supervisor VALUES('ADMIN', 1234);


INSERT INTO VM VALUES('A01', '강남', '삼성', 'SSVM01', 'ADMIN');
INSERT INTO VM VALUES('A02', '용인', '삼성', 'SSVM01', 'ADMIN');
INSERT INTO VM VALUES('A03', '서초', 'LG', 'LGVM02', 'ADMIN');



INSERT INTO GOODS VALUES(GOODS_SEQ.NEXTVAL
,'200', 'A03', 10);
INSERT INTO GOODS VALUES(GOODS_SEQ.NEXTVAL
,'300', 'A03', 10);
INSERT INTO GOODS VALUES(GOODS_SEQ.NEXTVAL
,'400', 'A03', 10);
INSERT INTO GOODS VALUES(GOODS_SEQ.NEXTVAL
,'500', 'A03', 10);

INSERT INTO ORDERS VALUES(ORDER_SEQ.NEXTVAL
,200, 'A01', 2, 8000, 2021-02-26);
INSERT INTO ORDERS VALUES(ORDER_SEQ.NEXTVAL
,200, 'A01', 2, 8000, sysdate);
COMMIT;
ROLLBACK;
update goods set stock=stock-2 where goods_SEQ = 11;
update goods set stock=stock-2 where goods_SEQ = 2;

SELECT VM_NO, SUM(TOTAL_PRICE) OVER(PARTITION BY VM_NO
ORDER BY TOTAL_PRICE ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS 자판기별매출합계
FROM ORDERS;

select goods.VM_NO, menu.MENU_NAME, menu.PRICE, goods.stock 
from goods join menu 
on goods.menu_code = menu.menu_code and goods.vm_no = 'A03';


select sale_date, sum(total_price)일매출, sum(qty)총판매개수 from orders group by sale_date;
select vm_no, sum(total_price)해당자판기매출 from orders where vm_no = 'a01' from orders group by vm_no;


select m.menu_name 메뉴이름, o.total 판매액, o.qty 판매개수 
from (select menu_code, sum(total_price) total, sum(qty) qty from orders group by menu_code) o
join menu m
using(menu_code);


select menu.menu_name, menu.price, menu.kcal 
from menu join goods 
on menu.menu_code = goods.menu_code and goods.vm_no = 'a03';

INSERT INTO GOODS VALUES(GOODS_SEQ.NEXTVAL
,'200', 'A03', 10);

SELECT * FROM vm;


INSERT INTO ORDERS VALUES(ORDERS_SEQ.NEXTVAL, MENU_CODE, VM_NO, QTY, TOTAL_PRICE, SYSDATE);

select stock from goods where menu_code = 100 and vm_no = 'A03';

update goods set stock=stock-2 where menu_code = 100 and vm_no = 'A03';

rollback