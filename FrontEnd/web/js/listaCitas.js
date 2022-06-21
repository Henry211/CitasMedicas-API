

var citaUno = {id: "1", paciente: "Jhony Deep", registroDeSignos: {presion: 22, alto: 182, frecuenciaCardiaca: 55, temperatura: 30}, peso: "70kg", edad: "24",
    antecedentes: [{asma: false}, {diabetes: false}, {alcohol: false}, {tabaco: false}, {drogas: false}],
    examenes: [{id: "1"}, {id: "2"}]};
var citaDos = {id: "1", paciente: "Jhony Deep", registroDeSignos: {presion: 22, alto: 182, frecuenciaCardiaca: 55, temperatura: 30}, peso: "70kg", edad: "24",
    antecedentes: [{asma: false}, {diabetes: false}, {alcohol: false}, {tabaco: false}, {drogas: false}],
    examenes: [{id: "1"}, {id: "2"}]};
var citaTres = {id: "1", paciente: "Jhony Deep", registroDeSignos: {presion: 22, alto: 182, frecuenciaCardiaca: 55, temperatura: 30}, peso: "70kg", edad: "24",
    antecedentes: [{asma: false}, {diabetes: false}, {alcohol: false}, {tabaco: false}, {drogas: false}],
    examenes: [{id: "1"}, {id: "2"}]};
var citaCuatro = {id: "1", paciente: "Jhony Deep", registroDeSignos: {presion: 22, alto: 182, frecuenciaCardiaca: 55, temperatura: 30}, peso: "70kg", edad: "24",
    antecedentes: [{asma: false}, {diabetes: false}, {alcohol: false}, {tabaco: false}, {drogas: false}],
    examenes: [{id: "1"}, {id: "2"}]};

var citas = new Array();
var backend = "http://localhost:8080/BackEnd/api";


function pintar(componente, cita) {
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

    tr.find("#verExamenBtn").on("click", () => {
        // - Ver examen relacionado
    })

    componente.append(tr);

}

function printCitas(array) {

    array.forEach((p) => {

        pintar($("#lista"), p);
    });
}

function showButton(c){
    
    console.log("SHOW BUTTON "+ c.idCita)
    const request = new Request(backend+'/doctores/citaById/'+c.idCita, {method:'GET', headers: { }});
    (async ()=> {
        try{
            const response = await fetch(request);
            
            c = await response.json();
            console.log("cita**->"+JSON.stringify(c))
            
            //localStorage.setItem("pacientePerfil",JSON.stringify(c));
            //location.href = 'perfil.html';
            
           
        }catch(e){

        }
    })();
}


function pintar(componente, cita){
    var tr = $("<tr />");
    tr.html(`
            <div class="card"><h5 class="card-header">Paciente</h5>
                <div class="card-body">
                    <h5 class="card-title">  ${cita.horaStr}
                    </h5> <p class="card-text">
                    <div class="container">
                        <div class="row">
                            <div class="col">... </br></div>
                            <div class="col"> ... </br></div>
                        </div></div>
    <button type="button" id="verBtn" class="btn btn-primary cardButton" >Ver</button>
                        </div></div> `);
    tr.find("#verBtn").on("click", ()=> {
            showButton(cita);
        })
    componente.append(tr);

}


function fetchCitas() {

    const request = new Request(backend + '/doctores/citasExistentes', {method: 'GET', headers: {}});
    (async () => {
        try {
            const response = await fetch(request);

            citas = await response.json();
            console.log("citas->" + JSON.stringify(citas))

            citas.forEach((c) => {

                pintar($("#lista"), c);
            });

        } catch (e) {

        }
    })();
}

function main() {


    fetchCitas();

   
}

$(main);