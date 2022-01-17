$(document).ready(function () {
    $("#login").click(function () {
        var username = $('#username').val();
        var password = $('#password').val();
        
        if(username=="")
    {    alert('Taper votre username !!!');
        }
        else if(password=="")
        {
            alert('Taper votre password !!!');
        }else
        {
            $.ajax({
                url: "LoginController",
                data: {op: "login", username:username , password:password  },
                type: 'POST',
                success: function (data, textStatus, jqXHR) {

                    if(data === "1"){
                        window.location.replace("dashboard.jsp");
                    }

                    if(data === "3"){
                        $('#err').hide().html("Username or Password incorrect !!").fadeIn("slow");
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(textStatus);
                }
            });
        }
    });
});
