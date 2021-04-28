use bookanevent;
select * from user;
select * from event;
select * from venue;
select * from booking; 

select * from booking;
select * from event_venue_show where show_id = (select show_id from booking where show_id = 1);

select * from event_venue_show;
select event_id, count(1) from event_venue_show group by event_id;
select venue_id, count(1) from event_venue_show group by venue_id;
select event_id from event_venue_show where show_id=9;
update event_venue_show set seats_left = 120 where show_id = 5;

select distinct venue_city, venue_id from venue;

select event_id from event where event_name='Free Guy';
select venue_id from venue where venue_city = 'Boston';
select venue_id from event_venue_show where event_id = 17 and venue_id in (8, 12);

insert into user(user_id,fName,lName,email,password,user_type) values (2,'Ketan','Malik','admin','admin','admin');


