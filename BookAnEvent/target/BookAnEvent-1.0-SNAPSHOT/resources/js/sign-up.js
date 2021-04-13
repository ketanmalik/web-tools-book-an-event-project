/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function togglePassword() {
    var box = document.getElementById("show-password");
    if (box.checked) {
        document.getElementById('pwd').type = 'text';
    } else {
        document.getElementById('pwd').type = 'password';
    }
}

function validateSignUpForm() {
    var fName = document.getElementsByName("fName");
    var lName = document.getElementsByName("lName");
    var email = document.getElementsByName("email");
    var password = document.getElementsByName("password");
    var city = document.getElementsByName("city");
    var state = document.getElementsByName("state");
    if(!fName || !fName[0] || fName[0].value.trim() === '') {
        alert("Please enter a valid first name");
        return false;
    }
    if(!lName || !lName[0] || lName[0].value.trim() === '') {
        alert("Please enter a valid last name");
        return false;
    }
    if(!email || !email[0] || email[0].value.trim() === '' || !email[0].value.trim().match(/^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9]+.[a-zA-Z]+$/g)) {
        alert("Please enter a valid email");
        return false;
    }
    if(!password || !password[0] || password[0].value.trim() === '' || password[0].value.length > 15) {
        alert("Please enter a valid password");
        return false;
    }
    if(!city || !city[0] || city[0].value.trim() === '') {
        alert("Please enter a valid city");
        return false;
    }
    if(!state || !state[0] || state[0].value.trim() === '') {
        alert("Please select a valid state");
        return false;
    }
    return true;
}
