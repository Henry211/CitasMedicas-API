
var cita, paciente;

var backend = "http://localhost:8080/BackEnd/api";


function fillData(){
    $("#namePaciente").append(paciente.nombre);
    $("#cedulaPaciente").append(paciente.cedula);
    $("#edadPaciente").append(paciente.edad);
    
    //***************
    //---Falta fetch de cita y paciente
    //**************
}

function fetchPacienteData(pac){
    
}

function fetchCitaData(citaSimple){
    
    console.log("Enviando fetch Cita..."+citaSimple.hora+"..."+citaSimple.dia)
    
    const request = new Request(backend+'/doctores/afterCita/'+citaSimple.hora+"/"+citaSimple.dia, {method:'GET', headers: { }});
    (async ()=> {
        try{
            const response = await fetch(request);
            
            cita = await response.json();
            console.log("cita->"+JSON.stringify(cita))
            
            fetchPacienteData(cita.paciente);
            fillData();
            
            //localStorage.setItem("pacientePerfil",JSON.stringify(person));          
           
        }catch(e){

        }
    })();
}

function main(){
    
    var citaSimple = localStorage.getItem("atenderCita");
    console.log("cita: "+ citaSimple);
    
    fetchCitaData(JSON.parse(citaSimple));
    
}


$(main);