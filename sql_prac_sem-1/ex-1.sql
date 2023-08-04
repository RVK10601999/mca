#QUESTION-a
####table creation
CREATE TABLE customer(
c_no BIGINT,
c_name VARCHAR(30),
city VARCHAR(30),
PRIMARY KEY(c_no),
CHECK(c_no>=40000 and c_no<50000)
);

CREATE TABLE cust_order(
o_no bigint,
o_date DATE,
c_no BIGINT,
o_amt BIGINT,
PRIMARY KEY(o_no),
FOREIGN KEY(c_no) REFERENCES customer(c_no),
CHECK(o_no>=50000 and o_no<60000)
);


create table item(
i_no bigint,
i_name varchar(30),
unit_price int,
PRIMARY KEY(i_no),
CHECK(i_no>=60000 and i_no<70000)
);


create table order_item(
o_no bigint,
i_no bigint,
FOREIGN KEY(o_no) REFERENCES cust_order(o_no),
FOREIGN KEY(i_no) REFERENCES item(i_no),
quantity int
);


insert into customer
(c_no,c_name,city)
values
(40000,'Vicky','Chennai'),
(40001,'Swathi','Trivandrum'),
(40002,'Hema','Pune'),
(40003,'Ragini','Bangalore'),
(40004,'Jojin','Coimbatore'),
(40005,'Aravind','Salem')
;


insert into cust_order
(o_no,o_date,c_no)
values
(50000,'2023-04-01',40000),
(50001,'2023-04-02',40001),
(50002,'2023-04-02',40001),
(50003,'2023-04-03',40003),
(50004,'2023-04-03',40004),
(50005,'2023-04-04',40003)
;


insert into item
(i_no,i_name,unit_price)
values
(60000,'iMac+',50000),
(60001,'iPhoneXE',5000),
(60002,'iPhoneXE+',6000),
(60003,'iPhoneSE+',1000),
(60004,'iAdapter',500)
;

insert into order_item
(o_no,i_no,quantity)
values
(50000,60000,2),
(50000,60001,5),
(50001,60002,1),
(50001,60003,2),
(50001,60004,1),
(50002,60003,2),
(50002,60004,1),
(50003,60000,2),
(50003,60001,5),
(50003,60002,1),
(50003,60003,2),
(50004,60004,1),
(50004,60003,2),
(50005,60004,1)
;

insert into order_item
(o_no,i_no,quantity)
values
(50003,60002,1),
(50003,60003,2),
(50003,60002,1),
(50003,60003,2);


#QUESTION-b
select * from customer where c_no in (
select c_no as order_count from cust_order
group by c_no
having count(*)>3);

#QUESTION-c
select * from item where unit_price < (select avg(unit_price) from item);


#QUESTION-d
select o_no,count(DISTINCT i_no) count_of_items from order_item
group by o_no;


#QUESTION-e
select * from item where i_no in (
select a.i_no from
(select i_no,count(distinct o_no) as order_count,(select count(*) from order_item) as total_orders from order_item group by i_no) as a
where (a.order_count/a.total_orders)>=0.25);


#QUESTION-f
select * from item where i_no in (
select a.i_no from
(select i_no,count(distinct o_no) as order_count,(select count(*) from order_item) as total_orders from order_item group by i_no) as a
where (a.order_count/a.total_orders)>=0.25);

#question-f
(select sum(a.total_unit_price) as order_price from
(select o.o_no,(o.quantity*i.unit_price) as total_unit_price
from order_item o inner join item i on i.i_no = o.i_no
where o.o_no = 50000) as a
group by a.o_no)
;

update cust_order
		set o_amt = (select sum(a.total_unit_price) as order_price from
			(select o.o_no,(o.quantity*i.unit_price) as total_unit_price
			from order_item o inner join item i on i.i_no = o.i_no
			where o.o_no = 50005) as a
			group by a.o_no)
		where o_no = 50005;
/* 
create procedure update_ord_amt()
BEGIN
DECLARE n int default 0;
declare i int default 0;
select max(o_no) from cust_order into n;
select min(o_no) from cust_order into i;
	while i<=n do
		update cust_order
		set o_amt = (select sum(a.total_unit_price) as order_price from
			(select o.o_no,(o.quantity*i.unit_price) as total_unit_price
			from order_item o inner join item i on i.i_no = o.i_no
			where o.o_no = i) as a
			group by a.o_no);
		where o_no = i
	END
END */

#question-g

create view customer_stats as
select c.c_no,c.c_name,c.city,count(distinct co.o_no) as order_count
from customer c inner join cust_order co
on co.c_no = c.c_no
group by c.c_no;

#question-h


#sample

