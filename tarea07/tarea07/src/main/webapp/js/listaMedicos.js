

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


function showButton(id){

    console.log("Has visto a "+id);
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
                        </div><button type="submit" id="verBtn" class="btn btn-primary">Ver</button>
                        </div></div></div> `);
        tr.find("#verBtn").on("click", ()=> {
            showButton(persona.nombre);
        })
        componente.append(tr);

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
    

}

$(main);