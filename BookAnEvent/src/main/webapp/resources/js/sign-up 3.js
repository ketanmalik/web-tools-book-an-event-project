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
    var fName = document.getElementsByName("fName")[0].value;
    var lName = document.getElementsByName("lName")[0].value;
    var email = document.getElementsByName("email")[0].value;
    var password = document.getElementsByName("password")[0].value;
    var city = document.getElementsByName("city")[0].value;
    var state = document.getElementsByName("state")[0].value;
    if(!fName || fName.trim() === '') {
        alert("Please enter a valid first name");
        return false;
    }
    if(!lName || lName.trim() === '') {
        alert("Please enter a valid last name");
        return false;
    }
    if(!email || email.trim() === '' || !email.trim().match(/^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9]+.[a-zA-Z]+$/g)) {
        alert("Please enter a valid email");
        return false;
    }
    if(!password || password.trim() === '' || password.length > 15) {
        alert("Please enter a valid password");
        return false;
    }
    if(!city || city.trim() === '') {
        alert("Please enter a valid city");
        return false;
    }
    if(!state || state.trim() === '') {
        alert("Please select a valid state");
        return false;
    }
    return true;
}
