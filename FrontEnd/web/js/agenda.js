
let arr;

var especial = false;

var pacienteToCita;

let date;
let iteracionWeek;

var backend = "http://localhost:8080/BackEnd/api";


class CitaCell{
    constructor(dia,hora){
        this.dia = dia;
        this.hora = hora;
    }
}

function iteracionDay(i){

    switch(i){
        case 0:
            return "";
        case 1:
            return arr[1];
        case 2:
            return "M";
        case 3:
            return "I";
        case 4:
            return "J";
        case 5:
            return "V";
    }
}

function findPaciente(dia,hora){
    
    let cita={hora:"",dia:""};
    cita.hora = hora;
    cita.dia = dia;
    
    //- Cargar en LocalStorage al Paciente
    //- Cargar Perfil y Leer LocalStorage
    localStorage.setItem("cita-paciente",JSON.stringify(cita));
    location.href = 'listaPacientes.html';
}

function cell(col, hora, iteracion) {
    var tr = $("<tr />");
    var dayLetter = iteracionDay(iteracion);

    if (hora) { // true -> Botón habilitado

        tr.html(`
            <div class="horas">        
                <div class="calendario_dia" draggable="true">                  
                    <div class="hora-row ableButton">
                        <!-- <a class="item"> </a> -->
        <!--                        <button type="button" id="makeBtn" class="btn-primary cardButton" >${arr[iteracion]}</button>
         -->                <button type="button" id="makeBtn" class="cardButton">cita</button>
                    </div>
                </div> 
            </div>`);
        tr.find("#makeBtn").on("click", ()=> {
            console.log("it->"+ arr[iteracion])
            console.log("hora->"+ hora)
            findPaciente(arr[iteracion],hora);
        })
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


function unDay(col,hora){// días del pasado

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


function fetchShedule(){
    
    var cedula;
    console.log("Ejecutando fetchShedule")
    
    const request = new Request(backend+'/doctores/dias/'+cedula, {method:'GET', headers: { }});
    (async ()=> {
        try{
            const response = await fetch(request);
            
            doctores = await response.json();
            console.log("Doctores-> "+ JSON.stringify(doctores))

            if(existePersona()){ 
                
                //--- LOGIN finalizado
                console.log("Existe persona!!")
                mostrarPersona();

            }else{
                console.log("No existe persona")
            }
            
        }catch(e){

        }
    })();
}

function getWeek(dayString){
    
    var close = {checked:false};
    var week; 
    
    week = fetchShedule();
    
    switch(dayString){

        case "Monday":

            week = [{checked: true, desde: "8:00", hasta: "6:00"},//- Head
            {checked: true, desde: "9:30", hasta: "3:00"},
            {checked: true, desde: "1:30", hasta: "4:00"},
            {checked: true, desde: "9:30", hasta: "3:00"},
            {checked: true, desde: "8:30", hasta: "4:30"},
            {checked: true, desde: "9:30", hasta: "4:00"}];

            break;
        case "Tuesday":

            week = [{checked: true, desde: "8:00", hasta: "6:00"},
            {checked: false},
            {checked: true, desde: "1:30", hasta: "4:00"},
            {checked: true, desde: "9:30", hasta: "3:00"},
            {checked: true, desde: "8:30", hasta: "4:30"},
            {checked: true, desde: "9:30", hasta: "4:00"}];

            break;
        case "Wednesday":

            week = [{checked: true, desde: "8:00", hasta: "6:00"},
            {checked: false},
            {checked: false},
            {checked: true, desde: "9:30", hasta: "3:00"},
            {checked: true, desde: "8:30", hasta: "4:30"},
            {checked: true, desde: "9:30", hasta: "4:00"}];

            break;
        case "Thursday":

            week = [{checked: true, desde: "8:00", hasta: "6:00"},
            {checked: false},
            {checked: false},
            {checked: false},
            {checked: true, desde: "8:30", hasta: "4:30"},
            {checked: true, desde: "9:30", hasta: "4:00"}];

            break;
        case "Friday":

            week = [{checked: true, desde: "8:00", hasta: "6:00"},
            {checked: false},
            {checked: false},
            {checked: false},
            {checked: false},
            {checked: true, desde: "9:30", hasta: "4:00"}];

            break;
            
        

    }
    
    return week;
}

function validarFecha(weekCount,fecha){

    //fecha = new Date();
    let day = fecha.toLocaleString('en-us', {weekday: 'long'});
    console.log(day);
    console.log("fecha->"+fecha);
    var semana = getWeek(day);//-json días pasados

    

    let lu,ma,mi,ju,vi;//- To print Head Days

    if(day == "Monday"){
 
        lu = "Lunes " + String(fecha.getDate()).padStart(2, '0'); 
        ma = "Martes " + String(fecha.getDate()+1).padStart(2, '0');
        mi = "Miercoles " + String(fecha.getDate()+2).padStart(2, '0');
        ju = "Jueves " + String(fecha.getDate()+3).padStart(2, '0');
        vi = "Viernes " + String(fecha.getDate()+4).padStart(2, '0');
        

    }else if(day == "Tuesday"){

        lu = "Lunes";
        ma = "Martes " + String(fecha.getDate()).padStart(2, '0');
        mi = "Miercoles " + String(fecha.getDate()+1).padStart(2, '0');
        ju = "Jueves " + String(fecha.getDate()+2).padStart(2, '0');
        vi = "Viernes " + String(fecha.getDate()+3).padStart(2, '0');

    }else if(day == "Wednesday"){

        lu = "Lunes";
        ma = "Martes ";
        mi = "Miercoles " + String(fecha.getDate()).padStart(2, '0');
        ju = "Jueves " + String(fecha.getDate()+1).padStart(2, '0');
        vi = "Viernes " + String(fecha.getDate()+2).padStart(2, '0');

    }else if(day == "Thursday"){

        lu = "Lunes";
        ma = "Martes ";
        mi = "Miercoles ";
        ju = "Jueves " + String(fecha.getDate()).padStart(2, '0');
        vi = "Viernes " + String(fecha.getDate()+1).padStart(2, '0');

    }else if(day == "Friday"){

        lu = "Lunes";
        ma = "Martes ";
        mi = "Miercoles ";
        ju = "Jueves ";
        vi = "Viernes " + String(fecha.getDate()).padStart(2, '0');
    }

    arr = ["",lu,ma,mi,ju,vi]// Print Head Days
    let n = 0;
    
    
    $('.dias_item').html('');
    $('.dias_item').each( function() {

        var tr = $("<tr />");
        tr.html(`${arr[n]}`)

        $(this).append(tr)
        n++;

    })


    return semana;
    
}

function nextWeek(){
    
    iteracionWeek = iteracionWeek + 1;
    let num = 7*iteracionWeek;
    date = new Date();
    console.log("today  --> "+ date);
    //var nextWeek = new Date( date.getDate()+7);
    var nextWeek = new Date(date.getFullYear(), date.getMonth(), date.getDate()+num);

    
    let newDay = nextWeek.toLocaleString('en-us', {weekday: 'long'});
    console.log("NextWeek Str -> "+newDay);
    
    var horario = validarFecha(1,nextWeek);//--> retorna lo de NextWeek (semana)
}






function main() {

    iteracionWeek = 0;
    
    if(localStorage.getItem('pacienteToCita')){
        pacienteToCita = localStorage.getItem('pacienteToCita')
        especial = true;
        console.log("Vista Especial")
    }
    

    /*var head = {checked: true, desde: "8:00", hasta: "6:00"};
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
                    {checked: true, desde: "9:30", hasta: "4:00"}];*/

    /* 0:lunes  1:martes  2:miercoles  3:jueves  4:viernes*/
    //var horario2 = [head, lunes, martes, miercoles, jueves, viernes];

    date = new Date();
    var horario = validarFecha(1,date);
    
    let i = 0;
    let j = 0;
    let frequency = 1; //-  1 x 30min = 30min
    let horas;
    let invalidColumn = ["_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_"];
    let horasString = ["8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "1:00", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00", "4:30", "5:00", "5:30", "6:00"];


    $("#nextBtn").click(nextWeek);


    $(".col-main").each(function () {
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
            
                    cell($(this), h, i);// ->   h  ==  1||0
                
                j++;
                count++;
            })
            
        }

        i++;
    })

}

$(main);