$(document).ready(function () {
    $("#signup").click(function () {
        var username    = $('#username').val();
        var email       = $('#email').val();
        var parking     = $('#parking').val();
        var parkingAddr = $('#parkingAdd').val();
        var password    = $('#password').val();
        var password1   = $('#password1').val(); 
        
        if(username === "")
        {
            $('#err').hide().html("Username is empty !!!").fadeIn("slow");
        }
        else if(email === "")
        {
            $('#err').hide().html("Email is empty !!!").fadeIn("slow");
        }
        else if(parking === "")
        {
            $('#err').hide().html("Parking name is empty !!!").fadeIn("slow");
        }
        else if(parkingAddr === "")
        {
            $('#err').hide().html("Parking address is empty !!!").fadeIn("slow");
        }
        else if(password === "")
        {
            $('#err').hide().html("Password is empty !!!").fadeIn("slow");
        }
        else if(password !== password1)
        {
            $('#err').hide().html("password not match !!").fadeIn("slow");
        }
        else
        {
            $.ajax({
                url: "LoginController",
                data: {op: "signup", username:username , email:email , parking:parking , parkingAddr:parkingAddr, password:password  },
                type: 'POST',
                success: function (data, textStatus, jqXHR) {
                    if(data === "1"){
                        window.location.replace("login.jsp");
                    }
                    
                    if(data === "2"){
                        $('#err').hide().html("Cette email est deja utiliser !!").fadeIn("slow");
                    }
                    
                    if(data === "3"){
                        $('#err').hide().html("Cette username est deja utiliser !!").fadeIn("slow");
                    }

                    if(data === "4"){
                        $('#err').hide().html("ce nom de parking est deja utiliser !!").fadeIn("slow");
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(textStatus);
                }
            });
        }
    });
});
