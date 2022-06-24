
let arrayDiasSemana;

var especial = false;

var pacienteToCita;

let date;
let iteracionWeek;
var fetchSemana;
var citasDeMedico;
var ocupadas;

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
            return arrayDiasSemana[1];
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
    cita.hora = hora;//// --> esta 'hora' es de 1 y 0
    cita.dia = dia;
    
    //- Cargar en LocalStorage al Paciente
    //- Cargar Perfil y Leer LocalStorage
    localStorage.setItem("citaToPaciente",JSON.stringify(cita));
    location.href = 'listaPacientes.html';
}

function occupiedCell(dayColumn,iteracion){
    var tr = $("<tr />");
    
        tr.html(`
            <div class="horas">        
                <div class="calendario_dia" draggable="true">                  
                    <div class="hora-row ableButton">
                        <button type="button" id="atenderBtn" class="cardButton">ocupado</button>
                    </div>
                </div> 
            </div>`);
        tr.find("#atenderBtn").on("click", ()=> {
            
            console.log("it->"+ arrayDiasSemana[iteracion])
            console.log("hora->"+ hora)
            if(especial){
                location.href = 'makeCita.html';
            }else{
                //findPaciente(arrayDiasSemana[iteracion],hora);
            }
            
        })
        dayColumn.append(tr);

}

