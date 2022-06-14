

var paciente = {id:"1", nombre:"", enfermedades:"", alergias:"", cirugias:"", contacto:""}

function guardarNewPaciente(){
    paciente = Object.fromEntries( (new FormData($("#formulario").get(0))).entries());
    console.log("paciente->"+ JSON.stringify(paciente))
}

function main(){
    
    $("#saveBtn").click(guardarNewPaciente);
}

$(main);