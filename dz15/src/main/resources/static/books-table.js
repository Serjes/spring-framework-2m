// $(document).ready(function () {
//
//     // $('#bookTable').load("/books-table");
//     $("#adding-form").submit(function (event) {
//         event.preventDefault();
//         adding_book_submit();
//     });
// });

// function adding_book_submit(){
//
//     var addingFormData = {
//         bookTitle :  $("#bookTitle-input").val(),
//         authorName: $("#authorName").val(),
//         authorLastName :  $("#authorLastName").val(),
//         genre : $("#genre").val(),
//         author : $("#author").val()
//     }
//
//     $("#adding-form").prop("disabled", true);
//
//     $.ajax({
//         type: "POST",
//         contentType: "application/json",
//         url: "/books",
//         data: JSON.stringify(addingFormData),
//         dataType: 'json',
//         cache: false,
//         // timeout: 600000,
//         success: function (data) {
//
//             // var json = "<h4>Ajax Response</h4><pre>"
//             //     + JSON.stringify(data, null, 4) + "</pre>";
//             // $('#feedback').html(json);
//             // window.location.href = "/books";
//             // document.getElementById("books").onload;
//             // var jsonBooks = JSON.stringify(data);
//             // $('#table-books').html(json);
//             // $('#bookTable').load("/books-table #table-books");
//             $('#bookTable').load("/books-table");
//
//             console.log("SUCCESS : ", data);
//             // $("#btn-search").prop("disabled", false);
//             $("#adding-form").prop("disabled", false);
//
//         },
//         error: function (e) {
//
//             // var json = "<h4>Ajax Response</h4><pre>"
//             //     + e.responseText + "</pre>";
//             // $('#feedback').html(json);
//
//             console.log("ERROR : ", e);
//             // $("#btn-search").prop("disabled", false);
//             $("#adding-form").prop("disabled", false);
//
//         }
//     });
// }

function deleteBook(id) {
    // alert("delete book!");
    // var bookidval = document.getElementById("book");
    // var object = bookidval.valueOf();
    // var bookData = {
    //     bookId :  $("#book").val()
    // }

    // alert(object);
    // alert(id);
    var bookData = {
            id : id
        }

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