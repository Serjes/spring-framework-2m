$(document).ready(function () {

    $("#adding-form").submit(function (event) {
        event.preventDefault();
        adding_book_submit();
    });
});

function adding_book_submit(){

    var addingFormData = {
        bookTitle :  $("#bookTitle-input").val(),
        authorName: $("#authorName").val(),
        authorLastName :  $("#authorLastName").val(),
        genre : $("#genre").val(),
        author : $("#author").val()
    }

    $("#adding-form").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/books",
        data: JSON.stringify(addingFormData),
        dataType: 'json',
        cache: false,
        // timeout: 600000,
        success: function (data) {

            // var json = "<h4>Ajax Response</h4><pre>"
            //     + JSON.stringify(data, null, 4) + "</pre>";
            // $('#feedback').html(json);
            // window.location.href = "/books";
            // document.getElementById("books").onload;
            // var jsonBooks = JSON.stringify(data);
            // $('#table-books').html(json);

            console.log("SUCCESS : ", data);
            // $("#btn-search").prop("disabled", false);
            $("#adding-form").prop("disabled", false);

        },
        error: function (e) {

            // var json = "<h4>Ajax Response</h4><pre>"
            //     + e.responseText + "</pre>";
            // $('#feedback').html(json);

            console.log("ERROR : ", e);
            // $("#btn-search").prop("disabled", false);
            $("#adding-form").prop("disabled", false);

        }
    });
}