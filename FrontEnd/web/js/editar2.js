
var paciente;
var backend = "http://localhost:8080/BackEnd/api";


function fetchUpdate(){
    
    const request = new Request(backend+'/pacientes/'+paciente.cedula, 
        {method: 'PUT', headers: { 'Content-Type': 'application/json'},
            body: JSON.stringify(paciente)});
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

function saveUpdate(){
    
    console.log("Button pressed")
    
    paciente.nombre = $("#nombreId").val();
    paciente.cedula = $("#cedulaId").val();
    paciente.edad = $("#edadId").val();
    paciente.enfermedades = $("#enfermedadesId").val();
    paciente.padecimientos = $("#padecimientosId").val();
    paciente.cirugias = $("#cirugiasId").val();
    paciente.alergias = $("#alergiasId").val();
    
    console.log(JSON.stringify(paciente));
    
    fetchUpdate();
}

async function addpdf() {
    var pdfData = new FormData();
    pdfData.append("cedula", paciente.cedula);
    pdfData.append("pdf", $("#pdf").get(0).files[0]);
    let request = new Request(BE + '/citas/' + paciente.cedula + '/pdf', {method: 'POST', body: pdfData});
    const response = await fetch(request);
    if (!response.ok) {
        alert("respuesta mal en addimagen");
    }
}

function main(){
    
    console.log("Cargando main..")
    
    paciente = JSON.parse(localStorage.getItem('pacientePerfil'));
    
    $("#nombreId").val(paciente.nombre);
    $("#cedulaId").val(paciente.cedula);
    $("#edadId").val(paciente.edad);
    $("#enfermedadesId").val(paciente.enfermedades);
    $("#alergiasId").val(paciente.alergias);
    $("#padecimientosId").val(paciente.padecimientos);
    $("#cirugiasId").val(paciente.cirugias);
    
    $("#saveBtn").click(saveUpdate);
    $("#printPdf").attr("href", backend+'/pacientes/'+paciente.cedula+'/pdf');    
}

$(main);