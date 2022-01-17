$(document).ready(function () {


    $('#section_').hide(function () {
        $(this).css({"visibility": "hidden"});
    });
    $('#place_').hide(function () {
        $(this).css({"visibility": "hidden"});
    });
    
    $.ajax({
        url: "GestionController",
        data: {op: "load"},
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            remplirEtage(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });

    
    $("#sectionLibre").click(function () {
        var id = $("#contentEtage").val();
        alert(id);
        $.ajax({
            url: "GestionController",
            data: {op: "loadSection", id: id},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                remplirSection(data);
                $('#section_').show(function () {
                    $(this).css({"visibility": "visible"});
                });
                
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });
    });
    
    
    $("#placeLibre").click(function () {
        var etage = $("#contentEtage").val();
        var section = $("#contentSection").val();
        alert(section);
        
        $.ajax({
            url: "GestionController",
            data: {op: "loadPlace", section: section, etage:etage},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                remplirPlace(data);
                $('#place_').show(function () {
                    $(this).css({"visibility": "visible"});
                });
                
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });
    });

    $("#placechoisi").click(function () {
        var place = $("#contentPlace").val();
        
        $.ajax({
            url: "GestionController",
            data: {op: "choisiPlace", place:place},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                if(data === "1"){
                    alert("La place est bien choisie")
                    window.location.replace("gesParking.jsp");
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });
        
    });
    
    function remplirEtage(data) {
        var ligne = "";
        var numero = "";
        data.forEach(function (e) {
            if (e.numero === 1) {
                numero = "1 ere Etage";
            } else if (e.numero === 2) {
                numero = "2 eme Etage";
            } else if (e.numero === 3) {
                numero = "3 eme Etage";
            } else if (e.numero === 4) {
                numero = "4 eme Etage";
            } else if (e.numero === 5) {
                numero = "5 eme Etage";
            }
            
            ligne += "<option value='"+e.numero+"'>"+numero+"</option>";
        });
        $("#contentEtage").html(ligne);
    }
    
    function remplirSection(data) {
        var ligne = "";
        data.forEach(function (e) {
            ligne += "<option value='"+e.nom+"'>"+e.nom+"</option>";
        });
        $("#contentSection").html(ligne);
    }
    
    function remplirPlace(data) {
        var ligne = "";
        data.forEach(function (e) {
            ligne += "<option value='"+e.id+"'>"+e.nom+"</option>";
        });
        $("#contentPlace").html(ligne);
    }
    
    
});

