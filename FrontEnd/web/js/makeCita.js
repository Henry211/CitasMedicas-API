
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
    
    cita = {
            estado:"activo",
            //paciente:paciente.id,
            dateStr:date.dia,
            horaStr:date.hora
        }
        
        
}

function fetchGuardar(){
    
    console.log("Guardando...")
    
    const request = new Request(backend+'/pacientes/cita', 
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