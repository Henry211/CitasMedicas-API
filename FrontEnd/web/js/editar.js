
var paciente;


function main(){
    
    paciente = JSON.parse(localStorage.getItem('pacientePerfil'));
    
    $("#nombreId").val(paciente.nombre);
    $("#cedulaId").val(paciente.cedula);
    $("#edadId").val(paciente.edad);
    $("#enfermedadesId").val(paciente.enfermedades);
    $("#alergiasId").val(paciente.alergias);
    $("#padecimientosId").val(paciente.padecimientos);
    $("#cirugiasId").val(paciente.cirugias);
}

$(main);