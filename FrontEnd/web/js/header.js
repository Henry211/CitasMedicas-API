var backend = "";

function loadHeader(){
    
    let menu = document.getElementById("headerMenu");
    menu.innerHTML = `<header><div class="container">
            <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
 
                <a href="url" class="navbar-brand mb0 h1">
                    <img class="d-inline-block align-top" 
                         src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg"
                         alt="alt" width="30" height="30" style="margin-left: 20px;"/>
                    Smart Medical
                </a>
    
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a href="agenda.html" class="nav-link">
                                Agenda
                            </a>
                        </li>

                        <li class="navbar-item active">
                            <a href="listaPacientes.html" class="nav-link">
                                Lista de Pacientes
                            </a>
                        </li>
                        
                        <li class="navbar-item active">
                            <a href="listaCitas.html" class="nav-link">
                                Lista de Citas
                            </a>
                        </li>
                        
                        <li class="navbar-item active">
                            <a href="listaMedicos.html" class="nav-link">
                                Lista de Medicos
                            </a>
                        </li>
                        
                        
                        <li class="navbar-item active">
                            <a href="makeCita.html" class="nav-link">
                                MakeCita
                            </a>
                        </li>
                        
                        <li class="navbar-item active">
                            <a href="perfil.html" class="nav-link">
                                Perfil
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div></header> `;
}

$(loadHeader);