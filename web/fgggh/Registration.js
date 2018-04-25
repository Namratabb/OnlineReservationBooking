function validate()
{
    var r;
    var Firstname=document.getElementById("n1");
    if(Firstname.value=="")
    {
        alert("First name cannot be balnk");
        Firstname.focus();
        return false;
    }
    var Lastname=document.getElementById("n2");
    if(Lastname.value=="")
    {
        alert("Second name cannot be balnk");
        Lastname.focus();
        return false;
    }
    
    var Email=document.getElementById("n3");
    if(Email.value=="")
    {
       alert("Email cannot be balnk");
       Email.focus();
       return false;
    }
    
//    r=/^\w+([a-zA-z0-9]?\w+)*@\w+([a-z]?\w+)*(\.\w{4,10})+$/;
//    if(!r.test(Email))
//    {
//        alert("Enter valid email id");
//        Email.focus();
//        return false;
//    }

//password validation
//var pass=document.getElementById("n4");
//r=/^[a-zA-Z]\w{3,14}$/;
//if(!r.test(pass))
//{
//    alert("The password must contain at least one number one character ");
//    pass.focus();
//    return false;
//}
    var Phone=document.getElementById("n5");
//     r=/^\d{10}$/;
    if(Phone.length>10)
    {
        alert("Phone number should be of the length 10");
        Phone.focus();
        return false;
    }
}


