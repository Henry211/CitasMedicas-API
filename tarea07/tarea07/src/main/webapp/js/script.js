/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


var  doctores = new Array();

/*
var doctor={nombre:"", cedula:"",password:"",localidad:"",especialidad:"",tarifa:"",
    horario:[ {checked:false}, {checked:false}, {checked:false}, {checked:false}, {checked:false}]};
*/

var doctor={nombre:"", cedula:"",password:"",localidad:"",especialidad:"",tarifa:""};


var lunes={checked:false};
var martes={checked:false};
var miercoles={checked:false};
var jueves={checked:false};
var viernes={checked:false};
var horario=[lunes,martes,miercoles,jueves,viernes];
var id="";
var mode='A'; //adding
var backend="http://localhost:8080/backend/api";
const NET_ERR=999;

   function render(){
        $("#cedula").val(doctor.cedula);
	$("#nombre").val(doctor.nombre);
        $("#password").val(doctor.password);
        $("#localidad").val(doctor.localidad);
	$("#especialidad").val(doctor.especialidad);
	$("#tarifa").val(doctor.tarifa);
            switch(mode){
            case 'A':
                $("#cedula").prop( "readonly", false );
                $('#aplicar').off('click').on('click', add);
                break;
            case 'E':
                $("#cedula").prop("readonly", true );
                $('#aplicar').off('click').on('click');
                break;             
        }
         //$('#add-modal').modal('show');  
                                        
  }


  function load(){
      //id=doctor._id;
      doctor = Object.fromEntries( (new FormData($("#formulario").get(0))).entries());
      //var horario=[lunes,martes,miercoles,jueves,viernes];
      //doctor.horario=horario;
  }
  
  function reset(){
      nombre.value="";
      cedula.value="";
      password.value="";
      localidad.value="";
      especialidad.value="";
      tarifa.value="";
  } 
  
  
  
  

function add(){
  load();
  //if(!validar()) return;
  const request = new Request(backend+'/doctores', {method: 'POST', headers: { 'Content-Type': 'application/json'},body: JSON.stringify(doctor)});
  (async ()=>{
      try{
          const response = await fetch(request);
          console.log(response);
          reset();
           if (response.ok) {
              alert('Registro exitoso');
          }
          //fetchAndList();
          
          
      }
      catch(e){
        console.log('error');
      }        
  })();    
} 




function makenew(){
     add();
    render();
    

    
    console.log('hola2');
  }
  
function search(){
    //to do
}

function errorMessage(status,place){  
      switch(status){
          case 404: error= "Registro no encontrado"; break;
          case 403: case 405: error="Usuario no autorizado"; break;
          case 406: case 405: error="Usuario ya existe"; break;
          case NET_ERR: error="Error de comunicación"; break;
      };            
      place.html('<div class="alert alert-danger fade show">' +
      '<button type="button" class="close" data-dismiss="alert">' +
      '&times;</button><h4 class="alert-heading">Error!</h4>'+error+'</div>');
      return;        
  }  

function fetchAndList(){
  const request = new Request(backend+'/doctores', {method: 'GET', headers: { }});
  (async ()=>{
      try{
          const response = await fetch(request);
          if (!response.ok) {errorMessage(response.status,$("#buscarDiv #errorDiv"));return;}
          doctores = await response.json();
          console.log(doctores);
         // list();
      }
      catch(e){
          errorMessage(NET_ERR,$("#buscarDiv #errorDiv"));
      }         
  })();    
} 
function renderPopup(){
   document.getElementById("overlay").classList.toggle("active");
    document.getElementById("popup").classList.toggle("active");
  
}
 function edit(){
      renderPopup();
  }
  
   function regresar(){
    document.getElementById("overlay").classList.toggle("active");
    document.getElementById("popup").classList.toggle("active"); 
     //document.querySelector("#popup input[id='lunes'][value='"+doctor.horario+"']").checked=true;
  }
  
   function Rhorario(){
       
       const chLunes=document.querySelector("#lunes");
       const chMartes=document.querySelector("#martes");
       const chMiercoles=document.querySelector("#miercoles");
       const chJueves=document.querySelector("#jueves");
       const chViernes=document.querySelector("#viernes");
       
       if(chLunes.checked){
           const desLunes =document.querySelector("#desdeL");
           const hasLunes =document.querySelector("#hastaL");
           
           lunes={checked:true,desde:desLunes.value,hasta:hasLunes.value};          
       }else{lunes={checked:false};}
       
         if(chMartes.checked){
           const desMartes =document.querySelector("#desdeM");
           const hasMartes =document.querySelector("#hastaM");
           
           martes={checked:true,desde:desMartes.value,hasta:hasMartes.value};          
       }else{martes={checked:false};}
       
        if(chMiercoles.checked){
           const desMiercoles =document.querySelector("#desdeMI");
           const hasMiercoles =document.querySelector("#hastaMI");
           
           miercoles={checked:true,desde:desMiercoles.value,hasta:hasMiercoles.value};          
       }else{miercoles={checked:false};}
       
        if(chJueves.checked){
           const desJueves =document.querySelector("#desdeJ");
           const hasJueves =document.querySelector("#hastaJ");
           
           jueves={checked:true,desde:desJueves.value,hasta:hasJueves.value};          
       }else{jueves={checked:false};}
       
        if(chViernes.checked){
           const desViernes =document.querySelector("#desdeV");
           const hasViernes =document.querySelector("#hastaV");
           
           viernes={checked:true,desde:desViernes.value,hasta:hasViernes.value};          
       }else{viernes={checked:false};}
       
      
   }