/* 
DELIMITER $$
-- before inserting new id
DROP TRIGGER IF EXISTS before_insert_id$$
CREATE TRIGGER before_insert_id
    BEFORE INSERT ON test FOR EACH ROW
    BEGIN
        -- condition to check
        IF NEW.id < 0 THEN
            -- hack to solve absence of SIGNAL/prepared statements in triggers
            UPDATE `Error: invalid_id_test` SET x=1;
        END IF;
    END$$

DELIMITER ; */


delimiter //
drop trigger check_order_count;
create trigger check_order_count
before insert on order_item for each row
begin
declare count_order int;
select count(*) into count_order from order_item where o_no = new.o_no;
if count_order > 6 then signal sqlstate '45000' set message_text = 'ERROR!!!';
end if;
end//

################
#BANK
###################


create table customer(
cid int,
cname varchar(200),
primary key(cid)
);

insert into customer(cid,cname) values
#(1000,'Vicky'),
#(1001,'Velan'),
#(1002,'Chandra'),
(1003,'Cecil'),
(1004,'Cassandra'),
(1005,'Emile')
;

create table account(
ano int,
atype enum('S','C'),
balance int,
cid int,
primary key(ano,atype),
foreign key(cid) references customer(cid)
);

INSERT INTO CUSTOMER (CID, CNAME) VALUES
(1, 'John Doe'),
(2, 'Jane Smith'),
(3, 'Mike Johnson');

INSERT INTO ACCOUNT (ANO, ATYPE, BALANCE, CID) VALUES
(101, 'S', 5000.00, 1),
(102, 'C', 10000.00, 1),
(103, 'S', 3000.00, 2),
(104, 'C', 8000.00, 2),
(105, 'S', 2000.00, 3);
create table txn(
tid int,
ano int,
ttype enum('D','W'),
tdate date,
tamt int,
primary key(tid),
foreign key(ano) references account(ano)
);

INSERT INTO TXN(TID, ANO, TTYPE, TDATE, TAMT) VALUES
(1, 101, 'D', '2023-01-01', 1000.00),
(2, 101, 'W', '2023-01-02', 500.00),
(3, 102, 'D', '2023-01-01', 2000.00),
(4, 103, 'D', '2023-01-01', 1500.00),
(5, 104, 'W', '2023-01-02', 1000.00),
(6, 105, 'D', '2023-01-02', 500.00);

INSERT INTO TXN(TID, ANO, TTYPE, TDATE, TAMT) VALUES
(7, 101, 'D', '2023-01-01', 1000.00),
(8, 101, 'W', '2023-01-02', 500.00);


INSERT INTO TXN(TID, ANO, TTYPE, TDATE, TAMT) VALUES
(9, 101, 'D', '2023-01-01', 1000.00),
(10, 101, 'W', '2023-01-02', 500.00),
(11, 101, 'D', '2023-01-01', 1000.00)
;

/* trigger create */
delimiter //
create trigger limit_txn
before insert on txn
for each row
begin
declare txn_lmt int;
select count(*) into txn_lmt
from txn 
where tdate = new.tdate and ano=new.ano;
if txn_lmt>=3
then signal sqlstate '45000'
set message_text = 'Limit reached for the day';
end if;
end//



/* create_procedure */
delimiter //
create procedure update_balance(
txn_id int,
acc_no int,
txn_type varchar(2),
txn_amt int
)
begin
declare bal_amt int;
declare acc_type varchar(2);
select balance into bal_amt from account where ano = acc_no;
select atype into acc_type from account where ano = acc_no;
if txn_type='D' then
	update account
	set balance = balance+txn_amt
	where ano = acc_no;
	insert into txn(tid,ano,ttype,tdate,tamt)
	values(txn_id,acc_no,txn_type,curdate(),txn_amt);
elseif txn_type='W' then
	if (bal_amt-txn_amt)>=2000 and acc_type='S' then
		update account
		set balance = balance-txn_amt
		where ano = acc_no;
		insert into txn(tid,ano,ttype,tdate,tamt)
		values(txn_id,acc_no,txn_type,curdate(),txn_amt);
	elseif (bal_amt-txn_amt)>=5000 and acc_type='C' then
		update account
		set balance = balance-txn_amt
		where ano = acc_no;
		insert into txn(tid,ano,ttype,tdate,tamt)
		values(txn_id,acc_no,txn_type,curdate(),txn_amt);
	else
		signal sqlstate '45000'
		set message_text = 'minimum balance not maintained after withdrawal';
	end if;
else
	signal sqlstate '45000'
	set message_text = 'Transaction not possible';
end if;
end//


call update_balance(15,104,'D',499999);
call update_balance(16,104,'W',49999);