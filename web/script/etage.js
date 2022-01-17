$(document).ready(function () {

    $.ajax({
        url: "EtageController",
        data: {op: "load"},
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            remplir(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });




    $("#add").click(function () {

        var numero = $("#numero").val();
        var nbrSection = $("#nbrSection").val();
        var idParking = $("#idParking").val();

        if (numero.length === 0 && nbrSection.length === 0) {
            alert("s'il vous plait Taper les Infos");
        } else {
            $.ajax({
                url: "EtageController",
                data: {numero: numero, nbrSection: nbrSection, idParking: idParking},
                type: 'POST',
                success: function (data, textStatus, jqXHR) {
                    if (data === "2") {
                        $('#err').hide().html("Ce numero de etage est deja utiliser !!").fadeIn("slow");
                    } else {
                        remplir(data);
                        $("#numero").val("");
                        $("#nbrSection").val("");
                        $('#err').hide().html("").fadeIn("slow");
                        $('#suc').hide().html("l'etage est creer avec success").fadeIn("slow");

                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(textStatus);
                }
            });
        }
    });


    $("#content").on("click", ".delete", function () {


        var id = $(this).closest("tr").find("td").eq(0).text();

        $.ajax({
            url: "EtageController",
            data: {op: "delete", id: id},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                remplir(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });

    });

    $("#content").on("click", ".modifier", function () {
        var id = $(this).closest("tr").find("td").eq(0).text();

        $('#add').hide(function () {
            $(this).css({"visibility": "hidden"});
        });
        $.ajax({
            url: "EtageController",
            data: {op: "modifier", id: id},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                $("#id").val(data.id);
                $("#numero").val(data.numero);
                $("#nbrSection").val(data.nbr_section);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });
    });

    $("#modifier").click(function () {
        var id = $("#id").val();
        var numero = $("#numero").val();
        var nbrSection = $("#nbrSection").val();


        $.ajax({
            url: "EtageController",
            data: {op: "Mod", id: id, numero: numero, nbrSection: nbrSection},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                if (data === "2") {
                    $('#err').hide().html("Impossible de modifier ce etage !!").fadeIn("slow");
                    $('#suc').hide().html("").fadeIn("slow");
                } else {
                    remplir(data);

                    $("id").val("");
                    $("#numero").val("");
                    $("#nbrSection").val("");

                    $('#add').show(function () {
                        $(this).css({"visibility": "visible"});
                    });
                    
                    $('#suc').hide().html("l'etage est modifier avec success").fadeIn("slow");
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });

    });

    $("#content").on("click", ".generer", function () {
        var id_Etage = $(this).closest("tr").find("td").eq(1).text();
        var nbr_Section = $(this).closest("tr").find("td").eq(2).text();
        var idParking = $("#idParking").val();
        
        $.ajax({
            url: "EtageController",
            data: {op: "generer", id_Etage: id_Etage, nbr_Section: nbr_Section, idParking: idParking},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                if (data === "1") {
                    $('#err').hide().html("").fadeIn("slow");
                    $('#suc').hide().html("La generation de sections est bien fait").fadeIn("slow");
                }
                else if (data === "2") 
                {
                    $('#err').hide().html("La generation de sections est deja fait!!").fadeIn("slow");
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
            ligne += "<tr><td>" + e.id + "</td><td>" + e.numero + "</td><td>" + e.nbr_section + "</td><td><button class='delete btn btn-danger btn-rounded'><i class='mdi mdi-alert mr-2'></i>Supprimer</button></td><td ><button class='modifier btn btn-primary btn-rounded'><i class='mdi mdi-autorenew mr-2'></i>Modifier</button></td><td ><button class='generer btn btn-secondary btn-rounded'><i class='mdi mdi-tag mr-2'></i>Generer</button></td></tr>";
        });
        $("#content").html(ligne);
    }
});
