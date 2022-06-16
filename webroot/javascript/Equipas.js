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

    return fetch("/obterEquipas")
            .then((res) => {
                return res.json();
            })
            .then((result) => {
              let li = '<tr><th>Equipas: </th></tr>'
              for (let i=0; i<result.length;i++){
              li += '<tr><td>' + result[i].nome +  '</td></tr>';
              }
              document.getElementById("respostaEquipas").innerHTML=li;
              return result;
                 //var caixa2 = document.getElementById("caixa2");
                //caixa1.innerHTML = result;
                //caixa2.innerHTML = result;

                // return result;
            }
            ).catch(erro => {
        console.log(erro);
    });
}

 let form = document.getElementById("registarEquipasID");
 let formdata = new FormData(form);

function registarEquipas(){


    fetch('/registarEquipa',
    {method: 'POST',
    body: formdata
    })
    .then((res) => {
        if(res.status===201)
        return res.json();
        else throw Error("Erro no servidor!!");})
    .then((data) => {
      // let li = '<tr><th>Username</th><th>Email</th><th>Password</th> <th>Telefone</th><th>Viatura</th></tr>';
      // li+='<tr><td>'+1+'</td><td>'+data[0].nome+'</td><td>'+data[0].email+'</td><td>'+data[0].telefone+'</td><td>'+data[0].viatura+'</td>  </tr>';
        return data;
    })
    .catch((err) => console.log(err));
}

