
create table Childprofile ( id int(11) primary key, case_no varchar(10), hospital varchar(10), child_name varchar(20), sex char, dob date, age int, mother_tongue varchar(10), father_name varchar(20), mother_name varchar(20), contact_no bigint, disease varchar(20), doctor_id int, vol_id int, wish1 varchar(30), wish2 varchar(30), wish3 varchar(30), date_submit date, approved_wish varchar(30), date_approve date, donor_id int, family varchar(150), friends varchar(150), color varchar(10), book varchar(20), game varchar(20), food varchar(20), muisc_movie varchar(20), hobby varchar(20), cartoon varchar(20), actor varchar(20), trip varchar(20), ambition varchar(20), bigwish1 varchar(200), bigwish2 varchar(200), bigwish3 varchar(200), foreign key (doctor_id) references Doctor(Doctor_id), foreign key (vol_id) references Volunteer(Volunteer_id) )

CREATE TABLE `doctor` (
 `Doctor_id` int(11) NOT NULL,
 `Doctor_name` varchar(50) NOT NULL,
 `Hospital` varchar(50) NOT NULL,
 `Contact` int(10) NOT NULL,
 PRIMARY KEY (`Doctor_id`)
) 

CREATE TABLE `volunteer` (
 `Volunteer_id` int(11) NOT NULL,
 `Name` varchar(50) NOT NULL,
 `Area` varchar(50) NOT NULL,
 `GovtID` varchar(10) NOT NULL,
 `IDno` int(20) NOT NULL,
 `Hospital` varchar(50) NOT NULL,
 `Approved` tinyint(1) NOT NULL,
 `Points` int(5) NOT NULL,
 PRIMARY KEY (`Volunteer_id`)
)

CREATE TABLE `donor` (
 `donor_id` int(10) NOT NULL,
 `Name` varchar(50) NOT NULL,
 `email` varchar(50) NOT NULL,
 `contact` int(10) NOT NULL,
 `points` int(5) NOT NULL,
 `amount` int(10) NOT NULL,
 PRIMARY KEY (`donor_id`)
) 

create table transaction( donor_id int, child_id int, amt int, method varchar(20), dateofPay date, foreign key(donor_id) references donor(donor_id), foreign key(child_id) references childprofile(id) )

CREATE TABLE donor_refer ( donor_id int (10), name varchar (50), email varchar (50), contact int (10), foreign key(donor_id) references donor(donor_id) )

CREATE TABLE doctor_refer
(
    doctor_id int (10),
    name varchar (50),
    email varchar (50),
    contact int (10),
    foreign key(doctor_id) references doctor(doctor_id)
    )

