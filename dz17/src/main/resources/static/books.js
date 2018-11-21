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
        url: "/books",
        data: JSON.stringify(addingFormData),
        dataType: 'json',
        cache: false,
        success: function (data) {

            // $('#bookTable').load("/books-table");
            addBookToTable(data);
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
        url: "/books/" + $("#id").val(),
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


function createBooksTable(booksData) {
    var authorsTableDiv = document.getElementById("bookTable");

    var table = document.createElement("table");
    table.setAttribute("id", "books-Table");
    var thead = createHeadTable();
    table.appendChild(thead);

    var tbody = document.createElement("tbody");
    booksData.forEach(function (book) {
        var tr = createRowByBook(book);
        tbody.appendChild(tr);
    });
    table.appendChild(tbody);

    authorsTableDiv.appendChild(table);
}

function createHeadTable() {
    var thead = document.createElement("thead");

    var tr = document.createElement("tr");
    var thId = document.createElement("th");
    thId.innerHTML = "ID";
    tr.appendChild(thId);
    var thTittle = document.createElement("th");
    thTittle.innerHTML = "Название";
    tr.appendChild(thTittle);
    var thFirstname = document.createElement("th");
    thFirstname.innerHTML = "Имя Автора";
    tr.appendChild(thFirstname);
    var thLastname = document.createElement("th");
    thLastname.innerHTML = "Фамилия Автора";
    tr.appendChild(thLastname);
    var thGenre = document.createElement("th");
    thGenre.innerHTML = "Жанр";
    tr.appendChild(thGenre);
    var thAction = document.createElement("th");
    thAction.innerHTML = "Редактирование";
    tr.appendChild(thAction);
    thead.appendChild(tr);

    return thead;
}

function createRowByBook(book) {
    var tr = document.createElement("tr");

    var tdId = document.createElement("td");
    var inId = document.createElement("input");
    inId.setAttribute("type", "text");
    inId.setAttribute("id", "ID" + book["id"]);
    inId.setAttribute("value", book["id"]);
    tdId.appendChild(inId);
    tr.appendChild(tdId);

    var tdTittle = document.createElement("td");
    var inTittle = document.createElement("input");
    inTittle.setAttribute("type", "text");
    inTittle.setAttribute("id", "Tittle" + book["id"]);
    inTittle.setAttribute("value", book["bookTitle"]);
    tdTittle.appendChild(inTittle);
    tr.appendChild(tdTittle);

    var tdFistname = document.createElement("td");
    var inFistname = document.createElement("input");
    inFistname.setAttribute("type", "text");
    inFistname.setAttribute("id", "inputFirstname" + book["id"]);
    inFistname.setAttribute("value", book["authorName"]);
    tdFistname.appendChild(inFistname);
    tr.appendChild(tdFistname);

    var tdLastname = document.createElement("td");
    var inLastname = document.createElement("input");
    inLastname.setAttribute("type", "text");
    inLastname.setAttribute("id", "inputLastname" + book["id"]);
    inLastname.setAttribute("value", book["authorLastName"]);
    tdLastname.appendChild(inLastname);
    tr.appendChild(tdLastname);

    var tdGenre = document.createElement("td");
    var inGenre = document.createElement("input");
    inGenre.setAttribute("type", "text");
    inGenre.setAttribute("id", "genre" + book["id"]);
    inGenre.setAttribute("value", book["genre"]);
    tdGenre.appendChild(inGenre);
    tr.appendChild(tdGenre);

    var tdButton = document.createElement("td");
    var button = document.createElement("button");
    var textButton = document.createTextNode("Edit");
    button.appendChild(textButton);
    button.onclick = function(){
        editAuthor(book["id"]);
    };
    tdButton.appendChild(button);
    tr.appendChild(tdButton);

    return tr;
}

function addBookToTable(book) {
    var tbody = document.getElementsByTagName("tbody");
    // var tbody = document.getElementById("bookTable");
    var tr = createRowByBook(book);
    // alert(tr);
    // tbody.item(tbody.length).appendChild(tr);
    tbody.item(0).appendChild(tr);
}