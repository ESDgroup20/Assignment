/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function myFunction() {
//  var input = document.getElementById('dateTimeInput');
  var d = new Date("2020,10,9");
  var n;
    switch (d.getDay()) {
        case 0:
            n = "Sunday";
            break;
        case 1:
            n = "Monday";
            break;
        case 2:
            n = "Tuesday";
            break;
        case 3:
            n = "Wednesday";
            break;
        case 4:
            n = "Thursday";
            break;
        case 5:
            n = "Friday";
            break;
        case 6:
            n = "Saturday";
            break;

    }
//  document.getElementById("demo").innerHTML = input.textContent;
  document.getElementById("demo").innerHTML = n;
}

