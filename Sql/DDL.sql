use bookanevent;
create table user (
	user_id int NOT NULL AUTO_INCREMENT,
    fName varchar(100) NOT NULL,
    lName varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    password varchar(15) NOT NULL,
    city varchar(100) NOT NULL,
    state varchar(100) NOT NULL,
    country varchar(100) NOT NULL,
    user_type varchar(10) NOT NULL,
    PRIMARY KEY (user_id),
    CONSTRAINT user_type CHECK (user_type in ('admin', 'customer'))
);

insert into user (fName, lName, email, password, city, state, country, user_type) 
values ('Admin', 'User', 'admin@bookanevent.com', 'admin', 'N/A', 'N/A', 'N/A', 'admin');

delete from user where user_id in (8);
select * from user;
DELETE FROM USER WHERE USER_ID=3;
