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
