

var backend = "http://localhost:8080/BackEnd/api";
var doctores = new Array();
var doctor={cedula:"", nombre:"",clave:""};
var id="";


function mostrarPersona(){
    console.log("Mostrar Persona")
    /* $("#listado").html(""); */
   /*  personas.forEach( (p)=>{row($("#listado"),p);});	 */
   
   //window.location.href = "registro.html";
   //window.open("registro.html");
   
   document.getElementById("cedula3").value = doctor.cedulaField;
   document.getElementById("nombre").value = doctor.nombreField;
   document.getElementById("clave").value = doctor.claveField;

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
            
            mostrarPersona();
        }catch(e){

        }
    })();
}

function load(){
    id = doctor._id; //- llamar al formulario
    //---  Set Persona, antes del request.  !!
    doctor = Object.fromEntries( (new FormData($("#formulario").get(0))).entries());

    console.log("Doctosh->");
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
            fetchAndLoad();
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
            console.log("Personas-> "+ JSON.stringify(doctores));

            if(existePersona()){ 
                
                //--- LOGIN finalizado
                console.log("Existe persona!!");
                

                localStorage.setItem("doctor",JSON.stringify(doctor));
                
                document.location = "registro.html";

            }else{
                console.log("No existe persona");
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
    //add();
    //search();
    login();
    //--------------------------------------------------------
}

function login(){
    
    rolValue = $("input[name=rol]");
    
        if (!loginValidar()) return;
        doctor = {
            id: $("#cedula").val(),
            password: $("#clave").val()
        };

        //load();
        console.log( "User Credencials: "+ JSON.stringify(doctor))
        
        let request = new Request(backend+'/login/doctor', {method: 'POST', headers: { 'Content-Type': 'application/json'},body: JSON.stringify(doctor)});
        (async ()=>{
            const response = await fetch(request);
            //if (!response.ok) {errorMessage(response.status,$("#loginDialog #errorDiv"));return;}
            usuario = await response.json();
            console.log("user->"+ JSON.stringify(usuario));
            sessionStorage.setItem('user', JSON.stringify(usuario)); //- SESSION
            $('#loginDialog').modal('hide');            
           switch(usuario.rol){
               case 'Medico': document.location = url+"listado.html"+ "?t="+Math.random(); break;
               case 'Administrador': document.location = url+"about.html"; break;
           }                           
        })();   
  }
  
  
 function loginValidar(){
        /*$("#loginForm").addClass("was-validated");
        return $("#loginForm").get(0).checkValidity(); */
     return true;
 }

function reset(){
    doctor={cedula:"", nombre:"",sexo:""};
}

function makeNew(){
    console.log("Make new");
    reset();
    render();
}

function loaded(){
    $("#login").click(makeNew);
}

$(loaded);