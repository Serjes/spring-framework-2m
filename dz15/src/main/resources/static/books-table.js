function deleteBook(id) {
    var bookData = {
            id : id
        };

    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/api/books/{" + id +"}",
        data: JSON.stringify(bookData),
        dataType: 'json',
        cache: false,
        // timeout: 600000,
        success: function (data) {

            // alert("OK");
            $('#bookTable').load("/books-table");

            console.log("SUCCESS : ", data);
        },
        error: function (e) {
            console.log("ERROR : ", e);
            // alert("not Ok");
        }
    });
}

function editBook(id) {
    $('#editTable').load("/editor/" + id);
}