





function cell(col, hora) {
    var tr = $("<tr />");


    if (hora) { // true -> Botón habilitado

        tr.html(`
            <div class="horas">        
                <div class="calendario_dia">                  
                    <div class="hora-row ableButton">
                        ${hora}
                        <!-- <a class="item"> </a> -->
                    </div>
                </div> 
            </div>`);
        col.append(tr);
    } else { // false -> Botón inhabilitado
       
        tr.html(`
            <div class="horas">        
                <div class="calendario_dia">                  
                    <div class="hora-row unableButton">
                        O.S.
                        <!-- <a class="item"> </a> -->
                    </div>
                </div> 
            </div>`);
        col.append(tr);
    }
}

function headCell(col, hora){
    
    var tr = $("<tr />");
    
    tr.html(`
            <div class="horas">        
                <div class="calendario_dia">                  
                    <div class="hora-row">
                        ${hora}
                        <!-- <a class="item"> </a> -->
                    </div>
                </div> 
            </div>`);
        col.append(tr);
    
}


function unDay(col,hora){

    var tr = $("<tr />");

    tr.html(`
            <div class="horas">        
                <div class="calendario_dia">                  
                    <div class="hora-row unableDay">
                        _
                        <!-- <a class="item"> </a> -->
                    </div>
                </div> 
            </div>`);
        col.append(tr);

}

function calcHoras(frequency, desde, hasta) {
    /*count cells = 21 when frequency = 30min  (8am->6pm)*/
    let horas = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    let horasString = ["8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "1:00", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00", "4:30", "5:00", "5:30", "6:00"];
    let validRange = false; //true into range
    let i = 0;
    horasString.forEach((h) => {

        if (h == desde) {
            validRange = true;
        }

        if (h == hasta) {
            validRange = false;
        }

        if (validRange) {
            horas[i] = 1;
        } else {
            horas[i] = 0;
        }
        i++;
    })

    console.log("Array horas -> " + horas);

    return horas;

}

function printDayNames(lu,ma,mi,ju,vi){



}

function validarFecha(dateStr, locale){

    let date = new Date();
    let day = date.toLocaleString('en-us', {weekday: 'long'});
    console.log(day);
    var semana;

    switch(day){

        case "Monday":

            semana = [{checked: true, desde: "8:00", hasta: "6:00"},//- Head
            {checked: true, desde: "9:30", hasta: "3:00"},
            {checked: true, desde: "1:30", hasta: "4:00"},
            {checked: true, desde: "9:30", hasta: "3:00"},
            {checked: true, desde: "8:30", hasta: "4:30"},
            {checked: true, desde: "9:30", hasta: "4:00"}];

            break;
        case "Tuesday":

            semana = [{checked: true, desde: "8:00", hasta: "6:00"},
            {checked: false},
            {checked: true, desde: "1:30", hasta: "4:00"},
            {checked: true, desde: "9:30", hasta: "3:00"},
            {checked: true, desde: "8:30", hasta: "4:30"},
            {checked: true, desde: "9:30", hasta: "4:00"}];

            break;
        case "Wednesday":

            semana = [{checked: true, desde: "8:00", hasta: "6:00"},
            {checked: false},
            {checked: false},
            {checked: true, desde: "9:30", hasta: "3:00"},
            {checked: true, desde: "8:30", hasta: "4:30"},
            {checked: true, desde: "9:30", hasta: "4:00"}];

            break;
        case "Thursday":

            semana = [{checked: true, desde: "8:00", hasta: "6:00"},
            {checked: false},
            {checked: false},
            {checked: false},
            {checked: true, desde: "8:30", hasta: "4:30"},
            {checked: true, desde: "9:30", hasta: "4:00"}];

            break;
        case "Friday":

            semana = [{checked: true, desde: "8:00", hasta: "6:00"},
            {checked: false},
            {checked: false},
            {checked: false},
            {checked: false},
            {checked: true, desde: "9:30", hasta: "4:00"}];

            break;

    }

    var todayNumber = String(date.getDate()).padStart(2, '0');
    let lu,ma,mi,ju,vi;

    if(day == "Monday"){
 
        lu = "Lunes " + todayNumber; 
        ma = "Martes " + (todayNumber+1);
        mi = "Miercoles " + (todayNumber+2);
        ju = "Jueves " + (todayNumber+3);
        vi = "Viernes " + (todayNumber+4);
        

    }else if(day == "Tuesday"){

        lu = "Lunes";
        ma = "Martes " + todayNumber;
        mi = "Miercoles " + (todayNumber+1);
        ju = "Jueves " + (todayNumber+2);
        vi = "Viernes " + (todayNumber+3);

    }else if(day == "Wednesday"){

        lu = "Lunes";
        ma = "Martes ";
        mi = "Miercoles " + todayNumber;
        ju = "Jueves " + (todayNumber+1);
        vi = "Viernes " + (todayNumber+2);

    }else if(day == "Thursday"){

        lu = "Lunes";
        ma = "Martes ";
        mi = "Miercoles ";
        ju = "Jueves " + todayNumber;
        vi = "Viernes " + (todayNumber+1);

    }else if(day == "Friday"){

        lu = "Lunes";
        ma = "Martes ";
        mi = "Miercoles ";
        ju = "Jueves ";
        vi = "Viernes " + todayNumber;
    }

    let n = 0;
    
    $('.dias_item').each( function() {

        console.log("Iteración # de 6")

        if(n == 1 && day == "Monday"){
 
            lu = "Lunes " + todayNumber; 
            ma = "Martes " + (todayNumber+1);
            mi = "Miercoles " + (todayNumber+2);
            ju = "Jueves " + (todayNumber+3);
            vi = "Viernes " + (todayNumber+4);
            

        }else if(n == 2 && day == "Tuesday"){

            lu = "Lunes";
            ma = "Martes " + todayNumber;
            mi = "Miercoles " + (todayNumber+1);
            ju = "Jueves " + (todayNumber+2);
            vi = "Viernes " + (todayNumber+3);

        }else if(n == 3 && day == "Wednesday"){

            lu = "Lunes";
            ma = "Martes ";
            mi = "Miercoles " + todayNumber;
            ju = "Jueves " + (todayNumber+1);
            vi = "Viernes " + (todayNumber+2);

        }else if(n == 4 && day == "Thursday"){

            lu = "Lunes";
            ma = "Martes ";
            mi = "Miercoles ";
            ju = "Jueves " + todayNumber;
            vi = "Viernes " + (todayNumber+1);

        }else if(n == 5 && day == "Friday"){

            lu = "Lunes";
            ma = "Martes ";
            mi = "Miercoles ";
            ju = "Jueves ";
            vi = "Viernes " + todayNumber;
        }
        n++;

    })




    return semana;
    
}