function storage(){
    
    if(localStorage.getItem("doctor"))
    
    doctor=JSON.parse(localStorage.getItem("doctor"));
    
        document.getElementById("nombre").setAttribute("value",doctor.nombre);
        document.getElementById("cedula").setAttribute("value",doctor.cedula);
        document.getElementById("password").setAttribute("value",doctor.password);
        document.getElementById("localidad").setAttribute("value",doctor.localidad);
        document.getElementById("especialidad").setAttribute("value",doctor.especialidad);
        document.getElementById("tarifa").setAttribute("value",doctor.tarifa);
       // console.log(doctor.horario[0]);
       
        $("#lunes").on("click",
          (e)=>{e.target.parentNode.parentNode.querySelector(".horario-col-body").classList.toggle("active");});
        $("#martes").on("click",
          (e)=>{e.target.parentNode.parentNode.querySelector(".horario-col-body").classList.toggle("active");});
        $("#miercoles").on("click",
          (e)=>{e.target.parentNode.parentNode.querySelector(".horario-col-body").classList.toggle("active");});
        $("#jueves").on("click",
          (e)=>{e.target.parentNode.parentNode.querySelector(".horario-col-body").classList.toggle("active");});
        $("#viernes").on("click",
          (e)=>{e.target.parentNode.parentNode.querySelector(".horario-col-body").classList.toggle("active");});
/*
        document.querySelector("#lunes").checked=doctor.horario[0].checked;
        document.querySelector("#martes").checked=doctor.horario[1].checked;
        document.querySelector("#miercoles").checked=doctor.horario[2].checked;
        document.querySelector("#jueves").checked=doctor.horario[3].checked;
        document.querySelector("#viernes").checked=doctor.horario[4].checked;
       
        if(doctor.horario[0].checked){
            document.querySelector('#desdeL').value=doctor.horario[0].desde;
            document.querySelector('#hastaL').value=doctor.horario[0].hasta;
            
            document.querySelector('#lunes').parentNode.parentNode.querySelector(".horario-col-body").classList.toggle("active");
        }
         if(doctor.horario[1].checked){
            document.querySelector('#desdeM').value=doctor.horario[1].desde;
            document.querySelector('#hastaM').value=doctor.horario[1].hasta;
            
            document.querySelector('#martes').parentNode.parentNode.querySelector(".horario-col-body").classList.toggle("active");
        }
         if(doctor.horario[2].checked){
            document.querySelector('#desdeMI').value=doctor.horario[2].desde;
            document.querySelector('#hastaMI').value=doctor.horario[2].hasta;
            
            document.querySelector('#miercoles').parentNode.parentNode.querySelector(".horario-col-body").classList.toggle("active");
        }
          if(doctor.horario[3].checked){
            document.querySelector('#desdeJ').value=doctor.horario[3].desde;
            document.querySelector('#hastaJ').value=doctor.horario[3].hasta;
            
            document.querySelector('#jueves').parentNode.parentNode.querySelector(".horario-col-body").classList.toggle("active");
        }
          if(doctor.horario[4].checked){
            document.querySelector('#desdeV').value=doctor.horario[4].desde;
            document.querySelector('#hastaV').value=doctor.horario[4].hasta;
            
            document.querySelector('#viernes').parentNode.parentNode.querySelector(".horario-col-body").classList.toggle("active");
        }
 
        */
        
  
        
}
 

function loaded(){
   storage();
  console.log('hola');

  document.getElementById("horario").addEventListener("click",edit);
  document.getElementById("overlay").addEventListener("click",regresar);
   document.getElementById("xd").addEventListener("click",Rhorario);
   document.getElementById("regresar").addEventListener("click",regresar);
   document.getElementById("xd").addEventListener("click",regresar);
   $("#aplicar").click(makenew);
}
 // $("#xd").click(Rhorario);




$(loaded); 
 
 
