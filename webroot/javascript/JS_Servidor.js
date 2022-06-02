

function obterAlunos() {

    return fetch("/alunosString")
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
// caminho para outro handler, mas idêntico ao do anterior
function obterAlunosJson() {

    return fetch("/alunosJson")
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


function inserirAluno() {
    let form = document.getElementById('form4');
    if (form.numero.value === "") {
        alert("preencher numero");
        return;
    }

    let aluno = new FormData(form);

    return fetch("/alunos", {method: 'POST',
        headers: {'Content-type': 'application/json'},
        body: JSON.stringify(Object.fromEntries(aluno))})
            .then((res) => {
                return res.json();
            })
            .then((result) => {
                console.log(">" + result.nome);
                return result;
            }
            ).catch(erro => {
        console.log(erro);
    });
}


function actualizarAluno() {
    let form = document.getElementById('form4');

    let aluno = new FormData(form);

    if (form.numero.value === "") {
        alert("preencher numero");
        return;
    }

    return fetch(`/alunos/${form.numero.value}`, {method: 'PUT',
        headers: {'Content-type': 'application/json'},
        body: JSON.stringify(Object.fromEntries(aluno))})
            .then((res) => {
                return res.json();
            })
            .then((result) => {
                console.log(">" + result.nome);
                let val = result;
                return val;
            }
            ).catch(erro => {
        console.log(erro);
    });
}

function mudarPagina() {
    //window.location.href = "html/nova1.html"; NAO USAR
    window.location.href = "/paginaNova";
}