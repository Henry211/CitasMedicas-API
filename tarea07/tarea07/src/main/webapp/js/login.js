/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


var  doctores = new Array();
var doctor={nombre:"", cedula:"",password:"",localidad:"",especialidad:"",tarifa:""};
var id="";
var mode='A'; //adding
var backend="https://crudcrud.com/api/6aa7dbd096aa4041aa641e46a86bc447";
const NET_ERR=999;



function load(){
  id=doctor._id;
  doctor = Object.fromEntries( (new FormData($("#formulario").get(0))).entries());
}
  
  function reset(){
      nombre.value="";
      cedula.value="";
  
  }  
  
   function render(){
        $("#cedula").val(doctor.cedula);
	$("#nombre").val(doctor.nombre);
  }

function login(){
   doctor={cedula:$("#cedula").val(),
   password:$("#password").val()
}
const request = new Request(backend+'/doctores', {method: 'GET', headers: { }});
(async ()=>{
  try{
      const response = await fetch(request);
      //if (!response.ok) {errorMessage(response.status,$("#buscarDiv #errorDiv"));return;}
      doctores = await response.json();
      console.log(doctores);
      doctor=doctores.find(d=>d.cedula==doctor.cedula);
      console.log(doctor);
      if(doctor){
      localStorage.setItem("doctor",JSON.stringify(doctor));
      document.location="registro.html";
      }else{
        throw new Error("Usuario incorrecto")
      }
  }
  catch(e){
      alert(e);
  }         
})(); 
   }

function Regi(){
  console.log('Regi');
  //window.location="registro.html";
  document.location="registro.html";
  localStorage.clear();
 // localStorage.setItem("doctor","");
  console.log('Regi');
  }




function makenew(){
    login();
    //render();
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

function loaded(){
  console.log('hola');
  $("#aplicar").click(makenew);
  $("#Regi").click(Regi);
}

$(loaded);   