use bookanevent;
select * from user;
select * from event;
select * from venue;
select * from booking;

select * from event_venue_show;
select event_id from event_venue_show where show_id=9;

select distinct venue_city, venue_id from venue;

select event_id from event where event_name='Free Guy';
select venue_id from venue where venue_city = 'Boston';
select venue_id from event_venue_show where event_id = 17 and venue_id in (8, 12);

rollback();


