function checkTaikhoan() {
    uname = document.getElementById("unamenew");
    errorname = document.getElementById("error_unamenew");
    if (uname.value.length < 8) {
        errorname.innerHTML = "Tài khoản phải ít nhất 8 ký tự";
        errorname.style.color = "red";
    } else {
        errorname.innerHTML = "";
    }
}





function checkEmail() {
    uemail = document.getElementById("umail");
    erroremail = document.getElementById("error_umail");
    k = /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/i;
    if ((k.test(uemail.value)) == false) {
        erroremail.innerHTML = "Vui lòng bạn nhập lại email";
        erroremail.style.color = "red";
    } else {
        erroremail.innerHTML = "";
    }
}

function checkPass() {
    upass = document.getElementById("upassnew");
    errorpass = document.getElementById("error_upassnew");
    numbers = /[0-9]/;
    lowerCaseLetters = /[a-z]/;
    upperCaseLetters = /[A-Z]/;
    if (upass.value.length < 8) {
        errorpass.style.color = "red";
        errorpass.innerHTML = "Mật khẩu phải có ít nhất 8 ký tự";
    } else if (upass.value.match(numbers) == null) {
        errorpass.style.color = "red";
        errorpass.innerHTML = "Mật khẩu phải có ít nhất 1 chữ số";
    } else if (upass.value.match(lowerCaseLetters) == null) {
        errorpass.style.color = "red";
        errorpass.innerHTML = "Mật khẩu phải có ít nhất 1 ký tự thường";
    } else if (upass.value.match(upperCaseLetters) == null) {
        errorpass.style.color = "red";
        errorpass.innerHTML = "Mật khẩu phải có ít nhất 1 ký tự hoa";
    } else {
        errorpass.innerHTML = "";
    }
}

function checkPassCon() {
    upass = document.getElementById("upassnew");
    upass3 = document.getElementById("upassnewcon");
    errorpass = document.getElementById("error_upassnewcon");
    numbers = /[0-9]/;
    lowerCaseLetters = /[a-z]/;
    upperCaseLetters = /[A-Z]/;
    if (upass3.value !== upass.value) {
        errorpass.style.color = "red";
        errorpass.innerHTML = "Mật khẩu của bạn không trùng khớp";
    } else {
        errorpass.innerHTML = "";
    }
}




