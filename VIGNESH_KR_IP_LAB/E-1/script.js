function validate(){
    var result = "";
    result+=validateName();
    result+=validateEmail();
    result+=validatePassword();
    result+=validateTerms();
    if(result=="") return true;
    alert("Validation Result:\n\n"+result);
    return false;
}

function validateName(){
    var name = document.getElementsByName("name")[0].value;
    if(name.length<=3)
    return "Name should be atleast 4 characters.\n";
    return "";

}


function validatePassword(){
    var pass = valueOf("pass");
    var retype_pass = valueOf("retype_pass");
    if(pass.length<=6)
    return "Pass should be atleast 7 characters.\n";
    if(pass!=retype_pass)
    return "Passwords do not match!\n";
    return "";
}

function validateEmail(){
    var email = valueOf("email");
    var retype_email = valueOf("retype_email");
    if(email.indexOf('@')==-1)
    return "Email should be a valid address.\n";
    if(email!=retype_email)
    return "Email addresses do not match.\n";
    return "";
}



function validateTerms(){
    var terms = document.getElementsByName("terms")[0];
    if(!terms.checked)
    return "Please accept the Terms of Service and Privacy policy";
    return "";
}

function valueOf(name){
    return document.getElementsByName(name)[0].value;
}