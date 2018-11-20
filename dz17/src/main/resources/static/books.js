$(document).ready(function () {

    // $('#bookTable').load("/books-table");
    createBookTable();
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
        success: function (data) {

            $('#bookTable').load("/books-table");
            console.log("SUCCESS : ", data);
            $("#adding-form").prop("disabled", false);

        },
        error: function (e) {

            alert("проблема с сохранением");
            console.log("ERROR : ", e);
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
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "/api/books/" + $("#id").val(),
        data: JSON.stringify(editingFormData),
        dataType: 'json',
        cache: false,
        success: function (data) {
            console.log("SUCCESS : ", data);
            $('#bookTable').load("/books-table");
            $('#editTable').load("/blankeditor");

        },
        error: function (e) {
            console.log("ERROR : ", e);
            alert("проблема с сохранением");

        }
    });
}

function createBookTable() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/books",
        dataType: "json",
        cache: false,
        success: function (result) {
            // addToLog("Запрашиваем список авторов");
            createBooksTable(result);
            // addToLog("Список авторов успешно загружен!");
        },
        error: function (err) {
            // addToLog("Ошибка " + err);
            alert("проблема с таблицей");
        }
    });
}