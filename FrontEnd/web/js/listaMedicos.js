
var backend = "http://localhost:8080/BackEnd/api";
var medicos = new Array();


function showButton(person){

    //console.log("Has visto a "+id);
    //- Cargar en LocalStorage al Paciente
    //- Cargar Perfil y Leer LocalStorage
    localStorage.setItem("medicoPerfil",JSON.stringify(person));
    location.href = 'perfil.html';

}


function pintar(componente, persona){
    var tr = $("<tr />");
    tr.html(`
                <div class="card">
                <h5 class="card-header">Especialidad.</h5>
                <div class="card-body">
                    <h5 class="card-title"> 
                        ${persona.nombre}
                    </h5>
                    <p class="card-text">

                    <div class="container">
                        <div class="row">
                            <div class="col">
                                ... </br> 
                            </div>
                            <div class="col">
                                ... </br>
                            </div>
                        </div><button type="submit" id="aceptarBtn" class="btn btn-primary">Aceptar Solicitud</button>
                        </div></div></div> `);
        tr.find("#aceptarBtn").on("click", ()=> {
            showButton(persona);
        })
        componente.append(tr);

}

function fetchMedicos(){
    
    const request = new Request(backend + '/doctores', {method: 'GET', headers: {}});
    (async () => {
        try {
            const response = await fetch(request);

            medicos = await response.json();
            console.log("medicos->" + JSON.stringify(medicos))

            medicos.forEach( (p) => {

                pintar($("#lista"),p);
            });

        } catch (e) {

        }
    })();
        
}

function main(){

    fetchMedicos();
    
    
    

}

$(main);