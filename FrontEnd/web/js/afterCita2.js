
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

function fetchPacienteData(idCita){
    
    const request = new Request(backend+'/pacientes/byCitaId/'+idCita, {method:'GET', headers: { }});
    (async ()=> {
        try{
            const response = await fetch(request);
            
            paciente = await response.json();
            console.log("paciente->"+JSON.stringify(paciente))
            
            fillData();
            
            //localStorage.setItem("pacientePerfil",JSON.stringify(person));          
           
        }catch(e){

        }
    })();
    
}

function fetchCitaData(citaSimple){
    
    console.log("Enviando fetch Cita..."+citaSimple.hora+"..."+citaSimple.dia)
    
    const request = new Request(backend+'/doctores/afterCita/'+citaSimple.hora+"/"+citaSimple.dia, {method:'GET', headers: { }});
    (async ()=> {
        try{
            const response = await fetch(request);
            
            cita = await response.json();
            console.log("cita->"+JSON.stringify(cita))
            
            fetchPacienteData(cita.idCita);
            
        }catch(e){

        }
    })();
}


function guardarBtn(){
    
    // UPDATE cita
    
    var newCita = {signos:"",diagnostico:"",prescripcion:"",estado:false};
    
    const request = new Request(backend+'/doctores/updateCita', 
        {method: 'PUT', headers: { 'Content-Type': 'application/json'},
            body: JSON.stringify(newCita)});
    (async ()=>{
        try{
            const response = await fetch(request);
            //if (!response.ok) {errorMessage(response.status,$("#add-modal #errorDiv"));return;}
            
        }
        catch(e){
            errorMessage(NET_ERR,$("#add-modal #errorDiv"));
        } 
    })();   
}

function main(){
    
    var citaSimple = localStorage.getItem("atenderCita");
    console.log("cita: "+ citaSimple);
    
    cita = localStorage.getItem("verCita");
    
    console.log("cita->"+cita)
            
    fetchPacienteData(cita.paciente);
            //fillData();
    //fetchCitaData(JSON.parse(citaSimple));
    
    $("#guardarBtn").click(guardarBtn);
    
}


$(main);