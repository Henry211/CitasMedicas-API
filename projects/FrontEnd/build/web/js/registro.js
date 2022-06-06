

var backend = "http://localhost:8080/BackEnd/api";
//var backend = "https://crudcrud.com/api/80909ca5f735420688ef880f614e5345";

var  doctores = new Array();


var doctor={cedula:"", nombre:"",clave:"", especialidad:"", fee:"", localidad:"localidad",
                horario:[ {checked:false}, {checked:false}, {checked:false}, {checked:false}, {checked:false}]};

var horario = [lunes,martes,miercoles,jueves,viernes];
var lunes = {checked:false};
var martes = {checked:false};
var miercoles = {checked:false};
var jueves = {checked:false};
var viernes = {checked:false};


var id="";



function mostrarPersona(){
    console.log("Mostrar Persona");
    
    /* $("#listado").html(""); */
   /*  personas.forEach( (p)=>{row($("#listado"),p);});	 */
   
   document.getElementById("cedula").value = doctor.cedula;
   document.getElementById("nombre").value = doctor.nombre;
   document.getElementById("clave").value = doctor.clave;

   //$('#add-modal').modal('show');
  }  

function existePersona(){
      let existe=false;

      doctores.forEach( (p)=> {
          if(p.cedula == doctor.cedula && p.clave == doctor.clave){
            existe = true;
            console.log("ced: "+ p.cedula + " - ced: " + doctor.cedula)
            doctor = p;            
          } 
      })
      return existe;
  }
 
function fetchAndLoad(){
   
    const request = new Request(backend+'/doctores', {method:'GET', headers: { }});
    (async ()=> {
        try{
            const response = await fetch(request);
            
            doctores = await response.json();
            console.log("Personas Array-> "+ JSON.stringify(doctores));
            
            //mostrarPersona();
            //-> mostrar datos de persona registrada
        }catch(e){

        }
    })();
}

function load(){
    id = doctor._id; //- llamar al formulario
    //---  Set Persona, antes del request.  !!
    doctor = Object.fromEntries( (new FormData($("#formulario").get(0))).entries());
    
    //saveSchedule();// -- ojo 
    horario = [lunes,martes,miercoles,jueves,viernes];
    doctor.horario = horario;

    console.log("Persona->");
    console.log(JSON.stringify(doctor));
}

function add(){
    console.log("Add method")
    load();
    /* if (!validar()) return; */
    
    const request = new Request(backend + '/doctores', {method:'POST',headers:{'Content-Type':'application/json'}, body:JSON.stringify(doctor)});
    (async ()=> {
        try{
            const response = await fetch(request);
            
            fetchAndLoad(); //- traer lista de personas
            reset();
        }catch(e){
            
        }
    })();

}

function search(){
    console.log("Search method");

    load(); //- persona loaded

    const request = new Request(backend+'/doctores', {method:'GET', headers: { }});
    (async ()=> {
        try{
            const response = await fetch(request);
            
            doctores = await response.json();
            console.log("Personas-> "+ JSON.stringify(doctores))

            if(existePersona()){ 
                
                //--- LOGIN finalizado
                console.log("Existe persona!!")
                mostrarPersona();

            }else{
                console.log("No existe persona")
            }
            
        }catch(e){

        }
    })();

}

function render(){
    /* $("#cedula").val(persona.cedula);
    $("#cedula").val(persona.clave); */

    $("#cedula").prop("readonly", false);
    
    //*******************--------------------******************* */
      add();
    //search();
    //--------------------------------------------------------
}

function reset(){
    doctor={cedula:"", nombre:"",clave:"", especialidad:"", fee:"", localidad:"localidad",
                horario:[ {checked:false}, {checked:false}, {checked:false}, {checked:false}, {checked:false}]};
}

function makeNew(){
    console.log("Make new");
    reset();
    render();
}

function saveSchedule(){

    //const checkBoxList = document.querySelectorAll("checked");
    const checkL = document.querySelector('#lunes');
    const checkM = document.querySelector('#martes');
    const checkI = document.querySelector('#miercoles');
    const checkJ = document.querySelector('#jueves');
    const checkV = document.querySelector('#viernes');
    
    //persona.horario[0].checked  = lunes;
    console.log("P 1");
    console.log(JSON.stringify(doctor));

    // Lunes Only
    if(checkL.checked){
        const desdeL = document.querySelector('#desdeL');
        const hastaL = document.querySelector('#hastaL');
        // --> Agregar desde y hasta a el día marcado
        lunes = {checked:true,desde:desdeL.value, hasta:hastaL.value};
    }else { lunes = {checked:false}; }

    if(checkM.checked){
        const desdeM = document.querySelector('#desdeM');
        const hastaM = document.querySelector('#hastaM');
        
        martes = {checked:true,desde:desdeM.value, hasta:hastaM.value};
    }else { martes = {checked:false}; }
    if(checkI.checked){/*  */
        const desdeI = document.querySelector('#desdeI');
        const hastaI = document.querySelector('#hastaI');
        
        miercoles = {checked:true,desde:desdeI.value, hasta:hastaI.value};
    }else { miercoles = {checked:false}; }
    if(checkJ.checked){
        const desdeJ = document.querySelector('#desdeJ');
        const hastaJ = document.querySelector('#hastaJ');
        
        jueves = {checked:true,desde:desdeJ.value, hasta:hastaJ.value};
    }else { jueves = {checked:false}; }
    if(checkV.checked){
        const desdeV = document.querySelector('#desdeV');
        const hastaV = document.querySelector('#hastaV');
        
        viernes = {checked:true,desde:desdeV.value, hasta:hastaV.value};
    }else { viernes = {checked:false}; }


    //***********  YA FUNCIONÓ  ************** */

    //fetchUpdate();

}

