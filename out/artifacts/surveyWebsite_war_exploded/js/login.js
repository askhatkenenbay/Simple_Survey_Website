function checkInput() {
    var login = document.getElementById("login").value;
    const regexName = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    var isValidName = regexName.test(login)
    var password = document.getElementById("password").value;
    const regexPassword = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$^+=!*()@%&]).{8,25}$/
    var isValidPassword = regexPassword.test(password)
    document.getElementById("password").value = password.replace('<script>', '');
    document.getElementById("password").value = password.replace('</script>', '');
    document.getElementById("login").value = login.replace('<script>', '');
    document.getElementById("login").value = login.replace('</script>', '');
    if (isValidName && isValidPassword) {
        document.getElementById("loginForm").submit();
    } else {
        document.getElementsByClassName("button")[0].style.backgroundColor = "#ff0000";
    }
}