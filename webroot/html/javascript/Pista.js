function pistaG() {
    document.getElementById('myImage')
            .src = "images/Pista_geral.jpg";
    document.getElementById('message')
            .innerHTML = "Percurso completo, contém a pista da Dragster entre duas equipas. Pista geral para cada prova:";
}

function pistaI() {
    document.getElementById('myImage')
            .src = "images/Pista_individual.jpg";
    document.getElementById('message')
            .innerHTML = "Pista individual para cada equipa, constituída pelas seguintes características:";
}

function semaforo() {
    document.getElementById('myImage')
            .src = "images/semaforo.jpg";
    document.getElementById('message')
            .innerHTML = "Aqui consegues observar o semáforo existente início da pista. Semáforo esse que indica o início da prova.";
}