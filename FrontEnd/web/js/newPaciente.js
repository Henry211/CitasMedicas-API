

var paciente = {cedula:"19292", nombre:"", enfermedades:"", alergias:"", cirugias:"", contacto_emergencia:""};

var backend = "http://localhost:8080/BackEnd/api";

  
function add(){
    var  paciente;
    paciente = Object.fromEntries( (new FormData($("#formulario").get(0))).entries());
    
    console.log("Personas->"+ JSON.stringify(paciente));
    
    const request = new Request(backend+'/pacientes', 
            {method: 'POST', 
                headers: { 'Content-Type': 'application/json'},
                body: JSON.stringify(paciente)});
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
    
    $("#saveBtn").click(add);
}

$(main);