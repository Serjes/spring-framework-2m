$(document).ready(function () {

    // $('#authorTable').load("/authors-table");
    $("#editing-form").submit(function (event) {
        event.preventDefault();
        editing_book_submit();
    });
});

function editing_book_submit() {

    // var delFormData = {
    //     id: $("#authorId").val()
    // };

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
            alert("ok");
            console.log("SUCCESS : ", data);
            // $('#authorTable').load("/authors-table");

            // $("#editing-form").prop("disabled", false);
        },
        error: function (e) {
            console.log("ERROR : ", e);
            // alert("not Ok");
            // $("#btn-search").prop("disabled", false);
            // $("#del-form").prop("disabled", false);

        }
    });
}