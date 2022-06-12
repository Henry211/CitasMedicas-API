



var paciente={cedula:"1", nombre:"Messi",clave:"1",peso:"70kg",edad:"24",
antecedentes:[{asma:false},{diabetes:false},{alcohol:false},{tabaco:false},{drogas:false}],
examenes:[{id:"1",fecha:"22/11/1997"},{id:"2",fecha:"21/6/1995"}]};


function verCitasBtn(){
    location.href = 'listaCitas.html';
}


function sortBool(tipo,bool){
    if(tipo=="1"){
        if(bool)    return " Sí tiene";
        else        return " No tiene";
    }else if(tipo == "2"){
        if(bool)    return " Niega";
        else        return " Confirma";
    }
    
}

function fillData(){
    
    
    paciente = JSON.parse(localStorage.getItem('pacientePerfil'));
    console.log("paciente-> "+ JSON.stringify(paciente));
    
    $("#nameTxt").append(paciente.nombre);
    $("#idTxt").append("Id: "+paciente.id);
    $("#pesoTxt").append("Peso: "+paciente.peso);
    $("#edadTxt").append("Edad: "+paciente.edad);

    $("#antecedentesTxt").append("<br><p>Asma: &nbsp&nbsp&nbsp" + sortBool("1",paciente.antecedentes[0]) + "</p>");
    $("#antecedentesTxt").append("<p>Diabetes: &nbsp&nbsp&nbsp" + sortBool("1",paciente.antecedentes[1]) + "</p>");
    $("#antecedentesTxt").append("<p>Alcohol: &nbsp&nbsp&nbsp" + sortBool("2",paciente.antecedentes[2]) + "</p>");
    $("#antecedentesTxt").append("<p>Tabaco: &nbsp&nbsp&nbsp" + sortBool("2",paciente.antecedentes[3]) + "</p>");
    $("#antecedentesTxt").append("<p>Drogas: &nbsp&nbsp&nbsp" + sortBool("2",paciente.antecedentes[4]) + "</p>");
    
    paciente.examenes.forEach((e)=> {
        $("#examenesTxt").append("<p>Exámenes registrados: &nbsp&nbsp&nbsp" + e.fecha);
    })
}

function main(){
    
    
    fillData();
    $("#citasBtn").click(verCitasBtn);
    
}


$(main);