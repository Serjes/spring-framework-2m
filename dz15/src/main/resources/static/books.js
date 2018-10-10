$(document).ready(function () {

    $('#bookTable').load("/books-table");
    $("#adding-form").submit(function (event) {
        event.preventDefault();
        adding_book_submit();
    });
    $("#editing-form").submit(function (event) {
        event.preventDefault();
        editing_book_submit();
    });
});

function adding_book_submit(){

    var addingFormData = {
        bookTitle :  $("#bookTitle-input").val(),
        authorName: $("#authorName").val(),
        authorLastName :  $("#authorLastName").val(),
        genre : $("#genre").val(),
        author : $("#author").val()
    };

    $("#adding-form").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/books",
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
            // $('#bookTable').load("/books-table #table-books");
            $('#bookTable').load("/books-table");

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

function editing_book_submit() {

    var editingFormData = {
        bookTitle :  $("#bookTitle-input").val(),
        authorName: $("#authorName").val(),
        authorLastName :  $("#authorLastName").val(),
        genre : $("#genre").val(),
        author : $("#author").val()
    };
    // $("#del-form").prop("disabled", true);
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "/api/books/" + $("#id").val(),
        data: JSON.stringify(editingFormData),
        dataType: 'json',
        cache: false,
        success: function (data) {
            // alert("ok");
            console.log("SUCCESS : ", data);
            // $("#editing-form").prop("disabled", false);
            $('#bookTable').load("/books-table");
            $('#editTable').load("/blankeditor");
            // $(document).
            // document.getElementById("editTable").innerText("OK");

        },
        error: function (e) {
            console.log("ERROR : ", e);
            alert("проблема с сохранением");
            // $("#btn-search").prop("disabled", false);
            // $("#del-form").prop("disabled", false);

        }
    });
}