function main() {

    

    
    

    var head = {checked: true, desde: "8:00", hasta: "6:00"};
    var lunes = {checked: true, desde: "9:30", hasta: "3:00"};
    var martes = {checked: true, desde: "1:30", hasta: "4:00"};
    var miercoles = {checked: true, desde: "9:30", hasta: "4:00"};
    var jueves = {checked: true, desde: "8:30", hasta: "4:00"};
    var viernes = {checked: true, desde: "9:30", hasta: "4:00"};
    //examenes:[{id:"1"},{id:"2"}]
    var semana = [{checked: true, desde: "8:00", hasta: "6:00"},
                    {checked: true, desde: "9:30", hasta: "3:00"},
                    {checked: true, desde: "1:30", hasta: "4:00"},
                    {checked: true, desde: "9:30", hasta: "3:00"},
                    {checked: true, desde: "8:30", hasta: "4:30"},
                    {checked: true, desde: "9:30", hasta: "4:00"}];

    /* 0:lunes  1:martes  2:miercoles  3:jueves  4:viernes*/
    var horario2 = [head, lunes, martes, miercoles, jueves, viernes];

    var horario = validarFecha();

    let i = 0;
    let j = 0;
    let frequency = 1; //-  1 x 30min = 30min
    let horas;
    let invalidColumn = ["_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_"];
    let horasString = ["8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "1:00", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00", "4:30", "5:00", "5:30", "6:00"];


    


    $(".col-Lunes").each(function () {
        console.log("day-count + " + i + " " + JSON.stringify(horario[i]))

        let count=0;
        if(i == 0){ //-primera iteración (HEAD)
            count = 0;
            horasString.forEach((h) => {
                
                    headCell($(this), h);
                
                j++;
            })
            count++;
        } else
        if (!horario[i].checked) { // false
            // print gray boxes
            console.log("ha sido false **!!!**");

            invalidColumn.forEach((c) => {
                
                unDay($(this), c);
            
            j++;
        })
        } else { // true

            count = 0;
            horas = calcHoras(frequency, horario[i].desde, horario[i].hasta);
            horas.forEach((h) => {
                
                
                    cell($(this), h);
                
                
                j++;
                count++;
            })
            
        }

        i++;
    })

}

$(main);