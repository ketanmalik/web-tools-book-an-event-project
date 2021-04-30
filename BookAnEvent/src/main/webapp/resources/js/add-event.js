/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validateAddEventForm() {
    var event_name = document.getElementsByName("event-name")[0].value;
    var event_type = document.getElementsByName("event-type")[0].value;
    var event_cast = document.getElementsByName("event-cast")[0].value;
    var event_rating = document.getElementsByName("event-rating")[0].value;
    var event_genre = document.getElementsByName("event-genre")[0].value;
    var event_language = document.getElementsByName("event-language")[0].value;
    var event_summary = document.getElementsByName("event-summary")[0].value;
    var event_date = document.getElementsByName("event-date")[0].value;
    var event_duration = document.getElementsByName("event-duration")[0].value;
    debugger;
    if (!event_name || event_name.trim() === "") {
        alert("Please enter a valid event name");
        return false;
    }
    if (!event_cast || event_cast.trim() === "") {
        alert("Please enter a valid event cast");
        return false;
    }
    if (!event_type || event_type.trim() === "") {
        alert("Please select a valid event type");
        return false;
    }
    if (!event_rating || event_rating.trim() === "") {
        alert("Please select a valid event rating");
        return false;
    }
    if (!event_genre || event_genre.trim() === "") {
        alert("Please select a valid event genre");
        return false;
    }
    if (!event_language || event_language.trim() === "") {
        alert("Please enter a valid event language");
        return false;
    }
    if (!event_summary || event_summary.trim() === "") {
        alert("Please enter a valid event summary");
        return false;
    }
    if (event_summary && event_summary.length > 2000) {
        alert("Event summary should not exceed 2000 characters");
        return false;
    }
    if (!event_date || event_date === "") {
        alert("Please enter a valid event date");
        return false;
    }
    var todaysDate = new Date();
    if(new Date(event_date) < todaysDate) {
        alert("Event date cannot be in the past");
        return false;
    }
    if (!event_duration || event_duration.trim() === "" || !event_duration.match(/^[1-9][0-9]+/g)) {
        alert("Please enter a valid event duration");
        return false;
    }
    return true;
}
