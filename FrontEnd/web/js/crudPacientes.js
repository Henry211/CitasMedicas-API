
var pacientes = new Array();

var backend = "http://localhost:8080/BackEnd/api";

function showButton(person){

    //console.log("Has visto a "+id);
    //- Cargar en LocalStorage al Paciente
    //- Cargar Perfil y Leer LocalStorage
    localStorage.setItem("pacientePerfil",JSON.stringify(person));
    location.href = 'perfil.html';

}


function fetchDelete(id){
    
    const request = new Request(backend+'/pacientes/'+id, 
        {method: 'DELETE', headers: {'Content-type': 'application/json; charset=UTF-8' }});
    (async ()=>{
        try{
            console.log("deleting..."+id)
            const response = await fetch(request);
            //fetchAndList();
            
        }
        catch(e){
            errorMessage(NET_ERR,$("#add-modal #errorDiv"));
        } 
    })();
}


function deleteButton(person){
    
    // Mostrar pop-up para confirmación
    
    $('#add-modal').modal('show');
    $('#applyDelete').click(fetchDelete(person.cedula));
    $('#add-modal').modal('hide');
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

function printPaciente(arrayPs){
 
    arrayPs.forEach( (p) => {
        
        pintar($("#lista"),p);
    });
}

function cargarPacientes(){
    
    var array = new Array();

    const request = new Request(backend+'/pacientes', {method:'GET', headers: { }});
    (async ()=> {
        try{
            const response = await fetch(request);
            
            array = await response.json();
            console.log("Array2->"+JSON.stringify(array))
            
            printPaciente(array);
        }catch(e){

        }
    })();
    
    
    
    
}

function main(){
    
    cargarPacientes();
    console.log("Array3->"+JSON.stringify(pacientes));
    
    
    $("#newBtn").click(fillNewPaciente);
    

}

$(main);