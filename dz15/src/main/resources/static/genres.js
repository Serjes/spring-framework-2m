$(document).ready(function () {

    $('#genreTable').load("/genres-table");
    $("#del-form").submit(function (event) {
        event.preventDefault();
        deleting_genre_submit();
    });
});

function deleting_genre_submit() {

    var delFormData = {
        id: $("#genreId").val()
    };

    // $("#del-form").prop("disabled", true);

    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/api/genres/" + $("#genreId").val(),
        data: JSON.stringify(delFormData),
        dataType: 'json',
        cache: false,
        success: function (data) {
            // alert("ok");
            console.log("SUCCESS : ", data);
            $('#genreTable').load("/genres-table");

            $("#del-form").prop("disabled", false);
        },
        error: function (e) {
            console.log("ERROR : ", e);
            // alert("not Ok");
            // $("#btn-search").prop("disabled", false);
            $("#del-form").prop("disabled", false);

        }
    });
}