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

create table event (
	event_id int NOT NULL AUTO_INCREMENT,
    event_name varchar(100) NOT NULL,
    event_type varchar(100) NOT NULL,
    event_cast varchar(1000) NOT NULL,
    event_rating varchar(10) NOT NULL,
    event_genre varchar(100) NOT NULL,
    event_language varchar(100) NOT NULL,
    event_summary varchar(2000) NOT NULL,
    event_duration int NOT NULL,
    event_date DATE NOT NULL,
    PRIMARY KEY (event_id)
);
commit;

