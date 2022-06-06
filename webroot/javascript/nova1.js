


function nova2() {
    //console.log("de nova1.html para nova2.html");
    window.location.href = "/paginaNova2";
}

function nova1() {
    //console.log("voltar de nova2.html para nova1.html");
    window.location.href = "/paginaNova";
}

function index() {
    //console.log("voltar de nova2.html para nova1.html");
    window.location.href = "/";
}

function myFunction() {
    document.getElementById("accountcont").classList.toggle("show");
}

window.onclick = function (e) {
    if (!e.target.matches('.account')) {
        var myDropdown = document.getElementById("accountcont");
        if (myDropdown.classList.contains('show')) {
            myDropdown.classList.remove('show');
        }
    }
}