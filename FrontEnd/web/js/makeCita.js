
var paciente,date,cita;
var backend = "http://localhost:8080/BackEnd/api";


function fillData(){

    paciente = JSON.parse(localStorage.getItem('pacienteToCita'));
    date = JSON.parse(localStorage.getItem('citaToPaciente'));
        
    $('#namePaciente').append(paciente.nombre);
    $('#cedulaPaciente').append(paciente.cedula);
    $('#edadPaciente').append(paciente.edad);
    $('#diaCita').append(date.dia);
    $('#horaCita').append(date.hora);
    
    console.log("Cargando paciente: "+ JSON.stringify(paciente))
    
    cita = {
            estado:"activo",
            //paciente:JSON.parse(paciente),
            dateStr:date.dia,
            horaStr:date.hora
        }
        
        
}

function fetchGuardar(){
    
    
    const request = new Request(backend+'/pacientes/cita/'+paciente.cedula, // Pasarle por parametro el id paciente 
            {method: 'POST', 
                headers: { 'Content-Type': 'application/json'},
                body: JSON.stringify(cita)});
    (async ()=>{
        try{
            const response = await fetch(request);
            
        }
        catch(e){
            errorMessage(NET_ERR,$("#add-modal #errorDiv"));
        }        
    })();   
}

function main(){
    
    fillData();
    
    $('#guardarBtn').click(fetchGuardar);
}

$(main);