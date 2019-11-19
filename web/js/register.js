function checkNewUser() {
    console.log("I am here");
    var name = document.getElementById("name").value;
    var email = document.getElementById("mail").value;
    var password = document.getElementById("password").value;
    const regexEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    const regexPassword = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$^+=!*()@%&]).{8,25}$/
    const regexName = /[A-Z][a-z]{2,19}/;
    var isValidEmail = regexEmail.test(email)
    var isValidPassword = regexPassword.test(password)
    var isValidName = regexName.test(name)
    document.getElementById("name").value = name.replace('<script>', '');
    document.getElementById("name").value = name.replace('</script>', '');
    document.getElementById("mail").value = email.replace('<script>', '');
    document.getElementById("mail").value = email.replace('<script>', '');
    document.getElementById("password").value = password.replace('<script>', '');
    document.getElementById("password").value = password.replace('</script>', '');
    console.log(isValidEmail);
    console.log(isValidPassword);
    console.log(isValidName);
    if (isValidEmail && isValidPassword && isValidName) {
        document.getElementById("registerForm").submit();
    } else {
        document.getElementById("submit").style.backgroundColor = "#ff0000";
    }
}