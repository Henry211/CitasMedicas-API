

var lunes = {checked: true, desde: 08, hasta: 10};
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


function main() {

    console.log("set col-Lunes");
    let i = 0;
    let horas = [false, true, true, false, false];

    $(".col-Lunes").each(function () {
        console.log("day-count + " + i + " " + JSON.stringify(horario[i]))

        if (!horario[i].checked) { // false
            // print gray boxes
        } else { // true

            horas.forEach((h) => {
                cell($(this), h);
            })

        }

        i++;
    })

}

$(main);