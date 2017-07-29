create table childprofile (
id int(11) primary key,
case_no varchar(10),
hospital varchar(10),
child_name varcharr(20),
sex char,
dob date,
age int,
mother_tongue varchar(10),
father_name varchar(20),
mother_name varchar(20),
contact_no bigint,
disease varchar(20),
doctor_id int,
vol_id int,
wish1 varchar(30),
wish2 varchar(30),
wish3 varchar(30),
date_submit date,
approved_wish varchar(30),
date_approve date,
donor_id int,
family varchar(150),
friends varchar(150),
color varchar(10),
book varchar(20),
game varchar(20),
food varchar(20),
muisc_movie varchar(20),
hobby varchar(20),
cartoon varchar(20),
actor varchar(20),
trip varchar(20),
ambition varchar(20),
bigwish1 varchar(200),
bigwish2 varchar(200),
bigwish3 varchar(200),
foreign key (doctor_id) references Doctor(doc_id),
foreign key (vol_id) references Doctor(volunteer_id),
);

create table volunteer_register(
volunteer_id int primary key,
area varchar(20),
id_type varchar(10),
govt_id bigint,
volun_type varchar(20),
hosptal varchar(20),
status boolean,
points int
);

create table donor(
don_id int primary key,
name varchar(20),
email varchar(20),
ph_no bigint,
points int,
amt int
);

create table transaction(
donor_id int,
child_id int,
amt int,
method varchar(20),
dateofPay date,
foreign key(donor_id) references donor(don_id),
foreign key(child_id) references childprofile(id)
);