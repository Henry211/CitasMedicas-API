

var deep={cedula:"1", nombre:"Jhony Deep",clave:"1",peso:"70kg",edad:"24",
antecedentes:[{asma:false},{diabetes:false},{alcohol:false},{tabaco:false},{drogas:false}],
examenes:[{id:"1"},{id:"2"}]};
var winston={cedula:"1", nombre:"Winston Churchill",clave:"1",peso:"70kg",edad:"24",
antecedentes:[{asma:false},{diabetes:false},{alcohol:false},{tabaco:false},{drogas:false}],
examenes:[{id:"1"},{id:"2"}]};
var elon={cedula:"1", nombre:"Elon Musk",clave:"1",peso:"70kg",edad:"24",
antecedentes:[{asma:false},{diabetes:false},{alcohol:false},{tabaco:false},{drogas:false}],
examenes:[{id:"1"},{id:"2"}]};
var stef={cedula:"1", nombre:"Stefanny",clave:"1",peso:"70kg",edad:"24",
antecedentes:[{asma:false},{diabetes:false},{alcohol:false},{tabaco:false},{drogas:false}],
examenes:[{id:"1"},{id:"2"}]};
var messi={cedula:"1", nombre:"Messi",clave:"1",peso:"70kg",edad:"24",
antecedentes:[{asma:false},{diabetes:false},{alcohol:false},{tabaco:false},{drogas:false}],
examenes:[{id:"1"},{id:"2"}]};

var pacientes = new Array();


function showButton(person){

    //console.log("Has visto a "+id);
    //- Cargar en LocalStorage al Paciente
    //- Cargar Perfil y Leer LocalStorage
    localStorage.setItem("pacientePerfil",JSON.stringify(person));
    location.href = 'perfil.html';

}


function deleteButton(person){
    
    // Mostrar pop-up para confirmación
    
    $('#add-modal').modal('show');
}

function pintar(componente, persona){
    var tr = $("<tr />");
    tr.html(`
                <div class="card">
                <h5 class="card-header">Paciente</h5>
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
                        </div></div>
                        <button type="button" id="verBtn" class="btn btn-primary cardButton" >Ver</button>
                        <button type="button" id="borrarBtn" class="btn btn-primary cardButton" >Eliminar</button>
                        </div></div> `);
    tr.find("#verBtn").on("click", ()=> {
            showButton(persona);
        })
    
    tr.find("#borrarBtn").on("click", ()=> {
            deleteButton(persona);
        })
    componente.append(tr);

}

function fillNewPaciente(){
    location.href = 'newPaciente.html';
}

function main(){

    

    pacientes.push(deep);
    pacientes.push(elon);
    pacientes.push(winston);
    pacientes.push(stef);
    pacientes.push(messi);

    pacientes.forEach( (p) => {

        pintar($("#lista"),p);
    });
    
  $("#newBtn").click(fillNewPaciente);
    

}

$(main);