function validate(){
    var result = "";
    result += validateName();
    result += validateEmail();
    result += validatePassword();
    result += validateTerms();
    if(result == "") return true;
    alert("Validation Result: \n\n"+result);
    return false;
}

function validateName(){
    var name = document.getElementsByName("name")[0].value;
    if(name.length <= 3)
        return "Name should be atleast three characters.\n";
    return "";
}

function validatePassword(){
    var password = valueOf("password");
    var retype = valueOf("ret_password");
    if(password.length <= 6)
        return "password should be atleast 6 characters.\n";
    if(password != retype)
        return "Passwords do not match. \n";
    return "";
}

function validateEmail(){
    var email = valueOf("email");
    var retype = valueOf("ret_email");
    if(email.indexOf('@') == -1)
        return "Email should be a valied address.\n";
    if(email != retype)
        return "Email do not match. \n";
    return "";
}

function validateTerms(){
    var terms = document.getElementsByName("items")[0];
    if(!terms.checked)
        return "Please accept the terms of service and privacy policy.";
    return "";
}

function valueOf(name){
    return document.getElementsByName(name)[0].value;
}