function cell(col, hora, iteracion, horasString) {// con la iteración puedo saber la hora
    var tr = $("<tr />");
    var dayLetter = iteracionDay(iteracion);

    if (hora) { // true -> Botón habilitado
        
        tr.html(`
            <div class="horas">        
                <div class="calendario_dia" draggable="true">                  
                    <div class="hora-row ableButton">
                       <button type="button" id="makeBtn" class="cardButton">cita</button>
                    </div>
                </div> 
            </div>`);
        tr.find("#makeBtn").on("click", ()=> {
            
            console.log("it->"+ arrayDiasSemana[iteracion])
            console.log("hora->"+ horasString[iteracion])
            if(especial){
                location.href = 'makeCita.html';
            }else{
                findPaciente(arrayDiasSemana[iteracion],horasString[iteracion]);
            }
            
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
    /* count cells = 21 when frequency = 30min  (8am->6pm) */
    let horas = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    let horasString;
    
    console.log("Frequemy: "+frequency);
    if(frequency == 30){
        horasString  = ["8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "1:00", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00", "4:30", "5:00", "5:30", "6:00"];
    }else if(frequency == 60){
        horasString = ["8:00","9:00","10:00", "11:00", "12:00", "1:00", "2:00", "3:00", "4:00","5:00","6:00"];
    }
    
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

    return horas;

}

function printDayNames(lu,ma,mi,ju,vi){



}

function existeCita(toAnalize,citasFromDB){
    console.log("toAnalize: "+toAnalize)
    citasFromDB.forEach((c) => {
       console.log("--citaFromDB: "+ c.dateStr + " " + c.horaStr);
       if(toAnalize == c.dateStr+" "+ c.horaStr){
           return true;
       }
    })
    return false;
}

function calcOcupadas(frequency,iteracion){ 
    
    console.log("citaValidate()...");
    //-- usar citasDeMedico
    
    /* count cells = 21 when frequency = 30min  (8am->6pm) */
    let ocupadas = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    let horasString;
    
    console.log("Frequemy: "+frequency);
    if(frequency == 30){
        horasString  = ["8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "1:00", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00", "4:30", "5:00", "5:30", "6:00"];
    }else if(frequency == 60){
        horasString = ["8:00","9:00","10:00", "11:00", "12:00", "1:00", "2:00", "3:00", "4:00","5:00","6:00"];
    }
    
    let i = 0;
    
    console.log(arrayDiasSemana[iteracion]);
    let strDate;
    var citasFromDB = JSON.stringify(citasDeMedico);
    
    horasString.forEach((h) => {
    // comparar cada elemento (se recorren todas las citas existentes)
        console.log("citasDeMedico->"+ citasFromDB);
        
        str = arrayDiasSemana[iteracion] +" "+ h;
        console.log("Horas String ->"+str);
        
        if(existeCita(str,citasDeMedico)){
            ocupadas[i] = 1;
        }
        
        i++;
    })

    return ocupadas;
}

function citaValidate(frequency,iteracion){ 
    
    console.log("citaValidate()...");
    //-- usar citasDeMedico
    
    /* count cells = 21 when frequency = 30min  (8am->6pm) */
    let ocupadas = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    let horasString;
    
    console.log("Frequemy: "+frequency);
    if(frequency == 30){
        horasString  = ["8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "1:00", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00", "4:30", "5:00", "5:30", "6:00"];
    }else if(frequency == 60){
        horasString = ["8:00","9:00","10:00", "11:00", "12:00", "1:00", "2:00", "3:00", "4:00","5:00","6:00"];
    }
    
    let i = 0;
    
    console.log(arrayDiasSemana[iteracion]);
    let strDate;
    var citasFromDB = JSON.stringify(citasDeMedico);
    
    horasString.forEach((h) => {
    // comparar cada elemento (se recorren todas las citas existentes)
        console.log("citasDeMedico->"+ citasFromDB);
        
        str = arrayDiasSemana[iteracion] +" "+ h;
        console.log("Horas String ->"+str);
        
        if(existeCita(str,citasDeMedico)){
            return true;
        }
        
        i++;
    })

    return false;
}

function printElements(fetchSemana){
    
    let i = 0;
    let j = 0;
    let frequency = 30; //-  1 x 30min = 30min
    let horas;
    let invalidColumn = ["_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_","_"];
    let horasString = ["8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "1:00", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00", "4:30", "5:00", "5:30", "6:00"];


    console.log("ejecutando print elements**")
    

    $("#nextBtn").click(nextWeek);


    $(".col-main").each(function () {
        //console.log("day-count + " + i + " " + JSON.stringify(horario[i]))

        let count=0;
        if(i == 0){ //-primera iteración (HEAD)
            count = 0;

            horasString.forEach((h) => {
                
                    headCell($(this), h);
                
                j++;
            })
            count++;
        } else
        if (!fetchSemana[i].checked) { // false | gray box ( - )
            // print gray boxes
            console.log("ha sido false **!!!**");

            invalidColumn.forEach((c) => {
                
                unDay($(this), c);// caja con  ( O.S )
            
            j++;
        })
        } else { // true
            console.log("ha sido true *!*");
            count = 0;
            
            // -- horas = arreglo de '1' y '0'  || (rango de fecha en que atiende)
            horas = calcHoras(frequency, fetchSemana[i].desde, fetchSemana[i].hasta);
            
            // -- ocupadas = arreglo de '1' y '0'  || (citas ocupadas)
            ocupadas = calcOcupadas(frequency, fetchSemana[i].desde, fetchSemana[i].hasta);

            horas.forEach((h) => {
                
                    // VALIDAR aquí si la cita ya existe
            //        if(citaValidate(30,i)){//- params (frequency y iteracion)
                        cell($(this), h, i, horasString);// ->     h  ==  1 || 0    i == 1,2,3,4,5 (l,m,i,j,v)
            //        }else{
                        // cita ocupada
            //            occupiedCell($(this),i);
             //       }
                    
                
                j++;
                count++;
            })
            
        }

        i++;
    })
    
}


function fetchShedule(dayString){
    
    var cedula="2222";
    
    const request = new Request(backend+'/doctores/dias/'+cedula, {method:'GET', headers: { }});
    (async ()=> {
        try{
            const response = await fetch(request);
            
            fetchSemana = await response.json();
            console.log("Semana one-> "+ JSON.stringify(fetchSemana))

            loadShedule(dayString,fetchSemana);// este metodo carga a 'fetchSemana'
            //fetchCitasExistentes();
            console.log("LoadShedule() finalizado")
            printElements(fetchSemana); // fetchSemana como parametro
            
        }catch(e){

        }
    })();
    
    
    
}



function prepareWeek(theWeek,boolL,boolM,boolI,boolJ,boolV){
            
            var dayHead = {checked: true, desde: "8:00", hasta: "6:00"};
            var close = {checked:false};
    
            console.log("Week 1: "+ JSON.stringify(fetchSemana));
            
            console.log("adding head")
            fetchSemana.splice(0,0,dayHead);
            console.log("Week 2: "+ JSON.stringify(fetchSemana));
            
            
        if(boolL){    
            console.log("adding close")
            fetchSemana.splice(1,0,close);
            console.log("Week 3: "+JSON.stringify(fetchSemana));
            
            console.log("deleting previous")
            fetchSemana.splice(2,1);
            console.log("Week 4: "+ JSON.stringify(fetchSemana));
        }
        if(boolM){    
            console.log("adding close")
            fetchSemana.splice(2,0,close);
            console.log("Week 3: "+JSON.stringify(theWeek));
            
            console.log("deleting previous")
            fetchSemana.splice(3,1);
            console.log("Week 4: "+ JSON.stringify(theWeek));
        }
        if(boolI){    
            console.log("adding close")
            fetchSemana.splice(3,0,close);
            console.log("Week 3: "+JSON.stringify(theWeek));
            
            console.log("deleting previous")
            fetchSemana.splice(4,1);
            console.log("Week 4: "+ JSON.stringify(theWeek));
        }
        if(boolJ){    
            console.log("adding close")
            fetchSemana.splice(4,0,close);
            console.log("Week 3: "+JSON.stringify(theWeek));
            
            console.log("deleting previous")
            fetchSemana.splice(5,1);
            console.log("Week 4: "+ JSON.stringify(theWeek));
        }
        if(boolV){    
            console.log("adding close")
            fetchSemana.splice(5,0,close);
            console.log("Week 3: "+JSON.stringify(theWeek));
            
            console.log("deleting previous")
            fetchSemana.splice(6,1);
            console.log("Week 4: "+ JSON.stringify(theWeek));
        }
            
            
}

function loadShedule(dayString,fetchSemana){
    
    
    console.log("Semana two-> "+ JSON.stringify(fetchSemana))
    console.log("dayString-> "+ dayString)
    
    switch(dayString){ // 1 = día del pasado || 0 = día presente o del futuro

        case "Monday":
            
            prepareWeek(fetchSemana,0,0,0,0,0);

            break;
        case "Tuesday":
            
            prepareWeek(fetchSemana,1,0,0,0,0);

            break;
        case "Wednesday":

            prepareWeek(fetchSemana,1,1,0,0,0);

            break;
        case "Thursday":

            prepareWeek(fetchSemana,1,1,1,0,0);

            break;
        case "Friday":

            prepareWeek(fetchSemana,1,1,1,1,0);

            break;
    }
    
    
    
}

function getWeek(dayString){
    
    
    var week; 
    
    fetchShedule(dayString);
    week = fetchSemana;
    
    
    return week;
}

function validarFecha(weekCount,fecha){

    //fecha = new Date();
    let day = fecha.toLocaleString('en-us', {weekday: 'long'});
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

    arrayDiasSemana = ["",lu,ma,mi,ju,vi]// Print Head Days
    let n = 0;
    
    
    $('.dias_item').html('');
    $('.dias_item').each( function() {

        var tr = $("<tr />");
        tr.html(`${arrayDiasSemana[n]}`)

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

    date = new Date();
    
    console.log("Entró a citas Existentes")
    

    const request = new Request(backend+'/doctores/citasExistentes', {method:'GET', headers: { }});
    (async ()=> {
        try{
            const response = await fetch(request);
            
            citasDeMedico = await response.json();
            console.log("citas de medico-> "+ JSON.stringify(citasDeMedico))
               //... when 'fetch' finished ...//
              //*****************************//
             //----> LEER CITAS Y PRINT <---//
            //*****************************//
            var horario = validarFecha(1,date);
                        
        }catch(e){

        }
    })();
    
    
    

}

$(main);