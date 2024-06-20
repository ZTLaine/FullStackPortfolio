insert into users (user_id, username, password, first_name, last_name)
values (1, 'ZTLaine', 'pw123', 'Zack', 'Laine');
insert into users (user_id, username, password, first_name, last_name)
values (2, 'ScreamyMcGee', 'aaaaaaaaaaaaaaaaaa', 'Pippin', 'Laine');
insert into users (user_id, username, password, first_name, last_name)
values (3, 'TeenyBean', 'boof', 'Skylar', 'Laine');
insert into users (user_id, username, password, first_name, last_name)
values (4, 'Tyrandir', 'fen', 'Tyrandir', 'Dargon');

select * from users;

select username from users;

insert into transactions(transaction_id, transaction_date, amount, type)
values (3, '2024-02-20 15:23', 128.79, 'C');

select * from transactions;

alter table transactions
change column amount amount decimal(6, 2);

alter table transactions
add foreign key (user_id) references users (user_id);

update transactions 
set user_id =  1;

select * from users
where last_name = 'Laine'
and username = 'ZTLaine';

update transactions
set user_id = 2
where transaction_id = 3;

select * from transactions
where user_id = 2;

create table user_account(
`user_id` int not null,
`account_id` int not null,
foreign key (user_id) references users (user_id),
foreign key (account_id) references accounts (account_id)
);

insert into accounts (account_id, account_name, balance)
values (3, 'savings', 2301);

select * from accounts;
select * from users;
select * from user_account;
select * from transactions;
select * from addresses;

insert into user_account( user_id, account_id)
values (1, 1);

insert into user_account( user_id, account_id)
values (2, 3);

update user_account
set user_id = 4
where user_id = 2;

alter table transactions disable keys;

alter table transactions
drop foreign key `transactions_ibfk_1`;

alter table transactions
drop column user_id;

alter table transactions
add column account_id int not null;

alter table transactions
add foreign key (account_id) references accounts (account_id);

ALTER TABLE address
ADD FOREIGN KEY (`user_id`)
REFERENCES users (`user_id`);

alter table address
rename to addresses;

insert into addresses (user_id, address_line_1, city, region, country, zip_code)
values(1, '69 Main street', 'Seattle', 'WA', 'USA', '98101');

update addresses
set address_line_1 = '69 Main Street'
where user_id = 1;

select * from users
join addresses on users.user_id = addresses.user_id;

select * from users u
left join addresses on u.user_id = addresses.user_id
left join user_account ua on ua.user_id = u.user_id
left join accounts acc on acc.account_id = ua.account_id
left join transactions t on t.account_id = acc.account_id;
where last_name = 'Laine';

select * from users u
left join addresses on u.user_id = addresses.user_id
left join user_account ua on ua.user_id = u.user_id
left join accounts acc on acc.account_id = ua.account_id
left join transactions t on t.account_id = acc.account_id
where first_name in ('Pippin', 'Skylar');


insert into transactions(transaction_id, transaction_date, amount, type, account_id)
values (4, '2024-03-30 13:43', 12.79, 'C', 3);

select * from transactions
group by account_id;

SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

select sum(amount) from transactions
group by account_id;

select account_id, 
	sum(case
			when `type` = 'D' then amount
			when `type` = 'C' then amount * -1
        end) as account_balance 
from transactions
-- where amount > 100
group by account_id;

select account_id, count(*) from transactions
group by account_id;

insert into transactions(transaction_id, transaction_date, amount, type, account_id)
values (5, '2024-04-19 17:32', 1292.11, 'D', 3);

select account_id, count(*) from transactions
group by account_id
having count(*) > 1;

-- having filters by the entire aggregated collection
-- where filters the individual entries 