function fetchUpdate(){


    const request = new Request(backend + '/doctores/'+id, {method: 'PUT', headers: { 'Content-Type': 'application/json'},body: JSON.stringify(doctor)});
    (async ()=> {
        try{
            const response = await fetch(request);
            if(!response.ok){ }
            //fetchAndList();
            reset();
            $('#add-modal').modal('hide');
        }catch(e){

        }
    })();
}

function verHorario(){

    $('#add-modal').modal('show');
    $('#aplicar').click(saveSchedule);

    console.log("Solicitando Persona del Servidor.....");
    fetchAndLoad();

}

function checkLocalStorage(){

    if(localStorage.getItem('doctor')){
        //- Cargar datos en fields

        doctor = JSON.parse(localStorage.getItem('doctor'));
        
        document.querySelector('#cedula').value = doctor.cedula;
        document.querySelector('#nombre').value = doctor.nombre;
        document.querySelector('#clave').value = doctor.clave;
        document.querySelector('#especialidad').value = doctor.especialidad;
        document.querySelector('#fee').value = doctor.fee;
        document.querySelector('#localidad').value = doctor.localidad;

        //-- add schedule

        console.log("Horario L: " + JSON.stringify(doctor.horario[0]));
        console.log("Horario M: " + doctor.horario[1]);

        $('#lunes').on("click",
                (e)=>{e.target.parentNode.parentNode.querySelector('.col-body').classList.toggle("active");});
        $('#martes').on("click",
                (e)=>{e.target.parentNode.parentNode.querySelector('.col-body').classList.toggle("active");});
        $('#miercoles').on("click",
                (e)=>{e.target.parentNode.parentNode.querySelector('.col-body').classList.toggle("active");});
        $('#jueves').on("click",
                (e)=>{e.target.parentNode.parentNode.querySelector('.col-body').classList.toggle("active");});
        $('#viernes').on("click",
                (e)=>{e.target.parentNode.parentNode.querySelector('.col-body').classList.toggle("active");});
                

        document.querySelector('#lunes').checked = doctor.horario[0].checked; 
        document.querySelector('#martes').checked = doctor.horario[1].checked; 
        document.querySelector('#miercoles').checked = doctor.horario[2].checked; 
        document.querySelector('#jueves').checked = doctor.horario[3].checked; 
        document.querySelector('#viernes').checked = doctor.horario[4].checked;

             

        if(doctor.horario[0].checked){
            document.querySelector('#desdeL').value = doctor.horario[0].desde;
            document.querySelector('#hastaL').value = doctor.horario[0].hasta;

            document.querySelector('#lunes').parentNode.parentNode.querySelector('.col-body').classList.toggle("active");
        }
        if(doctor.horario[1].checked){
            document.querySelector('#desdeM').value = doctor.horario[1].desde;
            document.querySelector('#hastaM').value = doctor.horario[1].hasta;

            document.querySelector('#martes').parentNode.parentNode.querySelector('.col-body').classList.toggle("active");
        }
        if(doctor.horario[2].checked){
            document.querySelector('#desdeI').value = doctor.horario[2].desde;
            document.querySelector('#hastaI').value = doctor.horario[2].hasta;

            document.querySelector('#miercoles').parentNode.parentNode.querySelector('.col-body').classList.toggle("active");
        }
        if(doctor.horario[3].checked){
            document.querySelector('#desdeJ').value = doctor.horario[3].desde;
            document.querySelector('#hastaJ').value = doctor.horario[3].hasta;

            document.querySelector('#jueves').parentNode.parentNode.querySelector('.col-body').classList.toggle("active");
        }
        if(doctor.horario[4].checked){
            document.querySelector('#desdeV').value = doctor.horario[4].desde;
            document.querySelector('#hastaV').value = doctor.horario[4].hasta;

            document.querySelector('#viernes').parentNode.parentNode.querySelector('.col-body').classList.toggle("active");
        }
    }else{
        $('#lunes').on("click",
                (e)=>{e.target.parentNode.parentNode.querySelector('.col-body').classList.toggle("active");});
        $('#martes').on("click",
                (e)=>{e.target.parentNode.parentNode.querySelector('.col-body').classList.toggle("active");});
        $('#miercoles').on("click",
                (e)=>{e.target.parentNode.parentNode.querySelector('.col-body').classList.toggle("active");});
        $('#jueves').on("click",
                (e)=>{e.target.parentNode.parentNode.querySelector('.col-body').classList.toggle("active");});
        $('#viernes').on("click",
                (e)=>{e.target.parentNode.parentNode.querySelector('.col-body').classList.toggle("active");});
                

        document.querySelector('#lunes').checked = false; 
        document.querySelector('#martes').checked = false; 
        document.querySelector('#miercoles').checked = false; 
        document.querySelector('#jueves').checked = false; 
        document.querySelector('#viernes').checked = false;
    }
}

function loaded(){

    checkLocalStorage();
    $("#login").click(makeNew);
    $("#horario").click(verHorario);
}

$(loaded);