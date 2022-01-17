$(document).ready(function () {
     $.ajax({
        url: "PlaceController",
        data: {op: "load"},
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
            var etat;
            e.etat === 0 ? etat = "Plein" : etat = "Vide";
            ligne += "<tr><td>" + e.id + "</td><td>" + e.nom + "</td><td>" + etat + "</td><td>"+ e.section + "</td><td>" + e.etage + "</td>";
        });
        $("#content").html(ligne);
    }
});
