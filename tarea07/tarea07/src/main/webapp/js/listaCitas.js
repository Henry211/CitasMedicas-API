

var citaUno={id:"1", paciente:"Jhony Deep", registroDeSignos:{ presion:22,alto:182,frecuenciaCardiaca:55,temperatura:30 },peso:"70kg",edad:"24",
antecedentes:[{asma:false},{diabetes:false},{alcohol:false},{tabaco:false},{drogas:false}],
examenes:[{id:"1"},{id:"2"}]};
var citaDos={id:"1", paciente:"Jhony Deep", registroDeSignos:{ presion:22,alto:182,frecuenciaCardiaca:55,temperatura:30 },peso:"70kg",edad:"24",
antecedentes:[{asma:false},{diabetes:false},{alcohol:false},{tabaco:false},{drogas:false}],
examenes:[{id:"1"},{id:"2"}]};
var citaTres={id:"1", paciente:"Jhony Deep", registroDeSignos:{ presion:22,alto:182,frecuenciaCardiaca:55,temperatura:30 },peso:"70kg",edad:"24",
antecedentes:[{asma:false},{diabetes:false},{alcohol:false},{tabaco:false},{drogas:false}],
examenes:[{id:"1"},{id:"2"}]};
var citaCuatro={id:"1", paciente:"Jhony Deep", registroDeSignos:{ presion:22,alto:182,frecuenciaCardiaca:55,temperatura:30 },peso:"70kg",edad:"24",
antecedentes:[{asma:false},{diabetes:false},{alcohol:false},{tabaco:false},{drogas:false}],
examenes:[{id:"1"},{id:"2"}]};

var citas = new Array();



function pintar(componente, cita){
    var tr = $("<tr />");
    tr.html(`
                <div class="card">
                <h5 class="card-header">Especialidad.</h5>
                <div class="card-body">
                    <h5 class="card-title"> 
                        Paciente: ${cita.paciente}
                        </p></p></p></p>
                    </h5>
                    <h5 class="card-title"> 
                        Registro de Signos: 
                    </h5>
                    <p class="card-text"> 
                        Presion: ${cita.registroDeSignos.presion}
                        Alto: ${cita.registroDeSignos.alto}</p>
                        Frecuencia cardiaca: ${cita.registroDeSignos.frecuenciaCardiaca}
                        Temperatura: ${cita.registroDeSignos.temperatura}
                    </p>
    <button type="submit" id="verExamenBtn" class="btn btn-primary">Var Examen relacionado</button>
                        </div></div></div> `);

        tr.find("#verExamenBtn").on("click", ()=> {
            // - Ver examen relacionado
        })

        componente.append(tr);

}


function main(){


    citas.push(citaUno);
    citas.push(citaDos);
    citas.push(citaTres);
    citas.push(citaCuatro);

    citas.forEach( (c) => {

        pintar($("#lista"),c);
    })

}

$(main);