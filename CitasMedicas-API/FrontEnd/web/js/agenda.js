

var lunes = {checked: true, desde: "9:30", hasta: "4:00"};
var martes = {checked: false};
var miercoles = {checked: false};
var jueves = {checked: false};
var viernes = {checked: false};

/* 0:lunes  1:martes  2:miercoles  3:jueves  4:viernes*/
var horario = [lunes, martes, miercoles, jueves, viernes];



function cell(col, hora) {
    var tr = $("<tr />");


    if (hora) { // true -> Botón habilitado

        tr.html(`
            <div class="horas">        
                <div class="calendario_dia">                  
                    <div class="hora-row">
                        true-> ${hora}
                        <!-- <a class="item"> </a> -->
                    </div>
                </div> 
            </div>`);
        col.append(tr);
    } else { // false -> Botón inhabilitado

        tr.html(`
            <div class="horas">        
                <div class="calendario_dia">                  
                    <div class="hora-row">
                        false-> ${hora}
                        <!-- <a class="item"> </a> -->
                    </div>
                </div> 
            </div>`);
        col.append(tr);
    }
}

function calcHoras(frequency,desde,hasta){
    /*count cells = 21 when frequency = 30min  (8am->6pm)*/
    let horas = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0];
    let horasString = ["8:00","8:30","9:00","9:30","10:00","10:30","11:00","11:30","12:00","12:30","1:00","1:30","2:00","2:30","3:00","3:30","4:00","4:30","5:00","5:30","6:00"];
    let validRange = false; //true into range
    let i=0;
    horasString.forEach((h) => {
        
        if(h == desde){
            validRange = true;
        }
        
        if(h == hasta){
            validRange = false;
        }
        
        if(validRange){
            horas[i] = 1;
        }else{
            horas[i] = 0;
        }
        i++;
    })
    
    console.log("desde - hasta  :: "+desde+" - "+hasta);
    console.log("Array horas -> " + horas );
    
    return horas;
    
}


function main() {

    console.log("set col-Lunes");
    let i = 0;
    let frequency = 1; //-  1 x 30min = 30min
    let horas = [0, 1, 1, 0, 0];
    

    $(".col-Lunes").each(function () {
        console.log("day-count + " + i + " " + JSON.stringify(horario[i]))

        if (!horario[i].checked) { // false
            // print gray boxes
        } else { // true

            horas = calcHoras(frequency,horario[i].desde,horario[i].hasta);
            horas.forEach((h) => {
                cell($(this), h);
            })

        }

        i++;
    })

}

$(main);