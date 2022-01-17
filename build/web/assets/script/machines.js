$(document).ready(function () {

    $.ajax({
        url: "MachineController",
        data: {op: "load"},
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            remplir(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });
    
    $('#add').show('slow', function() {
      $(this).css({"visibility":"visible"});
    });
    
    $('#modifier').hide('slow', function() {
      $(this).css({"visibility":"hidden"});
      $(this).css({"display":"block"});
    });
    $("#add").click(function () {
        var reference = $("#reference").val();
        var dateAchat = $("#dateAchat").val();
        var prix = $("#prix").val();
        $.ajax({
            url: "MachineController",
            data: { reference: reference, dateAchat: dateAchat, prix: prix},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                remplir(data);
                
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });
    });


    $("#content").on("click", ".delete", function () {
        var id = $(this).closest("tr").find("td").eq(0).text();
        $.ajax({
            url: "MachineController",
            data: {op: "delete", id:id},
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
        $('#modifier').show('slow', function() {
            $(this).css({"visibility":"visible"});
        });
        $('#add').hide('slow', function() {
            $(this).css({"visibility":"hidden"});
            $(this).css({"display":"block"});
        });
        $.ajax({
            url: "MachineController",
            data: {op: "modifier", id:id},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                
                
                $("#idMachine").val(data.id);
                $("#reference").val(data.reference);
                $("#prix").val(data.prix);
                var d = new Date(data.dateAchat);
                var formattedDate = d.getFullYear() + '-' + ("0" + (d.getMonth() + 1)).slice(-2) + '-' + ("0" + d.getDate()).slice(-2);
                $('#dateAchat').val(formattedDate);
                
                
                
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });
    });
    
    $("#modifier").click(function () {
        var idMachine = $("#idMachine").val();
        var reference = $("#reference").val();
        var dateAchat = $("#dateAchat").val();
        var prix = $("#prix").val();
        $.ajax({
            url: "MachineController",
            data: { op: "Mod" , idMachine: idMachine, reference: reference, dateAchat: dateAchat, prix: prix},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                remplir(data);
            
                $('#add').show('slow', function() {
                    $(this).css({"visibility":"visible"});
                });

                $('#modifier').hide('slow', function() {
                  $(this).css({"visibility":"hidden"});
                  $(this).css({"display":"block"});
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });
    });
    
    $.ajax({
        url: "MachineController",
        data: {op: "modifier"},
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            remplir(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });

    function remplir(data) {
        var ligne = "";
        data.forEach(function (e) {
            ligne += "<tr><td>" + e.id + "</td><td>" + e.reference + "</td><td>" + e.dateAchat + "</td><td>" + e.prix + "</td><td><button class='delete'>Supprimer</button></td><td ><button class='modifier'>Modifier</button></td></tr>";
        });
        $("#content").html(ligne);
    }
    
    
});
