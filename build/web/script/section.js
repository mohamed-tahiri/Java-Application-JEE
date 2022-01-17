$(document).ready(function () {

    $.ajax({
        url: "SectionController",
        data: {op: "load"},
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            remplir(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });


    $("#content").on("click", ".generer", function () {
        
        var id = $(this).closest("tr").find("td").eq(0).text();
        var ref = $(this).closest("tr").find("td").eq(1).text();
        var id_Etage = $(this).closest("tr").find("td").eq(2).text();
        var idParking = $("#idParking").val();
        
        $.ajax({
            url: "SectionController",
            data: {op: "generer", id:id, ref:ref , id_Etage: id_Etage, idParking: idParking},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
               
                if (data === "1") {
                    $('#err').hide().html("").fadeIn("slow");
                    $('#suc').hide().html("La generation de place est bien fait").fadeIn("slow");
                }
                else 
                {
                    $('#err').hide().html("La generation des places est deja fait!!").fadeIn("slow");
                    $('#suc').hide().html("").fadeIn("slow");
                }
                
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });
        
    });
    
    function remplir(data) {
        var ligne = "";
        data.forEach(function (e) {
            ligne += "<tr><td>" + e.id + "</td><td>" + e.nom + "</td><td>" + e.id_etage + "</td><td ><button class='generer btn btn-secondary btn-rounded'><i class='mdi mdi-tag mr-2'></i>Generer</button></td></tr>";
        });
        $("#content").html(ligne);
    }
});
