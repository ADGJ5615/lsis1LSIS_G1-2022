
function registar() {
    let form = document.getElementById("registoRobot");
    let formdata = new FormData(form);
        fetch("/Robot/registarRobot", {
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
    }

