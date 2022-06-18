function registar() {
    let form = document.getElementById("registo");
    let formdata = new FormData(form);


    if (document.getElementById("equipa").checked === true) {
        fetch("/Equipa/registarEquipa", {
            method: "POST",
            body: formdata
        })
            .then((res) => {
                if (res.status === 200) {
                    window.location.assign("/index.html");
                    alert("Registado com sucesso!");
                    return res.json();
                } else {
                    throw Error("Erro no servidor!!");

                }
            })
            .catch((err) => console.log(err));
        return;

    } else if (document.getElementById("juri").checked === true) {
        fetch("/Juri/registarJuri", {
            method: "POST",
            body: formdata
        })
            .then((res) => {
                if (res.status === 200) {
                    alert("Registado com sucesso!");
                    window.location.assign("/index.html");
                    return res.json();
                } else {
                    throw Error("Erro no servidor!!");
                }
            })
            .catch((err) => console.log(err));
    } else {
        alert("Precisa de selecionar um cargo.");
    }
}

function logar() {
    let form = document.getElementById("login");
    let formdata = new FormData(form);

    fetch("/Login", {
        method: "POST",
        body: formdata
    })
        .then((res) => {
            if (res.status === 200) {
                window.location.assign("/index.html");
                alert("Login Efetuado");
                return res.json();
            } else if (res.status === 201) {
                window.location.assign("/index.html");
                return res.json();
            } else {
                throw Error("Erro no servidor!!");
            }
        })
        .catch((err) => console.log(err));
}