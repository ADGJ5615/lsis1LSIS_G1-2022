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

function redirect() {
  location.replace("InfoEquipa.html")
}

function obterEquipas() {

    return fetch("/")
            .then((res) => {
                return res.json();
            })
            .then((result) => {

                var caixa1 = document.getElementById("caixa1");
                var caixa2 = document.getElementById("caixa2");
                caixa1.innerHTML = result[0].nome;
                caixa2.innerHTML = result[1].nome;

                return result;
            }
            ).catch(erro => {
        console.log(erro);
    });
}
