



var messi={cedula:"1", nombre:"Messi",clave:"1",peso:"70kg",edad:"24",
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

function main(){
    
    $("#nameTxt").append(messi.nombre);
    $("#idTxt").append("Id: "+messi.id);
    $("#pesoTxt").append("Peso: "+messi.peso);
    $("#edadTxt").append("Edad: "+messi.edad);

    $("#antecedentesTxt").append("<br><p>Asma: &nbsp&nbsp&nbsp" + sortBool("1",messi.antecedentes[0]) + "</p>");
    $("#antecedentesTxt").append("<p>Diabetes: &nbsp&nbsp&nbsp" + sortBool("1",messi.antecedentes[1]) + "</p>");
    $("#antecedentesTxt").append("<p>Alcohol: &nbsp&nbsp&nbsp" + sortBool("2",messi.antecedentes[2]) + "</p>");
    $("#antecedentesTxt").append("<p>Tabaco: &nbsp&nbsp&nbsp" + sortBool("2",messi.antecedentes[3]) + "</p>");
    $("#antecedentesTxt").append("<p>Drogas: &nbsp&nbsp&nbsp" + sortBool("2",messi.antecedentes[4]) + "</p>");
    
    messi.examenes.forEach((e)=> {
        $("#examenesTxt").append("<p>Exámenes registrados: &nbsp&nbsp&nbsp" + e.fecha);
    })

    $("#citasBtn").click(verCitasBtn);
    
}


$(main);