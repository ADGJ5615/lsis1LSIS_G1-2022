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