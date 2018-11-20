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

// function addAuthorToTable(author) {
//     var tbody = document.getElementsByTagName("tbody");
//     var tr = createRowByBook(author);
//     tbody.item(0).appendChild(tr);
// }