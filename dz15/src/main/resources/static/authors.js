$(document).ready(function () {

    $('#authorTable').load("/authors-table");
    $("#del-form").submit(function (event) {
        event.preventDefault();
        deleting_book_submit();
    });
});

function deleting_book_submit() {

    var delFormData = {
        id: $("#authorId").val()
    };

    // $("#del-form").prop("disabled", true);

    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/api/authors/" + $("#authorId").val(),
        data: JSON.stringify(delFormData),
        dataType: 'json',
        cache: false,
        success: function (data) {
            // alert("ok");
            console.log("SUCCESS : ", data);
            $('#authorTable').load("/authors-table");

            $("#del-form").prop("disabled", false);
        },
        error: function (e) {
            console.log("ERROR : ", e);
            alert("not Ok");
            // $("#btn-search").prop("disabled", false);
            $("#del-form").prop("disabled", false);

        }
    });
}